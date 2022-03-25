package fr.vadimsoude.mentalcounting.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import static fr.vadimsoude.mentalcounting.R.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import fr.vadimsoude.mentalcounting.database.ScoreboardBaseHelper;
import fr.vadimsoude.mentalcounting.database.ScoreboardDao;
import fr.vadimsoude.mentalcounting.entity.Score;
import fr.vadimsoude.mentalcounting.service.ScoreboardService;


public class Scoreboard extends AppCompatActivity {
    List<Score> ListScore;
    ArrayList<TextView> TextViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_scoreboard);

        for (int i = 0; i < 10; i++) {
            String id = "TextView" + i;
            TextView textView = findViewById(getResources().getIdentifier(id, "id", getPackageName()));
            TextViews.add(textView);
        }

        ScoreboardService Score = new ScoreboardService(new ScoreboardDao(new ScoreboardBaseHelper(this)));
        ListScore = Score.getScore();
/*
        for(int i = 0; i < TextViews.size(); i++){
            TextViews.get(i).setText(" ");
        }
        int i;
        for (i = 0; i < ListScore.size(); i++) {
            TextViews.get(i).setText(ListScore.get(i).toString());
            if (i == 10) {
                break;
            }
        }
        if (i < 10) {
            for (int j = i; j < 10; j++) {
                TextViews.get(i).setText(" ");
            }
        }

 */
        System.console().printf(String.valueOf(ListScore));
    }
}