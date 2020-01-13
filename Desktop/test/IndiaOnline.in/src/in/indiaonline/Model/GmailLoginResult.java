package in.indiaonline.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GmailLoginResult {

    @SerializedName("UserID")
    @Expose
    private Integer userID;
    @SerializedName("EmailID")
    @Expose
    private String emailID;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("MobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("RoleID")
    @Expose
    private Integer roleID;
    @SerializedName("Status")
    @Expose
    private Boolean status;
    @SerializedName("Message")
    @Expose
    private Object message;
    @SerializedName("GmailID")
    @Expose
    private String gmailID;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("AndroidDeviceID")
    @Expose
    private Integer androidDeviceID;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getGmailID() {
        return gmailID;
    }

    public void setGmailID(String gmailID) {
        this.gmailID = gmailID;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getAndroidDeviceID() {
        return androidDeviceID;
    }

    public void setAndroidDeviceID(Integer androidDeviceID) {
        this.androidDeviceID = androidDeviceID;
    }

}