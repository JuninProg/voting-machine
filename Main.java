import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.event.*;

import src.views.FloatingView.FloatingTextField;
import src.views.FloatingView.FloatingView;
import src.views.VoteView.VoteTextField;
import src.views.VoteView.VoteView;
import src.repository.PartyRepository.Party;
import src.repository.PartyRepository.PartyRepository;
import src.repository.VoteRepository.VoteRepository;
import src.views.ButtonView;

class Main {
  public static void main(String[] args) {
    Integer FRAME_WIDTH = 800;
    Integer FRAME_HEIGHT = 600;

    JFrame frame = new JFrame("Urna Eletrônica");

    JPanel panel = new JPanel();

    PartyRepository partyRepository = new PartyRepository();
    VoteRepository voteRepository = new VoteRepository();

    ButtonView buttonView = new ButtonView(FRAME_WIDTH, FRAME_HEIGHT);
    VoteView voteView = new VoteView(FRAME_WIDTH, FRAME_HEIGHT);
    // TODO: control vote office phases
    voteView.setVoteOffice("Vereador");

    FloatingView floatingView = new FloatingView(FRAME_WIDTH, FRAME_HEIGHT);

    for (JButton component : buttonView.getComponents()) {
      String text = component.getText();

      switch (text) {
        case "0":
        case "1":
        case "2":
        case "3":
        case "4":
        case "5":
        case "6":
        case "7":
        case "8":
        case "9":
          component.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              voteView.addVote(text);
              String partyNumber = voteView.getPartyNumber();
              Party partyFound = partyRepository.findPartyByNumber(partyNumber);
              if (partyFound != null) {
                floatingView.buildPartyFoundView(partyFound);
              } else {
                if (partyNumber.length() > 1) {
                  floatingView.buildNullVoteView();
                }
              }
            }
          });
          break;
        case "Corrige":
          component.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              voteView.cleanVotes();
              floatingView.cleanView();
              voteView.restoreVoteTextFields();
            }
          });
          break;
        case "Confirmar":
          component.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String partyNumber = voteView.getPartyNumber();

              String partyVote = "";
              
              if (partyNumber.length() > 0) {
                Party partyFound = partyRepository.findPartyByNumber(partyNumber);
                
                if (partyFound != null) {
                  partyVote = partyNumber;
                } else {
                  partyVote = "nulo";
                }
              } else {
                partyVote = "branco";
              }

              voteRepository.addVote(partyVote);
              voteView.cleanVotes();
              floatingView.cleanView();

              if (partyVote == "branco") {
                voteView.restoreVoteTextFields();
              }

              System.out.println("Votos: " + partyVote + " - " + voteRepository.getVotesCounterByPartyNumber(partyVote));
            }
          });
          break;
        case "Branco":
          component.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              voteView.cleanVoteTextFields();
              voteView.cleanVotes();
              floatingView.cleanView();
              floatingView.buildBlankVoteView();
            }
          });
          break;
      }

      panel.add(component);
    }

    for (VoteTextField component : voteView.getComponents()) {
      panel.add(component);
    }

    for (FloatingTextField component : floatingView.getComponents()) {
      panel.add(component);
    }


    panel.setLayout(null);

    frame.add(panel);

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setVisible(true);
  }
}