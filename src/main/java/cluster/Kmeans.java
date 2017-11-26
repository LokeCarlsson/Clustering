package cluster;

import java.util.ArrayList;

class Kmeans {
    private ArrayList<Centroid> centroids;
    private ArrayList<Article> articles;
    private Pearson pearson;

    Kmeans(ArrayList<Article> articles) {
        this.articles = articles;
        pearson = new Pearson();
    }

    ArrayList<Centroid> generate() {
        centroids = new ArrayList<>();
        RNG rng = new RNG(articles);
        for (int i = 0; i < 10; i++) {
            centroids.add(rng.generate());
        }
        boolean done = false;
        while (!done) {
            iterate();
            for (Centroid centroid : centroids) {
                centroid.reCalc();
            }
            done = true;
            for (Centroid centroid : centroids) {
                if (!centroid.matchOnPrevAssign()) {
                    done = false;
                }
            }
        }
        return centroids;
    }

    private void iterate() {
        for (Centroid c : centroids) {
            c.savePrev();
        }
        for (Article article : articles) {
            double closest = Double.MAX_VALUE;
            Centroid centroid = null;
            for (Centroid c : centroids) {
                double score = pearson.calc(article, c.article);
                if (score < closest) {
                    closest = score;
                    centroid = c;
                }
            }
            if (centroid != null) {
                centroid.addArticle(article);
            }
        }
    }
}
