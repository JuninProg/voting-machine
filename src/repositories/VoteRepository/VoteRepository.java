package src.repositories.VoteRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import src.repositories.PartyRepository.Party;
import src.repositories.PartyRepository.PartyRepository;

public class VoteRepository {
  HashMap<String, Vote> votes = new HashMap<String, Vote>();

  public VoteRepository(PartyRepository partyRepository) {
    for (Party party : partyRepository.getParties()) {
      this.votes.put(party.getNumber(), new Vote(party.getNumber()));
    }
    this.votes.put("branco", new Vote("branco"));
    this.votes.put("nulo", new Vote("nulo"));
  }

  public List<Vote> getSortedVotes() {
    List<Vote> votes = new ArrayList<Vote>(this.votes.values());
    Collections.sort(votes, Comparator.comparing(Vote::getCounter));
    Collections.reverse(votes);
    return votes;
  }

  public void addVote(String partyNumber) {
    Vote voteFound = this.votes.get(partyNumber);
    voteFound.counter ++;
    this.votes.put(partyNumber, voteFound);
  }
  
  public Vote getVotesCounterByPartyNumber(String partyNumber) {
    return this.votes.get(partyNumber);
  }
}
