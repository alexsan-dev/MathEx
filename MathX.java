import javax.swing.*;

public class MathX {
  public static void main(String[] args) {
    // PRUEBAS
    // System.out.print(Maths.tan(Math.PI));

    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }

    // CREAR VENTANA Y MENU PRINCIPAL
    new MainMenu(800, 600);
  }
}