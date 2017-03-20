import java.awt.*;
import javax.swing.*;

public class fileCommand implements Command {
    JFrame frame;

    public fileCommand(JFrame fr) {
        frame = fr;
    }
    //------------------------------
    public void Execute() {
        FileDialog fDlg = new FileDialog(frame, "Open file");
        fDlg.show();
    }
}
