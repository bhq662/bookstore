package hh.backend.autoprojekti.domain;

public class Car {

    // attribuutit
    private String model;
    private Integer year;

    // konstruktorit
    public Car() {
        this.model = null;
        this.year = null;
    }

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    // getterit
    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    // setterit
    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    // toString
    @Override
    public String toString() {
        return "Car [model=" + model + ", year=" + year + "]";
    }

}