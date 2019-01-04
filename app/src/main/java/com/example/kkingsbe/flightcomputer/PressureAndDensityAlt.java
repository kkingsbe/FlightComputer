package com.example.kkingsbe.flightcomputer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PressureAndDensityAlt extends AppCompatActivity {
    int pressureAlt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure_and_density_alt);

        setTitle("Pressure and Density Altitude");
        EditText altEditText = findViewById(R.id.altEditText);
        EditText altimeterEditText = findViewById(R.id.altimeterEditText);
        final TextView pressureAltTextView = findViewById(R.id.pressureAltTextView);
        EditText airTempEditText = findViewById(R.id.airTempEditText);
        final TextView daText = findViewById(R.id.densityAltitudeTextView);

        altimeterEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    pressureAltTextView.setText(Integer.toString(calculatePressureAltitude()) + "ft");
                    return true;
                }
                return false;
            }
        });

        airTempEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    daText.setText(Integer.toString(calculateDensityAltitude()) + "ft");
                    return true;
                }
                return false;
            }
        });
    }

    private int calculatePressureAltitude(){
        EditText altEditText = findViewById(R.id.altEditText);
        EditText altimeterEditText = findViewById(R.id.altimeterEditText);

        int alt = Integer.parseInt(altEditText.getText().toString());
        double inHg = Double.parseDouble(altimeterEditText.getText().toString());

        double pa = ((29.92 - inHg) * 1000) + alt;

        pressureAlt = (int)Math.round(pa);
        return pressureAlt;
    }

    private int calculateDensityAltitude(){
        EditText airTempEditText = findViewById(R.id.airTempEditText);
        EditText altEditText = findViewById(R.id.altEditText);

        double oat = Double.parseDouble(airTempEditText.getText().toString());
        int alt = Integer.parseInt(altEditText.getText().toString());

        int isaTemp = 15+((alt/1000 * -2));
        double da;
        da = pressureAlt + (120 * (1 + oat - isaTemp));
        return (int)da;
    }

    public void goBack(View v){
        finish();
    }
}
