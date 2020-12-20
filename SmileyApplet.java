import javax.swing.*;
import java.awt.*;

public class SmileyApplet extends JApplet {
	public void init() {
		add(new Tegning());
	}
}
class Tegning extends JPanel {
	public void paintComponent(Graphics tegneflate) {
		super.paintComponent(tegneflate);
		tegneflate.drawString("Smiley", 40, 30);
		tegneflate.setColor(Color.YELLOW);
		tegneflate.drawOval(200,50,80,80);
		tegneflate.fillOval(200,50,80,80);

		tegneflate.setColor(Color.BLACK);

		tegneflate.drawOval(220,70,5,10);
		tegneflate.fillOval(220,70,5,10);

		tegneflate.drawOval(260, 70,5,10);
		tegneflate.fillOval(260,70,5,10);

		tegneflate.drawArc(220, 90, 40, 20, 180, 180);
	}
}