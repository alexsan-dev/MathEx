import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Riemann extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Riemann() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(300, 300);
    setLayout(new GridLayout(2, 1));

    // COMPONENTES
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(5, 2));

    JLabel funcL = new JLabel("Función");
    JComboBox<String> funcC = new JComboBox<String>();
    funcC.addItem("Cuadrática");
    funcC.addItem("Cubica");
    funcC.addItem("Exponencial");

    JLabel liminfL = new JLabel("Limite inferior");
    JTextField liminfF = new JTextField();

    JLabel limsupL = new JLabel("Limite superior");
    JTextField limsupF = new JTextField();

    JLabel limdifL = new JLabel("Diferencial");
    JTextField limdifF = new JTextField();

    JLabel res = new JLabel("Resultado");
    JButton calculate = new JButton("Calcular");

    panel.add(funcL);
    panel.add(funcC);
    panel.add(liminfL);
    panel.add(liminfF);
    panel.add(limsupL);
    panel.add(limsupF);
    panel.add(limdifL);
    panel.add(limdifF);
    panel.add(res);

    add(panel);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        int func = funcC.getSelectedIndex();
        double inf = Double.parseDouble(liminfF.getText());
        double sup = Double.parseDouble(limsupF.getText());
        double dif = Double.parseDouble(limdifF.getText());
        Double riemannRes = Maths.riemann(func, inf, sup, dif);

        res.setText("Resultado =  " + riemannRes.toString());
      }
    });
  }
}