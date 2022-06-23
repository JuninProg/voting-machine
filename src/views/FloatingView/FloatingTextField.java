package src.views.FloatingView;

import javax.swing.JTextField;

public class FloatingTextField extends JTextField{
  String type;

  public FloatingTextField(String text) {
    super(text);
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }
}