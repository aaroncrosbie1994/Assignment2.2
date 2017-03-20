import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame implements ActionListener {

    // Setting variables globally
    JPanel backPanel, mainPanel, brandPanel, rightPanel, specPanel;
    JLabel sign, buildTitle;
    JTextArea displayArea;
    JComboBox specType, brandType, contactType, sunType;
    FrameTypes ft;
    Ocular frames;
    JMenu mnuFile, options, helpFile;
    JMenuItem showCurrent, mute, creators, noHelp;
    ExitCommand extc;
    cmdMenu  close;
    ImageIcon showIcon;
    JLabel forIcon;

    // Initial setup within the constructor
    ClientGUI() {
        super("Spectacular Specticals");
        initComponents();
        setGUI();
        ImageIcon icon = new ImageIcon("glasses.png");
        setIconImage(icon.getImage());
    }

    private void initComponents() {

        // Menu bar setup
        JMenuBar mBar = new JMenuBar();

        mBar.setBackground(new Color(0, 102, 255));
        mBar.setForeground(Color.white);

        backPanel = new JPanel();
        backPanel.setLayout(new BorderLayout());
        getContentPane().add(backPanel);//Setting backPanel

        ft = new FrameTypes();

        mnuFile = new JMenu("File", true);
        options = new JMenu("Options", true);
        helpFile = new JMenu("Help", true);

        mBar.add(mnuFile);
        mBar.add(options);
        mBar.add(helpFile);

        showCurrent = new JMenuItem("Current build");
        mute = new JMenuItem("Mute sound");
        creators = new JMenuItem("Creators");
        noHelp = new JMenuItem("No help");


//        update = new cmdMenu("Close", this);
//        update.setCommand (new UpdateCommand());

        close = new cmdMenu("Close", this);
        close.setCommand (new ExitCommand());

        mnuFile.add(showCurrent);
        mnuFile.add(close);
        close.addActionListener(this);
        options.add(mute);

        helpFile.add(creators);
        helpFile.add(noHelp);

        setJMenuBar(mBar);

        sign = new JLabel("Temp");
        backPanel.add(sign, BorderLayout.NORTH);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // Type of ocular assistance
        String [] glassesType = {"Frames", "Sunglasses", "Contact Lenses"};
        specType = new JComboBox(glassesType);

        // Brand names for contact lenses
        String [] brandsContact = {"Eye Expert", "Expert Comfort plus", "Kiba Vision", "Alcon"};
        contactType = new JComboBox(brandsContact);

        // Brand names for sunglasses
        String [] brandsSun = {"Hugo Boss", "Oakley", "Ted Baker", "Polaroid", "VE", "Gucci", "Paul Smyth", "Tiffany"};
        sunType = new JComboBox(brandsSun);

        // Brand names for normal glasses
        String [] brands = {"Oakley", "Ted Baker", "Calvin Klein", "Minn Kinn", "Heritage", "Tagheur", "Tiffany", "Speedo", "LightFly"};
        brandType = new JComboBox(brands);

        specPanel = new JPanel();
        brandPanel = new JPanel();
        rightPanel = new JPanel(new GridLayout(2,1));

        buildTitle = new JLabel("Your Current Build:");
        buildTitle.setFont(new Font("Comic Sans", Font.BOLD, 18));
        buildTitle.setHorizontalAlignment(SwingConstants.CENTER);
        buildTitle.setVerticalAlignment(SwingConstants.BOTTOM);

        showIcon = new ImageIcon("src/glasses.png");
        forIcon = new JLabel();
        forIcon.setHorizontalAlignment(SwingConstants.CENTER);
        forIcon.setVerticalAlignment(SwingConstants.TOP);
        forIcon.setIcon(showIcon);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBackground(Color.WHITE);
    }

    private void setGUI(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 10, 10,10);

        brandType.addActionListener(this);
        specType.addActionListener(this);
        contactType.addActionListener(this);
        sunType.addActionListener(this);

        specPanel.add(specType);
        specPanel.setBackground(new Color(0, 102, 255));
        mainPanel.add(specPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        brandPanel.add(brandType);
        brandPanel.add(contactType);
        brandPanel.add(sunType);

        sunType.setVisible(false);
        contactType.setVisible(false);

        brandPanel.setVisible(false);
        brandPanel.setBackground(new Color(0, 102, 255));
        mainPanel.add(brandPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        rightPanel.add(forIcon);
        rightPanel.add(buildTitle);

        gbc.fill = GridBagConstraints.BOTH;

        rightPanel.add(displayArea);
        mainPanel.add(rightPanel, gbc);

        mainPanel.setBackground(new Color(100, 149, 237));


        backPanel.add(mainPanel, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

//        CommandHolder obj = (CommandHolder) e.getSource();
//        obj.getCommand().Execute();

        if (e.getSource() == specType) {
            frames = ft.getOcular(specType.getSelectedItem().toString());

            // Need to optimize this... Badly!
            if (specType.getSelectedItem().toString() == "Frames") {
                brandType.setVisible(true);
                sunType.setVisible(false);
                contactType.setVisible(false);
                frames.setBrand(brandType.getSelectedItem().toString());
                forIcon.setIcon(showIcon);

            } else if (specType.getSelectedItem().toString() == "Sunglasses") {

                sunType.setVisible(true);
                brandType.setVisible(false);
                contactType.setVisible(false);
                frames.setBrand(sunType.getSelectedItem().toString());
            } else {
                contactType.setVisible(true);
                sunType.setVisible(false);
                brandType.setVisible(false);
                frames.setBrand(contactType.getSelectedItem().toString());
            }

            updateDisplay();
        }
    }

//        if(e.getSource() == brandType){
//            frames.setBrand(brandType.getSelectedItem().toString());
//            updateDisplay();
//        }



    public void updateDisplay(){
        displayArea.setText("");
        displayArea.append(frames.getType() + "\n");

        if(frames.getType() != null){
            brandPanel.setVisible(true);
        }
        if(frames.getBrand() != null){
            displayArea.append(frames.getBrand() + "\n");
        }
        displayArea.repaint();
        displayArea.updateUI();
    }

    public static void main(String []  args)  {
        ClientGUI gui = new ClientGUI();
    }
}
