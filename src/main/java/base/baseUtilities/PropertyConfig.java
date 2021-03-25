package base.baseUtilities;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyConfig {

    public static Properties prop;
    public String platform;
    public String platformType;
    public String url;
    public String localBin;
    public String androidSdk;
    public String nodeJs;
    public String appPath;

    @SneakyThrows
    public PropertyConfig(String path) {
        prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + path);
        prop.load(ip);
        platform = setProperties("platform");
        platformType = setProperties("platformType");
        url = setProperties("url");
        localBin = setProperties("localBin");
        androidSdk = setProperties("androidSdk");
        nodeJs = setProperties("nodeJs");
        appPath = setProperties("appPath");
        ip.close();
    }

    private static String setProperties(String proName) {
        if (System.getProperty(proName) != null)
            return System.getProperty(proName);
        else return prop.getProperty(proName);
    }

}
