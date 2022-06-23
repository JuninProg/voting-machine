package src.views.VoteView;

import javax.swing.JTextField;

public class VoteTextField extends JTextField{
  String type;

  public VoteTextField(String text) {
    super(text);
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }
}
