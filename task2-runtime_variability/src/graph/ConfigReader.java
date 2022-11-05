package graph;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public Properties properties = new Properties();
    public Boolean labeled;
    public Boolean weighted;
    public Boolean directed;
    public Boolean depthFirstSearch;
    public Boolean minimumSpanningTree;

    public ConfigReader() {
        try {
            properties.load(new FileInputStream("task2-runtime_variability/resources/config.properties"));
            labeled = Boolean.parseBoolean(properties.getProperty("labeled"));
            weighted = Boolean.parseBoolean(properties.getProperty("weighted"));
            directed = Boolean.parseBoolean(properties.getProperty("directed"));
            depthFirstSearch = Boolean.parseBoolean(properties.getProperty("depthFirstSearch"));
            minimumSpanningTree = Boolean.parseBoolean(properties.getProperty("minimumSpanningTree"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
