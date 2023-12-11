package gr.aueb.cf.TemperatureConverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView display;
    RadioGroup rdgroup;
    Button convert;


    /**
     * Handles the click event of the "Convert" button.
     *
     * This method is called when the user clicks the "Convert" button. It checks the selected
     * radio button and performs the corresponding temperature conversion.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        input = findViewById(R.id.input);
        display = findViewById(R.id.display);
        rdgroup = findViewById(R.id.rdgroup);
        convert = findViewById(R.id.convert);

        rdgroup.clearCheck();

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the ID of the selected radio button
                int radioid = rdgroup.getCheckedRadioButtonId();

                // Check which radio button is selected
                if (radioid == R.id.rbtn1) {
                    // Celsius to Fahrenheit conversion
                    double get = Double.parseDouble(String.valueOf(input.getText()));
                    double far_to_cel = (get - 32) * 5 / 9;
                    display.setText("The temperature is " + far_to_cel + " degrees Celsius");
                } else if (radioid == R.id.rbtn2) {
                    // Fahrenheit to Celsius conversion
                    double get2 = Double.parseDouble(String.valueOf(input.getText()));
                    double cel_to_far = (9.0 / 5 * get2 + 32);
                    display.setText("The temperature is " + cel_to_far + " degrees Fahrenheit");
                }
            }
        });
    }
}