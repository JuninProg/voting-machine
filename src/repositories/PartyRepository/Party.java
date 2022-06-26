package src.repositories.PartyRepository;

public class Party {
  String name;
  String number;
  String initials;

  public Party(String name, String number, String initials){
    this.name = name;
    this.number = number;
    this.initials = initials;
  }
  
  public String getNumber() {
    return this.number;
  }

  public String getInitials() {
    return this.initials;
  }

  public String getName() {
    return this.name;
  }
}
