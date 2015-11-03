package bobby.tasklist;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class TaskList {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskList window = new TaskList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TaskList() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 400);
		frame.setTitle("Task List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultMutableTreeNode priority1 = new DefaultMutableTreeNode("Priority 1");
		DefaultMutableTreeNode priority2 = new DefaultMutableTreeNode("Priority 2");
		DefaultMutableTreeNode priority3 = new DefaultMutableTreeNode("Priority 3");
		DefaultMutableTreeNode priority4 = new DefaultMutableTreeNode("Priority 4");
		DefaultMutableTreeNode priority5 = new DefaultMutableTreeNode("Priority 5");
		DefaultMutableTreeNode priority6 = new DefaultMutableTreeNode("Priority 6");
		DefaultMutableTreeNode priority7 = new DefaultMutableTreeNode("Priority 7");
		DefaultMutableTreeNode priority8 = new DefaultMutableTreeNode("Priority 8");
		DefaultMutableTreeNode priority9 = new DefaultMutableTreeNode("Priority 9");
		DefaultMutableTreeNode priority10 = new DefaultMutableTreeNode("Priority 10");
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Task List") {
				private static final long serialVersionUID = 1L;

				{
					add(priority1);
					add(priority2);
					add(priority3);
					add(priority4);
					add(priority5);
					add(priority6);
					add(priority7);
					add(priority8);
					add(priority9);
					add(priority10);
//					for (int i = 1; i <= 10; i++) {
//						priority = new DefaultMutableTreeNode("Priority " + i);
//						add(priority);
//					}
				}
			}
		));
		frame.getContentPane().add(tree, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane(tree);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        JPanel taskPanel = new JPanel();
        frame.getContentPane().add(taskPanel, BorderLayout.SOUTH);
        
        JLabel taskLabel = new JLabel("Task");
        JLabel priorityLabel = new JLabel("Priority");
        JTextField taskText = new JTextField();
        taskText.setColumns(10);
        JTextField priorityText = new JTextField();
        priorityText.setColumns(10);
        taskPanel.add(taskLabel);
        taskPanel.add(taskText);
        taskPanel.add(priorityLabel);
        taskPanel.add(priorityText);
        
		JButton addButton = new JButton("Add");
		JButton editButton = new JButton("Edit");
		JButton deleteButton = new JButton("Delete");
		taskPanel.add(addButton);
		taskPanel.add(editButton);
		taskPanel.add(deleteButton);
		
		/* ADD */
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MutableTreeNode newTask = new DefaultMutableTreeNode(taskText.getText());
                System.out.println(priorityText.getText());
                switch(priorityText.getText()) {
                	case "1":
                		priority1.add(newTask);
                		break;
                	case "2":
                		priority2.add(newTask);
                		break;
	                case "3":
	                	priority3.add(newTask);
	            		break;
	            	case "4":
	            		priority4.add(newTask);
	            		break;
	                case "5":
	                	priority5.add(newTask);
	            		break;
	            	case "6":
	            		priority6.add(newTask);
	            		break;
	                case "7":
	                	priority7.add(newTask);
	            		break;
	            	case "8":
	            		priority8.add(newTask);
	            		break;
	                case "9":
	                	priority9.add(newTask);
	            		break;
	            	case "10":
	            		priority10.add(newTask);
	            		break;
                	default:
                		JOptionPane.showMessageDialog(frame, "Please enter a number 1 through 10.");
                		break;
                }
	            
			}
	    });
		
		/* EDIT */
		editButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode selectedNode = 
					       (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				System.out.println(selectedNode);
				priority1.remove(selectedNode);
			}
		});
		
		
		/* DELETE */
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
//		tree.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println(e);		
//			}
//		});
		
	}

}
