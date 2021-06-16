package fp.daw.exprog20210616.ejercicio5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Collection;

import javax.swing.JPanel;

public class Lienzo extends JPanel {

	private static final long serialVersionUID = 1L;
	Collection<Integer> numeros;
	
	public Lienzo() {
		setPreferredSize(new Dimension(900, 600));
	}
	
	public void setNumeros(Collection<Integer> numeros) {
		this.numeros = numeros;
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		g.fillRect(0, 0, getWidth(), getHeight());
		if (numeros != null) {
			int x = 0;
			int y = getHeight() - 1;
			g.setColor(Color.ORANGE);
			for (int n: numeros) {
				g.drawLine(x, y, x, y - n + 1);
				x++;
			}
		}
	}
	
}
