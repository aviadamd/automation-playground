package base.utilities.config.data;

public class JsonData {

    public int key;
    public String platform;
    public String typeFromPlatform;
    public String url;

    public JsonData(String platform, String typeFromPlatform, String url) {
        this.platform = platform;
        this.typeFromPlatform = typeFromPlatform;
        this.url = url;
    }
    
    @Override
    public String toString() {
        return "JsonData{" +
                "key=" + key +
                ", platform='" + platform + '\'' +
                ", typeFromPlatform='" + typeFromPlatform + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
