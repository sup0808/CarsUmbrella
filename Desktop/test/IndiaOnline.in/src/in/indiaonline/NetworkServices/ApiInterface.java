package in.indiaonline.NetworkServices;



import java.util.List;

import in.indiaonline.Model.GmailLoginResult;
import in.indiaonline.Model.LatestAdDetailResult;
import in.indiaonline.Model.LatestAdsResult;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {


    final String AUTH_KEY ="E5XIJ7,08D,VIeGHhXRjKg==";

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

}
