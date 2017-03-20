import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;


public class ClientGUI extends JFrame implements ListSelectionListener, ActionListener {

    // Setting variables globally
    JPanel backPanel, mainPanel, brandPanel, rightPanel, specPanel;
    JLabel sign, buildTitle;
    JTextArea displayArea;
    JComboBox brandType, contactType, sunType;
    JawtList specType;
    FrameTypes ft;
    Ocular frames;
    JMenu mnuFile, options, helpFile;
    JMenuItem showCurrent, mute, creators, noHelp;
    ExitCommand extc;
    cmdMenu  close;
    ImageIcon showIcon;
    JLabel forIcon;
    Vector Glasses, SunGlass, CLs;
    multiChoice mchoice;
    choiceFactory cfact;
    JButton select;

    // Initial setup within the constructor
    ClientGUI() {
        super("Spectacular Specticals");
        initComponents();
        setGUI();
        ImageIcon icon = new ImageIcon("ve.png");
        setIconImage(icon.getImage());
        buildingTheSelected();
        cfact = new choiceFactory();
    }

    private void initComponents() {

        // Menu bar setup
        JMenuBar mBar = new JMenuBar();

        // Nice colour
//        mBar.setBackground(new Color(218, 62, 62));
        mBar.setBackground(new Color(77, 77, 77));

        backPanel = new JPanel();
        backPanel.setLayout(new BorderLayout());
        getContentPane().add(backPanel);//Setting backPanel

        ft = new FrameTypes();

        mnuFile = new JMenu("File", true);
        options = new JMenu("Options", true);
        helpFile = new JMenu("Help", true);

        mnuFile.setForeground(Color.white);
        options.setForeground(Color.white);
        helpFile.setForeground(Color.white);

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

        // Welcome label
        // Setting fonts and preferred size
        sign = new JLabel("");
        sign.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 50));
        sign.setFont(new Font("Sans Serif", Font.BOLD, 20));
        showIcon = new ImageIcon("src/images/ve2.png");
        sign.setIcon(showIcon);
        sign.setForeground(Color.black);
        sign.setHorizontalAlignment(JLabel.CENTER);
        backPanel.add(sign, BorderLayout.NORTH);
        backPanel.setBackground(Color.white);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // Type of ocular assistance
        String [] glassesType = {"Frames", "Sunglasses", "Contact Lenses"};
//        specType = new JComboBox(glassesType);



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
        buildTitle.setFont(new Font("Sans Serif", Font.BOLD, 18));
        buildTitle.setHorizontalAlignment(SwingConstants.CENTER);
        buildTitle.setVerticalAlignment(SwingConstants.BOTTOM);





        forIcon = new JLabel();
        forIcon.setHorizontalAlignment(SwingConstants.CENTER);
        forIcon.setVerticalAlignment(SwingConstants.TOP);

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
        contactType.addActionListener(this);
        sunType.addActionListener(this);

        JLabel specify = new JLabel("Select product");
        specify.setForeground(Color.white);
        specPanel.add(specify);

        specPanel.setPreferredSize(new Dimension(150, 200));

        specPanel.setBackground(new Color(40,40,40));
        mainPanel.add(specPanel, gbc);

        specType = new JawtList(13);
        specType.addListSelectionListener(this);
        specPanel.add(specType);

        specType.add("Glasses");
        specType.add("Sunglasses");
        specType.add("Contact Lenses");

        specType.addListSelectionListener(this);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        JLabel specify1 = new JLabel("Select the brand");
        brandPanel.add(specify1);

        brandPanel.add(brandType);
        brandPanel.add(contactType);
        brandPanel.add(sunType);

        sunType.setVisible(false);
        contactType.setVisible(false);

        brandPanel.setPreferredSize(new Dimension(150, 200));
        brandPanel.setVisible(false);
        brandPanel.setBackground(new Color(40,40,40));
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

        mainPanel.setBackground(new Color(218, 62, 62));

        backPanel.add(mainPanel, BorderLayout.CENTER);
        select = new JButton("Select");
        select.setEnabled(false);        //disabled until stock picked
        select.addActionListener(this);
        specPanel.add(select);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        choiceSelected();
    }

    public void actionPerformed(ActionEvent ev) {
        plDialog pl = new plDialog(this, mchoice);
        pl.show();
        brandPanel.setVisible(true);

    }

    public void choiceSelected(){
        Vector v = null;
        int index = specType.getSelectedIndex();
        brandPanel.removeAll();
        System.out.println(specType.getSelectedIndex());

        switch (index) {
            case 0:
                v = Glasses;  break;
            case 1:
                v = SunGlass;   break;
            case 2:
                v = CLs; break;
            case 3:
                v = null;
        }

        System.out.println(v);

        mchoice = cfact.getChoiceUI(v);    //get one of the UIs
        brandPanel.add(mchoice.getUI());    //insert in right panel
        brandPanel.validate();         //re-layout and display
        brandPanel.repaint ();
        select.setEnabled(true);

    }

    public void buildingTheSelected(){
            //arbitrary list of stock, bond and fund holdings
            Glasses = new Vector();
            Glasses.addElement("Oakley");
            Glasses.addElement("Ted Baker");
            Glasses.addElement("Calvin Klein");
            Glasses.addElement("Minn Kinn");
            Glasses.addElement("Heritage");
            Glasses.addElement("Tagheur");
            Glasses.addElement("Tiffany");
            Glasses.addElement("Speedo");
            Glasses.addElement("LightFly");

            SunGlass = new Vector();
            SunGlass.addElement("Cisco");
            SunGlass.addElement("Coca Cola");
            SunGlass.addElement("General Electric");
            SunGlass.addElement("Harley Davidson");

            CLs = new Vector();
            CLs.addElement("Fidelity Magellan");
            CLs.addElement("T Rowe Price");
            CLs.addElement("Vanguard PrimeCap");
            CLs.addElement("Lindner Fund");
    }



/*
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
        */
//    }

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
