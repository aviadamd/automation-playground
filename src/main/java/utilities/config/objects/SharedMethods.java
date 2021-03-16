package utilities.config.objects;

import extensions.UiActions;
import extensions.Verfications;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import utilities.BaseOperations;

@Configuration
@EnableAspectJAutoProxy
@ContextConfiguration(classes = {
        UiActions.class,
        Verfications.class
})
//@ComponentScan("src.main.java.demo.ClassFather")
public class SharedMethods extends BaseOperations {
    @Bean public UiActions uiActions() { return new UiActions(); }
    @Bean public Verfications verfications() { return new Verfications(); }
}
