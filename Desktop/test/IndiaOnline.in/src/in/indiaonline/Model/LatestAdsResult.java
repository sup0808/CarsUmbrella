package in.indiaonline.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class LatestAdsResult {

    @SerializedName("UserID")
    @Expose
    private Integer userID;
    @SerializedName("AdID")
    @Expose
    private Integer adID;
    @SerializedName("AdTitle")
    @Expose
    private String adTitle;
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
    private String adUrl;
    @SerializedName("Price")
    @Expose
    private String price;
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
    @SerializedName("BrandName")
    @Expose
    private String brandName;
    @SerializedName("BrandUrl")
    @Expose
    private String brandUrl;
    @SerializedName("ModelName")
    @Expose
    private String modelName;
    @SerializedName("ModelUrl")
    @Expose
    private String modelUrl;
    @SerializedName("MobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("UserName")
    @Expose
    private Object userName;
    @SerializedName("EmailID")
    @Expose
    private Object emailID;
    @SerializedName("LocalityName")
    @Expose
    private String localityName;
    @SerializedName("PinCode")
    @Expose
    private Object pinCode;
    @SerializedName("Valid")
    @Expose
    private Object valid;
    @SerializedName("Del")
    @Expose
    private Boolean del;
    @SerializedName("AdType")
    @Expose
    private Object adType;
    @SerializedName("TotalViews")
    @Expose
    private Object totalViews;
    @SerializedName("PostedDate")
    @Expose
    private Object postedDate;
    @SerializedName("DAYDIFF")
    @Expose
    private Integer dAYDIFF;
    @SerializedName("TotalStar")
    @Expose
    private Object totalStar;
    @SerializedName("Rating")
    @Expose
    private Integer rating;
    @SerializedName("SortCode")
    @Expose
    private Object sortCode;
    @SerializedName("SiteVoters")
    @Expose
    private Object siteVoters;
    @SerializedName("BlockReason")
    @Expose
    private Object blockReason;
    @SerializedName("VideoID")
    @Expose
    private Object videoID;
    @SerializedName("ADMobileNo")
    @Expose
    private Object aDMobileNo;
    @SerializedName("IsDisplayMobileNo")
    @Expose
    private Boolean isDisplayMobileNo;
    @SerializedName("IsMobileVerified")
    @Expose
    private Boolean isMobileVerified;
    @SerializedName("IsDraft")
    @Expose
    private Boolean isDraft;
    @SerializedName("IsCompleted")
    @Expose
    private Boolean isCompleted;
    @SerializedName("ExpiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("Attributeinfo")
    @Expose
    private List<Attributeinfo> attributeinfo = null;
    @SerializedName("Imageinfo")
    @Expose
    private List<Imageinfo> imageinfo = null;
    @SerializedName("MainCategoryID")
    @Expose
    private Integer mainCategoryID;
    @SerializedName("SubCategoryID")
    @Expose
    private Integer subCategoryID;
    @SerializedName("BrandID")
    @Expose
    private Integer brandID;
    @SerializedName("ModelID")
    @Expose
    private Integer modelID;
    @SerializedName("StateID")
    @Expose
    private Integer stateID;
    @SerializedName("CityID")
    @Expose
    private Integer cityID;
    @SerializedName("LocalityID")
    @Expose
    private Integer localityID;
    @SerializedName("RequirementMatch")
    @Expose
    private Integer requirementMatch;
    @SerializedName("isCurrentCity")
    @Expose
    private Integer isCurrentCity;
    @SerializedName("isCurrentState")
    @Expose
    private Integer isCurrentState;
    @SerializedName("DateTimeDiff")
    @Expose
    private String dateTimeDiff;
    @SerializedName("IsPassBlock")
    @Expose
    private Integer isPassBlock;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelUrl() {
        return modelUrl;
    }

    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Object getUserName() {
        return userName;
    }

    public void setUserName(Object userName) {
        this.userName = userName;
    }

    public Object getEmailID() {
        return emailID;
    }

    public void setEmailID(Object emailID) {
        this.emailID = emailID;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public Object getPinCode() {
        return pinCode;
    }

    public void setPinCode(Object pinCode) {
        this.pinCode = pinCode;
    }

    public Object getValid() {
        return valid;
    }

    public void setValid(Object valid) {
        this.valid = valid;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Object getAdType() {
        return adType;
    }

    public void setAdType(Object adType) {
        this.adType = adType;
    }

    public Object getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(Object totalViews) {
        this.totalViews = totalViews;
    }

    public Object getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Object postedDate) {
        this.postedDate = postedDate;
    }

    public Integer getDAYDIFF() {
        return dAYDIFF;
    }

    public void setDAYDIFF(Integer dAYDIFF) {
        this.dAYDIFF = dAYDIFF;
    }

    public Object getTotalStar() {
        return totalStar;
    }

    public void setTotalStar(Object totalStar) {
        this.totalStar = totalStar;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Object getSortCode() {
        return sortCode;
    }

    public void setSortCode(Object sortCode) {
        this.sortCode = sortCode;
    }

    public Object getSiteVoters() {
        return siteVoters;
    }

    public void setSiteVoters(Object siteVoters) {
        this.siteVoters = siteVoters;
    }

    public Object getBlockReason() {
        return blockReason;
    }

    public void setBlockReason(Object blockReason) {
        this.blockReason = blockReason;
    }

    public Object getVideoID() {
        return videoID;
    }

    public void setVideoID(Object videoID) {
        this.videoID = videoID;
    }

    public Object getADMobileNo() {
        return aDMobileNo;
    }

    public void setADMobileNo(Object aDMobileNo) {
        this.aDMobileNo = aDMobileNo;
    }

    public Boolean getIsDisplayMobileNo() {
        return isDisplayMobileNo;
    }

    public void setIsDisplayMobileNo(Boolean isDisplayMobileNo) {
        this.isDisplayMobileNo = isDisplayMobileNo;
    }

    public Boolean getIsMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(Boolean isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public Boolean getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(Boolean isDraft) {
        this.isDraft = isDraft;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<Attributeinfo> getAttributeinfo() {
        return attributeinfo;
    }

    public void setAttributeinfo(List<Attributeinfo> attributeinfo) {
        this.attributeinfo = attributeinfo;
    }

    public List<Imageinfo> getImageinfo() {
        return imageinfo;
    }

    public void setImageinfo(List<Imageinfo> imageinfo) {
        this.imageinfo = imageinfo;
    }

    public Integer getMainCategoryID() {
        return mainCategoryID;
    }

    public void setMainCategoryID(Integer mainCategoryID) {
        this.mainCategoryID = mainCategoryID;
    }

    public Integer getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(Integer subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public Integer getModelID() {
        return modelID;
    }

    public void setModelID(Integer modelID) {
        this.modelID = modelID;
    }

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getLocalityID() {
        return localityID;
    }

    public void setLocalityID(Integer localityID) {
        this.localityID = localityID;
    }

    public Integer getRequirementMatch() {
        return requirementMatch;
    }

    public void setRequirementMatch(Integer requirementMatch) {
        this.requirementMatch = requirementMatch;
    }

    public Integer getIsCurrentCity() {
        return isCurrentCity;
    }

    public void setIsCurrentCity(Integer isCurrentCity) {
        this.isCurrentCity = isCurrentCity;
    }

    public Integer getIsCurrentState() {
        return isCurrentState;
    }

    public void setIsCurrentState(Integer isCurrentState) {
        this.isCurrentState = isCurrentState;
    }

    public String getDateTimeDiff() {
        return dateTimeDiff;
    }

    public void setDateTimeDiff(String dateTimeDiff) {
        this.dateTimeDiff = dateTimeDiff;
    }

    public Integer getIsPassBlock() {
        return isPassBlock;
    }

    public void setIsPassBlock(Integer isPassBlock) {
        this.isPassBlock = isPassBlock;
    }

}