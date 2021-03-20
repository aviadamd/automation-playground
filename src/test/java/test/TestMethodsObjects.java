package test;

import base.utilities.BaseOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import test.grafana.GrafanaShared;

@ContextConfiguration(classes = {GrafanaShared.class})
public class TestMethodsObjects extends BaseOperations {

    @Bean
    public GrafanaShared grafanaShared() { return new GrafanaShared();}

}
