/* Matthew Sital-Singh
   ms1473
   COMS12100 Assignment: Scene
*/

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;

/** Slackpad.java
    Slackpad is a work-avoidance tool which simulates
    a normal text editor.
    However, when in 'Slacker mode', the program
    will respond to keystrokes by printing out the contents
    of the file last 'opened'.
**/

public class Slackpad extends JFrame {

    /** Main constructor
        Draws GUI components to the frame
        and makes it visible
     */
    public Slackpad() {
        note = this;
        Container panel = getContentPane();
        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(scrollview, gbc);

        ImageIcon icon = getMyImage("slack.gif");
        setIconImage(icon.getImage());
        setSize(800, 600);
        setTitle("Slackpad");
        addWindowListener(new CloseWindow());

        setJMenuBar(mainBar);
        mainBar.setLayout(new BorderLayout());

        mainBar.add(menuBar, BorderLayout.NORTH);
        menuBar.add(fileMenu);
        fileMenu.setMnemonic('F');
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(toolsMenu);
        toolsMenu.setMnemonic('T');
        toolsMenu.add(modeCheckBox);
        toolsMenu.add(setTitleMenuItem);
        toolsMenu.add(skipMenuItem);
        menuBar.add(helpMenu);
        helpMenu.setMnemonic('H');
        helpMenu.add(aboutMenuItem);
        helpMenu.add(readmeMenuItem);

        Ears menuEars = new Ears();

        String[] tmp = lib.getNames();
        for (int i=0; i < tmp.length; i++) {
            StoryMenuItem smi = new StoryMenuItem(tmp[i]);
            smi.addActionListener(menuEars);
            storyMenuItem.add(smi);
        }

        toolsMenu.add(storyMenuItem);

        newButton = new JButton(getMyImage("new.gif"));
        openButton = new JButton(getMyImage("open.gif"));

        newButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        mainBar.add(buttonBar, BorderLayout.SOUTH);
        buttonBar.add(newButton);
        openButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        buttonBar.add(openButton);

        newMenuItem.addActionListener(menuEars);
        openMenuItem.addActionListener(menuEars);
        exitMenuItem.addActionListener(menuEars);
        modeCheckBox.addActionListener(menuEars);
        setTitleMenuItem.addActionListener(menuEars);
        skipMenuItem.addActionListener(menuEars);
        aboutMenuItem.addActionListener(menuEars);
        readmeMenuItem.addActionListener(menuEars);

        newButton.addActionListener(menuEars);
        openButton.addActionListener(menuEars);

        contents.setText(lib.getReadme());

        setVisible(true);
    }

    /** Connects the 'source' buffer to a file
        specified by the string
        @param filename the file to 'open'
    */
    private boolean getFile(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            source = new BufferedReader(fr);
            cFilename = filename;
            usingFile = true;
        } catch (Exception e) {
            //e.printStackTrace();
            errorMessage("Could not open file \'" + filename + "\'");
            return false;
        }
        return true;
    }

    /** Connects the 'source' buffer to a predefined
        String contained in the Slackwords class
        @param story name of the 'story' to find
    */
    private void getStoryString(String story) {
        StringReader sr = new StringReader(lib.getStory(story));
        source = new BufferedReader(sr);
        cStory = story;
        usingFile = false;
    }

    /** 'Reloads' the current contents - effectively
        pointing the source to the beginning of the buffer
    */
    private void reloadPage() {
        if (usingFile) getFile(cFilename);
        else getStoryString(cStory);
    }

    /** Gets an image
     @param location where to find the image
    */
    private ImageIcon getMyImage(String loc) {
        return new ImageIcon(note.getClass().getResource(loc));
        //return new ImageIcon(loc);
    }

    /** Shows an error message dialog
        @param message error to display
    */
    private void errorMessage(String message) {
        infoMessage("Error", message);
    }

    /** Shows an information dialog
        @param title the title of the dialog
        @param message the message to display
     */
    private void infoMessage(String title, String message) {
        JOptionPane.showMessageDialog(note, message, title,
                                      JOptionPane.INFORMATION_MESSAGE);
    }

    /** SlackpadTextArea class which overrides
        the 'processKeyEvent' method of JTextArea
        so that keypresses can be captured and
        dealt with
    */
    private class SlackpadTextArea extends JTextArea {
        public SlackpadTextArea(int width, int height) {
            super(width, height);
        }
        protected void processKeyEvent(KeyEvent key) {
            if (editing) {
                super.processKeyEvent(key);
            }
            else {
                if (key.getID() == KeyEvent.KEY_TYPED) {
                    setCaretPosition(getText().length());
                    try {
                        char tmp = (char)source.read();
                        append("" + tmp);
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
       Main action listener to capture events from the buttons
       and carry out the appropriate action
     */
    private class Ears implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object clicked = e.getSource();
            if (clicked == exitMenuItem) {
                System.exit(0);
            }
            else if (clicked == modeCheckBox) {
                editing = !modeCheckBox.isSelected();
            }
            else if (clicked == newMenuItem ||
                     clicked == newButton) {
                contents.setText("");
                reloadPage();
            }
            else if (clicked == openMenuItem ||
                     clicked == openButton) {
                JFileChooser chooser = new JFileChooser();
                chooser.addChoosableFileFilter(new TextFilter());
                int returnVal = chooser.showOpenDialog(note);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    getFile(chooser.getSelectedFile().getPath());
                }
            }
            else if (clicked == setTitleMenuItem) {
                String inputValue =
                    JOptionPane.showInputDialog((JFrame)note,
                                                "Set title",
                                                "Document 1 - Microsoft Word",
                                                JOptionPane.INFORMATION_MESSAGE);
                if (inputValue != null)
                    note.setTitle(inputValue);
            }
            else if (clicked == skipMenuItem) {
                boolean isInt = false;
                int lines = 0;
                String inputValue =
                    JOptionPane.showInputDialog((JFrame)note,
                                                "Skip n lines (max 1000)",
                                                "10",
                                                JOptionPane.INFORMATION_MESSAGE);
                try {
                    lines = Integer.parseInt(inputValue);
                    isInt = true;
                } catch (Exception ie) {
                    isInt = false;
                    errorMessage("Invalid number of lines");
                }
                if (isInt) {
                    String tmp = "";
                    try {
                        if (lines <= 1000) {
                            for (int i=0; i<lines; i++) {
                                if ((tmp = source.readLine()) != null)
                                    contents.append(tmp + "\n");
                            }
                        }
                        else {
                            errorMessage("Invalid number of lines");
                        }
                    } catch (Exception re) {
                        // Do nothing
                    }
                }
            }
            else if (clicked instanceof StoryMenuItem) {
                getStoryString(((StoryMenuItem)clicked).getText());
            }
            else if (clicked == aboutMenuItem) {
                infoMessage("About",
                            "Slackpad 2003 (v1.0)\n\n"
                            + "A program by Matthew Sital-Singh");

            }
            else if (clicked == readmeMenuItem) {
                contents.setText(lib.getReadme());
            }
        }
    }

    /** Custom FileFilter to show only .txt files
     */
    private class TextFilter extends javax.swing.filechooser.FileFilter {
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String extension = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');
            if (i > 0 &&  i < s.length() - 1) {
                extension = s.substring(i+1).toLowerCase();
            }
            if (extension != null) {
                if (extension.equals("txt")) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        public String getDescription() {
            return "Text files (*.txt)";
        }
    }

    /** Extra class to differentiate the Story menu items
        from normal menu items
    */
    private class StoryMenuItem extends JMenuItem {
        public StoryMenuItem(String name) {
            super(name);
        }
    }

    /**
       Causes the program to exit when the main
       window is closed
    */
    private class CloseWindow extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    /** Main method
        Creates a new instance of Slackpad
     */
    public static void main(String[] args) {
        Slackpad np = new Slackpad();
    }

    /** The slackpad */
    private Slackpad note;

    /** Library */
    private Slackwords lib = new Slackwords();

    /** The menu bar */
    private JMenuBar mainBar = new JMenuBar();
    private JMenuBar menuBar = new JMenuBar();
    private JMenuBar buttonBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem newMenuItem = new JMenuItem("New...");
    private JMenuItem openMenuItem = new JMenuItem("Open...");
    private JMenuItem exitMenuItem = new JMenuItem("Exit");
    private JMenu toolsMenu = new JMenu("Tools");
    private JCheckBoxMenuItem modeCheckBox = new JCheckBoxMenuItem("Slacker mode");
    private JMenuItem setTitleMenuItem = new JMenuItem("Set title...");
    private JMenuItem skipMenuItem = new JMenuItem("Skip lines...");
    private JMenu storyMenuItem = new JMenu("Load auto-text");
    private JMenu helpMenu = new JMenu("Help");
    private JMenuItem aboutMenuItem = new JMenuItem("About...");
    private JMenuItem readmeMenuItem = new JMenuItem("View readme");

    /** The buttons */
    private JButton newButton;
    private JButton openButton;

    /** Text area and scrollpane */
    private SlackpadTextArea contents = new SlackpadTextArea(800, 1000);
    private JScrollPane scrollview = new JScrollPane (contents);

    /** File IO stuff */
    private BufferedReader source;

    /** Mode */
    private boolean editing = true;
    private boolean usingFile = false;
    private String cFilename;
    private String cStory;
}
