package bobby.textpad;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TextPad {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextPad window = new TextPad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TextPad() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		menuBar.add(file);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		menuBar.add(edit);
		
		JMenu format = new JMenu("Format");
		format.setMnemonic(KeyEvent.VK_O);
		menuBar.add(format);
				
		JMenu fontMenu = new JMenu("Font");
		fontMenu.setMnemonic(KeyEvent.VK_T);
		format.add(fontMenu);
		
		JMenuItem arial = new JMenuItem("Arial", KeyEvent.VK_A);
		fontMenu.add(arial);
		
		JMenuItem timesNewRoman = new JMenuItem("Times New Roman", KeyEvent.VK_T);
		fontMenu.add(timesNewRoman);
		
		JMenuItem courier = new JMenuItem("Courier", KeyEvent.VK_C);
		fontMenu.add(courier);
		
		JMenuItem helvetica = new JMenuItem("Helvetica", KeyEvent.VK_V);
		fontMenu.add(helvetica);
		
		JMenu colorMenu = new JMenu("Color");
		colorMenu.setMnemonic(KeyEvent.VK_C);
		format.add(colorMenu);
		
		JMenuItem red = new JMenuItem("Red", KeyEvent.VK_R);
		colorMenu.add(red);
		
		JMenuItem black = new JMenuItem("Black", KeyEvent.VK_B);
		colorMenu.add(black);
		
		JMenuItem green = new JMenuItem("Green", KeyEvent.VK_G);
		colorMenu.add(green);
		
		JMenuItem blue = new JMenuItem("Blue", KeyEvent.VK_L);
		colorMenu.add(blue);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(helpMenu);
		
		JMenuItem about = new JMenuItem("About Application", KeyEvent.VK_P);
		helpMenu.add(about);
		
		/* FONTS */
		Font arialFont = new Font("Arial", Font.PLAIN, 14);
		Font timesFont = new Font("Times New Roman", Font.PLAIN, 14);
		Font courierFont = new Font("Courier", Font.PLAIN, 14);
		Font helveticaFont = new Font("Helvetica", Font.PLAIN, 14);
		
		/* Content Pane with toolbar and scrollable text area*/
		JTextArea textArea = new JTextArea(0, 80);
		textArea.setText("Advanced Java Programming Swing Assignment written by Bobby Smith - "
				+ "this sample text specified at the time of creation is used for testing the module.");
		textArea.setEditable(true);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.WHITE);
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setMargin(new Insets(10,10,10,20));
		frame.getContentPane().add(textArea, BorderLayout.NORTH);
		
		JToolBar toolbar = new JToolBar();
		frame.getContentPane().add(toolbar, BorderLayout.NORTH);
		toolbar.setFloatable(false);
		
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setVisible(true);
		
		/* TOOLBAR BUTTONS */
		JButton arialButton = new JButton("Arial");
		arialButton.setToolTipText("Arial");
        arialButton.setFont(arialFont);
        arialButton.setMnemonic(KeyEvent.VK_A);
		toolbar.add(arialButton);
		
		JButton timesButton = new JButton("Times New Roman");
		timesButton.setToolTipText("Times New Roman");
		timesButton.setFont(timesFont);
		timesButton.setMnemonic(KeyEvent.VK_T);
		toolbar.add(timesButton);
		
		JButton courierButton = new JButton("Courier");
		courierButton.setToolTipText("Courier");
		courierButton.setFont(courierFont);
		courierButton.setMnemonic(KeyEvent.VK_C);
		toolbar.add(courierButton);
		
		JButton helveticaButton = new JButton("Helvetica");
		helveticaButton.setToolTipText("Helvetica");
		helveticaButton.setFont(helveticaFont);
		helveticaButton.setMnemonic(KeyEvent.VK_V);
		toolbar.add(helveticaButton);
		
		JSeparator separator = new JSeparator();
		toolbar.add(separator);
		
		JButton redButton = new JButton("Red");
		redButton.setToolTipText("Red");
		redButton.setForeground(Color.RED);
		redButton.setMnemonic(KeyEvent.VK_R);
		toolbar.add(redButton);
		
		JButton blackButton = new JButton("Black");
		blackButton.setToolTipText("Black");
		blackButton.setMnemonic(KeyEvent.VK_B);
		toolbar.add(blackButton);
		
		JButton greenButton = new JButton("Green");
		greenButton.setToolTipText("Green");
		greenButton.setForeground(Color.GREEN);
		greenButton.setMnemonic(KeyEvent.VK_G);
		toolbar.add(greenButton);
		
		JButton blueButton = new JButton("Blue");
		blueButton.setToolTipText("Blue");
		blueButton.setForeground(Color.BLUE);
		blueButton.setMnemonic(KeyEvent.VK_L);
		toolbar.add(blueButton);
		
		
		/* EVENT LISTENERS */
		
		/*Font Menu*/
		HashMap<JMenuItem, Font> fontsMenu = new HashMap<JMenuItem, Font>();
		fontsMenu.put(arial, arialFont);
		fontsMenu.put(timesNewRoman, timesFont);
		fontsMenu.put(courier, courierFont);
		fontsMenu.put(helvetica, helveticaFont);
		
		for(Entry<JMenuItem, Font> entry : fontsMenu.entrySet()){
		    entry.getKey().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                textArea.setFont(entry.getValue());
	            }
	        });
		}
		

		/* Color Menu */
		HashMap<JMenuItem, Color> colorsMenu = new HashMap<JMenuItem, Color>();
		colorsMenu.put(red, Color.RED);
		colorsMenu.put(black, Color.BLACK);
		colorsMenu.put(green, Color.GREEN);
		colorsMenu.put(blue, Color.BLUE);
		
		for(Entry<JMenuItem, Color> entry : colorsMenu.entrySet()){
			entry.getKey().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                textArea.setForeground(entry.getValue());
	            }
	        });
		}
		
		/* Help Menu */
		about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(frame, "This is a basic text editor created by Bobby Smith, it demonstartes various Java Swing "
            			+ "components and event listeners.",
            		    "About Application",
            		    JOptionPane.PLAIN_MESSAGE);
            }
        });
		
		/* Font Buttons */
		HashMap<JButton, Font> fonts = new HashMap<JButton, Font>();
		fonts.put(arialButton, arialFont);
		fonts.put(timesButton, timesFont);
		fonts.put(courierButton, courierFont);
		fonts.put(helveticaButton, helveticaFont);
		
		for(Entry<JButton, Font> entry : fonts.entrySet()){
		    entry.getKey().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
		            textArea.setFont(entry.getValue());
				}
		    });
		}
		
		/* Color Buttons */
		HashMap<JButton, Color> colors = new HashMap<JButton, Color>();
		colors.put(redButton, Color.RED);
		colors.put(blackButton, Color.BLACK);
		colors.put(greenButton, Color.GREEN);
		colors.put(blueButton, Color.BLUE);
		
		for(Map.Entry<JButton, Color> entry : colors.entrySet()){
		    entry.getKey().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
		            textArea.setForeground(entry.getValue());
				}
		    });
		}
		
	}
}
