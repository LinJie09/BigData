import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Movies_Script {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://gimytv.com/browse/movies.html").get();
            System.out.println(doc.title());
            Elements moviesTitle = doc.select(".container .row li div.myui-vodlist__box h4.title.text-overflow a");
            System.out.println(moviesTitle);
            for (Element moviesClass : moviesTitle) {
                Elements TitleElement = doc.select("div.myui-vodlist__detail h4.title.text-overflow a");
                String titleName = TitleElement.attr("title");
//                System.out.println(titleName);
                String titleDoc = moviesClass.absUrl("href");
                Document moviesDoc = Jsoup.connect(titleDoc).get();
                System.out.println("Movies Title Link: "+ titleDoc);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
