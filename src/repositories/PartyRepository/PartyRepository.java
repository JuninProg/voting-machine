package src.repositories.PartyRepository;

import java.util.ArrayList;

public class PartyRepository {
  public ArrayList<Party> parties = new ArrayList<Party>();

  public PartyRepository() {
    this.parties.add(new Party("Elden Ring", "666", "ELrg"));
    this.parties.add(new Party("Fifa 22", "10", "FF22"));
    this.parties.add(new Party("League of Legends", "171", "LOL"));
    this.parties.add(new Party("Talisman Online", "100", "TO"));
    this.parties.add(new Party("Counter Strike GO", "05", "CSgo"));
  }

  public ArrayList<Party> getParties() {
    return this.parties;
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
