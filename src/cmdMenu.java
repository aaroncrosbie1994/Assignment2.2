import javax.swing.*;

public class cmdMenu extends JMenuItem implements CommandHolder {
   protected Command menuCommand;
   protected JFrame frame;
//-----------------------
   public cmdMenu(String name, JFrame frm) {
      super(name);
      frame = frm;
   }
//-----------------------
   public void setCommand(Command comd) {
      menuCommand = comd;
   }
//-----------------------
   public Command getCommand() {
      return menuCommand;
   }
}
