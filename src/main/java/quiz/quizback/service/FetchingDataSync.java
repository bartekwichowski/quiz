package quiz.quizback.service;
/**
 * Created by Bartlomiej Wichowski Date: 8/27/2018 Time: 8:20 AM
 */

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

/**
 *
 */
public class FetchingDataSync  {

    public static void main(String[] args) throws IOException, InterruptedException {

        Connection.Response response = Jsoup //
                .connect("http://www.example.com/") //
                .userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2") //
                .header("Content-Language", "en-US") //
                .method(Connection.Method.GET)
                .execute();

        Document doc = response.parse();
        System.out.println(doc.body());
    }

}
