import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Movies_Script {
    public static void main(String[] args) {
        try {
            File fuckYouHanry = new File("C:\\Users\\ENDUSER\\Desktop\\output.txt");
            fuckYouHanry.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(fuckYouHanry));
            int count = 0;
            Document doc = Jsoup.connect("https://gimytv.com/genre/drama---.html").get();
            System.out.println(doc.title());
            out.write(doc.title() + "\n");
            out.write("================================================\n");
            Elements moviesTitle = doc.select(".container .row li div.myui-vodlist__box h4.title.text-overflow a");
            for (Element moviesClass : moviesTitle) {
                String titleDoc = moviesClass.absUrl("href");
                Element movieLoad = doc.select(".container .row div.myui-vodlist__box a.myui-vodlist__thumb").get(count);
                String MovieUrl = movieLoad.absUrl("href");
                Document introduce = Jsoup.connect(MovieUrl).get();
                Elements MoviesIntroduce = introduce.select("div.col-pd.text-collapse.content");
                if (!MoviesIntroduce.text().isEmpty()){
                    System.out.println("moviesClass：" + moviesClass.attr("title"));
                    System.out.println("Movies Title Link：" + titleDoc);
                    System.out.println("MovieIntroduce：" + MoviesIntroduce.text());
                    out.write("moviesClass：" + moviesClass.attr("title") + "\n");
                    out.write("Movies Title Link：" + titleDoc + "\n");
                    out.write("MovieIntroduce：" + MoviesIntroduce.text() + "\n");
                    out.write("================================================\n");
                }else{
                    System.out.println("moviesClass：" + moviesClass.attr("title"));
                    System.out.println("Movies Title Link：" + titleDoc);
                    System.out.println("MovieIntroduce：No introduce");
                    out.write("moviesClass：" + moviesClass.attr("title") + "\n");
                    out.write("Movies Title Link：" + titleDoc + "\n");
                    out.write("MovieIntroduce：No introduce\n");
                    out.write("================================================\n");
                }
                count = count + 1;
            }
            out.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
