package binblee;

import binblee.model.Book;
import binblee.model.BookReview;
import binblee.model.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by libin on 11/24/15.
 */

@RestController
public class BookReviewController {

    private static final Logger log = LoggerFactory.getLogger(BookReviewController.class);

    @Autowired
    private LoadBalancerClient loadBalancer;

    private RestTemplate restTemplate = new RestTemplate();

    public BookReviewController() {
    }

    @RequestMapping(value="/br/{isbn}", method = RequestMethod.GET)
    public BookReview getBookReview(@PathVariable String isbn){

        URI uri = fetchServiceURI("book");
        String productUrl = uri + "/book/" + isbn;
        Book book = restTemplate.getForObject(productUrl, Book.class);

        uri = fetchServiceURI("review");
        String reviewUrl = uri + "/review/" + isbn;

        Review review = restTemplate.getForObject(reviewUrl, Review.class);

        BookReview br = new BookReview();
        br.setAuthor(book.getAuthor());
        br.setIsbn(book.getIsbn());
        br.setTitle(book.getName());
        br.setComments(review.getComments());

        return br;
    }

    private URI fetchServiceURI(String serviceName){
        ServiceInstance serviceInstance = loadBalancer.choose(serviceName);
        return serviceInstance.getUri();
    }
}
