package src.views.FloatingView;

import java.awt.*;
import java.util.ArrayList;

import src.repository.PartyRepository.Party;

public class FloatingView {
  ArrayList<FloatingTextField> components = new ArrayList<FloatingTextField>();

  public enum floatingTypes {
    voteTitle,
    parttyOffice,
    blankVote,
    nullVote
  }

  public ArrayList<FloatingTextField> getComponentsByType(floatingTypes type) {
    ArrayList<FloatingTextField> filteredComponents = new ArrayList<FloatingTextField>(this.components);
    filteredComponents.removeIf(comp -> (comp.getType() != type.toString()));
    return filteredComponents;
  }

  public ArrayList<FloatingTextField> getComponents(){
    return this.components;
  }

  public FloatingView(Integer FRAME_WIDTH, Integer FRAME_HEIGHT){
    // Dimension voteTitleTextFieldDimension = new Dimension(50, 80);
    Font voteTitleTextFieldFont = new Font("Arial", Font.PLAIN, 18);

    Integer voteTitleTextFieldFixedPosX = 4;
    Integer voteTitleTextFieldFixedPosY = 20;

    FloatingTextField voteTitleTextField = new FloatingTextField("SEU VOTO PARA");
    voteTitleTextField.setType(floatingTypes.voteTitle.toString());
    voteTitleTextField.setFont(voteTitleTextFieldFont);
    Dimension voteTitleTextFieldDimension = voteTitleTextField.getPreferredSize();
    voteTitleTextField.setBounds(voteTitleTextFieldFixedPosX, voteTitleTextFieldFixedPosY, voteTitleTextFieldDimension.width, voteTitleTextFieldDimension.height);
    voteTitleTextField.setEditable(false);
    voteTitleTextField.setVisible(false);
    this.components.add(voteTitleTextField);

    // partyOffice

    Font partyOfficeTextFieldFont = new Font("Arial", Font.PLAIN, 18);

    Integer partyOfficeTextFieldFixedPosX = 4;
    Integer partyOfficeTextFieldFixedPosY = 340;

    FloatingTextField partyOfficeTextField = new FloatingTextField("");
    partyOfficeTextField.setType(floatingTypes.parttyOffice.toString());
    partyOfficeTextField.setFont(partyOfficeTextFieldFont);
    Dimension partyOfficeTextFieldDimension = partyOfficeTextField.getPreferredSize();
    partyOfficeTextField.setBounds(partyOfficeTextFieldFixedPosX, partyOfficeTextFieldFixedPosY, partyOfficeTextFieldDimension.width, partyOfficeTextFieldDimension.height);
    partyOfficeTextField.setEditable(false);
    partyOfficeTextField.setVisible(false);
    this.components.add(partyOfficeTextField);

    // blankVote

    Font blankVoteTextFieldFont = new Font("Arial", Font.PLAIN, 34);

    Integer blankVoteTextFieldFixedPosX = 60;
    Integer blankVoteTextFieldFixedPosY = 230;

    FloatingTextField blankVoteTextField = new FloatingTextField("VOTO EM BRANCO");
    blankVoteTextField.setType(floatingTypes.blankVote.toString());
    blankVoteTextField.setFont(blankVoteTextFieldFont);
    Dimension blankVoteTextFieldDimension = blankVoteTextField.getPreferredSize();
    blankVoteTextField.setBounds(blankVoteTextFieldFixedPosX, blankVoteTextFieldFixedPosY, blankVoteTextFieldDimension.width, blankVoteTextFieldDimension.height);
    blankVoteTextField.setEditable(false);
    blankVoteTextField.setVisible(false);
    this.components.add(blankVoteTextField);


    // nullVote

    Font nullVoteTextFieldFont = new Font("Arial", Font.PLAIN, 34);

    Integer nullVoteTextFieldFixedPosX = 90;
    Integer nullVoteTextFieldFixedPosY = 330;

    FloatingTextField nullVoteTextField = new FloatingTextField("VOTO NULO");
    nullVoteTextField.setType(floatingTypes.nullVote.toString());
    nullVoteTextField.setFont(nullVoteTextFieldFont);
    Dimension nullVoteTextFieldDimension = nullVoteTextField.getPreferredSize();
    nullVoteTextField.setBounds(nullVoteTextFieldFixedPosX, nullVoteTextFieldFixedPosY, nullVoteTextFieldDimension.width, nullVoteTextFieldDimension.height);
    nullVoteTextField.setEditable(false);
    nullVoteTextField.setVisible(false);
    this.components.add(nullVoteTextField);
  }

  public void buildPartyFoundView(Party party){
    FloatingTextField voteTitleTextField = this.getComponentsByType(floatingTypes.voteTitle).get(0);
    voteTitleTextField.setVisible(true);
    FloatingTextField nullVoteTextField = this.getComponentsByType(floatingTypes.nullVote).get(0);
    nullVoteTextField.setVisible(false);

    FloatingTextField partyOfficeTextField = this.getComponentsByType(floatingTypes.parttyOffice).get(0);
    partyOfficeTextField.setText("Partido:   " + party.getInitials());
    Point partyOfficeTextFieldLocation = partyOfficeTextField.getLocation();
    Dimension partyOfficeTextFieldSize =  partyOfficeTextField.getPreferredSize();
    partyOfficeTextField.setBounds(partyOfficeTextFieldLocation.x, partyOfficeTextFieldLocation.y, partyOfficeTextFieldSize.width, partyOfficeTextFieldSize.height);
    partyOfficeTextField.setVisible(true);
  }

  public void buildBlankVoteView() {
    FloatingTextField voteTitleTextField = this.getComponentsByType(floatingTypes.voteTitle).get(0);
    voteTitleTextField.setVisible(true);
    FloatingTextField blankVoteTextField = this.getComponentsByType(floatingTypes.blankVote).get(0);
    blankVoteTextField.setVisible(true);
  }

  public void buildNullVoteView() {
    FloatingTextField voteTitleTextField = this.getComponentsByType(floatingTypes.voteTitle).get(0);
    voteTitleTextField.setVisible(true);
    FloatingTextField nullVoteTextField = this.getComponentsByType(floatingTypes.nullVote).get(0);
    nullVoteTextField.setVisible(true);
    FloatingTextField partyOfficeTextField = this.getComponentsByType(floatingTypes.parttyOffice).get(0);
    partyOfficeTextField.setVisible(false);
  }

  public void cleanView(){
    for (FloatingTextField floatingTextField : this.getComponents()) {
      floatingTextField.setVisible(false);
    }
  }
}
