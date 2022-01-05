import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Author_Script {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://gimytv.com/v_XvT.html").get();
            System.out.println(doc.title());
            System.out.println("------------------------");
            Elements article = doc.select(".container .myui-panel_bd #remark42");
            System.out.println(article);
            for (Element articleClass : article) {
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
