package mx.unam.fciencias;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author José Cruz Galindo Martínez
 */
public class Sierpinski extends JPanel {

    private final double senSesenta = 0.866025;
    private final double cosSesenta = 0.5;
    
    /***
     * Constructor que crea un panel,
     * el cual se encarga de pintar un Triángulo de Sierpinski.
     * @param width El ancho del panel que tenemos para dibujar.
     * @param height El largo del panel que tenemos para dibujar.
     */
    public Sierpinski(int width, int height) {
        super();
        setSize(width, height);
    }
    
    @Override
    public void paint(Graphics g) {
        int anchoPantalla = getSize().width;
        int largoPantalla = getSize().height;
        int puntoX1 = 25;
        int puntoY1 = 10;
        int puntoX2 = anchoPantalla - 25;
        int puntoY2 = 10;
        pintaRecursivo(g, 6, 
                puntoX1, puntoY1,
                puntoX2, puntoY2);
    }
    
    private void pintaRecursivo(Graphics g, int recursividad,
            double point_X1, double point_Y1, 
            double point_X2, double point_Y2) {
        
        double difX = (point_X2 - point_X1);
        double punto_X3 = (difX * cosSesenta) + point_X1;
        double punto_Y3 = (difX * senSesenta) + point_Y1;
        
        // Mitades
        double mitadX_1 = (point_X1 + point_X2) / 2.0;
        double mitadY_1 = (point_Y1 + point_Y1) / 2.0;
        
        double mitadX_2 = (point_X1 + punto_X3) / 2.0;
        double mitadY_2 = (point_Y1 + punto_Y3) / 2.0;
        
        double mitadX_3 = (point_X2 + punto_X3) / 2.0;
        double mitadY_3 = (point_Y2 + punto_Y3) / 2.0;
        
        if (recursividad > 0) {
            pintaRecursivo(g, recursividad -1 ,point_X1, point_Y1, mitadX_1, mitadY_1);
            pintaRecursivo(g, recursividad -1 ,mitadX_1, mitadY_1, point_X2, point_Y2);
            pintaRecursivo(g, recursividad -1 ,mitadX_2, mitadY_2, mitadX_3, mitadY_3);
        } else {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.blue);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine((int)point_X1, (int)point_Y1, (int)point_X2, (int)point_Y2);
            g2d.drawLine((int)point_X1, (int)point_Y1, (int)punto_X3, (int)punto_Y3);
            g2d.drawLine((int)punto_X3, (int)punto_Y3, (int)point_X2, (int)point_Y2);
        }
        
    }
    
}
