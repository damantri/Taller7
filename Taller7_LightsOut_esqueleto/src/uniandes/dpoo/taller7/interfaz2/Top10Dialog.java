package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;
import uniandes.dpoo.taller7.modelo.Top10;
import uniandes.dpoo.taller7.modelo.RegistroTop10;

public class Top10Dialog extends JDialog {
    public Top10Dialog(Frame owner, Top10 top10) {
        super(owner, "Top 10", true);
        setSize(400, 300);
        setLocationRelativeTo(owner);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (RegistroTop10 registro : top10.darRegistros()) {
            listModel.addElement(registro.darNombre() + " - " + registro.darPuntos() + " puntos");
        }

        JList<String> list = new JList<>(listModel);
        list.setFont(new Font("Arial", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(list);

        add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(e -> dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
