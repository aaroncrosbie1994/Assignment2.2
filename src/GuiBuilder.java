import javax.swing.*;
import java.awt.*;

public class GuiBuilder extends ClientGUI {
    public JPanel getUi(){
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        String [] choices = {"Frame","Contact"};
        JComboBox specType = new JComboBox(choices);
        specType.addActionListener(this);
        p.add(specType);
        return p;
    }
}
