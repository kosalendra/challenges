package main.java.es.pybit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DictionaryService {
  private static final Logger log = LogManager.getLogger(DictionaryService.class);
  private static final List<Word> words = new ArrayList<>();

  public List<Word> loadDictionary() {
    log.info("Reading file Dictionary.txt");
    try (BufferedReader br =
        new BufferedReader(new FileReader("externalResources\\dictionary.txt"))) {
      String line = null;
      while ((line = br.readLine()) != null) {
        words.add(Word.of(line));
      }
      log.info("Total words loaded from the dictionary: {}", words.size());
      return words;
    } catch (Exception e) {
      e.printStackTrace();
      log.error("Unable to read the file. Try again");
      return Collections.EMPTY_LIST;
    }
  }

}
