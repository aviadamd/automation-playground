package base.data;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class JsonWrapper {
    @SerializedName("dictionary")
    public ArrayList<JsonData> dictionary;
}
