package fr.vadimsoude.mentalcounting.view;

import static fr.vadimsoude.mentalcounting.R.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import fr.vadimsoude.mentalcounting.database.ScoreboardBaseHelper;
import fr.vadimsoude.mentalcounting.database.ScoreboardDao;
import fr.vadimsoude.mentalcounting.entity.Score;
import fr.vadimsoude.mentalcounting.service.ScoreboardService;

public class LoseScreen extends Activity {
    private TextView Score;
    private int userScore;
    private ScoreboardService scoreboardService = new ScoreboardService(new ScoreboardDao(new ScoreboardBaseHelper(this)));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_lose_screen);
        ScoreFromIntent();
        Score = findViewById(id.Score);
        Button Save = findViewById(id.Save);
        Save.setOnClickListener(view -> Valider());
    }

    public void ScoreFromIntent() {
        userScore = getIntent().getIntExtra("Score",0);
        //Score.setText("Score :" + userScore);
    }

    public void Valider() {
        TextInputEditText textInputLayout = findViewById(id.TextInputName);
        String text = textInputLayout.getText().toString().trim();
        fr.vadimsoude.mentalcounting.entity.Score score = new Score();
        score.setName(text);
        score.setScore(userScore);
        scoreboardService.storeScoreInDb(score);

        finish();

    }


}
