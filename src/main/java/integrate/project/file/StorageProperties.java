package integrate.project.file;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "integrate.storage")
public class StorageProperties {
    @Getter
    @Setter
    private String location;
}
