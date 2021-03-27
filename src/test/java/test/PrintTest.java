package test;

import base.baseUtilities.BaseOperations;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class PrintTest extends BaseOperations {

    @Test(description = "test 01 : print test")
    public void printMethod() {
        System.out.println("print form here " + getProperty.platformType);
    }
}
