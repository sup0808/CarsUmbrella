package in.indiaonline.news;


import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import in.indiaonline.Adapter.PaginationScrollListener;
import in.indiaonline.Adapter.ViewAdsAdpter;
import in.indiaonline.Model.LatestAdsResult;
import in.indiaonline.NetworkServices.ApiClient;
import in.indiaonline.NetworkServices.ApiInterface;
import library.Helper;
import library.JSONParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAds extends AppCompatActivity implements OnClickListener {
	RecyclerView list;
	AdsListAdapter adapter;
    ArrayList<String> titlelist,ListUrl,imagelist,datelist;
    ArrayList<Long> AdIdList = new ArrayList<Long>();
    ArrayList<Long> PaidmeMeberList = new ArrayList<Long>();
    String AdsUrl="http://m.ads.indiaonline.in/";
    int catid=1,state_id=10,city_id=0,gps_sid=10,gps_cid=0;
    String gps_state="Delhi",gps_city="New Delhi";
    GPSTracker gps;
    JSONParser jParser;
    Button adslist,postad,myad ;
    LinearLayout location_dropdown,select_tab;
    SessionManager sessions;
    Boolean isInternetPresent = false,singleResponse=false;
    ConnectionDetector cd;
    Menu mainmenu;
    AlertDialogManager alert = new AlertDialogManager();
    TextView myadbottom;
	    String SearchLoc;
	    AutoCompleteTextView SearchLocation;
		ArrayAdapter<String> autoCompleteAdapter;
		ArrayList<String> SuggestionArray,StateNameArray,CityNameArray,DomainArray;
		ArrayList<Integer> StateIdArray,CityIdArray;
		ImageView delTxt,mic;
		long userid=0;

		GPSTracker gpsTracker;

	int pageNo = 1,pageSize =10;
	TextView viewadbottom;

	ViewAdsAdpter viewAdsAdpter;
	LinearLayoutManager linearLayoutManager;

	private boolean isLoading = false;
	private boolean isLastPage = false;
	// limiting to 5 for this tutorial, since total pages in actual API is very large. Feel free to modify.
	private int TOTAL_PAGES = 0;
	private int currentPage = 1;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setIcon(R.drawable.logo);
		actionBar.setTitle("");
		setContentView(R.layout.activity_view_ads);
		sessions = new SessionManager(ViewAds.this);
		list=(RecyclerView)findViewById(R.id.list);
		postad=(Button)findViewById(R.id.postad);
		myad=(Button)findViewById(R.id.myad);
		adslist=(Button)findViewById(R.id.adslist);
		viewadbottom=(TextView)findViewById(R.id.viewadbottom);

		gpsTracker = new GPSTracker(this);

		postad.setOnClickListener(this);
		adslist.setOnClickListener(this);
		viewadbottom.setOnClickListener(this);
		myad.setOnClickListener(this);
		location_dropdown =(LinearLayout)findViewById(R.id.location_dropdown);
		Bundle jextra = getIntent().getExtras();
		 if (jextra != null) {
			 AdsUrl=jextra.getString("AdsUrl");
		 }
		sessions.CustomTextView(viewadbottom, "moon");
		if(sessions.isLoggedIn()){
	        String user_name=sessions.getUserName();
	        userid=sessions.getUserID();
	        Log.i("user details :",user_name+"User_id :"+userid );
	     }

		if(sessions.isLocation())
        {
        	HashMap<String, String> LocationArray = sessions.locationdetails();
        	String State= LocationArray.get(SessionManager.STATE_NAME);
        	String City= LocationArray.get(SessionManager.CITY_NAME);
        	Log.i("Location data:",""+State+"-"+City);
        	String[] stateData=State.split("-");
        	gps_state=stateData[0];
        	state_id=Integer.parseInt(stateData[1]);
        	String[] cityData=City.split("-");
        	gps_city=cityData[0];
        	city_id=Integer.parseInt(cityData[1]);
        	Log.i("Location data:",""+gps_state+state_id+gps_city+city_id);

			gps =new GPSTracker(ViewAds.this);
        	state_id = 10;
        	city_id = 0;

        }

		viewAdsAdpter=  new ViewAdsAdpter(ViewAds.this);
		linearLayoutManager= new LinearLayoutManager(ViewAds.this);
		list.setLayoutManager(linearLayoutManager);
		list.setAdapter(viewAdsAdpter);

		getLatestAds();

		list.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
			@Override
			protected void loadMoreItems() {
				isLoading = true;
				currentPage += 1;

				getLatestAdsNext();
			}

			@Override
			public int getTotalPageCount() {
				return TOTAL_PAGES;
			}

			@Override
			public boolean isLastPage() {
				return isLastPage;
			}

			@Override
			public boolean isLoading() {
				return isLoading;
			}
		});

		gps = new GPSTracker(ViewAds.this);
		gps.getAddress();


	//	new LongOperation(userid).execute();
	}




	@Override
    protected void onStart() {
       super.onStart();

       EasyTracker.getInstance(this).activityStart(this);
       Helper.pushOpenScreenEvent(this, "User My Ads Page");
    }
		 @Override
		 protected void onStop() {

    super.onStop();
     EasyTracker.getInstance(this).activityStop(this); // Add this method
   }



	public void getLatestAds(){
		try{
			final ProgressDialog dialog = new ProgressDialog(ViewAds.this);
			dialog.setTitle("Loading..");
			dialog.show();
			ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
			Call<List<LatestAdsResult>> call = apiInterface.GetLatestAds("E5XIJ7,08D,VIeGHhXRjKg==",
					String.valueOf(gps_sid),String.valueOf(gps_cid),currentPage,pageSize);

			call.enqueue(new Callback<List<LatestAdsResult>>() {
				@Override
				public void onResponse(Call<List<LatestAdsResult>> call, Response<List<LatestAdsResult>> response) {
					try{
						dialog.dismiss();
						Typeface roboto_font ;

						if(response.isSuccessful()) {
							TOTAL_PAGES = 100;
							viewAdsAdpter.addAll(response.body());

							if (currentPage <= TOTAL_PAGES)
								viewAdsAdpter.addLoadingFooter();
							else isLastPage = true;

						}
					}
					catch(Exception e){
						e.printStackTrace();
						dialog.dismiss();
					}
				}

				@Override
				public void onFailure(Call<List<LatestAdsResult>> call, Throwable t) {
					dialog.dismiss();
				}
			});
		}
		catch(Exception e){
			e.printStackTrace();

		}
	}


	public void getLatestAdsNext(){
		try{
			final ProgressDialog dialog = new ProgressDialog(ViewAds.this);
			dialog.setTitle("Loading..");
			// dialog.show();
			ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
			Call<List<LatestAdsResult>> call = apiInterface.GetLatestAds("E5XIJ7,08D,VIeGHhXRjKg==",
					String.valueOf(gps_sid),String.valueOf(gps_cid),currentPage,pageSize);

			call.enqueue(new Callback<List<LatestAdsResult>>() {
				@Override
				public void onResponse(Call<List<LatestAdsResult>> call, Response<List<LatestAdsResult>> response) {
					try{
						dialog.dismiss();
						Typeface roboto_font ;

						if(response.isSuccessful()) {

							if( response.body().size()>0) {

								viewAdsAdpter.removeLoadingFooter();
								isLoading = false;

								List<LatestAdsResult> results = response.body();
								viewAdsAdpter.addAll(results);

								if (currentPage != TOTAL_PAGES) {
									viewAdsAdpter.addLoadingFooter();
								} else {
									isLastPage = true;
								}
							}
							else{
								isLastPage = true;
								viewAdsAdpter.removeLoadingFooter();
							}


						}
					}
					catch(Exception e){
						e.printStackTrace();
						dialog.dismiss();
					}
				}

				@Override
				public void onFailure(Call<List<LatestAdsResult>> call, Throwable t) {
					dialog.dismiss();
				}
			});
		}
		catch(Exception e){
			e.printStackTrace();

		}
	}


	public void SearchData()
	{

		 delTxt=(ImageView)findViewById(R.id.delTxt);
			mic=(ImageView)findViewById(R.id.mic);
			delTxt.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					SearchLocation.setText("");
					delTxt.setVisibility(View.GONE);
					mic.setVisibility(View.VISIBLE);
				}
			});
			mic.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					promptSpeechInput();
					mic.setVisibility(View.GONE);
				}
			});

			autoCompleteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
	        autoCompleteAdapter.setNotifyOnChange(true);
			SearchLocation=(AutoCompleteTextView)findViewById(R.id.SearchLocation);
			SearchLocation.setThreshold(3);
			SearchLocation.requestFocus();
			SearchLocation.setAdapter(autoCompleteAdapter);

		SearchLocation.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
               int position, long id) {
            	Log.i("onclick array"+position, "-"+SuggestionArray.size());
            	state_id=StateIdArray.get(position);
            	city_id=CityIdArray.get(position);
            	gps_state=StateNameArray.get(position);
            	gps_city=CityNameArray.get(position);
            	sessions.LocationSession(gps_state, gps_city, state_id, city_id);
            	CustomMenu();
            	location_dropdown.setVisibility(View.GONE);

				SearchLocation.setText("");

				location_dropdown.setVisibility(View.GONE);

				gps_sid = Integer.valueOf(state_id);
				gps_cid = Integer.valueOf(city_id);

				detect_loc.setTitle(gps_city);
				currentPage =1;

				viewAdsAdpter=  new ViewAdsAdpter(ViewAds.this);
				//linearLayoutManager= new LinearLayoutManager(ViewAds.this);
				//list.setLayoutManager(linearLayoutManager);
				list.setAdapter(viewAdsAdpter);

				getLatestAds();

            }

       });

	     TextWatcher textChecker = new TextWatcher() {
	        public void afterTextChanged(Editable s) {

	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
	        public void onTextChanged(CharSequence s, int start, int before, int count)
	        {
                if (!s.equals(""))
                {
                	autoCompleteAdapter.clear();
                	delTxt.setVisibility(View.VISIBLE);
                	SearchLoc = s.toString();
                	singleResponse=false;
                	if(!SearchLoc.contains("-")){
                	//	SearchResponse(SearchLoc);

						new AsyncSearch(SearchLoc).execute();
                	}

	           }
                else { SearchLoc = ""; delTxt.setVisibility(View.INVISIBLE); }

	        }
	    };
	    SearchLocation.addTextChangedListener(textChecker);
     }

	 private void promptSpeechInput() {
	        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
	        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,getString(R.string.speech_prompt));
	        try {
	            startActivityForResult(intent, 300);
	        } catch (ActivityNotFoundException a) {
	            Toast.makeText(getApplicationContext(),
	                    getString(R.string.speech_not_supported),
	                    Toast.LENGTH_SHORT).show();
	        }
	    }
	 public  void onActivityResult(int requestCode, int resultCode, Intent intent) {
		 if (requestCode == 300 && resultCode == RESULT_OK ) {
				if (intent != null) {
					ArrayList<String> result = intent.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
					SearchLocation.setText(result.get(0));
					}
				else { }

			}
	    	else
	    	{

	  	      Log.i("result code ","requestCode:"+requestCode+"resultcode :"+resultCode);

	    	}
	 }

	public class AsyncSearch extends AsyncTask<Void,Void,Void>{

		String SearchTerm;
		AsyncSearch(String SearchTerm){
			this.SearchTerm = SearchTerm;
		}

		@Override
		protected Void doInBackground(Void... voids) {

			SearchResponse(SearchTerm);
			return null;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);

			SuggestionArray= new ArrayList<String>();
			StateNameArray= new ArrayList<String>();
			CityNameArray= new ArrayList<String>();
			DomainArray= new ArrayList<String>();
			StateIdArray=new ArrayList<Integer>();
			CityIdArray=new ArrayList<Integer>();

			try
			{
				boolean Status = json.getBoolean("Status");
				if(Status==true)
				{
					JSONArray Cities=json.getJSONArray("Data");
					for (int i = 0; i < Cities.length(); i++) {
						JSONObject ctlist = Cities.getJSONObject(i);
						if(SearchTerm.matches(regexStr))
							sugg= ctlist.getString("Suggestion")+" - "+ ctlist.getString("CityName")+" - "
									+ctlist.getString("StateName");
						else

							sugg= ctlist.getString("Suggestion")+" - "+ ctlist.getString("StateName");

						sugg = ctlist.getString("CityName") + "-"+ctlist.getString("StateName");
						autoCompleteAdapter.add(sugg);
						SuggestionArray.add(sugg);

						// SuggestionArray.add(ctlist.getString("Suggestion"));

						StateNameArray.add(ctlist.getString("StateName"));
						CityNameArray.add(ctlist.getString("CityName"));
						DomainArray.add(ctlist.getString("Domain"));
						StateIdArray.add(ctlist.getInt("StateID"));
						CityIdArray.add(ctlist.getInt("CityID"));
					}



					SearchLocation.requestFocus();
					SearchLocation.setThreshold(1);
					autoCompleteAdapter = new ArrayAdapter<String>(ViewAds.this,
							android.R.layout.simple_dropdown_item_1line,SuggestionArray);
					// autoCompleteAdapter.setNotifyOnChange(true);
					SearchLocation.setAdapter(autoCompleteAdapter);

					Log.i("array size", "-"+SuggestionArray.size());

				/*	if(SuggestionArray.size() ==1){
						System.out.println("Test :: "+sugg);
						state_id = StateIdArray.get(0);
						city_id = CityIdArray.get(0);
						gps_state = StateNameArray.get(0);
						gps_city = CityNameArray.get(0);
						sessions.LocationSession(gps_state, gps_city, state_id, city_id);

						SearchLocation.setText("");

						location_dropdown.setVisibility(View.GONE);

						gps_sid = Integer.valueOf(state_id);
						gps_cid = Integer.valueOf(city_id);

						detect_loc.setTitle(gps_city);
						currentPage =1;

						viewAdsAdpter=  new ViewAdsAdpter(ViewAds.this);
						linearLayoutManager= new LinearLayoutManager(ViewAds.this);
						list.setLayoutManager(linearLayoutManager);
						list.setAdapter(viewAdsAdpter);

						getLatestAds();
					}*/
				}
				else
				{
					final String Message=json.getString("Message");
					autoCompleteAdapter.add(SearchLoc);
				}
			}
			catch (JSONException e) {
				e.printStackTrace();
				Log.i("Catch ",""+e.getMessage());
			}
		}
	}
	JSONObject json;
	String regexStr = "^[0-9]*$";
	String sugg = "";
	MenuItem detect_loc;

	public void SearchResponse(String SearchTerm)
	{

		try {
			SearchTerm= URLEncoder.encode(SearchTerm, "UTF-8");
			Log.i("Encode",SearchTerm);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			Log.i("Encode Ex",e1.getMessage());
		}

		String url="http://app.indiaonline.in/api/other/getlocationbysearch?atoken=E5XIJ7,08D,VIeGHhXRjKg==&q="+SearchTerm;
		String regexStr = "^[0-9]*$";
		String sugg="";
		JSONParser jParser=new JSONParser();
		json = jParser.getJSONFromUrl(url);
      /*  SuggestionArray= new ArrayList<String>();
        StateNameArray= new ArrayList<String>();
        CityNameArray= new ArrayList<String>();
        DomainArray= new ArrayList<String>();
        StateIdArray=new ArrayList<Integer>();
        CityIdArray=new ArrayList<Integer>();

        try
        {
            boolean Status = json.getBoolean("Status");
            if(Status==true)
            {
                JSONArray Cities=json.getJSONArray("Data");
                for (int i = 0; i < Cities.length(); i++) {
                    JSONObject ctlist = Cities.getJSONObject(i);
                    if(SearchTerm.matches(regexStr))
                        sugg= ctlist.getString("Suggestion")+" - "+ ctlist.getString("CityName")+" - "+ctlist.getString("StateName");
                    else  sugg= ctlist.getString("Suggestion")+" - "+ ctlist.getString("StateName");
                    autoCompleteAdapter.add(sugg);
                    SuggestionArray.add(ctlist.getString("Suggestion"));
                    StateNameArray.add(ctlist.getString("StateName"));
                    CityNameArray.add(ctlist.getString("CityName"));
                    DomainArray.add(ctlist.getString("Domain"));
                    StateIdArray.add(ctlist.getInt("StateID"));
                    CityIdArray.add(ctlist.getInt("CityID"));
                }
                Log.i("array size", "-"+SuggestionArray.size());
            }
            else
            {
                final String Message=json.getString("Message");
                //autoCompleteAdapter.add(SearchLoc);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
            Log.i("Catch ",""+e.getMessage());
        }*/
	}


	public void LocationFound()
	 {

		 location_dropdown.setVisibility(View.VISIBLE);
		 SearchData();

	 }
	 public void hidelocation()
	    {
		 location_dropdown.setVisibility(View.GONE);
		 	gps =new GPSTracker(ViewAds.this);
		 //	gps.getAddress();
			new getAddressAsync().execute();
		 	String fulladress=gps.Fulladress();
		        if(fulladress.isEmpty())
		    	{
		    		Toast.makeText(ViewAds.this, "Location Not Detected", Toast.LENGTH_LONG).show();
			        gps_state="Delhi";
			        gps_city="New Delhi";
			        sessions.LocationSession(gps_state, gps_city, 10, 0);
		    	}
		    	else
		    	{
		    		gps_state=gps.getState();
		    		gps_state=gps.getState();
			        gps_city=gps.getCity();
			        state_id=gps.getStateId();
			        city_id=gps.getCityId();
		        	sessions.LocationSession(gps_state, gps_city, state_id, city_id);

		    	}
		        CustomMenu();
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_activity, menu);
		mainmenu = menu;
		 detect_loc = menu.findItem(R.id.detect_loc);
		MenuItem login_item = menu.findItem(R.id.login_item);
		MenuItem action_mybusiness = menu.findItem(R.id.action_mybusiness);

		if (sessions.isLoggedIn()) {
			login_item.setTitle("Logout");
		} else {
			login_item.setTitle("Login");
		}
		MenuItem app_custom = menu.findItem(R.id.ListMenu);
		app_custom.setVisible(false);
		try {
			if (gps_city.contains("City") || gps_city.equals("")) {
				detect_loc.setTitle(gps_state);
			} else {
				detect_loc.setTitle(gps_city);
			}
			if (sessions.isLoggedIn()) {
				login_item.setTitle("Logout");
			} else {
				login_item.setTitle("Login");
			}


			if (sessions.IsCompanyExist() == true) {
				action_mybusiness.setVisible(true);
			}
			else{
				action_mybusiness.setVisible(false);
			}

		} catch (Exception e) {
		}

		return true;
	}

	class getAddressAsync extends AsyncTask<Void,Void,Void>{

		@Override
		protected Void doInBackground(Void... voids) {
			gps.getAddress();

			return null;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
		}
	}




	private void CustomMenu() {

		    if (mainmenu != null) {
		    	MenuItem detect_loc = mainmenu.findItem(R.id.detect_loc);
		       if (detect_loc != null) {
		    	    ActivityCompat.invalidateOptionsMenu(ViewAds.this);
		        }
		    }
	    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();


		if (id == android.R.id.home) {
			onBackPressed();
			return true;
		}

		if (id == R.id.action_settings) {
			Intent i = new Intent(ViewAds.this, SettingsActivity.class);
			startActivity(i);
			return true;
		}
		else if(id==R.id.login_item){

			if(sessions.isLoggedIn())
			{
				//comment by supriya
			//	sessions.callFacebookLogout(MyAds.this);
				sessions.logoutUser();
				finish();

			}
			else
			{
				Intent i = new Intent(ViewAds.this, LoginActivity.class);
				startActivity(i);
			}
		}
		else if(id==R.id.detect_loc){
		       // Toast.makeText(MyAds.this, "Location detection",Toast.LENGTH_LONG).show();
		        return true;

		}
		else if(id==R.id.auto_detect){

			hidelocation();

	        return true;
		}
		else if(id==R.id.manualy_detect){
			LocationFound();
			return true;
		}


		else if(id==R.id.auto_detect2){
			hidelocation();
		    return true;
		}
		else if(id==R.id.manualy_detect2){
			LocationFound();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}




	@Override
	public void onClick(View v) {
		int id=v.getId();
		switch(id)
		{
		case  R.id.postad: Intent i=new Intent(ViewAds.this,Ads.class);
							i.putExtra("AdsUrl", AdsUrl);
							finish();
						  startActivity(i);	
						  overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
						  break;

		case R.id.myad:
            Intent i1=new Intent(ViewAds.this,MyAds.class);
            i1.putExtra("AdsUrl", AdsUrl);
            finish();
            startActivity(i1);
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			break;
		case R.id.adslist:

			break;		  
		}
	}
	
	public void onBackPressed()
	{
		alert.ExitPopup(ViewAds.this);
	}
	
}
