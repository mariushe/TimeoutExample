import java.util.Date;
import java.util.List;

/**
 * Created by marius on 25/01/15.
 */
public class Article {

    private final Integer id;
    private final String title;

    public Article(Integer id, String title) {
        this.id = id;
        this.title = title;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
