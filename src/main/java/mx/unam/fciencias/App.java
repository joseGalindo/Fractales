package mx.unam.fciencias;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        
        JFrame marco = new JFrame("Sierpinsky");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setPreferredSize(new Dimension(600, 800));
        
//        Sierpinski sierpinski = new Sierpinski(600, 600);
//        
//        marco.add(sierpinski);
//        marco.pack();
//        marco.setVisible(true);
        
        Koch koch = new Koch(600,600);

        marco.add(koch);
        marco.pack();
        marco.setVisible(true);
        
        
        
    }
}
