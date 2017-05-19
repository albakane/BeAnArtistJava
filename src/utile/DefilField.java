package utile;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class DefilField extends JFrame{
	
	JTextField myField = new JTextField("FERRAND - GAUTREY");
	
	public DefilField(){
		this.setTitle("BANNIERE");
		this.setSize(320, 75);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(myField);
		this.myField.setEditable(true);
		this.setVisible(true);
		this.defile(myField);
	}
	
	public void defile(JTextField field){
		while(true){
			String text = field.getText();
			field.setText(text.substring(1, text.length()) + text.charAt(0));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		DefilField defile = new DefilField();
	}
}