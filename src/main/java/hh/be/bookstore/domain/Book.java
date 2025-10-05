package hh.be.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private Long isbn;
    private String title;
    private String author;
    private int publicationYear;
    private float price;

    @ManyToOne
    // @JsonIgnoreProperties - one way to avoid infinite loop during JSON
    // serialization/deserialization with bidirectional relationships
    @JsonIgnoreProperties("books")
    @JoinColumn(name = "category_id")
    private Category category;

    public Book(String title, String author, int publicationYear, Long isbn, float price, Category category) {
        super();
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    public Book() {
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbn = null;
        this.price = 0.0f;
    }

    // Getters and setters

    public Long getBookId() {
        return bookId;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public Long getIsbn() {
        return isbn;
    }

    public float getPrice() {
        return price;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "Book [id = " + bookId
                + "title=" + title
                + ", author=" + author
                + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn
                + ", price=" + price
                + ", category=" + (category != null ? category.getCategoryName() : null)
                + "]";
    }
}