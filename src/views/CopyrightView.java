package src.views;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.JTextField;

public class CopyrightView {

  public enum copyrightTypes {
    vote,
    owner
  }

  public HashMap<copyrightTypes, JTextField> components = new HashMap<copyrightTypes, JTextField>();

  public JTextField getComponentByType(copyrightTypes type) {
    JTextField componentFound = this.components.get(type);
    return componentFound;
  }

  public Collection<JTextField> getComponents() {
    return this.components.values();
  }


  public CopyrightView(Integer FRAME_WIDTH, Integer FRAME_HEIGHT) {
    Font copyrightTextFont = new Font("Arial", Font.PLAIN, 9);
    
    JTextField voteTextField = new JTextField("Sistema de Contagem de Voto - S I M U L A D O R - Para fins Educacionais");
    voteTextField.setFont(copyrightTextFont);
    Dimension voteTextFieldDimension = voteTextField.getPreferredSize();
    Integer voteTextFieldPosY = FRAME_HEIGHT - voteTextFieldDimension.height - 25;
    Integer voteTextFieldPosX = 2;
    voteTextField.setBounds(voteTextFieldPosX, voteTextFieldPosY, voteTextFieldDimension.width, voteTextFieldDimension.height);
    voteTextField.setEditable(false);
    this.components.put(copyrightTypes.vote, voteTextField);

    JTextField ownerTextField = new JTextField("Desenvolvido por José - jose.lima.jjunior@gmail.com");
    ownerTextField.setFont(copyrightTextFont);
    Dimension ownerTextFieldDimension = ownerTextField.getPreferredSize();
    Integer ownerTextFieldPosY = FRAME_HEIGHT - ownerTextFieldDimension.height - 25;
    Integer ownerTextFieldPosX = FRAME_WIDTH - 2 - ownerTextFieldDimension.width;
    ownerTextField.setBounds(ownerTextFieldPosX, ownerTextFieldPosY, ownerTextFieldDimension.width, ownerTextFieldDimension.height);
    ownerTextField.setEditable(false);
    this.components.put(copyrightTypes.owner, ownerTextField);
  }
}
