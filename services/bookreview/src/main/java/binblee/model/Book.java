package binblee.model;

import com.eureka2.shading.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by libin on 11/24/15.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String name;
    private String author;
    private Double price;
    private String isbn;

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
