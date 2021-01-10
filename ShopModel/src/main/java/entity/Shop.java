package entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@JsonAutoDetect
@XmlRootElement(name = "shop", namespace = "https://www.cs.com/")
public class Shop {
    private List<Category> categories;

    public Shop() {
    }

    public Shop(List<Category> categories) {
        this.categories = categories;
    }

    @XmlElement(name = "category")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        if (categories == null) return "Shop: [null]";
        StringBuilder sb = new StringBuilder();
        sb.append("Shop: [");
        categories.forEach(category -> sb.append("\n\t").append(category.toString()));
        sb.append("\n]");
        return sb.toString();
    }
}
