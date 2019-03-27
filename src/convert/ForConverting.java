package convert;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ForConverting {

    private String somString;
    private int id;


    public ForConverting(String somString, int id) {
        this.somString = somString;
        this.id = id;
    }

    public ForConverting() {
    }

    public String getSomString() {
        return somString;
    }

    public void setSomString(String somString) {
        this.somString = somString;
    }

    @XmlElement(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
