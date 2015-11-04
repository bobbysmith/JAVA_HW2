package bobby.tasklist;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

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
		
		JTree tree = new JTree();
		
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
		
		
		DefaultTreeModel model = new DefaultTreeModel(new DefaultMutableTreeNode("Task List") {
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
			}
		});
		
		tree.setModel(model);
		
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
				DefaultMutableTreeNode newTask = new DefaultMutableTreeNode(taskText.getText());
                System.out.println(priorityText.getText());
                switch(priorityText.getText()) {
                	case "1":
                		priority1.add(newTask);
                		tree.repaint();
                		break;
                	case "2":
                		priority2.add(newTask);
                		tree.repaint();
                		break;
	                case "3":
	                	priority3.add(newTask);
	                	tree.repaint();
	            		break;
	            	case "4":
	            		priority4.add(newTask);
	            		tree.repaint();
	            		break;
	                case "5":
	                	priority5.add(newTask);
	                	tree.repaint();
	            		break;
	            	case "6":
	            		priority6.add(newTask);
	            		tree.repaint();
	            		break;
	                case "7":
	                	priority7.add(newTask);
	                	tree.repaint();
	            		break;
	            	case "8":
	            		priority8.add(newTask);
	            		tree.repaint();
	            		break;
	                case "9":
	                	priority9.add(newTask);
	                	tree.repaint();
	            		break;
	            	case "10":
	            		priority10.add(newTask);
	            		tree.repaint();
	            		break;
                	default:
                		JOptionPane.showMessageDialog(frame, "Please enter a number 1 through 10.");
                		break;
                }
	            
			}
	    });
		
		/* EDIT */
		/* getting the task and priority of the selected node when you click edit and populating the
		 * corresponding text fields with those values
		 * trying to then add the edited node to its new priority and delete the old one when add is clicked again
		 */
		editButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode editedTask = new DefaultMutableTreeNode(taskText.getText());
				DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				MutableTreeNode parent = (MutableTreeNode) (selected.getParent());
				taskText.setText(selected.toString());
				priorityText.setText(parent.toString().replaceAll("[^0-9]",""));
				
				addButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					
						selected.removeFromParent();
			            
						switch(priorityText.getText()) {
	                	case "1":
	                		priority1.add(editedTask);
	                		tree.repaint();
	                		break;
	                	case "2":
	                		priority2.add(editedTask);
	                		tree.repaint();
	                		break;
		                case "3":
		                	priority3.add(editedTask);
		                	tree.repaint();
		            		break;
		            	case "4":
		            		priority4.add(editedTask);
		            		tree.repaint();
		            		break;
		                case "5":
		                	priority5.add(editedTask);
		                	tree.repaint();
		            		break;
		            	case "6":
		            		priority6.add(editedTask);
		            		tree.repaint();
		            		break;
		                case "7":
		                	priority7.add(editedTask);
		                	tree.repaint();
		            		break;
		            	case "8":
		            		priority8.add(editedTask);
		            		tree.repaint();
		            		break;
		                case "9":
		                	priority9.add(editedTask);
		                	tree.repaint();
		            		break;
		            	case "10":
		            		priority10.add(editedTask);
		            		tree.repaint();
		            		break;
	                	default:
	                		JOptionPane.showMessageDialog(frame, "Please enter a number 1 through 10.");
	                		break;
						}
				        
					}
				});
			}
		});
		
		
		/* DELETE */
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String regex = "(Priority \\d)";
			    Pattern p = Pattern.compile(regex);
				TreePath currentSelection = tree.getSelectionPath();
				if (currentSelection != null) {
					DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection.getLastPathComponent());
		            MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
		            Matcher match = p.matcher(parent.toString());
		            // only deletes tasks, not priority nodes
		            if (match.matches()) {
		            	model.removeNodeFromParent(currentNode);
		            } else {
		            	JOptionPane.showMessageDialog(frame, "You cannot delete a Priority node.");
		            }
				}
			}
		});
		
	}

}
