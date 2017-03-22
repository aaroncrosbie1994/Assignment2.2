import javax.swing.*;

public class AuthorsCommand implements Command {
    public void Execute(){
        JOptionPane.showMessageDialog(null, "Authors:\nAaron Crosbie\nGelmis S. Bartulis", "Authors", JOptionPane.PLAIN_MESSAGE);
    }
}
