import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Trigonometric extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Trigonometric() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Aritmética");
    setSize(400, 400);
    setResizable(true);
    setLayout(new GridLayout(6, 1));

    // COMPONENTES
    JPanel senPanel = new JPanel();

    JLabel trigTitle = new JLabel("   Funciones trigonométricas:");
    trigTitle.setFont(trigTitle.getFont().deriveFont(15f));
    JLabel archTitle = new JLabel("   Longitud de arco:");
    archTitle.setFont(archTitle.getFont().deriveFont(15f));

    JLabel senT = new JLabel("sen(");
    Font font = senT.getFont().deriveFont(20f);
    senT.setFont(font);

    JTextField senF = new JTextField();
    senF.setText("0");
    senF.setHorizontalAlignment(SwingConstants.CENTER);
    senF.setFont(font);
    senF.setPreferredSize(new Dimension(50, 50));

    JButton calcSen = new JButton("Calcular");
    calcSen.setFont(calcSen.getFont().deriveFont(18f));
    calcSen.setBackground(new Color(21, 101, 192));
    calcSen.setForeground(Color.white);
    JLabel senRes = new JLabel(") = 0.0");
    senRes.setFont(font);

    senPanel.setLayout(new FlowLayout());
    senPanel.add(senT);
    senPanel.add(senF);
    senPanel.add(senRes);
    senPanel.add(calcSen);

    JPanel cosPanel = new JPanel();
    JLabel cosT = new JLabel("cos(");
    cosT.setFont(font);
    JTextField cosF = new JTextField();
    cosF.setText("0");
    cosF.setHorizontalAlignment(SwingConstants.CENTER);
    cosF.setFont(font);
    cosF.setPreferredSize(new Dimension(50, 50));

    JButton calcCos = new JButton(" Calcular");
    calcCos.setFont(calcSen.getFont().deriveFont(18f));
    calcCos.setBackground(new Color(21, 101, 192));
    calcCos.setForeground(Color.white);
    JLabel cosRes = new JLabel(") = 1.0");
    cosRes.setFont(font);
    cosPanel.setLayout(new FlowLayout());
    cosPanel.add(cosT);
    cosPanel.add(cosF);
    cosPanel.add(cosRes);
    cosPanel.add(calcCos);

    JPanel tanPanel = new JPanel();
    JLabel tanT = new JLabel("tan(");
    tanT.setFont(font);

    JTextField tanF = new JTextField();
    tanF.setText("0");
    tanF.setHorizontalAlignment(SwingConstants.CENTER);
    tanF.setFont(font);
    tanF.setPreferredSize(new Dimension(50, 50));

    JButton calcTan = new JButton("Calcular");
    calcTan.setFont(calcSen.getFont().deriveFont(18f));
    calcTan.setBackground(new Color(21, 101, 192));
    calcTan.setForeground(Color.white);
    JLabel tanRes = new JLabel(") = 0.0");
    tanRes.setFont(font);

    tanPanel.setLayout(new FlowLayout());
    tanPanel.add(tanT);
    tanPanel.add(tanF);
    tanPanel.add(tanRes);
    tanPanel.add(calcTan);

    JPanel archPanel = new JPanel();
    archPanel.setBackground(new Color(50, 50, 50));

    JLabel archT = new JLabel("angulo: ");
    archT.setFont(font);
    archT.setForeground(Color.white);

    JTextField archF = new JTextField();
    archF.setText("0");
    archF.setHorizontalAlignment(SwingConstants.CENTER);
    archF.setFont(font);
    archF.setPreferredSize(new Dimension(50, 50));

    JLabel archR = new JLabel("radio: ");
    archR.setForeground(Color.white);
    archR.setFont(font);

    JTextField archRf = new JTextField();
    archRf.setHorizontalAlignment(SwingConstants.CENTER);
    archRf.setFont(font);
    archRf.setPreferredSize(new Dimension(50, 50));
    archRf.setText("0");

    JPanel radioPanel = new JPanel();
    radioPanel.setLayout(new GridLayout(2, 1));
    radioPanel.setBackground(new Color(50, 50, 50));

    ButtonGroup G = new ButtonGroup();
    JRadioButton deg = new JRadioButton("D");
    JRadioButton rad = new JRadioButton("R");

    deg.setForeground(Color.white);
    rad.setForeground(Color.white);

    G.add(deg);
    G.add(rad);

    JButton calcArch = new JButton("Ver");
    calcArch.setFont(calcArch.getFont().deriveFont(18f));
    calcArch.setBackground(new Color(21, 101, 192));
    calcArch.setForeground(Color.white);
    archPanel.setLayout(new FlowLayout());
    archPanel.add(archT);
    archPanel.add(archF);
    archPanel.add(archR);
    archPanel.add(archRf);
    radioPanel.add(deg);
    radioPanel.add(rad);
    archPanel.add(radioPanel);
    archPanel.add(calcArch);

    add(trigTitle);
    add(senPanel);
    add(cosPanel);
    add(tanPanel);
    add(archTitle);
    add(archPanel);

    calcSen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        Double x = Double.parseDouble(senF.getText());
        senRes.setText(") = " + Maths.sin(x));
      }
    });

    calcCos.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        Double x = Double.parseDouble(cosF.getText());
        cosRes.setText(") = " + Maths.cos(x));
      }
    });

    calcTan.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        Double x = Double.parseDouble(tanF.getText());
        tanRes.setText(") = " + Maths.tan(x));
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

        if (tempAngle == 0 || radius == 0)
          JOptionPane.showMessageDialog(null, "El angulo o el radio no pueden ser 0", "Error al dibujar",
              JOptionPane.ERROR_MESSAGE);
        else
          new ArchFrame(Maths.parseInt(graphAngle), Maths.parseInt(radius), archLength);
      }
    });

  }
}