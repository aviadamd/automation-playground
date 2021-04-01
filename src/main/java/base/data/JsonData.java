package base.data;

public class JsonData {

    public int key;
    public String userName;
    public String password;

    public JsonData(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "key=" + key +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
