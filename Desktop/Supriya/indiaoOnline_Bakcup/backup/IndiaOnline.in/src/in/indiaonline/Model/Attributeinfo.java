package in.indiaonline.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributeinfo {

    @SerializedName("AdID")
    @Expose
    private Integer adID;
    @SerializedName("AttributeID")
    @Expose
    private Object attributeID;
    @SerializedName("AttributeName")
    @Expose
    private String attributeName;
    @SerializedName("AttributeAlias")
    @Expose
    private String attributeAlias;
    @SerializedName("AttributeValueName")
    @Expose
    private String attributeValueName;
    @SerializedName("AttributeValue")
    @Expose
    private String attributeValue;
    @SerializedName("AttributeValueAlias")
    @Expose
    private Object attributeValueAlias;
    @SerializedName("AttributeVerifiedField")
    @Expose
    private Integer attributeVerifiedField;

    public Integer getAdID() {
        return adID;
    }

    public void setAdID(Integer adID) {
        this.adID = adID;
    }

    public Object getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(Object attributeID) {
        this.attributeID = attributeID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeAlias() {
        return attributeAlias;
    }

    public void setAttributeAlias(String attributeAlias) {
        this.attributeAlias = attributeAlias;
    }

    public String getAttributeValueName() {
        return attributeValueName;
    }

    public void setAttributeValueName(String attributeValueName) {
        this.attributeValueName = attributeValueName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Object getAttributeValueAlias() {
        return attributeValueAlias;
    }

    public void setAttributeValueAlias(Object attributeValueAlias) {
        this.attributeValueAlias = attributeValueAlias;
    }

    public Integer getAttributeVerifiedField() {
        return attributeVerifiedField;
    }

    public void setAttributeVerifiedField(Integer attributeVerifiedField) {
        this.attributeVerifiedField = attributeVerifiedField;
    }

}