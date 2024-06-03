package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;
import java.io.File;
import com.formdev.flatlaf.FlatLightLaf;

public class VentanaPrincipal extends JFrame {
    private PanelSuperior panelSuperior;
    private PanelDerecho panelDerecho;
    private PanelInferior panelInferior;
    private TableroPanel tableroPanel;
    private Tablero tablero;
    private Top10 top10;

    public VentanaPrincipal() {
        setTitle("Lights Out");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        top10 = new Top10();
        // Cargar registros si existe el archivo
        File archivoTop10 = new File("top10.csv");
        if (archivoTop10.exists()) {
            top10.cargarRecords(archivoTop10);
        }

        panelSuperior = new PanelSuperior();
        panelDerecho = new PanelDerecho();
        panelInferior = new PanelInferior();
        tableroPanel = new TableroPanel();

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecho, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        add(tableroPanel, BorderLayout.CENTER);

        // Agregar escuchadores a los botones
        panelDerecho.agregarEscuchadores(new ManejadorBotones());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                salvarTop10();
            }
        });

        setVisible(true);
    }

    private void salvarTop10() {
        // Implementar la lógica para salvar el Top10
        File archivoTop10 = new File("top10.csv");
        try {
            top10.salvarRecords(archivoTop10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ManejadorBotones implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            if (comando.equals("NUEVO")) {
                int tamano = panelSuperior.getTamanoTablero();
                tablero = new Tablero(tamano);
                tablero.desordenar(panelSuperior.esDificil() ? 10 : 5); // Dificultad basada en la selección
                tableroPanel.setTablero(tablero);
            } else if (comando.equals("REINICIAR")) {
                tablero.reiniciar();
                tableroPanel.repaint();
            } else if (comando.equals("TOP-10")) {
                mostrarTop10();
            } else if (comando.equals("CAMBIAR JUGADOR")) {
                cambiarJugador();
            }
        }
    }

    private void mostrarTop10() {
        Top10Dialog dialog = new Top10Dialog(this, top10);
        dialog.setVisible(true);
    }

    private void cambiarJugador() {
        String nuevoJugador = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo jugador:");
        if (nuevoJugador != null && !nuevoJugador.isEmpty()) {
            panelInferior.setNombreJugador(nuevoJugador);
        }
    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        new VentanaPrincipal();
    }
}
