package cluster;

class Word {
    private String word;
    private double count;

    Word(String word, double count) {
        this.word = word;
        this.count = count;
    }

    String getWord() {
        return word;
    }

    double getCount() {
        return count;
    }

    void setCount(double value) {
        count = value;
    }
}
