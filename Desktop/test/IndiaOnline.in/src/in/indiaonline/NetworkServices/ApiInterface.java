package in.indiaonline.NetworkServices;


import java.util.List;

import in.indiaonline.Model.AddressRequest;
import in.indiaonline.Model.AddressResult;
import in.indiaonline.Model.BusinessInfoResult;
import in.indiaonline.Model.CategoryInfo;
import in.indiaonline.Model.CityClass;
import in.indiaonline.Model.CompanyDataResult;
import in.indiaonline.Model.FbDataResult;
import in.indiaonline.Model.GmailLoginResult;
import in.indiaonline.Model.LatestAdDetailResult;
import in.indiaonline.Model.LatestAdsResult;

import in.indiaonline.Model.LocalityData;
import in.indiaonline.Model.OrderResult;
import in.indiaonline.Model.ProfileDataGet;
import in.indiaonline.Model.SocailData;
import in.indiaonline.Model.TransactionData;
import in.indiaonline.latest.AddProfileActivity;
import library.Constant;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {


     String AUTH_KEY ="E5XIJ7,08D,VIeGHhXRjKg==";
     final long userId =  Constant.userId;


            ;

    @GET("account/GmailLogin")
    @Headers({
            "Content-Type: application/json",
            "atoken: " + AUTH_KEY
    })
    Call<GmailLoginResult> GmailLogin(@Query("emailid") String emailid,
                                      @Query("name") String name,
                                      @Query("aToken") String aToken,
                                      @Query("googleregistrationid") String googleregistrationid,
                                      @Query("Gmailid") String Gmailid);

    @GET("ads/GetAdsList")
    Call<List<LatestAdsResult>> GetLatestAds(@Query("aToken") String aToken,
                                             @Query("stateid") String stateid,
                                             @Query("cityid") String cityid,
                                             @Query("pageNo") int pageNo,
                                             @Query("pageSize") int pageSize);

    @GET("ads/adsdetailslist")
    Call<LatestAdDetailResult> GetLatestAdsDetails(@Query("atoken") String aToken,
                                                   @Query("AdId") int stateid);

    @GET("Dashboard/GetBusinessProfle?atoken="+ApiInterface.AUTH_KEY)
    Call<List<BusinessInfoResult>> getBusinessData(@Query("Userid")   String userd);

    //get Company data
    @GET("Dashboard/GetUserProfle?atoken="+ApiInterface.AUTH_KEY)
    Call<CompanyDataResult> getCompanyInfo(@Query("UserId")   String UserId,@Query("CompanyId")   String CompanyId);

    @POST("Dashboard/SaveAddressContactDtls?atoken="+ApiInterface.AUTH_KEY)
    @Headers("Content-Type: application/json")
    Call<AddressResult> updateAddress(@Body  AddressRequest addressrequest);

    //Update Logo
    @Multipart
    @POST("Dashboard/UploadLogo?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> updateLogo(@Query("UserId") String user_id,
                                         @Query("companyid") String companyid,
                                         @Part MultipartBody.Part logo);

    //Remove Logo

    @POST("Dashboard/RemoveLogo?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> RemoveLogo(@Query("companyid") int companyid,
                                   @Query("logoimagename") String logoimagename);

    //Update Profile
    @Multipart
    @POST("Dashboard/UploadProfileCover?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> UploadProfile(@Query("companyid") String companyid,
                                    /*  @Part MultipartBody.Part[] images0);*/
                                   @Part MultipartBody.Part logo);


    @GET("Dashboard/Category?atoken="+ApiInterface.AUTH_KEY)
    Call<List<CategoryInfo>> GetCategoryInfo(@Query("SearchTerm")   String SearchTerm);


    //add update Category

    @POST("Dashboard/addcategory?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> AddCategory(@Query("UserId") String user_id,
                                    @Query("companyid") int companyid,
                                   @Query("categoryIds") String categoryIds);


    //Add Info
    @POST("Dashboard/saveaddinfo?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> AddAdditionaInfo(@Query("UserId") String user_id,
                                    @Query("companyid") int companyid,
                                    @Query("profileDesc") String profileDesc,
                                    @Query("companyWebsite") String companyWebsite,
                                    @Query("yearOfEstablishment") String yearOfEstablishment);


    //Add soical Medai Info
    @POST("Dashboard/SaveSocialLink?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> AddSocaildata(@Query("companyid") int companyid,
                                    @Query("SocialLinksData") String SocialLinksData);

    //Add Company Conatct
    @POST("Dashboard/SaveCompanyContactForm?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> SaveCompanyContactForm(
                                         @Query("companyid") int companyid,
                                         @Query("formHeading") String formHeading,
                                         @Query("desc") String desc,
                                         @Query("btntxt") String btntxt);

    //Add Company Conatct
    @POST("Dashboard/SaveAppointmentRequest?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> SaveAppointmentRequest(@Query("UserId") String UserId,
            @Query("companyid") int companyid,
            @Query("Formheading") String formHeading,
            @Query("ShowOnProfile") String desc
            );

    //Add Phot Gallery
    @POST("Dashboard/SaveProfilePhoto?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> SaveProfilePhoto(
                                    @Query("companyid") int companyid,
                                    @Query("ImageIds") String ImageIds);

    //Add Company Conatct
    @POST("Dashboard/SaveBusinessHour?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> SaveBusinessHour(
            @Query("companyid") int companyid,
            @Query("noteText") String noteText,
            @Query("ShowBusinessHoure") String ShowBusinessHoure,
            @Query("is24x7service") String is24x7service,
            @Query("businessHoursJson") String businessHoursJson);

    @GET("Dashboard/GetSocialLinkData?atoken="+ApiInterface.AUTH_KEY)
    Call<List<SocailData>> GetSocialLinkData(@Query("CompanyId")   int CompanyId);

    @GET("cj/Getcities")
    Call<CityClass> getCities(@Query("atoken") String atoken, @Query("stateid") String stateid);


    //Add Info
    @POST("Dashboard/LocalityPincodeSuggestions?atoken="+ApiInterface.AUTH_KEY)
    Call<List<LocalityData>> GetLocality(@Query("cityid") String cityid,
                                         @Query("SearchTerm") String SearchTerm,
                                         @Query("Choice") String Choice);

    @Multipart
    @POST("Dashboard/UpdateUserProfile?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> UpdateMyProfile(
                                   @Query("model") String model,
                                   @Part MultipartBody.Part logo);

    @POST("Dashboard/UpdateUserProfile?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> UpdateMyProfile(
            @Query("model") String model);

    @GET("Dashboard/EditUserProfile?atoken="+ApiInterface.AUTH_KEY)
    Call<List<ProfileDataGet>> GetUserProfile(@Query("UserId") String UserId);

    @POST("Dashboard/RemoveProfilemage?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> RemoveProfile(@Query("UserId") int UserId,
                                   @Query("ImageName") String ImageName);


    @POST("Dashboard/deletewebsite?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> DeleteWebsite(@Query("WebsiteId") String WebsiteId,
                                    @Query("UserId") int UserId);

    @POST("Dashboard/deleteprofile?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> DeleteProfile(@Query("companyid") String companyid,
                                      @Query("UserId") int UserId);


    @GET("Dashboard/WebsiteURI?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> EditWebsite(@Query("websiteid") int websiteid,
                                      @Query("UserId") int UserId,
                                    @Query("Type") int Type);

    @GET("Dashboard/CheckMobileNo?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> CheckMobileNoChange(
                                    @Query("UserId") int UserId,
                                    @Query("mobileno") String mobileno);

    @POST("Dashboard/VerifyCode?atoken="+ApiInterface.AUTH_KEY)
    Call<AddressResult> VerifyCodeChnage(
            @Query("UserId") int UserId,
            @Query("mobileno") String mobileno,
            @Query("useremail") String useremail,
            @Query("VerfifyCode") String VerfifyCode,
            @Query("BAcode") String BAcode,
            @Query("name") String name
            );

    @GET("Dashboard/OrderHistory?atoken="+ApiInterface.AUTH_KEY)
    Call<OrderResult> GetOrderHistory(@Query("UserId") int UserId);

    @GET("Dashboard/OrderHistoryFilter?atoken="+ApiInterface.AUTH_KEY)
    Call<OrderResult> GetOrderHistoryFilter(@Query("UserId") int UserId,
                                            @Query("websiteid") long websiteid,
                                            @Query("Status") int Status,
                                            @Query("fromdate") String fromdate,
                                            @Query("todate") String todate


    );


    @GET("Dashboard/TranscationHistory?atoken="+ApiInterface.AUTH_KEY)
    Call<List<TransactionData>> GetTransactionHistory(@Query("UserId") int UserId);

    @GET("Dashboard/CheckFbUser?atoken="+ApiInterface.AUTH_KEY)
    Call<FbDataResult> CheckFbUser(@Query("name") String name,
                                   @Query("FacebookID") String FacebookID,
                                   @Query("EmailID") String EmailID,
                                   @Query("Gender") String Gender,
                                   @Query("FbImageURL") String FbImageURL);
}
