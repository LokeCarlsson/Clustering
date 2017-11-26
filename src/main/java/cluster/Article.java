package cluster;

import java.util.ArrayList;
import java.util.List;

class Article {
    private String name;
    private ArrayList<Word> words;

    Article(String name) {
        this.words = new ArrayList<>();
        this.name = name;
    }

    void addWord(Word word) {
        words.add(word);
    }

    Word getWord(int index) {
        return words.get(index);
    }

    List<Word> getWords() {
        return words;
    }

    String getName() {
        return name;
    }
}
