import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider_Food {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://gimy.app/").get();
            System.out.println(doc.title());
            Elements authorClasses = doc.select(".container .col-lg-6  col-md-6 col-sm-4 col-xs-3");
            System.out.println(authorClasses);
/*            for (Element authorClass : authorClasses) {
                String Topic = authorClasses.select(".sc-15-yfh73-4.jPnNqj").text();
                Document hotBoardDoc = Jsoup.connect().get();
                String articleSortDoc = authorClass.absUrl("href");
                System.out.println("author: "+ articleSortDoc);
                System.out.println("Topic: "+ Topic);
            }*/
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
