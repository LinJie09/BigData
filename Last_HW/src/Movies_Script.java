import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Movies_Script {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://gimytv.com/browse/movies.html").get();
            System.out.println(doc.title());
            System.out.println("------------------------");
            Elements moviesTitle = doc.select(".container .row li div.myui-vodlist__box h4.title.text-overflow a");
            for (Element moviesClass : moviesTitle) {
                Elements titleName = doc.select("li .title.text-overflow");
                String titleDoc = moviesClass.absUrl("href");
                System.out.println("Movies Name : "+ moviesClass.attr("title"));
                System.out.println("Movies Title Link: "+ titleDoc);
                System.out.println("=================================================");

            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
