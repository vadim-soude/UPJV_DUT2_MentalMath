package fr.vadimsoude.mentalcounting.view;

import static fr.vadimsoude.mentalcounting.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fr.vadimsoude.mentalcounting.R;

public class MentalMath extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private ArrayList<Button> buttons = new ArrayList<>();
    private String operationType = "";
    private int question1;
    private int question2;
    private int answer;
    private int score = 0;
    private int life = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_metal_math);


        textView1 = findViewById(id.textView);
        textView2 = findViewById(id.textView2);
        textView3 = findViewById(id.textView3);

        for (int i = 0; i < 10; i++) {
            String id = "button" + i;
            Button button = findViewById(getResources().getIdentifier(id, "id", getPackageName()));
            buttons.add(button);
        }

        buttons.add(findViewById(id.buttonPoint));
        buttons.add(findViewById(id.buttonMinus));
        buttons.add(findViewById(id.buttonValidate));
        buttons.add(findViewById(id.buttonAC));

        for (Button button : buttons) {
            button.setOnClickListener(this::onClick);
        }

        generateCalc();
        onUpdate();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case id.option1:
                Intent myIntent = new Intent(MentalMath.this, Scoreboard.class);
                MentalMath.this.startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
/*
    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, string.onPauseMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, string.onRestartMessage, Toast.LENGTH_SHORT).show();
    }

 */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, string.onDestroyMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }


    @SuppressLint({"SetTextI18n"})
    public void onClick(View view) {

        String contents = textView1.getText().toString();
        String[] content = contents.split("\n");
        String actualResult = content[0];

        switch (view.getId()) {
            case id.buttonPoint:
                if (!(actualResult.contains(getString(getResources().getIdentifier("point", "string", getPackageName()))))) {
                    textView1.setText(textView1.getText() + getString(getResources().getIdentifier("point", "string", getPackageName())));
                }
                break;
/*
            case id.buttonMultiply:
                if (!actualResult.equals("")) {
                    if (operationType.equals("")) {
                        operationType = "multiply";
                        number2 = Double.parseDouble(actualResult);
                        textView2.setText(actualResult + getString(getResources().getIdentifier("_multiply", "string", getPackageName())));
                        textView1.setText(null);
                    }
                }
                break;
            case id.buttonDivide:
                if (!actualResult.equals("")) {
                    if (operationType.equals("")) {
                        operationType = "divide";
                        number2 = Double.parseDouble(actualResult);
                        textView2.setText(actualResult + getString(getResources().getIdentifier("_divide", "string", getPackageName())));
                        textView1.setText(null);
                    }
                }
                break;
            case id.buttonPlus:
                if (!actualResult.equals("")) {
                    if (operationType.equals("")) {
                        operationType = "plus";
                        number2 = Double.parseDouble(actualResult);
                        textView2.setText(actualResult + getString(getResources().getIdentifier("_plus", "string", getPackageName())));
                        textView1.setText(null);
                    }
                }
                break;
*/
            case id.buttonMinus:
                if (!actualResult.equals("")) {
                    double number = Double.parseDouble(actualResult)*-1;
                    textView1.setText(String.valueOf(number));
                }
                break;
/*
            case id.buttonModulo:
                if (!actualResult.equals("")) {
                    if (operationType.equals("")) {
                        operationType = "modulo";
                        number2 = Double.parseDouble(actualResult);
                        textView2.setText(actualResult + getString(getResources().getIdentifier("_modulo", "string", getPackageName())));
                        textView1.setText(null);
                    }
                }
                break;
 */
            case id.buttonValidate:
                if(verifyCalc(Double.parseDouble(actualResult))){
                    score += 1;
                }else{
                    life-=1;
                }
                onUpdate();
                break;

            case id.buttonAC:
                textView1.setText(null);
                break;
                /*
            case id.buttonBack:
                if (!actualResult.equals("")) {
                    StringBuffer content1 = new StringBuffer(actualResult);
                    content1.deleteCharAt(content1.length() - 1);
                    textView1.setText(content1);
                }
                break;

                 */
        }

        for (int i = 0; i < 10; i++) {
            if (view.getId() == buttons.get(i).getId()) {
                String string = "_" + i;
                String valueOfButton = getString(getResources().getIdentifier(string, "string", getPackageName()));
                textView1.setText(textView1.getText() + valueOfButton);
            }
        }
    }

    public void generateCalc(){
        question1 = (int)(Math.random()*100);
        question2 = (int)(Math.random()*100);
        List<String> types = Arrays.asList("add","sub","mul","div");
        Random rand = new Random();
        operationType = types.get(rand.nextInt(types.size()));
        switch (operationType){
            case "add":
                textView2.setText(question1 + " " + getString(getResources().getIdentifier("_plus", "string", getPackageName())) + " " + question2);
                answer = question1 + question2;
                break;
            case "sub":
                textView2.setText(question1 + " " + getString(getResources().getIdentifier("_minus", "string", getPackageName())) + " " + question2);
                answer = question1 - question2;
                break;
            case "mul":
                textView2.setText(question1 + " " + getString(getResources().getIdentifier("_multiply", "string", getPackageName())) + " " + question2);
                answer = question1 * question2;
                break;
            case "div":
                textView2.setText(question1 + " " + getString(getResources().getIdentifier("_divide", "string", getPackageName())) + " " + question2);
                answer = question1 / question2;
                break;
        }
    }

    public void onUpdate(){
        String userScore = getString(getResources().getIdentifier("SCORE", "string", getPackageName())) + score;
        String userLife = getString(getResources().getIdentifier("LIFE", "string", getPackageName())) + life;
        textView3.setText(userLife + "   " + userScore);
        textView1.setText(null);
        generateCalc();
        if(life == 0){
            onLose();
        }
    }

    public void onLose(){
        Intent intent = new Intent(this, LoseScreen.class);
        intent.putExtra("Score",score);
        startActivity(intent);
        finish();
    }

    public boolean verifyCalc(double userNumber){
        return Math.round(answer) == Math.round(userNumber);
    }
}