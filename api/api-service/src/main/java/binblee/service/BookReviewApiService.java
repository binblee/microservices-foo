package binblee.service;

import binblee.service.model.BookReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;
import java.net.URI;

/**
 * Created by libin on 12/10/15.
 */

@RestController
public class BookReviewApiService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private RestTemplate restTemplate = new RestTemplate();

    public BookReviewApiService() {
    }

    @RequestMapping(value="/ping", method = RequestMethod.GET)
    public String ping(){
        return "Pong";
    }

    @RequestMapping(value="/bbr/{isbn}", method = RequestMethod.GET)
    public BookReview getBookReview(@PathVariable String isbn){
        URI uri = fetchServiceURI("bookreview");
        BookReview bookReview = restTemplate.getForObject(uri + "/br/" + isbn, BookReview.class);
        return bookReview;
    }

    private URI fetchServiceURI(String serviceName){
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceName);
        return serviceInstance.getUri();
    }
}
