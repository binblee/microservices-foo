package binblee;

import binblee.model.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by libin on 11/21/15.
 */

@RestController
public class BookController {

    private List<Book> books = Arrays.asList(
            new Book("Javascript Book","JS Author",10.2),
            new Book("Java Book","Java Author", 15.3),
            new Book("Ruby Book","Ruby Author", 16.0),
            new Book("Python Book","Python Author", 17.0)
            );

    @RequestMapping("/books")
    public List<Book> getBooks(){
        return books;
    }
}
