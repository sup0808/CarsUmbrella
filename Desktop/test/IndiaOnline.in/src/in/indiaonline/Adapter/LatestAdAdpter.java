package in.indiaonline.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


import in.indiaonline.Model.LatestAdsResult;
import in.indiaonline.news.Ads;
import in.indiaonline.news.LatestAdsDeatils;
import in.indiaonline.news.R;

public class LatestAdAdpter extends RecyclerView.Adapter<LatestAdAdpter.ViewHolderAD> {

    List<LatestAdsResult> latestAdsResultsList = new ArrayList<>();
    Context context;

    String roboto_font_path="fonts/RobotoCondensed-Regular.ttf";

    public LatestAdAdpter(List<LatestAdsResult> latestAdsResultsList, Context context) {
        this.latestAdsResultsList = latestAdsResultsList;
        this.context = context;

        System.out.println("LatestAdAdpter ::");
    }

    @NonNull
    @Override
    public ViewHolderAD onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_ads_adapter_main, parent, false);
        return new ViewHolderAD(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAD viewHolderAds, final int postion) {
        viewHolderAds.titles_ads.setText(latestAdsResultsList.get(postion).getAdTitle());
        //sessions.FontChange(titles_ads, 0, titlelist.get(0), false);


        ImageView image_ = viewHolderAds.image_ads;
        //DisplayImage function from ImageLoader Class
        String imagedata = latestAdsResultsList.get(postion).getImage();

        String cityName = latestAdsResultsList.get(postion).getCityName()==null? "" :latestAdsResultsList.get(postion).getCityName();
        String stateName = latestAdsResultsList.get(postion).getStateName()==null? "" :latestAdsResultsList.get(postion).getStateName();
        String locationData = cityName
                +","+stateName;

        System.out.println("State ::"+stateName +"::: "+cityName +":::: "+ locationData);
        viewHolderAds.location.setText(locationData);

        viewHolderAds.mobileno.setText(latestAdsResultsList.get(postion).getMobileNo());

        Picasso.with(context).load(imagedata).error(R.drawable.inlogo).placeholder(R.drawable.inlogo)
                .into(image_);

        viewHolderAds.ads_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LatestAdsDeatils.class);
                intent.putExtra("ADId",latestAdsResultsList.get(postion).getAdID());
                context.startActivity(intent);
            }
        });

        viewHolderAds.Post_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Ads.class);
                intent.putExtra("ADId",latestAdsResultsList.get(postion).getAdID());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return latestAdsResultsList.size();
    }

    public class ViewHolderAD extends RecyclerView.ViewHolder {
        Typeface roboto_font ;
        LinearLayout ads_layout;
        TextView titles_ads;
        ImageView image_ads;
        TextView video_txt,location,mobileno,Post_ad;


        public ViewHolderAD(@NonNull View itemView) {
            super(itemView);

            roboto_font = Typeface.createFromAsset(context.getAssets(), roboto_font_path);
            ads_layout = (LinearLayout)itemView.findViewById(R.id.ads_layout);
            titles_ads = (TextView) itemView.findViewById(R.id.titles_ads);

            titles_ads.setTypeface(roboto_font);
            image_ads = (ImageView)itemView. findViewById(R.id.image_ads);
            //    video_txt = (TextView)itemView. findViewById(R.id.video_txt);

            location = (TextView) itemView.findViewById(R.id.location);
            mobileno = (TextView) itemView.findViewById(R.id.mobileno);
            Post_ad = (TextView) itemView.findViewById(R.id.Post_ad);
        }
    }
}
