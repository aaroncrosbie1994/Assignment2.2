import javax.swing.*;
import java.util.ArrayList;

/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 13/03/2017 ******************
 * Subject: ***********************
 *********************************/
public class FactoryInfo {

    ArrayList<Ocular> ocular = new ArrayList<Ocular>();

    private String name;
    private ImageIcon imageIcon;
    private String description;

    FactoryInfo(String name) {
        this.name = name;
        imageIcon = null;
        description = null;
    }

    public Ocular getOcular(int i) {
        return ocular.get(i);
    }

    public void addOcular(Ocular ocular) {
        this.ocular.add(ocular);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
