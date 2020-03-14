import java.awt.*;
import javax.swing.*;

public class MainMenu extends JPanel {
  public MainMenu() {
    // CREAR BOTONES
    JButton aritm = new JButton("Aritmetica");
    JButton alegb = new JButton("Algebra");

    // CREAR LAYOUT
    setLayout(new GridLayout(1, 3));

    // ASIGNAR BOTONES
    add(aritm);
    add(alegb);
  }
}