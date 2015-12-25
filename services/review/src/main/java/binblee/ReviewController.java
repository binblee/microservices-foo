package binblee;

import binblee.model.Review;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by libin on 11/24/15.
 */

@RestController
public class ReviewController {


    @Value("${eureka.instance.instanceId}")
    private String randomValue;

    public ReviewController() {
    }

    @RequestMapping(value="/review/{isbn}", method = RequestMethod.GET)
    public Review getReview(@PathVariable String isbn){
        Map<String,Review> reviews = new HashMap<String,Review>();
        List<String> isbnList = Arrays.asList("1","2","3","4");
        for( String isbnInList : isbnList ){
            List<String> comments = Arrays.asList(
                    randomValue + " comment 1 for " + isbnInList,
                    randomValue + " comment 2 for " + isbnInList,
                    randomValue + " comment 3 for " + isbnInList);
            Review review = new Review(isbn,comments);
            reviews.put(isbn,review);
        }
        return reviews.get(isbn);
    }
}
