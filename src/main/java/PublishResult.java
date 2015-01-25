public class PublishResult {

    public enum Status {
        OK, FAILED
    }

    private final Article article;
    private final Status status;

    private PublishResult(Article article, Status status) {
        this.article = article;
        this.status = status;
    }

    public static PublishResult FAILED(Article article) {
        return new PublishResult(article, Status.FAILED);
    }

    public static PublishResult OK(Article article) {
        return new PublishResult(article, Status.OK);
    }

    public Article getArticle() {
        return article;
    }

    public Status getStatus() {
        return status;
    }
}
