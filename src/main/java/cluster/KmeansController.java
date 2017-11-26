package cluster;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KmeansController {

    @RequestMapping("/kmeans/blog")
    public String kmeans() throws IOException, URISyntaxException {
        // Read files
        URI uri = this.getClass().getResource("/blogdata.txt").toURI();
        List<String> data = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());

        // Generate the data
        WordProcessor WP = new WordProcessor();
        Kmeans kmeans = new Kmeans(WP.generateArticles(data));
        ArrayList<Centroid> clusteredCentroids = kmeans.generate();

        // Generate the display
        KmeansView view = new KmeansView();
        return view.show(clusteredCentroids);
    }
}
