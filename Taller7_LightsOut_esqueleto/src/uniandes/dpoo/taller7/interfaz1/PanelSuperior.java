package uniandes.dpoo.taller7.interfaz1;

import javax.swing.*;

public class PanelSuperior extends JPanel {
    private JComboBox<String> comboBox;
    private JRadioButton radioButton;

    public PanelSuperior() {
        JLabel label = new JLabel("Tamaño:");
        comboBox = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"});
        radioButton = new JRadioButton("Dificultad");

        add(label);
        add(comboBox);
        add(radioButton);
    }

    public int getTamanoTablero() {
        String seleccion = (String) comboBox.getSelectedItem();
        return Integer.parseInt(seleccion.split("x")[0]);
    }

    public boolean esDificil() {
        return radioButton.isSelected();
    }
}
