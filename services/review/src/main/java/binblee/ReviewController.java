package binblee;

import binblee.model.Review;
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

    private Map<String,Review> reviews;

    public ReviewController() {
        reviews = new HashMap<String,Review>();
        List<String> isbnList = Arrays.asList("1","2","3","4");
        for( String isbn : isbnList ){
            List<String> comments = Arrays.asList(
                    "comment 1 for " + isbn,
                    "comment 2 for " + isbn,
                    "comment 3 for " + isbn);
            Review review = new Review(isbn,comments);
            reviews.put(isbn,review);
        }
    }

    @RequestMapping(value="/review/{isbn}", method = RequestMethod.GET)
    public Review getReview(@PathVariable String isbn){
        return reviews.get(isbn);
    }
}
