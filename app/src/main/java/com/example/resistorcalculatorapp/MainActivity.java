package com.example.resistorcalculatorapp;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.AdapterView.OnItemSelectedListener;

//import static com.example.resistorcalculatorapp.R.id.band1;
public class MainActivity extends AppCompatActivity {
    //region Variables
    private Spinner band1, band2, band3, band4;
    TextView resistance;
    private Float resistorValue, tolerance;
    private double band1Value, band2Value, multiplierValue, toleranceValue;

    //spinner variables
    int selectedPositionBand1 = 0;
    int selectedPositionBand2 = 0;
    int selectedPositionBand3 = 0;
    int selectedPositionBand4 = 0;

    // Colours in band 1 and 2
    String[] colourNames = {
            "Black",
            "Brown",
            "Red",
            "Orange",
            "Yellow",
            "Green",
            "Blue",
            "Violet",
            "Gray",
            "White"
    };

    // Colours in multiplier band
    String[] multiplierColourNames ={
            "Black",
            "Brown",
            "Red",
            "Orange",
            "Yellow",
            "Green",
            "Blue",
            "Violet",
            "Gray",
            "White",
            "Gold",
            "Silver"
    };
    // Colours in multiplier band
    String[] toleranceColourNames ={
            "Brown",
            "Red",
            "Green",
            "Blue",
            "Violet",
            "Gray",
            "Gold",
            "Silver",
            "None"
    };
    // Variables for determining colour
    String selectedColourNameBand1 = colourNames[selectedPositionBand1];
    String selectedColourNameBand2 = colourNames[selectedPositionBand2];
    String selectedColourNameBand3 = colourNames[selectedPositionBand3];
    String selectedColourNameBand4 = colourNames[selectedPositionBand4];


    //endregion
    //region OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resistance = findViewById(R.id.resistance);
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
        //region OnClickListener
        band1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle the selection here
                selectedPositionBand1 = position;
                selectedColourNameBand1 = colourNames[position];
                band1Value = GetBandValue(selectedColourNameBand1, "band1");
                ChangeBandColour(selectedColourNameBand1, "band1");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected (optional)
            }
        });
        band2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle the selection here
                selectedPositionBand2 = position;
                selectedColourNameBand2 = colourNames[position];
                band2Value = GetBandValue(selectedColourNameBand2, "band2");
                ChangeBandColour(selectedColourNameBand2, "band2");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected (optional)
            }
        });
        band3.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle the selection here
                selectedPositionBand3 = position;
                selectedColourNameBand3 = multiplierColourNames[position];
                multiplierValue = GetBandValue(selectedColourNameBand3, "multiplier");
                ChangeBandColour(selectedColourNameBand3, "band3");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected (optional)
            }
        });
        band4.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle the selection here
                selectedPositionBand4 = position;
                selectedColourNameBand4 = toleranceColourNames[position];
                toleranceValue = GetBandValue(selectedColourNameBand4, "tolerance");
                ChangeBandColour(selectedColourNameBand4, "band4");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected (optional)
            }
        });
        //endregion

    }
    //endregion
    //region Calculation
    private Double GetBandValue(String colour, String bandType){
        Double bandValue = 0.0;
        if(bandType == "band1" || bandType == "band2")
        {
            switch (colour){
                case "Black":
                    bandValue = 0.0;
                    break;
                case "Brown":
                    bandValue = 1.0;
                    break;
                case "Red":
                    bandValue = 2.0;
                    break;
                case "Orange":
                    bandValue = 3.0;
                    break;
                case "Yellow":
                    bandValue = 4.0;
                    break;
                case "Green":
                    bandValue = 5.0;
                    break;
                case "Blue":
                    bandValue = 6.0;
                    break;
                case "Violet":
                    bandValue = 7.0;
                    break;
                case "Gray":
                    bandValue = 8.0;
                    break;
                case "White":
                    bandValue = 9.0;
                    break;
            }
        }
        else if (bandType == "multiplier") {
            switch (colour){
                case "Black":
                    bandValue = 1.0;
                    break;
                case "Brown":
                    bandValue = 10.0;
                    break;
                case "Red":
                    bandValue = 100.0;
                    break;
                case "Orange":
                    bandValue = 1000.0;
                    break;
                case "Yellow":
                    bandValue = 10000.0;
                    break;
                case "Green":
                    bandValue = 100000.0;
                    break;
                case "Blue":
                    bandValue = 1000000.0;
                    break;
                case "Violet":
                    bandValue = 10000000.0;
                    break;
                case "Gray":
                    bandValue = 100000000.0;
                    break;
                case "White":
                    bandValue = 1000000000.0;
                    break;
                case "Gold":
                    bandValue = 0.1;
                    break;
                case "Silver":
                    bandValue = 0.01;
                    break;
            }
        }
        else if (bandType == "tolerance") {
            switch (colour){
                case "Brown":
                    bandValue = 0.01;
                    break;
                case "Red":
                    bandValue = 0.02;
                    break;
                case "Green":
                    bandValue = 0.005;
                    break;
                case "Blue":
                    bandValue = 0.0025;
                    break;
                case "Violet":
                    bandValue = 0.001;
                    break;
                case "Gray":
                    bandValue = 0.0005;
                    break;
                case "Gold":
                    bandValue = 0.05;
                    break;
                case "Silver":
                    bandValue = 0.1;
                    break;
                case "None":
                    bandValue = 0.2;
                    break;
            }
        }
        return bandValue;

    }
    public void CalculateResistance(View view){
        Double resistanceValue = 0.0;
        resistanceValue = ((band1Value * 10) + band2Value) * multiplierValue;

        resistance.setText("Resistance : " + String.valueOf(resistanceValue) + "Ω ±" + String.valueOf(toleranceValue * 100) + "%");
        //resistance.setText(String.format("Resistance : %.2f%Ω ± %.2f%%", resistanceValue, toleranceValue * 100));
    }
    //endregion
    public void Clear(View view){
        resistance.setText("");
        band1.setSelection(0);
        band2.setSelection(0);
        band3.setSelection(0);
        band4.setSelection(0);
    }
    public void ChangeBandColour(String colour, String band){
        Drawable currentDrawable, newDrawable;
        ImageView currentView;
        // Get current drawable
        if(band == "band1"){
            currentDrawable = getResources().getDrawable(R.drawable.band1);
            currentView = findViewById(R.id.band1Display);
        } else if (band == "band2") {
            currentDrawable = getResources().getDrawable(R.drawable.band2);
            currentView = findViewById(R.id.band2Display);
        } else if (band == "band3") {
            currentDrawable = getResources().getDrawable(R.drawable.band3);
            currentView = findViewById(R.id.band3Display);
        } else {
            currentDrawable = getResources().getDrawable(R.drawable.band4);
            currentView = findViewById(R.id.band4Display);
            currentView.setVisibility(View.VISIBLE);
        }
        // Duplicate drawable
        newDrawable = currentDrawable.mutate();

        // Create new drawable with the desired colour
        switch (colour){
            case "Black":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN));
                break;
            case "Brown":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.rgb(135,62,35), PorterDuff.Mode.SRC_IN));
                break;
            case "Red":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_IN));
                break;
            case "Orange":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.rgb(252, 173, 3), PorterDuff.Mode.SRC_IN));
                break;
            case "Yellow":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN));
                break;
            case "Green":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN));
                break;
            case "Blue":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN));
                break;
            case "Violet":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.rgb(252, 3, 244), PorterDuff.Mode.SRC_IN));
                break;
            case "Gray":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN));
                break;
            case "White":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN));
                break;
            case "Gold":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.rgb(255, 215, 0), PorterDuff.Mode.SRC_IN));
                break;
            case "Silver":
                newDrawable.setColorFilter(new PorterDuffColorFilter(Color.rgb(255, 215, 0), PorterDuff.Mode.SRC_IN));
                break;
            case "None":
                currentView.setVisibility(View.INVISIBLE);
                break;
        }// End of switch
        currentView.setImageDrawable(newDrawable);
    }
}

