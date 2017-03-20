/**********************************
 * Created by Gelmis S. Bartulis  *
 * & Aaron Crosbie                *
 * Date: 13/03/2017               *
 * Subject: Object Orientation    *
 *          with Design Patterns  *
 * Type: Assignment [2]           *
 *********************************/

public class FrameTypes {

    public Ocular getOcular(String type)
    {
        if(type.equals("Frames")){
            //System.out.println("We got frames");
            return new Frames();
        }
        else if(type.equals("Sunglasses")){
            //System.out.println("We got contacts");
            return new Sunglasses();
        }
        else {
            //System.out.println("We got lenses");
            return new ContactLenses();
        }
    }
}
