package hh.backend.autolomakeprojekti.domain;

public class Car {
    private String model;
    private Long year;

    public Car(String model, long year) {
        this.model = model;
        this.year = year;
    }

    public Car() {
        this.model = null;
        this.year = null;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public Long getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", year=" + year + "]";
    }
}
