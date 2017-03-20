import javax.swing.*;

public class CurrentBuildCommand implements Command {

    Ocular frames;

    public CurrentBuildCommand(Ocular frames){
        this.frames = frames;
    }

    public void updateDetails(Ocular frames){
        this.frames = frames;
    }

    public void Execute(){
        String build = "Type: " + frames.getType() + "\nBrand: " + frames.getBrand();
        JOptionPane.showMessageDialog(null, build , "Current Build", JOptionPane.PLAIN_MESSAGE);
    }
}
