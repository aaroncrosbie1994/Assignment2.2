import javafx.scene.control.RadioButton;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class radioButtonChoice extends multiChoice {

    //This derived class creates
    //vertical grid of checkboxes

    int count;           //number of checkboxes
    JPanel p;             //contained in here

    //--------------------------------------------
    public radioButtonChoice(Vector choices) {
        super(choices);
        count = 0;
        p = new JPanel();
    }

    //--------------------------------------------
    public JPanel getUI() {
        String s;

        //create a grid layout 1 column by n rows
        p.setLayout(new GridLayout(choices.size(), 1));
        //and add labeled check boxes to it
        for (int i=0; i< choices.size(); i++) {
            s =(String)choices.elementAt(i);
            p.add(new JRadioButton(s));
            count++;
        }
        return p;
    }

    //--------------------------------------------
    public String[] getSelected() {
        JRadioButton cb;
        Vector clist = new Vector();
        //Copy JRadioButton what are checked
        //into the Vector clist
        for (int i = 0; i < count; i++ ) {
            cb = (JRadioButton)p.getComponent(i);
            if (cb.isSelected ())
                clist.addElement(cb.getText());
        }
        //create a string array the size of the
        //number of checked boxes
        String[] slist = new String[clist.size()];

        //copy labels of chekced radio buttons into
        //the string array
        for (int i = 0; i < clist.size(); i++)
            slist[i] = (String)(clist.elementAt(i));
        return(slist);
    }
    //--------------------------------------------
    public void clearAll() {
//        //uncheck all boxes
//        for (int i=0; i < count; i++) {
//            ((RadioButton)(p.getComponent(i))).setState(false);
//        }
    }
}

