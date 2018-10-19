package quiz.service.impl;
/**
 * Created by Bartlomiej Wichowski Date: 7/30/2018 Time: 5:57 PM
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.domain.Answer;
import quiz.domain.Category;
import quiz.domain.Question;
import quiz.dto.AnswerDTO;
import quiz.dto.CategoryDTO;
import quiz.dto.QuestionDTO;
import quiz.dto.ResultDTO;
import quiz.dto.*;
import quiz.mapper.AnswerMapper;
import quiz.mapper.CategoryMapper;
import quiz.mapper.QuestionMapper;
import quiz.repository.AnswerRepository;
import quiz.repository.CategoryRepository;
import quiz.repository.QuestionRepository;
import quiz.service.QuestionService;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void createQuestion(QuestionDTO questionDTO) {

        Category category = categoryRepository.getOne(100l);

        Question question = new Question();
        question.setQuestion(questionDTO.getQuestion());
        question.setCategory(category);
        question.setAnswers(new HashSet<>());

        for (AnswerDTO a : questionDTO.getAnswers()) {
            Answer a2 = answerMapper.toEntity(a);
            question.addToChildren(a2);
        }

        questionRepository.save(question);
    }

    @Override
    public List<QuestionDTO> getQuestions() {
        return questionRepository.getQuestionsWithCategory();
    }

    @Override
    public List<AnswerDTO> getAnswersByQuestionId(Long questionId) {
        return answerRepository.getAnswersByQuestionId(questionId);
    }

    @Override
    public ResultDTO checkQuiz(List<QuestionDTO> questions) {

        Map<Long, AnswerDTO> correctAnswers = answerRepository
                .getCorrectAnswersForQuestions(questions.stream().map(q -> q.getId()).collect(Collectors.toSet()))
                .stream().collect(Collectors.toMap(a -> a.getId(), a -> a));

        int score = 0;
        for (QuestionDTO q : questions) {
            boolean isCorrect = true;

            if (q.getAnswers() != null) {
                for (AnswerDTO a : q.getAnswers()) {
                    if (a.getChosen() != null && a.getChosen() != correctAnswers.get(a.getId()).getCorrect()) {
                        isCorrect = false;
                    }
                    a.setCorrect(correctAnswers.get(a.getId()).getCorrect());
                }
            } else {
                isCorrect = false;
            }

            if (isCorrect) {
                score++;
            }

        }

        ResultDTO result = new ResultDTO(questions);
        result.setNumberOfAll(questions.size());
        result.setNumberOfCorrect(score);
        return result;
    }

    @Override
    public QuestionDTO getQuestion(Long questionId) {
        QuestionDTO question = questionMapper.toDto(questionRepository.getOne(questionId));
        List<AnswerDTO> answers = answerRepository.getAllAnswersByQuestionId(questionId);
        question.setAnswers(answers);
        return question;
    }

    @Override
    public List<CategoryDTO> getCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public CategoryDTO getCategory(Long categoryId) {
        return categoryMapper.toDto(categoryRepository.getOne(categoryId));
    }

    @Override
    public void delete(Long questionId) {
        questionRepository.delete(questionRepository.getOne(questionId));
    }
}
