package hh.be.bookstore.domain;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("unused")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;
    private String cName;

    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();

    public Category() {
        this.cId = null;
        this.cName = null;
    }

    public Category(Long cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Long getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Category [cId=" + cId + ", cName=" + cName + "]";
    }

}
