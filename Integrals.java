import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Integrals extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Integrals() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(400, 400);
    setResizable(true);

    JEditorPane panel = new JEditorPane();
    panel.setBorder(new EmptyBorder(0, 20, 0, 20));

    JScrollPane scrollPane = new JScrollPane(panel);

    panel.setContentType("text/html");
    panel.setEditable(false);
    String text1 = "<html> <h1 align:'center'>Integración por sustitución</h1> <p> El método de integración por sustitución o cambio de variable se basa en la derivada de la función compuesta. Para cambiar de variable identificamos una parte de lo que se va a integrar con una nueva variable u, de modo que se obtenga una integral más sencilla.</p><h3 align:'center'>∫f'(u)*u'dx=f(u) + c</h3> <h1 align:'center'>Integración por partes</h1> <p> Cuando el integrando está formado por un producto (o una división, que podemos tratar como un producto) se recomienda utilizar el método de integración por partes que consiste en aplicar la siguiente fórmula: </p><h3 align:'center'>∫udv=uv - ∫vdu</h3><h1 align:'center'>Integración por cambio de variables</h1> <p> Para cada una de ellas existe una sustitución que al aplicarla, transforma el integrando de manera que queda en términos de expresiones trigonométricas, las cuales ya sabemos integrar. </p> <h3 align:'center'>∫sen(x)cos(x)dx=> ∫θd(θ)</h3></html>";

    panel.setText(text1);
    add(scrollPane);
  }
}