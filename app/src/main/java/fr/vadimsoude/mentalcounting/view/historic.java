package fr.vadimsoude.mentalcounting.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import fr.vadimsoude.mentalcounting.R;
import fr.vadimsoude.mentalcounting.database.CalculBaseHelper;
import fr.vadimsoude.mentalcounting.database.CalculDao;
import fr.vadimsoude.mentalcounting.service.CalculService;

public class historic extends AppCompatActivity {

    private TextView textView;
    private CalculService calculService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        textView = findViewById(R.id.textView3);
        textView.setText(getIntent().getStringExtra("test"));

        calculService = new CalculService(new CalculDao(new CalculBaseHelper(this)));
        textView.setText("Il y a " + calculService.getCalculNumber() + " calcule dans la bdd");
    }
}