package hh.be.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;
    private String cName;

    public Category() {
        this.cId = null;
        this.cName = null;
    }

    public Category(Long cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }

    public Long getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
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
