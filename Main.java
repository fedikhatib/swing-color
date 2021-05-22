import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
 
public class Main extends JFrame {
 
    
    JScrollBar redScroller;
    JScrollBar greenScroller;
    JScrollBar blueScroller;
    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;
    JPanel selectedColorSquare;
    JLabel selectedColorValue;
    JButton about;
    JButton copy;
 
    public Main() {
        createAndShowGUI();
    }
 
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    private void createAndShowGUI() {
 
        setTitle("Projet: Color Picker");
        redLabel = new JLabel("Red");
        greenLabel = new JLabel("Green");
        blueLabel = new JLabel("Blue");
        redScroller = new JScrollBar(JScrollBar.HORIZONTAL, 127, 1, 0, 256);
        greenScroller = new JScrollBar(JScrollBar.HORIZONTAL, 127, 1, 0, 256);
        blueScroller = new JScrollBar(JScrollBar.HORIZONTAL, 127, 1, 0, 256);
        selectedColorSquare = new JPanel();
        selectedColorValue = new JLabel("Color: 127, 127, 127", JLabel.CENTER);
        about = new JButton("About");
        copy = new JButton("Copy");
 
        redLabel.setBounds(40, 40, 40, 25);
        greenLabel.setBounds(40, 80, 40, 25);
        blueLabel.setBounds(40, 120, 40, 25);
        redScroller.setBounds(100, 40, 300, 25);
        greenScroller.setBounds(100, 80, 300, 25);
        blueScroller.setBounds(100, 120, 300, 25);
        about.setBounds(200, 150, 100, 15);
        copy.setBounds(450, 150, 100, 17);
        selectedColorSquare.setBounds(420, 40, 145, 80);
        selectedColorValue.setBounds(420, 125, 145, 25);
 
        redScroller.setBackground(Color.red);
        greenScroller.setBackground(Color.green);
        blueScroller.setBackground(Color.blue);
        selectedColorSquare.setBackground(new Color(127, 127, 127));

        add(redLabel);
        add(greenLabel);
        add(blueLabel);
        add(redScroller);
        add(greenScroller);
        add(blueScroller);
        add(selectedColorSquare);
        add(selectedColorValue);
        add(about);
        add(copy);
       
 
        AdjustmentListener al = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
 
                Color c = new Color(redScroller.getValue(), greenScroller.getValue(), blueScroller.getValue());
 
                selectedColorSquare.setBackground(c);
 
                selectedColorValue.setText("Color: " + redScroller.getValue() + ", " + c.getGreen() + ", " + c.getBlue());
                
 
            }
        };
 
        redScroller.addAdjustmentListener(al);
        greenScroller.addAdjustmentListener(al);
        blueScroller.addAdjustmentListener(al);
        

        
        
        copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=  selectedColorValue.getText();
		        StringSelection stringSelection = new StringSelection(str);
		        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		        clipboard.setContents(stringSelection, null);
				
			}
		});
        
        about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoBox("Color Picker \nProgrammer: Fedi Khatib","About Color Picker");
				
			}
		});
 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 210);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
 
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
 
}
