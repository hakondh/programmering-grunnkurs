import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame{
	private JButton tilSvensk = new JButton("Trykk her");
	private JButton tilNorsk = new JButton("Trykk her");
	private JTextField textField = new JTextField(20);

	public void myFrame(){
		setTitle("Valutakalkulator");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LayoutManager layout = new FlowLayout();
		setLayout(layout);

		ButtonListener theListener = new ButtonListener();
		tilNorsk.addActionListener(theListener);
		tilSvensk.addActionListener(theListener);

		add(textField);
		add(tilNorsk);
		add(tilSvensk);

		pack();
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event){

		}
	}
}

class ValutaKalkulator {
	public static void main(String[] args){
		MyWindow aWindow = new MyWindow();
		aWindow.setVisible(true);
	}
}