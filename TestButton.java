import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class MyWindow extends JFrame{
	private JButton myButton = new JButton("Trykk her");
	private JButton myOtherButton = new JButton("Trykk her");
	JTextField textField = new JTextField(20);

	public MyWindow(){
		//Setter tittel
		setTitle("Mitt første vindu");
		//Å lukke vinduet avslutter programmet:
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Legger til layout manager
		LayoutManager layout = new FlowLayout();
		setLayout(layout);
		//Knapp
		//JButton myButton = new JButton("blyat");
		add(myButton);
		//Lag og registrer knappelytter
		ButtonListener theListener = new ButtonListener();
		myButton.addActionListener(theListener);
		add(textField);
		pack();

		//Opretter tastatursnarveier
		myButton.setMnemonic(KeyEvent.VK_K);
		myOtherButton.setMnemonic(KeyEvent.VK_T);
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event){

			System.out.println("Du trykket på knappen");
			System.out.println((textField.getText()).toUpperCase());

			/*Random farge
				Random rand = new Random();
				float r = rand.nextFloat();
				float g = rand.nextFloat();
				float b = rand.nextFloat();
			*/

			if (myButton.getBackground().equals(Color.red)){
				myButton.setBackground(Color.blue);
			}
			else {
				myButton.setBackground(Color.red);
			}
		}
	}

}


class TestButton {
	public static void main(String[] args){
		MyWindow aWindow = new MyWindow();
		aWindow.setVisible(true);
	}
}