package entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@JsonAutoDetect
public class SubCategory {
    private String name;
    private List<Product> products;

    public SubCategory() {
    }

    public SubCategory(List<Product> products) {
        this.products = products;
    }

    @XmlAttribute(name = "subCategoryName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "product")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        if (products == null) return name + ": [null]";
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": [ ");
        products.forEach(product -> sb.append("\n\t\t\t").append(product.toString()).append(" "));
        sb.append("\n\t\t]");
        return sb.toString();
    }
}
