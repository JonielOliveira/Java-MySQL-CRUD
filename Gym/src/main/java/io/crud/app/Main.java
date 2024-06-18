package io.crud.app;

import io.crud.gui.ConsultaGUI;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ConsultaGUI startWindow = new ConsultaGUI();
                startWindow.setVisible(true);
            }
        });
    }
}