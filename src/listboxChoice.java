import java.util.*;
import java.awt.*;
import javax.swing.*;

public class listboxChoice extends multiChoice {
    JawtList list;
//--------------------------------------------
    public listboxChoice(Vector choices) {
        super(choices);
    }
//--------------------------------------------
    public JPanel  getUI() {
        //create a panel containing a list box
        JPanel p = new JPanel();
        list = new JawtList(choices.size());
        list.setMultipleMode(true);
        p.add(list);
        for (int i=0; i< choices.size(); i++)
            list.add((String)choices.elementAt(i));
        return p;
    }
//--------------------------------------------
    public String[] getSelected() {
        String[] slist = list.getSelectedItems ();
        return(slist);
    }
    //--------------------------------------------
    public void clearAll() {
        //unselect all lines in the list
        for (int i=0; i< choices.size(); i++)
            list.deselect(i);
    }
}

