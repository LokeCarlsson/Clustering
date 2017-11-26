package cluster;

import java.util.ArrayList;

class KmeansView {
    String show(ArrayList<Centroid> centroids) {
        StringBuilder sb = new StringBuilder();
        for (Centroid c : centroids) {
            sb.append("<h3>").append(c.article.getName()).append("</h3>");
            sb.append("\t<ul>");
            for (Article a : c.cluster) {
                sb.append("\t\t<li>").append(a.getName()).append("</li>");
            }
            sb.append("</ul>");
        }

        return sb.toString();
    }
}
