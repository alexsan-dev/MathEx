import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Riemann extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Riemann() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(300, 450);
    setResizable(true);
    setLayout(new GridLayout(8, 1));

    // COMPONENTES
    JPanel funcPanel = new JPanel();
    funcPanel.setLayout(new FlowLayout());
    JPanel liminfPanel = new JPanel();
    liminfPanel.setLayout(new FlowLayout());
    JPanel limsupPanel = new JPanel();
    limsupPanel.setLayout(new FlowLayout());
    JPanel limdifPanel = new JPanel();
    limdifPanel.setLayout(new FlowLayout());

    JLabel funcL = new JLabel("Función   ");
    Font font = funcL.getFont().deriveFont(20f);
    funcL.setFont(font);

    JLabel title = new JLabel("   Sumatorio de Riemann");
    title.setFont(title.getFont().deriveFont(15f));
    JLabel text = new JLabel("   Resultado:");
    text.setFont(text.getFont().deriveFont(15f));

    JComboBox<String> funcC = new JComboBox<String>();
    funcC.setFont(font);
    funcC.addItem("Cuadrática");
    funcC.addItem("Cubica");
    funcC.addItem("Exponencial");

    JLabel liminfL = new JLabel("Limite inferior   ");
    liminfL.setFont(font);
    JTextField liminfF = new JTextField();
    liminfF.setFont(font);
    liminfF.setHorizontalAlignment(SwingConstants.CENTER);
    liminfF.setPreferredSize(new Dimension(50, 50));

    JLabel limsupL = new JLabel("Limite superior   ");
    limsupL.setFont(font);
    JTextField limsupF = new JTextField();
    limsupF.setFont(font);
    limsupF.setHorizontalAlignment(SwingConstants.CENTER);
    limsupF.setPreferredSize(new Dimension(50, 50));

    JLabel limdifL = new JLabel("Diferencial   ");
    limdifL.setFont(font);
    JTextField limdifF = new JTextField();
    limdifF.setFont(font);
    limdifF.setHorizontalAlignment(SwingConstants.CENTER);
    limdifF.setPreferredSize(new Dimension(50, 50));

    JLabel res = new JLabel("");
    res.setFont(font);
    res.setOpaque(true);
    res.setHorizontalAlignment(SwingConstants.CENTER);
    res.setBackground(new Color(50, 50, 50));
    res.setForeground(Color.white);

    JButton calculate = new JButton("Calcular");
    calculate.setFont(calculate.getFont().deriveFont(18f));
    calculate.setBackground(new Color(21, 101, 192));
    calculate.setForeground(Color.white);

    funcPanel.add(funcL);
    funcPanel.add(funcC);

    liminfPanel.add(liminfL);
    liminfPanel.add(liminfF);

    limsupPanel.add(limsupL);
    limsupPanel.add(limsupF);

    limdifPanel.add(limdifL);
    limdifPanel.add(limdifF);

    add(title);
    add(funcPanel);
    add(liminfPanel);
    add(limsupPanel);
    add(limdifPanel);
    add(text);
    add(res);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        int func = funcC.getSelectedIndex();
        double inf = Double.parseDouble(liminfF.getText());
        double sup = Double.parseDouble(limsupF.getText());
        double dif = Double.parseDouble(limdifF.getText());
        Double riemannRes = Maths.riemann(func, inf, sup, dif);

        res.setText(riemannRes.toString());
      }
    });
  }
}