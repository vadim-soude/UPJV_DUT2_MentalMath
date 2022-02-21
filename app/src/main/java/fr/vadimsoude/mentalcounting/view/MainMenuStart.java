package fr.vadimsoude.mentalcounting.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import fr.vadimsoude.mentalcounting.R;

public class MainMenuStart extends AppCompatActivity {

    private ArrayList<Button> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_start);

        Toast.makeText(this, R.string.onCreateMessage, Toast.LENGTH_SHORT).show();

        buttons.add(findViewById(R.id.buttonCalcHistory));
        buttons.add(findViewById(R.id.buttonMentalMath));

        for (Button button : buttons) {
            button.setOnClickListener(this::onClick);
        }

    }

    @SuppressLint({"SetTextI18n"})
    public void onClick(View view) {
        Intent myIntent;
        switch (view.getId()) {
            case R.id.buttonMentalMath:
                myIntent = new Intent(MainMenuStart.this, MentalMath.class);
                //myIntent.putExtra("key", result); //Optional parameters
                MainMenuStart.this.startActivity(myIntent);
                break;
            case R.id.buttonCalcHistory:
                //historique des calcule réalisé dans la calculatrice
                myIntent = new Intent(MainMenuStart.this, historic.class);
                String result = "ça marche";
                myIntent.putExtra("test", result); //Optional parameters
                MainMenuStart.this.startActivity(myIntent);
                break;
        }
    }
}