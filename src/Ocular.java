/**********************************
 * Created by Gelmis S. Bartulis  *
 * & Aaron Crosbie                *
 * Date: 13/03/2017               *
 * Subject: Object Orientation    *
 *          with Design Patterns  *
 * Type: Assignment [2]           *
 *********************************/

public abstract class Ocular {

    private String description;
    private String brand;
    private String type;
    private int price;

    public Ocular(){
        description = null;
        brand = null;
        type = null;
        price = 0;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
