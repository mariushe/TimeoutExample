import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class PublishArticlesUseCase {

    private Publisher publisher;

    public PublishArticlesUseCase(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<PublishResult> publishArticles(List<Article> articles) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return articles.stream()
                .map(article -> {

                    Future<PublishResult> task = executorService.submit(() -> publisher.publish(article));

                    try {
                        return task.get(10, TimeUnit.SECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        return PublishResult.FAILED(article);
                    }
                })
                .collect(Collectors.toList());
    }
}
