package base.utilities.config.objects;

import base.baseUtilities.Base;
import base.utilities.JavaScriptUtil;
import base.utilities.UiActions;
import base.utilities.Verfications;
import base.utilities.config.data.JsonReader;
import base.utilities.config.data.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("base")
public class SharedObjects  {
    @Bean public Properties properties() { return new Properties(); }
    @Bean public UiActions uiActions() { return new UiActions(); }
    @Bean public Verfications verfications() { return new Verfications(); }
    @Bean public JavaScriptUtil jsUtil() { return new JavaScriptUtil(); }
    @Bean public JsonReader jsonReader() { return new JsonReader();}
}
