import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class PublishArticlesUseCaseTest {


    @Test
    public void testPublisherTimeout() throws Exception {

        PublishArticlesUseCase useCase = new PublishArticlesUseCase(article -> {
            Thread.sleep(20000);
            return PublishResult.OK(article);
        });

        List<Article> articles = Arrays.asList(new Article(3, "Java rises again"));
        List<PublishResult> result = useCase.publishArticles(articles);

        assertEquals(result.get(0).getStatus(), PublishResult.Status.FAILED);
    }

    @Test
    public void testPublisherOk() throws Exception {

        PublishArticlesUseCase useCase = new PublishArticlesUseCase(article -> PublishResult.OK(article));

        List<Article> articles = Arrays.asList(new Article(3, "Java rises again"));
        List<PublishResult> result = useCase.publishArticles(articles);

        assertEquals(result.get(0).getStatus(), PublishResult.Status.OK);
    }
}