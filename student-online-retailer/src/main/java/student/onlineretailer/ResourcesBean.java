package student.onlineretailer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile("development")
@ConfigurationProperties(prefix="resources")
public class ResourcesBean {
    private String db;

    @Override
    public String toString() {

        return "Hello from database: " + db;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }
}
