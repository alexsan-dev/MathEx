import javax.swing.*;

public class MathX {
  public static void main(String[] args) {
    // PRUEBAS
    // int[][] mat = { { 3, 2, 5 }, { 2, 1, 7 }, { 1, 5, 6 } };

    // System.out.print(Maths.root(5, 4));

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
