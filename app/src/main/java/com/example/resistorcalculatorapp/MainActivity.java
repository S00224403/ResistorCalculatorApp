package com.example.resistorcalculatorapp;
import static android.graphics.Color.RGBToHSV;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
//import static com.example.resistorcalculatorapp.R.id.band1;
public class MainActivity extends AppCompatActivity {
    private Spinner band1, band2, band3, band4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        band1 = findViewById(R.id.band1);
        band2 = findViewById(R.id.band2);
        band3 = findViewById(R.id.band3);
        band4 = findViewById(R.id.band4);

        // Sample data and colors
        ArrayList<String> items = new ArrayList<>();
        items.add("Black");
        items.add("Brown");
        items.add("Red");
        items.add("Orange");
        items.add("Yellow");
        items.add("Green");
        items.add("Blue");
        items.add("Violet");
        items.add("Gray");
        items.add("White");

        ArrayList<Integer> colours = new ArrayList<>();
        colours.add(Color.BLACK);
        colours.add(Color.rgb(135,62,35));
        colours.add(Color.RED);
        colours.add(Color.rgb(252, 173, 3));
        colours.add(Color.YELLOW);
        colours.add(Color.GREEN);
        colours.add(Color.BLUE);
        colours.add(Color.rgb(252, 3, 244));
        colours.add(Color.GRAY);
        colours.add(Color.WHITE);

        // Text field for multipliers
        ArrayList<String> multiplier = new ArrayList<>();
        multiplier.add("Black");
        multiplier.add("Brown");
        multiplier.add("Red");
        multiplier.add("Orange");
        multiplier.add("Yellow");
        multiplier.add("Green");
        multiplier.add("Blue");
        multiplier.add("Violet");
        multiplier.add("Gray");
        multiplier.add("White");
        multiplier.add("Gold");
        multiplier.add("Silver");

        // Multiplier colours
        ArrayList<Integer> multiplierColours = new ArrayList<>();
        multiplierColours.add(Color.BLACK);
        multiplierColours.add(Color.rgb(135,62,35));
        multiplierColours.add(Color.RED);
        multiplierColours.add(Color.rgb(252, 173, 3));
        multiplierColours.add(Color.YELLOW);
        multiplierColours.add(Color.GREEN);
        multiplierColours.add(Color.BLUE);
        multiplierColours.add(Color.rgb(252, 3, 244));
        multiplierColours.add(Color.GRAY);
        multiplierColours.add(Color.WHITE);
        multiplierColours.add(Color.rgb(255, 215, 0));//gold
        multiplierColours.add(Color.rgb(192, 192, 192));//silver

        // Text field for tolerance
        ArrayList<String> tolerance = new ArrayList<>();
        tolerance.add("Brown");
        tolerance.add("Red");
        tolerance.add("Green");
        tolerance.add("Blue");
        tolerance.add("Violet");
        tolerance.add("Gray");
        tolerance.add("Gold");
        tolerance.add("Silver");
        tolerance.add("None");

        // Colours for tolerance
        ArrayList<Integer> toleranceColours = new ArrayList<>();

        toleranceColours.add(Color.rgb(135,62,35));//brown
        toleranceColours.add(Color.RED);
        toleranceColours.add(Color.GREEN);
        toleranceColours.add(Color.BLUE);
        toleranceColours.add(Color.rgb(252, 3, 244));//violet
        toleranceColours.add(Color.GRAY);
        toleranceColours.add(Color.rgb(255, 215, 0));//gold
        toleranceColours.add(Color.rgb(192, 192, 192));//silver
        toleranceColours.add(Color.WHITE);

        // Create the custom adapter
        SpinnerAdapter adapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_dropdown_item, items, colours);
        SpinnerAdapter multiplierSpinner = new SpinnerAdapter(this, android.R.layout.simple_spinner_dropdown_item, multiplier, multiplierColours);
        SpinnerAdapter toleranceSpinner = new SpinnerAdapter(this, android.R.layout.simple_spinner_dropdown_item, tolerance, toleranceColours);

        // Set the adapter to the Spinner
        band1.setAdapter(adapter);
        band2.setAdapter(adapter);
        band3.setAdapter(multiplierSpinner);
        band4.setAdapter(toleranceSpinner);
    }

}

