package com.example.austin_calories_per_dollar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variables for the UI
    EditText calories_input;
    EditText num_servings_input;
    EditText price_input;
    EditText calories_per_dollar_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up the UI variables
        calories_input = findViewById(R.id.calories_input);
        num_servings_input = findViewById(R.id.numServings_input);
        price_input = findViewById(R.id.price_input);
        calories_per_dollar_output = findViewById(R.id.caloriesPerDollar_box);

        double calories_per_dollar = calculatePricePerDollar();
        calories_per_dollar_output.setText(String.format("%.1f", calories_per_dollar));

    }

    public double calculatePricePerDollar() {

        if (calories_input.getText().length() == 0 ||
        num_servings_input.getText().length() == 0 ||
        price_input.getText().length() == 0) {
            return 0;
        }

        double price = Double.parseDouble(price_input.getText().toString());
        if (price < 0.0005) { // double comparison with an epsilon
            return 0;
        }

        int calories = Integer.parseInt(calories_input.getText().toString());
        double num_servings = Double.parseDouble(num_servings_input.getText().toString());

        double total_calories = calories * num_servings;
        double calories_per_dollar = total_calories / price;

        //Toast.makeText(this, "Price: " + price, Toast.LENGTH_LONG).show();

        return calories_per_dollar;
    }
}
