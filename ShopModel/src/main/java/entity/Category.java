package entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@JsonAutoDetect
public class Category {
    private String name;
    private List<SubCategory> subCategories;

    public Category() {
    }

    public Category(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @XmlAttribute(name = "categoryName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "subcategory")
    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public String toString() {
        if (subCategories == null) return name + ": [null]";
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": [");
        subCategories.forEach(subCategory -> sb.append("\n\t\t").append(subCategory.toString()).append(" "));
        sb.append("\n\t]");
        return sb.toString();
    }
}
