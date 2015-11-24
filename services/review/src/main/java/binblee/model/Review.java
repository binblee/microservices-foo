package binblee.model;

import java.util.List;

/**
 * Created by libin on 11/24/15.
 */
public class Review {
    public Review(String isbn, List<String> comments) {
        this.isbn = isbn;
        this.comments = comments;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    private String isbn;
    private List<String> comments;
}
