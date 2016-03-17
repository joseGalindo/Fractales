package mx.unam.fciencias;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author grupojaque
 */
public class Koch extends JPanel{
    
    private final double senSesenta = 0.866025;
    private final double cosSesenta = 0.5;
    
    public Koch(int ancho, int largo) {
        setSize(ancho, largo);
    }
    
    public void paint(Graphics g) {
        int anchoPantalla = getSize().width;
        int largoPantalla = getSize().height;
        int puntoX1 = 60;
        int puntoY1 = 200;
        int puntoX2 = anchoPantalla - 60;
        int puntoY2 = 200;
        pintaRecursivo(g, 5, puntoX2, puntoY2, puntoX1, puntoY1);
        pintaRecursivo(g, 5, 285, 415 + 200, puntoX2, puntoY2);
        pintaRecursivo(g, 5, puntoX1, puntoY1, 285, 415 + 200);
    }
    
    private void pintaRecursivo(Graphics g, int recursividad, 
            int pX1, int pY1, 
            int pX2, int pY2) {
        
        double difX = (pX2 - pX1) / 3.0;
        double difY = (pY2 - pY1) / 3.0;
        
        double rotDifX = (difX * cosSesenta) - (difY * senSesenta);
        double rotDifY = (difX * senSesenta) + (difY * cosSesenta);
        
        double pX3 = pX1 + difX;
        double pY3 = pY1 + difY;
        double pX4 = pX1 + (2 * difX);
        double pY4 = pY1 + (2 * difY);
        
        double pX5 = pX3 + rotDifX;
        double pY5 = pY3 + rotDifY;
        
        if (recursividad > 0) {
            pintaRecursivo(g, recursividad-1,  (int)pX1, (int)pY1, (int)pX3, (int)pY3);
            pintaRecursivo(g, recursividad-1,  (int)pX3, (int)pY3, (int)pX5, (int)pY5);
            pintaRecursivo(g, recursividad-1,  (int)pX5, (int)pY5, (int)pX4, (int)pY4);
            pintaRecursivo(g, recursividad-1,  (int)pX4, (int)pY4, (int)pX2, (int)pY2);
        } else {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.blue);
            g.drawLine(pX1, pY1, (int)pX3, (int)pY3);
            g.drawLine((int)pX3, (int)pY3, (int)pX5, (int)pY5);
            g.drawLine((int)pX5, (int)pY5, (int)pX4, (int)pY4);
            g.drawLine((int)pX4, (int)pY4, pX2, pY2);
        }
        
    }
    
}
