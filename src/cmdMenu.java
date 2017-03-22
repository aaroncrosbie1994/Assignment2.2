import javax.swing.*;

public class cmdMenu extends JMenuItem implements CommandHolder {
   protected Command menuCommand;
   protected JFrame frame;
//-----------------------
   public cmdMenu(String name, JFrame frame) {
      super(name);
      this.frame = frame;
   }
//-----------------------
   public void setCommand(Command command) {
      menuCommand = command;
   }
//-----------------------
   public Command getCommand() {
      return menuCommand;
   }
}
