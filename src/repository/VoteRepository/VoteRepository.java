package src.repository.VoteRepository;

import java.util.HashMap;

public class VoteRepository {
  HashMap<String, Integer> votes = new HashMap<>();


  public void addVote(String partyNumber) {
    Integer partyVotes = this.votes.get(partyNumber);
    partyVotes = partyVotes != null ? partyVotes : 0;
    this.votes.put(partyNumber, partyVotes + 1);
  }
  
  public Integer getVotesCounterByPartyNumber(String partyNumber) {
    return this.votes.get(partyNumber);
  }
}
