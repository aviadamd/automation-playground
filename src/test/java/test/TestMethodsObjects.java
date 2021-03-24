package test;

import base.baseUtilities.BaseOperations;
import test.accountManagement.AccountManagementShared;

public class TestMethodsObjects extends BaseOperations {

    public AccountManagementShared accountManagementShared() {

        return new AccountManagementShared();
    }
}
