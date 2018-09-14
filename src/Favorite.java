import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Favorite {

    private String id = "id";
    private String name;
    private String favorite;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getFavorite() {
        return favorite;
    }

    @XmlElement
    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "name='" + name + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }
}
