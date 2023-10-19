package com.example.resistorcalculatorapp;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<String> {
    private ArrayList<Integer> colors;
    private int selectedPosition = -1;
    public SpinnerAdapter(Context context, int resource, ArrayList<String> items, ArrayList<Integer> colors) {
        super(context, resource, items);
        this.colors = colors;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView text = (TextView) view;
        text.setBackgroundColor(colors.get(position));
        if (position == selectedPosition) {
            text.setTextColor(getContext().getResources().getColor(android.R.color.white));
        } else {
            text.setTextColor(isBlackTextOption(position) ?
                    getContext().getResources().getColor(android.R.color.black) :
                    getContext().getResources().getColor(android.R.color.white));
        }
        return view;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView text = (TextView) view;
        text.setBackgroundColor(colors.get(position));
        if (position == selectedPosition) {
            text.setTextColor(getContext().getResources().getColor(android.R.color.white));
        } else {
            text.setTextColor(isBlackTextOption(position) ?
                    getContext().getResources().getColor(android.R.color.black) :
                    getContext().getResources().getColor(android.R.color.white));
        }
        return view;
    }

    private boolean isBlackTextOption(int position) {
        // Add conditions to check if the current position corresponds to "Gray", "White", "Orange", "Green", "Yellow", "Gold", "Silver", "None" options
        String item = getItem(position);
        return "Gray".equals(item) || "White".equals(item) || "Orange".equals(item) || "Green".equals(item) || "Yellow".equals(item) || "Gold".equals(item) || "Silver".equals(item) || "None".equals(item);
    }
}
