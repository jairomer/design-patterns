package observer;

import java.util.Map;

public interface Observer {
    void update (Map<String, Double> stocks);
}
