package main.java.es.pybit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordOperationsService {
  private static final Logger log = LogManager.getLogger(WordOperationsService.class);
  private Map<Character, Integer> letterScores = new HashMap<>();
  private boolean isLetterScoresLoaded = false;
  private Word maxScoreWord = Word.of("");

  public Word getMaxScoreWord(List<Word> wordList) {
    for (Word word : wordList) {
      if (getWordScore(word) > maxScoreWord.getScore()) {
        maxScoreWord = word;
      }
    }

    return maxScoreWord;
  }

  private int getWordScore(Word word) {
    char[] chr = word.getWord().toCharArray();
    int score = 0;
    for (char c : chr) {
      try {
        score += letterScores.getOrDefault(Character.toUpperCase(c), 0);
      } catch (Exception e) {
        log.info("Fetching score for {}", Character.toUpperCase(c));
      }

    }
    word.setScore(score);
    return score;
  }

  public boolean loadLetterScores() {
    log.info("Loading letter scores...");
    letterScores.put('E', 1);
    letterScores.put('A', 1);
    letterScores.put('O', 1);
    letterScores.put('I', 1);
    letterScores.put('N', 1);
    letterScores.put('R', 1);
    letterScores.put('T', 1);
    letterScores.put('L', 1);
    letterScores.put('S', 1);
    letterScores.put('U', 1);
    letterScores.put('D', 2);
    letterScores.put('G', 2);
    letterScores.put('B', 3);
    letterScores.put('C', 3);
    letterScores.put('M', 3);
    letterScores.put('P', 3);
    letterScores.put('F', 4);
    letterScores.put('H', 4);
    letterScores.put('V', 4);
    letterScores.put('W', 4);
    letterScores.put('Y', 4);
    letterScores.put('K', 5);
    letterScores.put('J', 8);
    letterScores.put('X', 8);
    letterScores.put('Q', 10);
    letterScores.put('Z', 10);
    log.info("Total letterScores loaded: {}", letterScores.size());
    isLetterScoresLoaded = true;
    return true;
  }

  /**
   * @return the isLetterScoresLoaded
   */
  public boolean isLetterScoresLoaded() {
    return isLetterScoresLoaded;
  }

  /**
   * @param isLetterScoresLoaded the isLetterScoresLoaded to set
   */
  public void setLetterScoresLoaded(boolean isLetterScoresLoaded) {
    this.isLetterScoresLoaded = isLetterScoresLoaded;
  }

}
