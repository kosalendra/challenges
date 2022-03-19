package main.java.es.pybit;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

  private static final Logger log = LogManager.getLogger(Main.class);

  public static void main(String[] args) {
    log.info("Loading dictionary...");
    DictionaryService service = new DictionaryService();
    List<Word> wordList = service.loadDictionary();
    
    WordOperationsService wordOp = new WordOperationsService();
    if (!wordOp.isLetterScoresLoaded()) {
      wordOp.loadLetterScores();
    }
    
    Word bestWord = wordOp.getMaxScoreWord(wordList);
    log.info("Maximum score word is {} with score of {}", bestWord.getWord(), bestWord.getScore());
    log.info("Process complete");
  }

}
