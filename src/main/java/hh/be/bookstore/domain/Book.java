package hh.be.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    private Long isbn;
    private String title;
    private String author;
    private int publicationYear;
    private float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // ...existing code...

    public Book(String title, String author, int publicationYear, Long isbn, float price, Category category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    // ...existing code...

    public Book() {
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbn = null;
        this.price = 0.0f;
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

    @Override
    public String toString() {
        return "Book [title=" + title
                + ", author=" + author
                + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn
                + ", price=" + price
                + ", category=" + (category != null ? category.getcName() : null)
                + "]";
    }

}