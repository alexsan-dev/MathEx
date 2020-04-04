import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Trigonometric extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Trigonometric() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Aritmética");
    setSize(400, 250);
    setLayout(new GridLayout(4, 1));

    // COMPONENTES
    JPanel senPanel = new JPanel();
    JLabel senT = new JLabel(" seno ");
    JTextField senF = new JTextField();
    JButton calcSen = new JButton(" Calcular");
    JLabel senRes = new JLabel(" = 0");
    senPanel.setLayout(new GridLayout(1, 4));
    senPanel.add(senT);
    senPanel.add(senF);
    senPanel.add(calcSen);
    senPanel.add(senRes);

    JPanel cosPanel = new JPanel();
    JLabel cosT = new JLabel(" cos ");
    JTextField cosF = new JTextField();
    JButton calcCos = new JButton(" Calcular");
    JLabel cosRes = new JLabel(" = 0");
    cosPanel.setLayout(new GridLayout(1, 4));
    cosPanel.add(cosT);
    cosPanel.add(cosF);
    cosPanel.add(calcCos);
    cosPanel.add(cosRes);

    JPanel tanPanel = new JPanel();
    JLabel tanT = new JLabel(" tangente ");
    JTextField tanF = new JTextField();
    JButton calcTan = new JButton(" Calcular");
    JLabel tanRes = new JLabel(" = 0");
    tanPanel.setLayout(new GridLayout(1, 4));
    tanPanel.add(tanT);
    tanPanel.add(tanF);
    tanPanel.add(calcTan);
    tanPanel.add(tanRes);

    JPanel archPanel = new JPanel();
    JLabel archT = new JLabel(" angulo ");
    JTextField archF = new JTextField();
    JLabel archR = new JLabel(" radio ");
    JTextField archRf = new JTextField();
    ButtonGroup G = new ButtonGroup();
    JRadioButton deg = new JRadioButton("D");
    JRadioButton rad = new JRadioButton("R");

    G.add(deg);
    G.add(rad);

    JButton calcArch = new JButton("VER");
    archPanel.setLayout(new GridLayout(1, 6));
    archPanel.add(archT);
    archPanel.add(archF);
    archPanel.add(archR);
    archPanel.add(archRf);
    archPanel.add(deg);
    archPanel.add(rad);
    archPanel.add(calcArch);

    add(senPanel);
    add(cosPanel);
    add(tanPanel);
    add(archPanel);

    calcSen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        Double x = Double.parseDouble(senF.getText());
        senRes.setText(" = " + Maths.sin(x));
      }
    });

    calcCos.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        Double x = Double.parseDouble(cosF.getText());
        cosRes.setText(" = " + Maths.cos(x));
      }
    });

    calcTan.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        Double x = Double.parseDouble(tanF.getText());
        tanRes.setText(" = " + Maths.tan(x));
      }
    });

    calcArch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {

        boolean mode = rad.isSelected();
        Double angle = Double.parseDouble(archF.getText());
        Double tempAngle = mode ? angle : angle * (Maths.PI / 180);
        Double graphAngle = mode ? angle * (180 / Maths.PI) : angle;

        Double radius = Double.parseDouble(archRf.getText());

        Double archLength = Maths.archLength(tempAngle, radius);
        new ArchFrame(Maths.parseInt(graphAngle), Maths.parseInt(radius), archLength);
      }
    });

  }
}