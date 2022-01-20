package fr.vadimsoude.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainMenuStart extends AppCompatActivity {

    private ArrayList<Button> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_start);

        Toast.makeText(this, R.string.onCreateMessage, Toast.LENGTH_SHORT).show();

        buttons.add(findViewById(R.id.buttonCalc));
        buttons.add(findViewById(R.id.buttonCalcHistory));

        for (Button button : buttons) {
            button.setOnClickListener(this::onClick);
        }

    }

    @SuppressLint({"SetTextI18n"})
    public void onClick(View view) {
        Intent myIntent;
        switch (view.getId()) {
            case R.id.buttonCalc:
                myIntent = new Intent(MainMenuStart.this, ClassicCalc.class);
                //myIntent.putExtra("key", result); //Optional parameters
                MainMenuStart.this.startActivity(myIntent);
                break;
            case R.id.buttonCalcHistory:
                myIntent = new Intent(MainMenuStart.this, historic.class);
                //myIntent.putExtra("key", result); //Optional parameters
                MainMenuStart.this.startActivity(myIntent);
                break;
        }
    }
}