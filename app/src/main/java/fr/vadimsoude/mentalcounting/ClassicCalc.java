package fr.vadimsoude.mentalcounting;

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

public class ClassicCalc extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private ArrayList<Button> buttons = new ArrayList<>();
    private String operationType = "";
    private double number1;
    private double number2;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        textView1 = findViewById(id.textView);
        textView2 = findViewById(id.textView2);

        for (int i = 0; i < 10; i++) {
            String id = "button" + i;
            Button button = findViewById(getResources().getIdentifier(id, "id", getPackageName()));
            buttons.add(button);
        }

        buttons.add(findViewById(id.buttonPoint));
        buttons.add(findViewById(id.buttonMultiply));
        buttons.add(findViewById(id.buttonDivide));
        buttons.add(findViewById(id.buttonPlus));
        buttons.add(findViewById(id.buttonMinus));
        buttons.add(findViewById(id.buttonModulo));
        buttons.add(findViewById(id.buttonEqual));
        buttons.add(findViewById(id.buttonAC));
        buttons.add(findViewById(id.buttonBack));

        for (Button button : buttons) {
            button.setOnClickListener(this::onClick);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case id.option1:
                Intent myIntent = new Intent(ClassicCalc.this, historic.class);
                //myIntent.putExtra("key", result); //Optional parameters
                ClassicCalc.this.startActivity(myIntent);
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

    //Must change everything from here to change the text view content from string to double
    //Easier for operations

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
            case id.buttonMinus:
                if (!actualResult.equals("")) {
                    if (operationType.equals("")) {
                        operationType = "minus";
                        number2 = Double.parseDouble(actualResult);
                        textView2.setText(actualResult + getString(getResources().getIdentifier("_minus", "string", getPackageName())));
                        textView1.setText(null);
                    }
                }
                break;
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
            case id.buttonEqual:
                if (!operationType.equals("")) {
                    number1 = Double.parseDouble(actualResult);
                    switch (operationType) {
                        case "multiply":
                            result = number1 * number2;
                            break;
                        case "plus":
                            result = number1 + number2;
                            break;
                        case "minus":
                            result = number2 - number1;
                            break;
                        case "divide":
                            result = number2 / number1;
                            break;
                        case "modulo":
                            result = number2 % number1;
                            break;
                    }
                    operationType = "";
                    textView2.setText(null);

                    if (result % 1 == 0) {
                        textView1.setText(String.valueOf(Math.round(result)));
                    } else {
                        textView1.setText(String.valueOf(result));
                    }
                }
                break;
            case id.buttonAC:
                operationType = "";
                textView1.setText(null);
                textView2.setText(null);
                break;
            case id.buttonBack:
                if (!actualResult.equals("")) {
                    StringBuffer content1 = new StringBuffer(actualResult);
                    content1.deleteCharAt(content1.length() - 1);
                    textView1.setText(content1);
                }
                break;
        }

        for (int i = 0; i < 10; i++) {
            if (view.getId() == buttons.get(i).getId()) {
                String string = "_" + i;
                String valueOfButton = getString(getResources().getIdentifier(string, "string", getPackageName()));
                textView1.setText(textView1.getText() + valueOfButton);
            }
        }
    }

}