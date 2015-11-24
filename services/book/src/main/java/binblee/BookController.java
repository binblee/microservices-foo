package binblee;

import binblee.model.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by libin on 11/21/15.
 */

@RestController
public class BookController {

    private List<Book> bookList = Arrays.asList(
            new Book("Javascript Book","JS Author",10.2,"1"),
            new Book("Java Book","Java Author", 15.3,"2"),
            new Book("Ruby Book","Ruby Author", 16.0,"3"),
            new Book("Python Book","Python Author", 17.0,"4")
    );
    private Map<String, Book> bookMap;

    public BookController() {
        bookMap = new HashMap<String, Book>();
        for(Book book : bookList){
            bookMap.put(book.getIsbn(),book);
        }
    }

    @RequestMapping(value = "/books", method=RequestMethod.GET)
    public List<Book> getBooks(){
        return bookList;
    }

    @RequestMapping(value = "/book/{isbn}",method = RequestMethod.GET)
    public Book getBook(@PathVariable String isbn){
        return bookMap.get(isbn);
    }
}
