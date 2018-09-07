package com.example.nishi.autoscrollviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Example Fragment class that shows an identifier inside a TextView.
 */
public class ColourFragment extends Fragment {

    private int position;
    private int colour;

    private String imagePath="file:///android_asset/images/images_mid/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        colour = args.getInt("colour");
        position = args.getInt("identifier");

        checkSize();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View itemView = inflater.inflate(R.layout.first_frag, container, false);

        ImageView iv_image_slide = (ImageView) itemView.findViewById(R.id.iv_image_slide);

        if (position == 0) {

            String imageFilePath = imagePath+"slide_1.jpg";
            Picasso.with(getActivity()).load(imageFilePath).into(iv_image_slide);

            //iv_image_slide.setImageResource(R.drawable.slide_1);
        } else if (position == 1) {

            String imageFilePath =  imagePath+"slide_2.jpg";
            Picasso.with(getActivity()).load(imageFilePath).into(iv_image_slide);


           // iv_image_slide.setImageResource(R.drawable.slide_2);

        } else if (position == 2) {

            String imageFilePath =  imagePath+"slide_3.jpg";
            Picasso.with(getActivity()).load(imageFilePath).into(iv_image_slide);


            //iv_image_slide.setImageResource(R.drawable.slide_3);
        }

        return itemView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("dummy", true);
    }


    private void checkSize(){
        int density= getResources().getDisplayMetrics().densityDpi;
        switch(density)
        {
            case DisplayMetrics.DENSITY_LOW:
                //Toast.makeText(getActivity(), "LDPI", Toast.LENGTH_SHORT).show();
                imagePath="file:///android_asset/images/images_mid/";
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                //Toast.makeText(getActivity(), "MDPI", Toast.LENGTH_SHORT).show();
                imagePath="file:///android_asset/images/images_mid/";
                break;
            case DisplayMetrics.DENSITY_HIGH:
                //Toast.makeText(getActivity(), "HDPI", Toast.LENGTH_SHORT).show();
                imagePath="file:///android_asset/images/images_mid/";
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                //Toast.makeText(getActivity(), "XHDPI", Toast.LENGTH_SHORT).show();
                imagePath="file:///android_asset/images/images_mid/";
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                //Toast.makeText(getActivity(), "XHDPI", Toast.LENGTH_SHORT).show();
                imagePath="file:///android_asset/images/images_high/";
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                //Toast.makeText(getActivity(), "XHDPI", Toast.LENGTH_SHORT).show();
                imagePath="file:///android_asset/images/images_high/";
                break;
        }
    }
}
