package base.utilities.config.data;

import base.baseUtilities.BaseOperations;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Data
@Configuration
@PropertySources({@PropertySource("classpath:project.properties")})
public class Properties  {
    @Value("${platform}")
    String platform;
    @Value("${typeFromPlatform}")
    String typeFromPlatform;
    @Value("${url}")
    String url;
}
