package fr.vadimsoude.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private ArrayList<Button> buttons = new ArrayList<>();
    private final int numberOfButton = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textView);

        for(int i=0;i<numberOfButton;i++){
            String id = "button"+i;
            Button button = findViewById(getResources().getIdentifier(id, "id", getPackageName()));
            buttons.add(button);
        }

        for(Button button : buttons){
            button.setOnClickListener(this::onClick);
        }
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void onClick(View view){
        for(int i=0;i<numberOfButton;i++){
            if(view.getId() == buttons.get(i).getId()){
                String string = "_"+i;
                String valueOfButton = getString(getResources().getIdentifier(string, "string", getPackageName()));
                result.setText(result.getText() + valueOfButton);
            }
        }
    }

}