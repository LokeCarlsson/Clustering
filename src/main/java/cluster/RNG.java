package cluster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RNG {
    private List<Article> articles;

    RNG(List<Article> a) {
        articles = new ArrayList<>(a);
    }

    Centroid generate() {
        Random RNG = new Random();
        Article RNGArticle = articles.get(RNG.nextInt(articles.size()));
        articles.remove(RNGArticle);
        return new Centroid(RNGArticle);
    }
}