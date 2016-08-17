package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by kelvin on 8/17/2016.
 */
public class EarthQuakeAdapter extends ArrayAdapter<Earthquake> {
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

        TextView magView = (TextView)listItemView.findViewById(R.id.mag_view);
        magView.setText("" + earthQuake.getMagnitude());

        TextView locationView = (TextView)listItemView.findViewById(R.id.location_view);
        locationView.setText(earthQuake.getCity());

        TextView dateView = (TextView)listItemView.findViewById(R.id.date_view);
        dateView.setText(earthQuake.getDate());

        return listItemView;
    }
}
