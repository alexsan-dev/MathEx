import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends FrameStyle {
  private static final long serialVersionUID = 1L;
  private Double x0 = 0.0;
  private Double x1 = 0.0;
  private Boolean mode = true;
  private int action = 0;
  private JTextArea view;

  private void addEvent(JButton btn, Double value) {
    btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        if (mode)
          x0 = value;
        else
          x1 = value;

        view.setText(value.toString());
      }
    });
  }

  private void addAction(JButton btn, int actionS, boolean calcOff) {
    btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        action = actionS;
        mode = false;

        if (calcOff)
          calculate();
      }
    });
  }

  private void calculate() {
    Double out = 0.0;
    switch (action) {
      case 0:
        out = Maths.sum(x0, x1);
        break;
      case 1:
        out = Maths.dif(x0, x1);
        break;
      case 2:
        out = Maths.mult(x0, x1);
        break;
      case 3:
        out = Maths.div(x0, x1);
        break;
      case 4:
        out = Maths.sqrt(x0);
        break;
      case 5:
        out = (double) Maths.fact(Maths.parseInt(x0));
        break;
      case 6:
        out = (double) Maths.pow(x0, Maths.parseInt(x1));
        break;
      case 7:
        out = Maths.inverse(x0);
        break;
      case 8:
        out = Maths.negative(x0);
        break;
      default:
        out = 0.0;
    }

    view.setText(out.toString());
    x0 = out;
  }

  public Calculator() {
    // CONFIGURAR FRAME
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Aritmética");
    setSize(350, 450);
    setLayout(new GridLayout(2, 1));

    // CONFIGURAR PANEL
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(5, 5));

    // CREAR COMPONENTES
    view = new JTextArea(1, 0);
    view.setFont(view.getFont().deriveFont(24f));
    view.setText("0.0");

    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton zero = new JButton("0");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton multiply = new JButton("x");
    JButton div = new JButton("/");
    JButton root = new JButton("√");
    JButton pow = new JButton("^");
    JButton fact = new JButton("!");
    JButton inverse = new JButton("1/x");
    JButton negative = new JButton("(-1)");
    JButton nRoot = new JButton("n√");
    JButton clear = new JButton("CLS");
    JButton favorite = new JButton("S");
    JButton equals = new JButton("=");

    // AGREGAR COMPONENTES
    panel.add(one);
    panel.add(two);
    panel.add(three);
    panel.add(four);
    panel.add(five);
    panel.add(six);
    panel.add(seven);
    panel.add(eight);
    panel.add(nine);
    panel.add(zero);
    panel.add(plus);
    panel.add(minus);
    panel.add(multiply);
    panel.add(div);
    panel.add(root);
    panel.add(pow);
    panel.add(fact);
    panel.add(inverse);
    panel.add(negative);
    panel.add(clear);
    panel.add(nRoot);
    panel.add(favorite);
    panel.add(equals);

    // EVENTOS
    addEvent(one, 1.0);
    addEvent(two, 2.0);
    addEvent(three, 3.0);
    addEvent(four, 4.0);
    addEvent(five, 5.0);
    addEvent(six, 6.0);
    addEvent(seven, 7.0);
    addEvent(eight, 8.0);
    addEvent(nine, 9.0);
    addEvent(zero, 0.0);

    addAction(plus, 0, false);
    addAction(minus, 1, false);
    addAction(multiply, 2, false);
    addAction(div, 3, false);
    addAction(root, 4, true);
    addAction(fact, 5, true);
    addAction(pow, 6, false);
    addAction(inverse, 7, true);
    addAction(negative, 8, true);
    addAction(nRoot, 9, true);

    equals.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        calculate();
      }
    });

    clear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        view.setText("0.0");
        x0 = 0.0;
      }
    });

    add(view);
    add(panel);
  }
}