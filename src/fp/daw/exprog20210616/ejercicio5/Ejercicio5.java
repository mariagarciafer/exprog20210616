package fp.daw.exprog20210616.ejercicio5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import fp.daw.exprog20210616.ejercicio4.Ejercicio4;

public class Ejercicio5 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Lienzo lienzo;
	private JButton intercalar;
	private Queue<Integer> q;
	
	public Ejercicio5() {
		super("Examen Final - Ejercicio 5");
		Container contentPane = getContentPane();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setMnemonic('a');
		menuBar.add(menuArchivo);
		JMenuItem menuArchivoGuardar = new JMenuItem("Abrir");
		menuArchivoGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
		menuArchivoGuardar.setActionCommand("abrir");
		menuArchivoGuardar.addActionListener(this);
		menuArchivo.add(menuArchivoGuardar);
		contentPane.setLayout(new BorderLayout());
		lienzo = new Lienzo();
		contentPane.add(lienzo, BorderLayout.CENTER);
		intercalar = new JButton("Interclalar");
		intercalar.setActionCommand("intercalar");
		intercalar.setMnemonic('i');
		intercalar.setEnabled(false);
		intercalar.addActionListener(this);
		contentPane.add(intercalar, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Ejercicio5().setVisible(true));
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "abrir":
			abrir();
			break;
		case "intercalar":
			Ejercicio4.intercalar(q);
			lienzo.repaint();
			break;
		}
	}
	
	private void abrir() {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("/home/julio/git/github/fpdistancia/exprog20210616/res"));
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			q = new LinkedList<>();
			try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fc.getSelectedFile())))) {
				while (true) {
					try {
						int n = in.readInt();
						q.offer(n);
					} catch (EOFException e) {
						break;
					}
				}
				lienzo.setNumeros(q);
				intercalar.setEnabled(true);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "No se ha podido leer el fichero");
			}
		}
	}
	
}
