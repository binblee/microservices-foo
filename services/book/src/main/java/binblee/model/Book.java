package binblee.model;

/**
 * Created by libin on 11/21/15.
 */
public class Book {
    public Book(String name, String author, Double price, String isbn) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
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

    private String name;
    private String author;
    private Double price;
    private String isbn;

}
