package src.repository.PartyRepository;

import java.util.ArrayList;

public class PartyRepository {
  public ArrayList<Party> parties = new ArrayList<Party>();

  public PartyRepository() {
    this.parties.add(new Party("PARTIDO DOS ESPORTES", "91", "PEsp"));
    this.parties.add(new Party("PARTIDO DOS RITMOS MUSICAIS", "92", "PMus"));
    this.parties.add(new Party("PARTIDO DAS PROFISSÕES", "93", "PProf"));
    this.parties.add(new Party("PARTIDO DAS PROFISSÕES", "963", "PProf"));
  }

  public Party findPartyByNumber(String number) {
    for (Party party : this.parties) {
      if (party.getNumber().equals(number)) {
        return party;
      }
    }
    return null;
  }
}
