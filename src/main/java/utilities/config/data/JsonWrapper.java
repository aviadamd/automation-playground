package utilities.config.data;

import com.google.gson.annotations.SerializedName;
import utilities.config.data.JsonData;

import java.util.ArrayList;

public class JsonWrapper {
    @SerializedName("dictionary")
    public ArrayList<JsonData> dictionary;
}
