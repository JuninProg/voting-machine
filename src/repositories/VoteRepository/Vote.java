package src.repositories.VoteRepository;

public class Vote {
  public String key;
  public Integer counter;

  public Vote(String key) {
    this.key = key;
    this.counter = 0;
  }

  public Integer getCounter() {
    return this.counter;
  }

  public String getKey() {
    return this.key;
  }
} 

