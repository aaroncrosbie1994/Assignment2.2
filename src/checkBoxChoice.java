import java.awt.*;
import java.util.*;
import javax.swing.*;
public class checkBoxChoice extends multiChoice {
    //This derived class creates 
    //vertical grid of checkboxes
    int count;           //number of checkboxes
    JPanel p;             //contained in here
//--------------------------------------------
    public checkBoxChoice(Vector choices) {
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
            p.add(new JCheckBox(s));
            count++;
        }
        return p;
    }
//--------------------------------------------
    public String[] getSelected() {
        JCheckBox cb;
        Vector clist = new Vector();
        //Copy checkboxes what are checked
        //into the Vector clist
        for (int i = 0; i < count; i++ ) {
            cb = (JCheckBox)p.getComponent(i);
            if (cb.isSelected ())
                clist.addElement(cb.getText());
        }
        //create a string array the size of the
        //number of checked boxes
        String[] slist = new String[clist.size()];

        //copy labels of chekced boxes into
        //the string array
        for (int i = 0; i < clist.size(); i++)
            slist[i] = (String)(clist.elementAt(i));
        return(slist);
    }
//--------------------------------------------
    public void clearAll() {
        //uncheck all boxes
        for (int i=0; i < count; i++) {
            ((Checkbox)(p.getComponent(i))).setState(false);
        }
    }
}

