package in.indiaonline.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDatum {

    @SerializedName("AdID")
    @Expose
    private Integer adID;
    @SerializedName("AdTitle")
    @Expose
    private String adTitle;
    @SerializedName("AdCityDomain")
    @Expose
    private Object adCityDomain;
    @SerializedName("AdURL")
    @Expose
    private String adURL;
    @SerializedName("IsRead")
    @Expose
    private Boolean isRead;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("Message")
    @Expose
    private Object message;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("LeadType")
    @Expose
    private Boolean leadType;
    @SerializedName("enqid")
    @Expose
    private Object enqid;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Updateddate")
    @Expose
    private String updateddate;
    @SerializedName("PaidMemberType")
    @Expose
    private Integer paidMemberType;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("StateName")
    @Expose
    private String stateName;
    @SerializedName("CityName")
    @Expose
    private String cityName;
    @SerializedName("CityDomain")
    @Expose
    private String cityDomain;
    @SerializedName("StateDomain")
    @Expose
    private String stateDomain;
    @SerializedName("CityUrl")
    @Expose
    private Object cityUrl;
    @SerializedName("AdUrl")
    @Expose
    private Object adUrl;
    @SerializedName("Price")
    @Expose
    private Object price;
    @SerializedName("KmsDriven")
    @Expose
    private Object kmsDriven;
    @SerializedName("InsuranceValidTill")
    @Expose
    private Object insuranceValidTill;
    @SerializedName("CategoryName")
    @Expose
    private String categoryName;
    @SerializedName("CategoryUrl")
    @Expose
    private String categoryUrl;
    @SerializedName("SubCategoryName")
    @Expose
    private String subCategoryName;
    @SerializedName("SubCategoryUrl")
    @Expose
    private String subCategoryUrl;


    @SerializedName("SortCode")
    @Expose
    private String SortCode;
    @SerializedName("AttributeID")
    @Expose
    private String AttributeID;
    @SerializedName("AttributeName")
    @Expose
    private String AttributeName;
    @SerializedName("AttributeAlias")
    @Expose
    private String AttributeAlias;

    @SerializedName("AttributeValueName")
    @Expose
    private String AttributeValueName;
    @SerializedName("AttributeValue")
    @Expose
    private String AttributeValue;
    @SerializedName("AttributeValueAlias")
    @Expose
    private String AttributeValueAlias;

    @SerializedName("AttributeVerifiedField")
    @Expose
    private Integer AttributeVerifiedField;

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public String getSortCode() {
        return SortCode;
    }

    public void setSortCode(String sortCode) {
        SortCode = sortCode;
    }

    public String getAttributeID() {
        return AttributeID;
    }

    public void setAttributeID(String attributeID) {
        AttributeID = attributeID;
    }

    public String getAttributeName() {
        return AttributeName;
    }

    public void setAttributeName(String attributeName) {
        AttributeName = attributeName;
    }

    public String getAttributeAlias() {
        return AttributeAlias;
    }

    public void setAttributeAlias(String attributeAlias) {
        AttributeAlias = attributeAlias;
    }

    public String getAttributeValueName() {
        return AttributeValueName;
    }

    public void setAttributeValueName(String attributeValueName) {
        AttributeValueName = attributeValueName;
    }

    public String getAttributeValue() {
        return AttributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        AttributeValue = attributeValue;
    }

    public String getAttributeValueAlias() {
        return AttributeValueAlias;
    }

    public void setAttributeValueAlias(String attributeValueAlias) {
        AttributeValueAlias = attributeValueAlias;
    }

    public Integer getAttributeVerifiedField() {
        return AttributeVerifiedField;
    }

    public void setAttributeVerifiedField(Integer attributeVerifiedField) {
        AttributeVerifiedField = attributeVerifiedField;
    }

    public Integer getAdID() {
        return adID;
    }

    public void setAdID(Integer adID) {
        this.adID = adID;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public Object getAdCityDomain() {
        return adCityDomain;
    }

    public void setAdCityDomain(Object adCityDomain) {
        this.adCityDomain = adCityDomain;
    }

    public String getAdURL() {
        return adURL;
    }

    public void setAdURL(String adURL) {
        this.adURL = adURL;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getLeadType() {
        return leadType;
    }

    public void setLeadType(Boolean leadType) {
        this.leadType = leadType;
    }

    public Object getEnqid() {
        return enqid;
    }

    public void setEnqid(Object enqid) {
        this.enqid = enqid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(String updateddate) {
        this.updateddate = updateddate;
    }

    public Integer getPaidMemberType() {
        return paidMemberType;
    }

    public void setPaidMemberType(Integer paidMemberType) {
        this.paidMemberType = paidMemberType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityDomain() {
        return cityDomain;
    }

    public void setCityDomain(String cityDomain) {
        this.cityDomain = cityDomain;
    }

    public String getStateDomain() {
        return stateDomain;
    }

    public void setStateDomain(String stateDomain) {
        this.stateDomain = stateDomain;
    }

    public Object getCityUrl() {
        return cityUrl;
    }

    public void setCityUrl(Object cityUrl) {
        this.cityUrl = cityUrl;
    }

    public Object getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(Object adUrl) {
        this.adUrl = adUrl;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Object getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(Object kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public Object getInsuranceValidTill() {
        return insuranceValidTill;
    }

    public void setInsuranceValidTill(Object insuranceValidTill) {
        this.insuranceValidTill = insuranceValidTill;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryUrl() {
        return subCategoryUrl;
    }

    public void setSubCategoryUrl(String subCategoryUrl) {
        this.subCategoryUrl = subCategoryUrl;
    }

}