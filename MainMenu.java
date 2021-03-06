import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public MainMenu(int width, int height) {
    // ASIGNAR TAMAÑO
    setSize(400, 400);

    // CREAR LAYOUT
    setLayout(new GridLayout(3, 3));

    // CREAR BOTONES
    JButton arith = new JButton("Aritmética");
    JButton algebra = new JButton("Algebra");
    JButton trigonometric = new JButton("Trigonometría");
    JButton calculus = new JButton("Calculo");
    JButton linear = new JButton("Algebra Lineal");
    JButton favorites = new JButton("Favoritos");
    JButton historyBtn = new JButton("Historial");

    // ASIGNAR BOTONES
    add(arith);
    add(algebra);
    add(trigonometric);
    add(calculus);
    add(linear);
    add(favorites);
    add(historyBtn);

    // EVENTO DE CALCULADORA
    arith.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new Calculator();
      }
    });

    algebra.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new Algebra();
      }
    });

    trigonometric.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new Trigonometric();
      }
    });

    calculus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new Calculus();
      }
    });

    linear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new Matrix();
      }
    });

  }
}
