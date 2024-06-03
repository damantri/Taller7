package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;

public class PanelInferior extends JPanel {
    private JTextField textField;

    public PanelInferior() {
        JLabel label = new JLabel("Jugador:");
        textField = new JTextField(10);

        add(label);
        add(textField);
    }

    public String getNombreJugador() {
        return textField.getText();
    }

    public void setNombreJugador(String nombre) {
        textField.setText(nombre);
    }
}
