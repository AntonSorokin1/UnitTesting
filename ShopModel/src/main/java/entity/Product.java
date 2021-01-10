package entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@JsonAutoDetect
@XmlType(name = "product")
public class Product {
    private String manufacturer;
    private String model;
    private Calendar date;
    private String color;
    private Double price;
    private Integer number;
    private Boolean isAvailable;

    public Product() {
    }

    public Product(String manufacturer, String model, Calendar date, String color, Double price, Integer number, Boolean isAvailable) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.date = date;
        this.color = color;
        this.price = price;
        this.number = number;
        this.isAvailable = isAvailable;
    }

    @XmlAttribute
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @XmlAttribute
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @XmlAttribute
    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(date.getTime());
    }
    public void setDate(String date) throws ParseException {
        if (this.date == null) this.date = Calendar.getInstance();
        this.date.setTime(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(date));
    }

    @XmlAttribute
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @XmlAttribute
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @XmlAttribute
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    @XmlAttribute
    public Boolean getAvailable() {
        return isAvailable;
    }
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "product: { " +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", date=" + date.get(Calendar.DAY_OF_MONTH) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.YEAR) +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", isAvailable=" + isAvailable +
                " }";
    }
}
