import javax.swing.*;

public class MathX {
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }

    // CREAR VENTANA Y MENU PRINCIPAL
    new MainMenu(800, 600);
  }
}
