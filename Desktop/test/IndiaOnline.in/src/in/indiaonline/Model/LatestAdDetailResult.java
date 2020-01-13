package in.indiaonline.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LatestAdDetailResult {

    @SerializedName("ResponseData")
    @Expose
    private List<ResponseDatum> responseData = null;

    public List<ResponseDatum> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<ResponseDatum> responseData) {
        this.responseData = responseData;
    }

}


