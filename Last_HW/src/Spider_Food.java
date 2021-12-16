import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider_Food {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.pixnet.net/tags/%E9%AB%98%E9%9B%84%E7%BE%8E%E9%A3%9F?utm_source=PIXNET&utm_medium=navbar&utm_term=search_result_tag&utm_content=%E9%AB%98%E9%9B%84%E7%BE%8E%E9%A3%9F").get();
            System.out.println(doc.title());
            Elements authorClasses =doc.select("#root .sc-15yfh73-3.dTOYFB .sc-15-yfh73-4.jPnNqj a.sc-15yfh73-5.clZsAM");
            for (Element authorClass : authorClasses) {
                String Topic = authorClasses.select(".sc-15-yfh73-4.jPnNqj").text();
                String articleSortDoc = authorClass.absUrl("href");
                System.out.println("author: "+ articleSortDoc);
                System.out.println("Topic: "+ Topic);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
