import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Derivate extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Derivate() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(400, 400);
    setResizable(true);

    JEditorPane panel = new JEditorPane();
    panel.setBorder(new EmptyBorder(0, 20, 0, 20));

    JScrollPane scrollPane = new JScrollPane(panel);

    panel.setContentType("text/html");
    panel.setEditable(false);
    String text1 = "<html> <h1 align:'center'>Derivada de función de grado n</h1> <p> En una función polinómica de grado n f(x)=x^n donde n es un entero positivo, su derivada es: <p/> <h3 align:'center'>f'(x)=nx^(n-1)</h3> <h1 align:'center'>Derivada del producto de una constante por una función</h1> <p>La derivada de una función f(x) por una constante k es la derivada de la función por la constante k <p/> <h3 align:'center'>kf'(x)</h3> <h1 align:'center'>Derivada de una suma</h1> <p> La derivada de una función f(x) más una función g(x) es la derivada de f mas la derivada de g <p/> <h3 align:'center'>f'(x) + g'(x)</h3> <h1 align:'center'>Derivada de un producto</h1> <p> La derivada de una función f(x) por una función g(x) es la derivada de f por g mas la derivada de g por f <p/> <h3 align:'center'>f'(x)g(x) + g'(x)f(x)</h3> <h1 align:'center'>Derivada de un cociente</h1> <p> La derivada de una función f(x) entre una función g(x) es la derivada de f por g menos la derivada de g por f sobre g al cuadrado <p/> <h3 align:'center'>f'(x)g(x) - g'(x)f(x) / g(x)²</h3> <h1 align:'center'>Regla de la cadena</h1> <p> La regla de la cadena es una fórmula para calcular la derivada de la composición de dos o más funciones. Esto es, si f y g son dos funciones, entonces la regla de la cadena expresa la derivada de la función compuesta f ∘ g en términos de las derivadas de f y g. Por ejemplo , la regla de la cadena de f ∘ g (x) ≡ f [g (x)] es <p/> <h3 align:'center'>(f o g)'(x)=f'(g(x)) * g'(x)</h3> </html>";

    panel.setText(text1);
    add(scrollPane);
  }
}