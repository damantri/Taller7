package uniandes.dpoo.taller7.interfaz1;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelDerecho extends JPanel {
    private JButton nuevoButton;
    private JButton reiniciarButton;
    private JButton top10Button;
    private JButton cambiarJugadorButton;

    public PanelDerecho() {
        nuevoButton = new JButton("NUEVO");
        reiniciarButton = new JButton("REINICIAR");
        top10Button = new JButton("TOP-10");
        cambiarJugadorButton = new JButton("CAMBIAR JUGADOR");

        add(nuevoButton);
        add(reiniciarButton);
        add(top10Button);
        add(cambiarJugadorButton);
    }

    public void agregarEscuchadores(ActionListener al) {
        nuevoButton.addActionListener(al);
        reiniciarButton.addActionListener(al);
        top10Button.addActionListener(al);
        cambiarJugadorButton.addActionListener(al);
    }
}

