import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Movies_Script {
    public static void main(String[] args) {
        try {
            File fuckYouHanry = new File("C:\\Users\\User\\Desktop.txt");
            fuckYouHanry.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(fuckYouHanry));

            Document doc = Jsoup.connect("https://gimytv.com/genre/drama---.html").get();
            String URL_3 = "https://gimytv.com/";
            System.out.println(doc.title());
            System.out.println(URL_3);
            out.write(doc.title() + "\n");
            out.write("================================================\n");
            int num = 0;
            int count = 0;
            String URL_1 = "";
            String URL_2 = "";
            Elements moviesTitle = doc
                    .select(".container .row li div.myui-vodlist__box h4.title.text-overflow a");//電影a
            if (num == 0) {
                for (Element moviesClass : moviesTitle) {
                    String titleDoc = moviesClass.absUrl("href");
                    Element movieLoad = doc
                            .select(".container .row div.myui-vodlist__box a.myui-vodlist__thumb").get(count);
                    String MovieUrl = movieLoad.absUrl("href");
                    Document introduce = Jsoup.connect(MovieUrl).get();
                    Elements MoviesIntroduce = introduce.select("div.col-pd.text-collapse.content");

                    URL_1 = moviesClass.attr("href");
                    URL_2 = URL_3 + URL_1;
                    Document index_1 = Jsoup.connect(URL_2).get();
                    Elements items = index_1.select("div.myui-content__detail");
                        Element p = items.select("p").first();
                        if (!MoviesIntroduce.text().isEmpty()) {
                            System.out.println();
                            System.out.println("======moviesClass：" + moviesClass.attr("title")+"=======");
                            System.out.println("Movies Title Link：" + titleDoc);
                            System.out.println("MovieIntroduce：" + MoviesIntroduce.text());
                            System.out.println(p.text());
                            System.out.println();
                            out.write("moviesClass：" + moviesClass.attr("title") + "\n");
                            out.write("Movies Title Link：" + titleDoc + "\n");
                            out.write("MovieIntroduce：" + MoviesIntroduce.text() + "\n");
                            out.write("================================================\n");
                        } else {
                            System.out.println();
                            System.out.println("======moviesClass：" + moviesClass.attr("title")+"=======");
                            System.out.println("Movies Title Link：" + titleDoc);
                            System.out.println("MovieIntroduce：No introduce");
                            out.write("moviesClass：" + moviesClass.attr("title") + "\n");
                            out.write("Movies Title Link：" + titleDoc + "\n");
                            out.write("MovieIntroduce：No introduce\n");
                            out.write("================================================\n");
                        }
                        count = count + 1;
                    }out.close();
            }
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
