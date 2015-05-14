package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonExit extends JLabel {

	public ButtonExit(final ImageIcon before, final ImageIcon after) {

		this.setIcon(before);
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setIcon(after);
				repaint();
			}

			public void mouseExited(MouseEvent e) {
				setIcon(before);
				repaint();
			}

			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

}
