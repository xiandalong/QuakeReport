package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kelvin on 8/17/2016.
 */
public class EarthQuakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthQuakeAdapter(Context context, ArrayList<Earthquake> earthQuakes) {
        super(context, 0, earthQuakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake earthQuake = getItem(position);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitude = formatter.format(earthQuake.getMagnitude());
        magnitudeView.setText(magnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthQuake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        //set location offset
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        String locationOffset = getLocationOffset(earthQuake.getCity());
        locationOffsetView.setText(locationOffset);

        //set primary location
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        String primaryLocation = getPrimaryLocation(earthQuake.getCity());
        primaryLocationView.setText(primaryLocation);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(earthQuake.getDate());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String getLocationOffset(String location){
        String locationOffset;
        if(location.contains(LOCATION_SEPARATOR)){
             locationOffset = location.split(LOCATION_SEPARATOR)[0]+ LOCATION_SEPARATOR;
        }
        else{
            locationOffset = getContext().getString(R.string.near_the);
        }
        return locationOffset;
    }

    private String getPrimaryLocation(String location){
        String primaryLocation;
        if(location.contains(LOCATION_SEPARATOR)){
            primaryLocation = location.split(LOCATION_SEPARATOR)[1];
        }
        else{
            primaryLocation = location;
        }
        return primaryLocation;
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int)Math.floor(magnitude);

        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId =R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId =R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId =R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId =R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId =R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId =R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId =R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId =R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId =R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId =R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
