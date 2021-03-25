package base.baseUtilities;

import lombok.SneakyThrows;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyConfig {

    public String platform;
    public String platformType;
    public String url;
    public String localBin;
    public String androidSdk;
    public String nodeJs;
    public String appPath;
    private static Properties properties;

    @SneakyThrows
    public PropertyConfig(String path) {
        properties = new Properties();
        FileInputStream fileInputStream =
                new FileInputStream(System.getProperty("user.dir") + path);
        properties.load(fileInputStream);

        platform = setProperties("platform");
        platformType = setProperties("platformType");
        url = setProperties("url");
        localBin = setProperties("localBin");
        androidSdk = setProperties("androidSdk");
        nodeJs = setProperties("nodeJs");
        appPath = setProperties("appPath");

        fileInputStream.close();
    }

    private static String setProperties(String proName) {
        if (System.getProperty(proName) != null)
             return System.getProperty(proName);
        else return properties.getProperty(proName);
    }

}
