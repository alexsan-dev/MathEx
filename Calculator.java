import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class Calculator extends FrameStyle {
  private static final long serialVersionUID = 1L;
  private Double x0 = 0.0;
  private Double x1 = 0.0;
  private Boolean mode = true;
  private int action = 0;
  private JLabel view;

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
        out = Maths.fact(Maths.parseInt(x0));
        break;
      case 6:
        out = Maths.pow(x0, Maths.parseInt(x1));
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
    mode = true;
  }

  public Calculator() {
    // CONFIGURAR FRAME
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Aritmética");
    setSize(300, 400);
    setLayout(new GridBagLayout());
    GridBagConstraints cMain = new GridBagConstraints();
    cMain.gridx = 0;
    cMain.gridy = 0;
    cMain.fill = GridBagConstraints.BOTH;
    cMain.weighty = 1.0;
    cMain.weightx = 1.0;

    // CONFIGURAR PANEL
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    // CREAR COMPONENTES
    view = new JLabel();
    view.setFont(view.getFont().deriveFont(24f));
    view.setHorizontalAlignment(SwingConstants.CENTER);
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
    c.gridx = 0;
    c.gridy = 0;
    c.fill = GridBagConstraints.BOTH;
    c.weighty = 1.0;
    c.weightx = 1.0;
    panel.add(one, c);

    c.gridx = 1;
    panel.add(two, c);

    c.gridx = 2;
    panel.add(three, c);

    c.gridx = 3;
    panel.add(four, c);

    c.gridx = 4;
    panel.add(five, c);

    c.gridx = 0;
    c.gridy = 1;
    panel.add(six, c);

    c.gridx = 1;
    panel.add(seven, c);

    c.gridx = 2;
    panel.add(eight, c);

    c.gridx = 3;
    panel.add(nine, c);

    c.gridx = 4;
    panel.add(zero, c);

    c.gridx = 0;
    c.gridy = 2;
    panel.add(plus, c);

    c.gridx = 1;
    panel.add(minus, c);

    c.gridx = 2;
    panel.add(multiply, c);

    c.gridx = 3;
    panel.add(div, c);

    c.gridx = 4;
    panel.add(root, c);

    c.gridx = 0;
    c.gridy = 3;
    panel.add(pow, c);

    c.gridx = 1;
    panel.add(fact, c);

    c.gridx = 2;
    panel.add(inverse, c);

    c.gridx = 3;
    panel.add(negative, c);

    c.gridx = 4;
    panel.add(nRoot, c);

    c.gridx = 0;
    c.gridy = 4;
    panel.add(favorite, c);

    c.gridx = 1;
    c.gridwidth = 2;
    panel.add(clear, c);

    c.gridx = 3;
    c.gridwidth = 2;
    panel.add(equals, c);

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

    add(view, cMain);

    cMain.gridy = 1;
    add(panel, cMain);
  }
}