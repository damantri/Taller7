package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import uniandes.dpoo.taller7.modelo.Tablero;

public class TableroPanel extends JPanel {
    private Tablero tablero;

    public TableroPanel() {
        // Inicializar con un tablero por defecto
        this.tablero = new Tablero(5); 

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int[] casilla = convertirCoordenadasACasilla(e.getX(), e.getY());
                tablero.jugar(casilla[0], casilla[1]);
                repaint();
            }
        });
    }

    private void inicializarTablero() {

        tablero.desordenar(10); 
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int anchoCasilla = getWidth() / tablero.darTablero().length;
        int altoCasilla = getHeight() / tablero.darTablero().length;

        for (int i = 0; i < tablero.darTablero().length; i++) {
            for (int j = 0; j < tablero.darTablero()[i].length; j++) {
                if (tablero.darTablero()[i][j]) {
                    g2d.setColor(Color.GRAY); // Apagado
                } else {
                    g2d.setColor(Color.YELLOW); // Encendido
                }
                g2d.fillRoundRect(j * anchoCasilla, i * altoCasilla, anchoCasilla, altoCasilla, 20, 20);
            }
        }
    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        int anchoCasilla = getWidth() / tablero.darTablero().length;
        int altoCasilla = getHeight() / tablero.darTablero().length;
        int fila = y / altoCasilla;
        int columna = x / anchoCasilla;
        return new int[]{fila, columna};
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
        repaint();
    }
}
