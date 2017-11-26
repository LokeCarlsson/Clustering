package cluster;

import java.util.ArrayList;

class Centroid {
    private ArrayList<Article> previous;
    ArrayList<Article> cluster;
    Article article;

    Centroid(Article article) {
        cluster = new ArrayList<>();
        previous = new ArrayList<>();
        this.article = article;
    }

    void savePrev() {
        previous = cluster;
        cluster = new ArrayList<>();
    }

    void addArticle(Article a) {
        cluster.add(a);
    }

    boolean matchOnPrevAssign() {
        return previous.containsAll(cluster);
    }

    void reCalc() {
        for (int i = 0; i < article.getWords().size(); i++) {
            double average = 0.0;
            for (Article article : cluster) {
                average += article.getWord(i).getCount();
            }

            average /= (double)cluster.size();
            article.getWord(i).setCount(average);
        }
    }
}
