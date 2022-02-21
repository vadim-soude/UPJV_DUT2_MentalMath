package fr.vadimsoude.mentalcounting.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import fr.vadimsoude.mentalcounting.R;

public class historic extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        textView = findViewById(R.id.textView3);
        textView.setText(getIntent().getStringExtra("test"));
    }
}