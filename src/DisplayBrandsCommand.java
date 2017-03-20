import javax.swing.*;

public class DisplayBrandsCommand implements Command {

    private String str;
    ClientGUI gui = new ClientGUI();
    public void Execute(){
        JOptionPane.showMessageDialog(gui, str, "asdf", JOptionPane.PLAIN_MESSAGE);
    }

    public void getBrands(String str){
        this.str = str;
    }
}
