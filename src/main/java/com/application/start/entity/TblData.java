package com.application.start.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Comparator;

@Entity
@Table(name = "tbl_data")
public class TblData {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "city")
    private String city;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "price")
    private Double price;
    @Column(name = "status")
    private String status;
    @Column(name = "color")
    private String color;

    public TblData(String city, LocalDate startDate, LocalDate endDate, Double price, String status, String color) {
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.status = status;
        this.color = color;
    }

    public TblData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "TblData{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static Comparator<TblData> sortByCity = new Comparator<TblData>() {
        public int compare(TblData obj1, TblData obj2) {

            //sort in ascending order
            return obj1.city.compareTo(obj2.city);

            //sort in descending order
            //return obj2.city.compareTo(obj1.city);
        }
    };

    public static Comparator<TblData> sortByCityDes = new Comparator<TblData>() {
        public int compare(TblData obj1, TblData obj2) {

            //sort in ascending order
            //return obj1.city.compareTo(obj2.city);

            //sort in descending order
            return obj2.city.compareTo(obj1.city);
        }
    };
}
