import java.awt.*;
import java.awt.event.*;
import java.awt.im.InputContext;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class EditorProject4 {

    public static void main(String args[]) {
        StartGUI obj = new StartGUI();
        obj.displayGUI();
    }
}

class StartGUI {

    JFrame frame;
    FileUI f = new FileUI();
    JPanel mainPanel;
    JPanel menuPanel;
    JPanel countPanel;
    JScrollPane textScrollPanel;
    DisplayTextPanel textPanel;
    JFrame abtf;
    JMenuBar menubar = new JMenuBar();

    JMenu file;
    JMenu edit;
    JMenu format;
    JMenu about;
    JButton OK = new JButton("OK");
    JFrame ff;
    JFrame sf = new JFrame();
    JButton ok = new JButton("Go");
    JTextField ss = new JTextField();
    String Fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    StringBuilder tempCutString = new StringBuilder();
//JLabel label=new JLabel();
    // StringBuilder str;

    JLabel wordCountLabel;
    JLabel lineCountLabel;
    JLabel charCountLabel;
    JMenuItem New;
    JMenuItem Open;
    JMenuItem Save;
    JMenuItem Exit;
    JMenuItem Cut;
    JMenuItem Copy;
    JMenuItem Paste;
    JMenuItem Search;
    JMenuItem Search_Replace;
    JMenuItem Font;
    JMenuItem ColorOption;
    JMenuItem About;

    //these items are for the Color display
    JFrame fr;
    JPanel mp;
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JButton fg1;
    JPanel fg2;
    JButton bg1;
    JPanel bg2;
    JButton set;

    //these items are for earch replace
    JFrame sfr;
    JPanel smp;
    JPanel sp1;
    JPanel sp2;
    JPanel sp3;
    JLabel fl;
    JLabel sl;
    JTextField ftf;
    JTextField stf;
    JButton sok;

    void MenuStuff() {
        file = new JMenu("File");
        edit = new JMenu("Edit");
        format = new JMenu("Format");
        about = new JMenu("About");
        New = new JMenuItem("New");
        Open = new JMenuItem("Open");
        Save = new JMenuItem("Save");
        Exit = new JMenuItem("Exit");
        Cut = new JMenuItem("Cut");
        Copy = new JMenuItem("Copy");
        Paste = new JMenuItem("Paste");
        Search = new JMenuItem("Search");
        Search_Replace = new JMenuItem("Search and Replace");
        Font = new JMenuItem("Font");
        ColorOption = new JMenuItem("Color");
        About = new JMenuItem("About us");

        New.addActionListener(new mbmethod());
        Open.addActionListener(new mbmethod());
        Save.addActionListener(new mbmethod());
        Exit.addActionListener(new mbmethod());
        Cut.addActionListener(new mbmethod());
        Copy.addActionListener(new mbmethod());
        Paste.addActionListener(new mbmethod());
        Search.addActionListener(new mbmethod());
        Search_Replace.addActionListener(new mbmethod());
        Font.addActionListener(new mbmethod());
        ColorOption.addActionListener(new mbmethod());
        About.addActionListener(new mbmethod());

        file.add(New);
        file.add(Open);
        file.add(Save);
        file.add(Exit);
        edit.add(Cut);
        edit.add(Copy);
        edit.add(Paste);
        edit.add(Search);
        edit.add(Search_Replace);
        format.add(Font);
        format.add(ColorOption);
        about.add(About);
        menuPanel.setLayout(new FlowLayout());
        menuPanel.add(menubar);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(format);
        menubar.add(about);
    }

    public void countMethod() {
        int wordCount = 0;

        if (textPanel.str.toString().length() != 0) {
            for (String temp : textPanel.str.toString().replaceAll(" +", " ").split("\n")) {
                wordCount += temp.split(" ").length;
            }
            wordCountLabel.setText("word count : " + wordCount + "                ");
            lineCountLabel.setText("line count : " + textPanel.str.toString().split("\n").length + "               ");
            charCountLabel.setText("character count : " + textPanel.str.toString().length());
        } else {
            wordCountLabel.setText("word count : 0" + "                ");
            lineCountLabel.setText("line count : 0" + "               ");
            charCountLabel.setText("character count : 0");
        }
    }

    void displayGUI() {
        frame = new JFrame();

        frame.setSize(new Dimension(700, 600));
        initialiselistmodel();
        mainPanel = new JPanel();
        menuPanel = new JPanel();
        countPanel = new JPanel();
        textPanel = new DisplayTextPanel();
        String temp = textPanel.str.toString();
        textScrollPanel = new JScrollPane(textPanel);
        wordCountLabel = new JLabel("");
        lineCountLabel = new JLabel("");
        charCountLabel = new JLabel("");
        MenuStuff();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        menuPanel.setPreferredSize(new Dimension(700, 30));
        menuPanel.setMaximumSize(new Dimension(1000, 30));
        textScrollPanel.setPreferredSize(new Dimension(700, 450));
        textPanel.setPreferredSize(new Dimension(2000, 2000));
        countPanel.setPreferredSize(new Dimension(700, 30));
        countPanel.setMaximumSize(new Dimension(700, 30));
        countPanel.setMinimumSize(new Dimension(700, 30));

        frame.getContentPane().add(mainPanel);
        mainPanel.add(menuPanel);
        mainPanel.add(textScrollPanel);
        mainPanel.add(countPanel);
        countPanel.setLayout(new FlowLayout());
        countPanel.add(wordCountLabel);
        countPanel.add(lineCountLabel);
        countPanel.add(charCountLabel);

        textScrollPanel.getActionMap().put("unitScrollRight", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        textScrollPanel.getActionMap().put("unitScrollDown", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        textPanel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                textPanel.requestFocusInWindow();
            }

            public void mouseExited(MouseEvent e) {
                return;
            }

            public void mouseReleased(MouseEvent e) {
                return;
            }

            public void mouseEntered(MouseEvent e) {
                return;
            }

            public void mousePressed(MouseEvent e) {
                return;
            }
        });
        textPanel.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                textPanel.sendKeyTyped(e);
                countMethod();
            }
        });
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    static int k = 0;
    StringBuilder str = new StringBuilder();
    StringBuilder substr = new StringBuilder();
//      String temp=textPanel.str.toString();
    StringBuilder abt = new StringBuilder("Theme of the project is a text editor.\nIt doesnt not use JTextarea.\nIts done by 4 students.\n1)Shyam.B.S - 13IT144\n2)Ohileshwar Itagi - 13IT251\n3)Praveen Kotre - 13IT229\n4)Raghvendra M Dani - 13IT231   \nIt has features like find,search,search-replace,cut,copy paste,colour,font,open,save,new.\n");

    class mbmethod implements ActionListener {

        String temp = textPanel.str.toString();
        StringBuilder prev = new StringBuilder();
        StringBuilder next = new StringBuilder();

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == New) {
                textPanel.str.setLength(0);
                countMethod();
                textPanel.cursorIndex = 0;
                textPanel.repaint();

            }
            if (e.getSource() == Open) {
                try {
                    f.openFile(textPanel);
                } catch (Exception ex) {
                    Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                countMethod();
            }
            if (e.getSource() == Save) {
                try {
                    f.saveFile(textPanel);
                } catch (Exception ex) {
                    Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == Exit) {
                frame.dispose();
                
            }
            if (e.getSource() == Cut) {
                tempCutString.setLength(0);
                tempCutString.append(textPanel.str.toString());
                textPanel.str.setLength(0);
                DisplayTextPanel.cursorIndex = 0;
                textPanel.repaint();
                countMethod();

                //Code Snippet for Cut
            }
            if (e.getSource() == Copy) {
                tempCutString.setLength(0);
                tempCutString.append(textPanel.str.toString());
                textPanel.repaint();
                countMethod();
                //Code Snippet for  Copy 
            }
            if (e.getSource() == Paste) {
                textPanel.str.insert(DisplayTextPanel.cursorIndex, tempCutString.toString());
                textPanel.repaint();
                countMethod();
                //Code Snippet for  Paste
            }
            if (e.getSource() == Search) {
                textPanel.cursorIndex = 0;
                textPanel.repaint();
                search();

                //Code Snippet for  Search 
            }
            if (e.getSource() == Search_Replace) {
                searchReplaceConstruct();
            }
            if (e.getSource() == Font) {
                displayfont();
                //Code Snippet for   Font
            }
            if (e.getSource() == ColorOption) {
                displayColorWindow();  // also sets the text color
            }
            if (e.getSource() == About) {
                displayabout();
            }
            if (e.getSource() == ok) {
                searchbe();
            }

            if (e.getSource() == OK) {
                DisplayTextPanel.font = f1l.getSelectedIndex() == -1 ? DisplayTextPanel.font : (listModel.get(f1l.getSelectedIndex()).toString());
                DisplayTextPanel.style = f2l.getSelectedIndex() == -1 ? DisplayTextPanel.style : (nat.get(f2l.getSelectedIndex()).toString());
                DisplayTextPanel.size = f3l.getSelectedIndex() == -1 ? DisplayTextPanel.size : (size.get(f3l.getSelectedIndex()).toString());
                textPanel.repaint();
            }
        }

        JPanel abtpanel = new JPanel();

        public void displayabout() {
            abtf = new JFrame();
            abtpanel.setSize(new Dimension(600, 190));
            abtpanel.setLayout(new BoxLayout(abtpanel, BoxLayout.PAGE_AXIS));
            abtf.setSize(new Dimension(600, 190));
            for (String temp : abt.toString().split("\n")) {
                abtpanel.add(new JLabel(temp));
            }
            abtf.add(abtpanel);
            abtf.setVisible(true);
            abtf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }

        public void searchbe() {
            substr.setLength(0);
            substr.append(ss.getText().trim());
            if (DisplayTextPanel.searchFlag == 1) {
                textPanel.cursorIndex = temp.indexOf(substr.toString(), textPanel.cursorIndex);
                DisplayTextPanel.searchFlag = 0;
            } else {
                textPanel.cursorIndex = temp.indexOf(substr.toString(), textPanel.cursorIndex + substr.toString().length());
            }
            textPanel.repaint();
        }
    }
    DefaultListModel nat = new DefaultListModel();
    DefaultListModel listModel = new DefaultListModel();
    DefaultListModel size = new DefaultListModel();
    JList f1l = new JList(listModel);
    JList f2l = new JList(nat);
    JList f3l = new JList(size);

    void initialiselistmodel() {
        for (int i = 0; i < Fonts.length; i++) {
            listModel.addElement(Fonts[i]);
        }
    }

    void displayColorWindow() {
        fr = new JFrame();
        mp = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        fg1 = new JButton("Forefround : ");
        fg2 = new JPanel();
        bg1 = new JButton("Background : ");
        bg2 = new JPanel();
        set = new JButton("SET");

        fr.setSize(new Dimension(400, 200));
        mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());

        fr.add(mp);
        mp.add(p1);
        mp.add(p2);
        mp.add(p3);
        p1.add(fg1);
        p1.add(fg2);
        p2.add(bg1);
        p2.add(bg2);
        p3.add(set);

        fg2.setPreferredSize(new Dimension(20, 20));
        bg2.setPreferredSize(new Dimension(20, 20));

        fg2.setBackground(textPanel.foregroundColor);
        bg2.setBackground(textPanel.backgroundColor);

        fg1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color defaultForeground = textPanel.foregroundColor;
                Color temp = JColorChooser.showDialog(null, "Chose a color", defaultForeground);
                fg2.setBackground(temp);
            }
        });
        bg1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color defaultBackground = textPanel.backgroundColor;
                Color temp = JColorChooser.showDialog(null, "Chose a color", defaultBackground);
                bg2.setBackground(temp);
            }
        });
        set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textPanel.foregroundColor = fg2.getBackground();
                textPanel.backgroundColor = bg2.getBackground();
                textPanel.repaint();
            }
        });
        fr.setVisible(true);
        fr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    void displayfont() {
        ff = new JFrame();
        ff.setSize(new Dimension(550, 300));
        JPanel mp = new JPanel();
        JPanel f1 = new JPanel();
        JPanel f2 = new JPanel();
        JPanel f3 = new JPanel();
        JPanel f5 = new JPanel();

        ff.add(mp);
        mp.setLayout(new GridLayout(1, 0));
        mp.add(f1);
        mp.add(f2);
        mp.add(f3);
        mp.add(f5);
        f1.setLayout(new BoxLayout(f1, BoxLayout.PAGE_AXIS));
        JLabel Font = new JLabel("Font:");
        f1.add(Font);
        f1l.setFixedCellHeight(32);
        f1l.setFont(f1l.getFont().deriveFont(18.0f));
        f1l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        f1l.setLayoutOrientation(JList.VERTICAL);
        JScrollPane f1ls = new JScrollPane(f1l);
        f1l.setVisibleRowCount(5);
        f1.add(f1ls);

        f2.setLayout(new BoxLayout(f2, BoxLayout.PAGE_AXIS));

        nat.addElement("BOLD");
        nat.addElement("Italic");
        nat.addElement("Regular");
        JLabel ftype = new JLabel("Style:");

        f2l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        f2l.setLayoutOrientation(JList.VERTICAL);
        f2l.setVisibleRowCount(5);
        f2l.setFixedCellHeight(32);
        f2l.setFont(f2l.getFont().deriveFont(18.0f));
        f2.add(ftype);
        f2.add(f2l);

        for (int i = 10; i <= 100; i = i + 2) {
            size.addElement(i);
        }
        JLabel si = new JLabel("Size:");

        JScrollPane f3ls = new JScrollPane(f3l);

        f3l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        f3l.setLayoutOrientation(JList.VERTICAL);
        f3l.setVisibleRowCount(5);
        f3l.setFixedCellHeight(32);
        f3l.setFixedCellWidth(32);
        f3l.setFont(f3l.getFont().deriveFont(18.0f));
        f3.add(si);
        f3.add(f3ls);
        f3.setLayout(new BoxLayout(f3, BoxLayout.PAGE_AXIS));
        f5.setLayout(new FlowLayout(FlowLayout.LEADING, 40, 120));
        OK.addActionListener(new mbmethod());
        f5.add(OK);
        ff.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ff.setVisible(true);
    }

    public void searchReplaceConstruct() {
        sfr = new JFrame();
        smp = new JPanel();
        sp1 = new JPanel();
        sp2 = new JPanel();
        sp3 = new JPanel();
        fl = new JLabel("search string :");
        sl = new JLabel("replace string :");
        ftf = new JTextField(20);
        stf = new JTextField(20);
        sok = new JButton("replace");

        sfr.setSize(new Dimension(400, 200));
        sfr.add(smp);
        smp.setLayout(new BoxLayout(smp, BoxLayout.Y_AXIS));
        sp1.setLayout(new FlowLayout());
        sp2.setLayout(new FlowLayout());
        sp3.setLayout(new FlowLayout());
        smp.add(sp1);
        smp.add(sp2);
        smp.add(sp3);

        sp1.add(fl);
        sp1.add(ftf);
        sp2.add(sl);
        sp2.add(stf);
        sp3.add(sok);

        sok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String temp = textPanel.str.toString().replaceAll(ftf.getText(), stf.getText());
                textPanel.str.setLength(0);
                textPanel.str.append(temp);
                textPanel.cursorIndex = 0;
                textPanel.repaint();
            }
        });
        sfr.setVisible(true);
        sfr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    int search() {
        JLabel sl = new JLabel("Search String:");
        JPanel p = new JPanel();
        sf = new JFrame();
        sf.setSize(new Dimension(400, 85));
        p = new JPanel();
        p.setPreferredSize(new Dimension(400, 85));
        sf.add(p);
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        ok = new JButton("OK");
        ok.addActionListener(new mbmethod());
        p.add(ok);

        p.add(sl);

        p.add(ss);

        sf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        sf.setVisible(true);
        DisplayTextPanel.searchFlag = 1;
        return -1;
    }

}

class DisplayTextPanel extends JPanel {

    Color foregroundColor = Color.BLACK;
    Color backgroundColor = Color.WHITE;

    static String style = "Regular";
    static String size = "16";
    static String font = "Arial";
    static int cursorIndex = 0;
    static int searchFlag = 0;

    static String cursor = "#";
    StringBuilder str = new StringBuilder("");

    int getStyle(String str) {
        if (str.equalsIgnoreCase("BOLD")) {
            return Font.BOLD;
        } else if (str.equalsIgnoreCase("ITALIC")) {
            return Font.ITALIC;
        } else {
            return Font.PLAIN;
        }
    }

    public void sendKeyTyped(KeyEvent e) {
        char ch = e.getKeyChar();
        int code = e.getKeyCode();
        int l = str.toString().length();
        if (ch >= 32 && ch <= 126) {  // all printable characters
            str.insert(cursorIndex, ch);
            cursorIndex++;
        } else if (code == KeyEvent.VK_ENTER) {
            str.insert(cursorIndex, '\n');
            cursorIndex++;
        } else if (code == KeyEvent.VK_BACK_SPACE) {
            if (cursorIndex != 0) {
                str.deleteCharAt(cursorIndex - 1);
                cursorIndex--;
            }
        } else if (code == KeyEvent.VK_DOWN) {
            cursorIndex = getRightMostCharacterIndex(getRightMostCharacterIndex(cursorIndex) + 1);
        } else if (code == KeyEvent.VK_UP) {
            int temp = getLeftMostCharacterIndex(cursorIndex);
            if (temp == 0) {
                cursorIndex = 0;
            } else {
                cursorIndex = temp - 1;
            }
        } else if (code == KeyEvent.VK_LEFT) {
            cursorIndex--;
            if (cursorIndex < 0) {
                cursorIndex = 0;
            }
        } else if (code == KeyEvent.VK_RIGHT) {
            cursorIndex++;
            if (cursorIndex > l) {
                cursorIndex = l;
            }
        }
        repaint();
    }

    public int getLeftMostCharacterIndex(int _index) {
        String tempString = str.toString();
        int i = _index - 1, l = tempString.length();
        if (_index > l) {
            return l;
        }
        for (; i >= 0 && str.charAt(i) != '\n'; i--);
        return i + 1;
    }

    public int getRightMostCharacterIndex(int _index) //returns right most character in the list of lines 
    {                                                 // returns str's length if called from last line
        String tempString = str.toString();
        int i = _index, l = tempString.length();
        if (_index > l) {
            return l;
        }
        for (; i < l && str.charAt(i) != '\n'; i++);
        return i;
    }

    public void paint(Graphics g) {
        int y = Integer.parseInt(size);
        Font tempFont = new Font(font, getStyle(style), Integer.parseInt(size));
        g.setFont(tempFont);
        g.setColor(backgroundColor);
        g.fillRect(0, 0, 2000, 2000);
        g.setColor(foregroundColor);
        String[] strArray = (str.toString()).split("\n");
        int count = 0;
        int flag = 1;
        for (String temp : strArray) {
            count += temp.length();
            count++;               //temp doesn't contain any newlines
            if (cursorIndex < count && flag == 1) {
                flag = 0;
                int x = 0;
                FontMetrics fontMetrics = getFontMetrics(tempFont);
                String str1 = temp.substring(0, cursorIndex - getLeftMostCharacterIndex(cursorIndex));
                String str2 = cursor;
                String str3 = temp.substring(cursorIndex - getLeftMostCharacterIndex(cursorIndex), temp.length());

                g.drawString(str1, 0, y);
                x += fontMetrics.stringWidth(str1);
                g.setColor(Color.RED);
                g.drawString(str2, x, y);
                x += fontMetrics.stringWidth(str2);
                g.setColor(foregroundColor);
                g.drawString(str3, x, y);
                y += Integer.parseInt(size) + 2;
                continue;
            }

            g.drawString(temp, 0, y);
            y += Integer.parseInt(size) + 2;

        }
    }
}

class FileUI {

    static int f = 0;

    public FileUI() {

    }

    

    public void openFile(DisplayTextPanel textPanel) throws Exception, FileNotFoundException {
        JFileChooser sel = new JFileChooser("");
        sel.showOpenDialog(null);
        File selFile = sel.getSelectedFile();
        try {
            BufferedReader br = new BufferedReader(new FileReader(selFile));
            textPanel.str.setLength(0);
            for (int ch = br.read(); ch != -1; ch = br.read()) {
                textPanel.str.append((char) ch);
            }
            textPanel.repaint();
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//use string object to append written text to Editor input

    public void saveFile(DisplayTextPanel textPanel) throws Exception {
        JFileChooser sel = new JFileChooser("");
        sel.showSaveDialog(null);
        File selFile = sel.getSelectedFile();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(selFile));
            String tempString = textPanel.str.toString();
            for (int i = 0; i < tempString.length(); i++) {
                bw.write((int) tempString.charAt(i));
            }
            textPanel.repaint();
            bw.close();
        } catch (Exception ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
