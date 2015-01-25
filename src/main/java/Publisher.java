/**
 * Created by marius on 25/01/15.
 */
public interface Publisher {

    public PublishResult publish(Article article) throws InterruptedException;
}
