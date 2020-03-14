import javax.swing.*;
import java.awt.Color;
import javax.swing.UnsupportedLookAndFeelException;

public class Window extends JFrame {
  public Window(int width, int height) {
    // AGREGAR NOMBRE
    super("MathEx - Java Calculator");

    // AGREGAR ICONO Y COLOR
    setIconImage(new ImageIcon("assets/icon.png").getImage());
    setBackground(new Color(255, 255, 255));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // AGREGAR DIMENSIONES
    setSize(width, height);
    setResizable(false);
    setVisible(true);
  }
}