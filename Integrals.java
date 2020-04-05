import java.awt.*;
import javax.swing.*;

public class Integrals extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Integrals() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(300, 300);
    setLayout(new GridLayout(2, 3));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2, 1));

    JScrollPane scrollPanel = new JScrollPane(panel);
    JLabel title1 = new JLabel("Método de sustitución");
    JLabel text1 = new JLabel(
        "El método de integración por sustitución o cambio de variable se basa en la derivada de la función compuesta. Para cambiar de variable identificamos una parte de lo que se va a integrar con una nueva variable t, de modo que se obtenga una integral más sencilla.");

    text1.setPreferredSize(new Dimension(300, 100));

    panel.add(title1);
    panel.add(text1);

    add(scrollPanel);
  }
}