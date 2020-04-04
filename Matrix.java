import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Matrix extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Matrix() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(300, 100);
    setLayout(new GridLayout(1, 2));

    JButton one = new JButton("Una matriz");
    JButton more = new JButton("Dos matrices");

    add(one);
    add(more);

    one.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new OMatrix();
      }
    });
  }
}