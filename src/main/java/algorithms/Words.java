package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        if (!isLoweCase(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        if (!isOneWord(word)) {
            throw new IllegalArgumentException("It should be one word!");
        }
        words.add(word);

    }

    private boolean isLoweCase(String word) {
        for (Character ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOneWord(String word) {
        for (Character ch : word.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                return false;
            }
        }
        return true;
    }

    public boolean isThereAWordTwice() {
        for (String w : words) {
            //System.out.println(w);
            if (isWordTwice(w)) {
                //System.out.println(isWordTwice(w));
                return true;
            }
        }
        return false;
    }

    private boolean isWordTwice(String word) {
        int counter = 0;
        for (String w : words) {
            if (w.equals(words)) {
                counter++;
                if (counter > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
