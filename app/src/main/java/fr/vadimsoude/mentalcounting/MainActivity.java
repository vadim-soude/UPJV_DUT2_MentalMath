package fr.vadimsoude.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private String operationType = "";
    private double number1;
    private double number2;
    private double result;
    private ArrayList<Button> buttons = new ArrayList<>();
    private final int numberOfButton = 10; //number of button with numbers ONLY
    private Button buttonPoint;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonModulo;
    private Button buttonEqual;
    private Button buttonC;
    private Button buttonAC;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        for(int i=0;i<numberOfButton;i++){
            String id = "button"+i;
            Button button = findViewById(getResources().getIdentifier(id, "id", getPackageName()));
            buttons.add(button);
        }
        for(Button button : buttons){
            button.setOnClickListener(this::onClick);
        }

        buttonPoint = findViewById(R.id.buttonPoint);
        buttonPoint.setOnClickListener(this::onClick);

        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this::onClick);

        buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this::onClick);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(this::onClick);

        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(this::onClick);

        buttonModulo = findViewById(R.id.buttonModulo);
        buttonModulo.setOnClickListener(this::onClick);

        buttonEqual = findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(this::onClick);

        buttonC = findViewById(R.id.buttonC);
        buttonC.setOnClickListener(this::onClick);

        buttonAC = findViewById(R.id.buttonAC);
        buttonAC.setOnClickListener(this::onClick);

        buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this::onClick);
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void onClick(View view){

        String contents = textView1.getText().toString();
        String[] content = contents.split("\n");
        String actualResult = content[0];

        switch (view.getId()){
            case R.id.buttonPoint:
                if(!(actualResult.contains(getString(getResources().getIdentifier("point","string",getPackageName()))))){
                    textView1.setText(textView1.getText()+getString(getResources().getIdentifier("point","string",getPackageName())));
                }
                break;
            case R.id.buttonMultiply:
                if(!actualResult.equals("")){
                    if(operationType.equals("")){
                        operationType = "multiply";
                        number2 = Double.parseDouble(actualResult);
                        textView2.setText(actualResult + getString(getResources().getIdentifier("_multiply","string",getPackageName())));
                        textView1.setText(null);
                    }
                }
                break;
            case R.id.buttonDivide:
                if(!actualResult.equals("")) {
                    if (operationType.equals("")) {
                        operationType = "divide";
                        number2 = Double.parseDouble(actualResult);
                        textView2.setText(actualResult + getString(getResources().getIdentifier("_divide", "string", getPackageName())));
                        textView1.setText(null);
                    }
                }
                break;
            case R.id.buttonPlus:
                if(!actualResult.equals("")) {
                    if (operationType.equals("")) {
                        operationType = "plus";
                        number2 = Double.parseDouble(actualResult);
                        textView2.setText(actualResult + getString(getResources().getIdentifier("_plus", "string", getPackageName())));
                        textView1.setText(null);
                    }
                }
                break;
            case R.id.buttonMinus:
                if(!actualResult.equals("")) {
                    if (operationType.equals("")) {
                        operationType = "minus";
                        number2 = Double.parseDouble(actualResult);
                        textView2.setText(actualResult + getString(getResources().getIdentifier("_minus", "string", getPackageName())));
                        textView1.setText(null);
                    }
                }
                break;
            case R.id.buttonModulo:
                if(!actualResult.equals("")) {
                    if (operationType.equals("")) {
                        operationType = "modulo";
                        number2 = Double.parseDouble(actualResult);
                        textView2.setText(actualResult + getString(getResources().getIdentifier("_modulo", "string", getPackageName())));
                        textView1.setText(null);
                    }
                }
                break;
            case R.id.buttonEqual:
                if(!operationType.equals("")){
                    number1 = Double.parseDouble(actualResult);
                    switch (operationType){
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

                    if(result%1 == 0){
                        textView1.setText(String.valueOf((int)result));
                    }else{
                        textView1.setText(String.valueOf(result));
                    }
                }
                break;
            case R.id.buttonC:
                textView1.setText(null);
                break;
            case R.id.buttonAC:
                operationType = "";
                textView1.setText(null);
                textView2.setText(null);
                break;
            case R.id.buttonBack:
                StringBuffer content1 = new StringBuffer(actualResult);
                content1.deleteCharAt(content1.length()-1);
                textView1.setText(content1);
                break;
        }

        for(int i=0;i<numberOfButton;i++){
            if(view.getId() == buttons.get(i).getId()){
                String string = "_"+i;
                String valueOfButton = getString(getResources().getIdentifier(string, "string", getPackageName()));
                textView1.setText(textView1.getText() + valueOfButton);
            }
        }
    }

}