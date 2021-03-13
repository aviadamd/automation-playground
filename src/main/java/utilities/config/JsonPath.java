package utilities.config;

public class JsonPath {

    public int key;
    public String localBin;
    public String androidSdk;
    public String nodeJs;
    public String appPath;

    public JsonPath(String localBin, String androidSdk, String nodeJs, String appPath) {
        this.localBin = localBin;
        this.androidSdk = androidSdk;
        this.nodeJs = nodeJs;
        this.appPath = appPath;
    }

    @Override
    public String toString() {
        return "JsonPath{" +
                "key=" + key +
                ", localBin='" + localBin + '\'' +
                ", androidSdk='" + androidSdk + '\'' +
                ", nodeJs='" + nodeJs + '\'' +
                ", appPath='" + appPath + '\'' +
                '}';
    }
}
