package cluster;

class Pearson {
    double calc(Article A, Article B) {
        double sumA = 0;
        double sumAsq = 0;
        for (Word word : A.getWords()) {
            sumA += word.getCount();
            sumAsq += Math.pow(word.getCount(), 2);
        }

        double sumB = 0;
        double sumBsq = 0;
        for (Word word : B.getWords()) {
            sumB += word.getCount();
            sumBsq += Math.pow(word.getCount(), 2);
        }

        double pSum = 0;
        int n = Math.min(A.getWords().size(), B.getWords().size());
        for (int i = 0; i < n; i++) {
            pSum += A.getWord(i).getCount() * B.getWord(i).getCount();
        }

        double num = pSum - (sumA * sumB / n);
        double den = Math.sqrt((sumAsq - Math.pow(sumA, 2) / n) * (sumBsq - Math.pow(sumB, 2) / n));

        if (den == 0) return 0;
        return 1.0 - num / den;
    }
}
