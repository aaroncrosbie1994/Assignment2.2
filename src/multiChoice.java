import java.util.*;
import java.awt.*;
import javax.swing.*;
public abstract class multiChoice {
    //This is the abstract base class
    //that the listbox and checkbox choice panels
    //are derived from
    protected Vector choices;    //array of labels

    public multiChoice(Vector choiceList) {
        choices = choiceList;    //save list
    }
    //to be implemented in derived classes
    abstract public JPanel getUI();         //return a Panel of components
    abstract public String[] getSelected();   //get a list those selected
    abstract public void clearAll();       //clear all the selected items
}
