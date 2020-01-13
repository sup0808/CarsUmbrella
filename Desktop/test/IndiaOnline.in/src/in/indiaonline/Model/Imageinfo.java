package in.indiaonline.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Imageinfo {

    @SerializedName("AdID")
    @Expose
    private Integer adID;
    @SerializedName("ImageID")
    @Expose
    private Integer imageID;
    @SerializedName("ImageName")
    @Expose
    private String imageName;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;

    public Integer getAdID() {
        return adID;
    }

    public void setAdID(Integer adID) {
        this.adID = adID;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}