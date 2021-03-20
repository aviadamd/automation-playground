package test;

import base.baseUtilities.BaseOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import test.accountManagement.AccountManagementShared;

@ContextConfiguration(classes = {AccountManagementShared.class})
public class TestMethodsObjects extends BaseOperations {

    @Bean
    public AccountManagementShared accountManagementShared() {
        return new AccountManagementShared();
    }
}
