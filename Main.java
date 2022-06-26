import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.event.*;

import src.views.FloatingView.FloatingTextField;
import src.views.FloatingView.FloatingView;
import src.views.VoteView.VoteTextField;
import src.views.VoteView.VoteView;
import src.repositories.PartyRepository.Party;
import src.repositories.PartyRepository.PartyRepository;
import src.repositories.VoteRepository.Vote;
import src.repositories.VoteRepository.VoteRepository;
import src.views.ButtonView;
import src.views.CopyrightView;

class Main {
  public static void main(String[] args) {
    Integer FRAME_WIDTH = 800;
    Integer FRAME_HEIGHT = 600;

    JFrame frame = new JFrame("Urna Eletrônica");

    JPanel panel = new JPanel();

    PartyRepository partyRepository = new PartyRepository();
    VoteRepository voteRepository = new VoteRepository(partyRepository);

    ButtonView buttonView = new ButtonView(FRAME_WIDTH, FRAME_HEIGHT);
    VoteView voteView = new VoteView(FRAME_WIDTH, FRAME_HEIGHT);
    // TODO: control vote office phases
    voteView.setVoteOffice("Melhor jogo");
    FloatingView floatingView = new FloatingView(FRAME_WIDTH, FRAME_HEIGHT);
    CopyrightView copyrightView = new CopyrightView(FRAME_WIDTH, FRAME_HEIGHT);

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
        case "Opções":
          component.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String initialHtml = "<html><h3>Candidatos: </h3><ul>";
              for (Party party : partyRepository.getParties()) {
                initialHtml += "<li>" + party.getNumber() + " - " + party.getInitials() + " - " + party.getName() + "</li>";
              }
              String endHtml = "</ul></html>";
              String htmlText = initialHtml + endHtml;
              JOptionPane.showMessageDialog(panel, htmlText, "Opções", JOptionPane.PLAIN_MESSAGE);
            }
          });
          break;
        case "Contagem":
          component.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String initialHtml = "<html><h3>Resultado: </h3><ol>";
              for (Vote vote : voteRepository.getSortedVotes()) {
                Party partyFound = partyRepository.findPartyByNumber(vote.getKey());
                if (partyFound != null) {
                  initialHtml += "<li>" + partyFound.getInitials() + " - " + vote.getCounter() + "</li>";
                } else {
                  initialHtml += "<li>" + vote.getKey() + " - " + vote.getCounter() + "</li>";
                }
              }
              String endHtml = "</ol></html>";
              String htmlText = initialHtml + endHtml;
              JOptionPane.showMessageDialog(panel, htmlText, "Contagem", JOptionPane.PLAIN_MESSAGE);
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

    for (JTextField component : copyrightView.getComponents()) {
      panel.add(component);
    }

    // TODO: with all components as ArrayList, concat all in one to add to panel

    panel.setLayout(null);

    frame.add(panel);

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setVisible(true);
  }
}