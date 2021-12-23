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
//            System.out.println(moviesTitle);
            for (Element moviesClass : moviesTitle) {
                Elements titleName = doc.select("li .myui-vodlist__detail");
                //16行是抓 a Tag 裡的 Title 
                System.out.println("Title : "+ titleName.select("a").attr("title"));
                String titleDoc = moviesClass.absUrl("href");
                Document moviesDoc = Jsoup.connect(titleDoc).get();
                System.out.println("Movies Title Link: "+ titleDoc);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
