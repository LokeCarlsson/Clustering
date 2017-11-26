package cluster;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordProcessor {
    private ArrayList<String> words;
    private ArrayList<Article> articles;

    WordProcessor() throws IOException, URISyntaxException {
        words = new ArrayList<>();
        articles = new ArrayList<>();
    }

    ArrayList<Article> generateArticles(List<String> text) {
        words.addAll(Arrays.asList(text.get(0).split("\\s+")));
        for (int i = 1; i < text.size(); i++) {
            String[] arr = text.get(i).split("\\t+");
            Article article = new Article(arr[0]);
            for (int j = 1; j < arr.length; j++) {
                double count = Integer.parseInt(arr[j]);
                Word word = new Word(words.get(j), count);
                article.addWord(word);
            }
            articles.add(article);
        }
        return articles;
    }
}
