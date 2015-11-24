package binblee.model;

import com.eureka2.shading.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by libin on 11/24/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
    private String isbn;
    private List<String> comments;

    public Review(){

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

    @Override
    public String toString() {
        return "Review{" +
                "isbn='" + isbn + '\'' +
                ", comments=" + comments +
                '}';
    }
}
