package Pearson;

class Cluster {
    Cluster left;
    Cluster right;
    Article article;
    double distance;

    Cluster merge(Cluster oc, double distance) {
        Cluster p = new Cluster();

        p.left = this;
        this.parent = p;
        p.right = oc;
        oc.parent = p;

        Article nA = new Article("");
        for (int i = 0; i < article.words.size(); i++) {
            Word wA = article.words.get(i);
            Word wB = oc.article.words.get(i);
            double nCnt = (wA.count + wB.count) / 2.0;
            nA.addWord(new Word(wA.word, nCnt));
        }

        p.article = nA;
        p.distance = distance;

        return p;
    }
}
