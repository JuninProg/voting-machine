package src.views.VoteView;
import javax.swing.JTextField;
import java.awt.*;
import java.util.ArrayList;

public class VoteView {
  ArrayList<VoteTextField> components = new ArrayList<VoteTextField>();

  public enum voteTypes {
    voteTexts,
    voteOffice
  }

  public ArrayList<VoteTextField> getComponentsByType(voteTypes type) {
    ArrayList<VoteTextField> filteredComponents = new ArrayList<VoteTextField>(this.components);
    filteredComponents.removeIf(comp -> (comp.getType() != type.toString()));
    return filteredComponents;
  }

  public ArrayList<VoteTextField> getComponents(){
    return this.components;
  }

  public VoteView(Integer FRAME_WIDTH, Integer FRAME_HEIGHT) {
    Dimension voteTextFieldDimension = new Dimension(50, 80);
    Font voteTextFieldFont = new Font("Arial", Font.PLAIN, 40);

    Integer voteTextFieldSpaceBetween = 5;
    Integer voteTextFieldFixedPosY = 190;

    Integer voteTextFieldInitialPosX = 50;

    Integer voteText1PosX = voteTextFieldInitialPosX;
    Integer voteText1PosY = voteTextFieldFixedPosY;

    VoteTextField voteText1Field = new VoteTextField("");
    voteText1Field.setType(voteTypes.voteTexts.toString());
    voteText1Field.setFont(voteTextFieldFont);
    voteText1Field.setBounds(voteText1PosX, voteText1PosY, voteTextFieldDimension.width, voteTextFieldDimension.height);
    voteText1Field.setHorizontalAlignment(JTextField.CENTER);
    voteText1Field.setEditable(false);
    this.components.add(voteText1Field);

    Integer voteText2PosX = voteText1PosX + voteTextFieldSpaceBetween + voteTextFieldDimension.width;
    Integer voteText2PosY = voteTextFieldFixedPosY;
    VoteTextField voteText2Field = new VoteTextField("");
    voteText2Field.setType(voteTypes.voteTexts.toString());
    voteText2Field.setFont(voteTextFieldFont);
    voteText2Field.setBounds(voteText2PosX, voteText2PosY, voteTextFieldDimension.width, voteTextFieldDimension.height);
    voteText2Field.setHorizontalAlignment(JTextField.CENTER);
    voteText2Field.setEditable(false);
    this.components.add(voteText2Field);

    Integer voteText3PosX = voteText2PosX + voteTextFieldSpaceBetween + voteTextFieldDimension.width;
    Integer voteText3PosY = voteTextFieldFixedPosY;
    VoteTextField voteText3Field = new VoteTextField("");
    voteText3Field.setType(voteTypes.voteTexts.toString());
    voteText3Field.setFont(voteTextFieldFont);
    voteText3Field.setBounds(voteText3PosX, voteText3PosY, voteTextFieldDimension.width, voteTextFieldDimension.height);
    voteText3Field.setHorizontalAlignment(JTextField.CENTER);
    voteText3Field.setEditable(false);
    this.components.add(voteText3Field);

    Integer voteText4PosX = voteText3PosX + voteTextFieldSpaceBetween + voteTextFieldDimension.width;
    Integer voteText4PosY = voteTextFieldFixedPosY;
    VoteTextField voteText4Field = new VoteTextField("");
    voteText4Field.setType(voteTypes.voteTexts.toString());
    voteText4Field.setFont(voteTextFieldFont);
    voteText4Field.setBounds(voteText4PosX, voteText4PosY, voteTextFieldDimension.width, voteTextFieldDimension.height);
    voteText4Field.setHorizontalAlignment(JTextField.CENTER);
    voteText4Field.setEditable(false);
    this.components.add(voteText4Field);

    Font voteOfficeTextFieldFont = new Font("Arial", Font.PLAIN, 30);

    Integer voteOfficeTextFieldFixedPosY = 120;
    Integer voteOfficeTextFieldFoxedPosX = 70;

    VoteTextField voteOfficeTextField = new VoteTextField("");
    voteOfficeTextField.setType(voteTypes.voteOffice.toString());
    voteOfficeTextField.setFont(voteOfficeTextFieldFont);
    Dimension voteOfficeTextFieldDimension = voteOfficeTextField.getPreferredSize();
    voteOfficeTextField.setBounds(voteOfficeTextFieldFoxedPosX, voteOfficeTextFieldFixedPosY, voteOfficeTextFieldDimension.width, voteOfficeTextFieldDimension.height);
    voteOfficeTextField.setEditable(false);
    this.components.add(voteOfficeTextField);
  }

  public void addVote(String vote){
    ArrayList<VoteTextField> voteTextFields = this.getComponentsByType(voteTypes.voteTexts);

    for (VoteTextField voteTextField : voteTextFields) {
      String text = voteTextField.getText();
      if (text.isEmpty() && voteTextField.isVisible()) {
        voteTextField.setText(vote);
        break;
      }
    }
  }

  public String getPartyNumber(){
    ArrayList<VoteTextField> voteTextFields = this.getComponentsByType(voteTypes.voteTexts);
    String partyNumber = "";
    for (VoteTextField voteTextField : voteTextFields) {
      partyNumber += voteTextField.getText();
    }
    return partyNumber;
  }

  public void cleanVotes(){
    ArrayList<VoteTextField> voteTextFields = this.getComponentsByType(voteTypes.voteTexts);

    for (JTextField component : voteTextFields) {
      component.setText("");
    }
  }

  public void setVoteOffice(String text){
    VoteTextField voteOfficeTextField = this.getComponentsByType(voteTypes.voteOffice).get(0);
    voteOfficeTextField.setText(text);
    Point voteOfficeTextFieldLocation = voteOfficeTextField.getLocation();
    Dimension voteOfficeTextFieldSize =  voteOfficeTextField.getPreferredSize();
    voteOfficeTextField.setBounds(voteOfficeTextFieldLocation.x, voteOfficeTextFieldLocation.y, voteOfficeTextFieldSize.width, voteOfficeTextFieldSize.height);
  }

  public void cleanVoteTextFields() {
    ArrayList<VoteTextField> voteTextFields = this.getComponentsByType(voteTypes.voteTexts);
    for (VoteTextField voteTextField : voteTextFields) {
      voteTextField.setVisible(false);
    }
  }

  public void restoreVoteTextFields() {
    ArrayList<VoteTextField> voteTextFields = this.getComponentsByType(voteTypes.voteTexts);
    for (VoteTextField voteTextField : voteTextFields) {
      voteTextField.setVisible(true);
    }
  }
}
