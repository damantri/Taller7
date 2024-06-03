package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import uniandes.dpoo.taller7.interfaz1.VentanaPrincipal;

public class PersonalizarVentanaPrincipal extends VentanaPrincipal {
    public PersonalizarVentanaPrincipal() {
        super();
    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        new PersonalizarVentanaPrincipal();
    }
}
