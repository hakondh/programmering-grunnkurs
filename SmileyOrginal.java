import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SmileyOriginal {
	public static void main (String[] args) {
		Vindu etVindu = new Vindu("Smiley");
		etVindu.setVisible(true);
	}
}

class Vindu extends JFrame {
	public Vindu(String tittel) {
		setTitle(tittel);
		setSize(500, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tegning tegningen = new Tegning();
		add(tegningen);
	}
}

class Tegning extends JPanel {
	public void paintComponent(Graphics tegneflate) {
		super.paintComponent(tegneflate);
		tegneflate.drawString("Smiley", 40, 30);
		tegneflate.setColor(Color.YELLOW);
		tegneflate.drawOval(200,50,55,40);
		tegneflate.fillOval(200,50,55,40);

		tegneflate.setColor(Color.BLACK);

		tegneflate.drawOval(210,50,5,10);
		tegneflate.fillOval(210,50,5,10);

		tegneflate.drawOval(220,50,5,10);
		tegneflate.fillOval(220,50,5,10);

		tegneflate.drawArc(210, 60, 5, 10, 180, 200);

	}
}