import javax.swing.*;

public class CurrentBuildCommand implements Command {

    Ocular frames;
    String build = "Please enter information before displaying current build";

    public CurrentBuildCommand(Ocular frames){
        this.frames = frames;
    }

    public void updateDetails(Ocular frames){
        this.frames = frames;
        build = "Type: " + frames.getType() + "\nBrand: " + frames.getBrand();
    }

    public void Execute(){
        JOptionPane.showMessageDialog(null, build , "Current Build", JOptionPane.PLAIN_MESSAGE);
    }
}
