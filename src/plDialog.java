import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class plDialog extends Dialog
implements ActionListener {
    Button OK;
    public plDialog(Frame fr, multiChoice ui)
    {
        super(fr, "Plotting:", true);
        //put selected funds in string
        String[] invsts = ui.getSelected();
        String title = "";
        for (int i = 0; i < invsts.length; i++) {
            title += invsts[i] + "; ";
        }
        add("Center", new Label(title)); //display fund list
        OK = new Button("OK");
        Panel p = new Panel();
        add("South", p);                 //close button
        p.add(OK);
        OK.addActionListener(this);
        setBounds(100,100,300,200);

    }
    public void actionPerformed(ActionEvent ev)
    {
        setVisible(false);
    }
}
