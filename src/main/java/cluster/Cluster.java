package cluster;

class Cluster {
    private Cluster left;
    private Cluster right;
    private Article article;
    private double distance;
    private Cluster parent;

    Cluster(Article article) {
        this.article = article;
    }

    private Cluster() {
    }

    public Article article() {
        return article;
    }

    Cluster merge(Cluster oc, double distance) {
        Cluster p = new Cluster();

        p.left = this;
        this.parent = p;
        p.right = oc;
        oc.parent = p;

        Article nA = new Article("");

        for (int i = 0; i < article.getWords().size(); i++) {
            Word wA = article.getWord(i);
            Word wB = oc.article.getWord(i);
            double nCnt = (wA.getCount() + wB.getCount()) / 2.0;
            nA.addWord(new Word(wA.getWord(), nCnt));
        }

        p.article = nA;
        p.distance = distance;

        return p;
    }

    public String toString() {
        return article.getName();
    }
}
