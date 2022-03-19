package main.java.es.pybit;

public class Word {
  private String word;
  private Integer score;

  private Word(String word) {
    super();
    this.word = word;
    this.score = 0;
  }
  
  public static Word of(String str) {
    return new Word(str);
  }

  /**
   * @return the word
   */
  public String getWord() {
    return word;
  }

  /**
   * @param word the word to set
   */
  public void setWord(String word) {
    this.word = word;
  }

  /**
   * @return the score
   */
  public int getScore() {
    return score;
  }

  /**
   * @param score the score to set
   */
  public void setScore(int score) {
    this.score = score;
  }

  
  
}
