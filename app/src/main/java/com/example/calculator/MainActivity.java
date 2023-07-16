package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final char ADDITION='+';
    public static final char SUBTRACTION='-';
    public static final char MULTIPLICATION='*';
    public static final char MOD='%';
    public static final char DIVISION='/';
    public static final char NEGATIVE='N';
    Button off,c,mod,div,multi,minus,plus,equal,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,dot,negative;
    TextView inputDisplay,outputDisplay;
    char currentSymbol;
    String errMsg;
    double firstValue=Double.NaN ,secondValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //define components from activity_main.xml
        //buttons
        off=findViewById(R.id.off);
        dot=findViewById(R.id.dot);
        c=findViewById(R.id.c);
        mod=findViewById(R.id.precent);
        div=findViewById(R.id.div);
        multi=findViewById(R.id.multi);
        minus=findViewById(R.id.min);
        equal=findViewById(R.id.equal);
        plus=findViewById(R.id.plus);
        btn0=findViewById(R.id.zero);
        btn1=findViewById(R.id.one);
        btn2=findViewById(R.id.two);
        btn3=findViewById(R.id.three);
        btn4=findViewById(R.id.four);
        btn5=findViewById(R.id.five);
        btn6=findViewById(R.id.six);
        btn7=findViewById(R.id.seven);
        btn8=findViewById(R.id.eight);
        btn9=findViewById(R.id.nine);
        negative=findViewById(R.id.negative);
        //textViews
        inputDisplay=findViewById(R.id.input);
        outputDisplay=findViewById(R.id.output);
        //display each button on the screen
       
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputDisplay.setText(inputDisplay.getText()+".");
            }
        });
       plus.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){

               if(inputDisplay.getText().toString().isEmpty()){
                   inputDisplay.setText("");
               }
               else {
                   allCalculations();

                   inputDisplay.setText("");
                   outputDisplay.setText(firstValue + "+");
                   currentSymbol = ADDITION;
               }
           }
       });
       minus.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               if(inputDisplay.getText().toString().isEmpty()){
                   inputDisplay.setText("");
               }
               else {
               allCalculations();
               currentSymbol=SUBTRACTION;
               inputDisplay.setText("");
               outputDisplay.setText(firstValue+"-");}
           }
       });
       multi.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(inputDisplay.getText().toString().isEmpty()){
                   inputDisplay.setText("");
               }
               else {
               allCalculations();
               currentSymbol=MULTIPLICATION;
               inputDisplay.setText("");
               outputDisplay.setText(firstValue+"*");}
           }
       });
       div.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(inputDisplay.getText().toString().isEmpty()){
                   inputDisplay.setText("");
               }
               else {
               allCalculations();
                   currentSymbol=DIVISION;
                   inputDisplay.setText("");
                   outputDisplay.setText(firstValue+"/");
               if(errMsg!=null){
                   inputDisplay.setText("");
                   outputDisplay.setText(errMsg);
                   errMsg=null;
                   firstValue=Double.NaN;
               }

               }
           }
       });
       mod.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(inputDisplay.getText().toString().isEmpty()){
                   inputDisplay.setText("");
               }
               else {
               allCalculations();
               currentSymbol=MOD;
               inputDisplay.setText("");
               outputDisplay.setText(firstValue+"%");}
           }
       });
       equal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               allCalculations();
               currentSymbol='0';
               inputDisplay.setText("");
               outputDisplay.setText(firstValue+"");
               firstValue=Double.NaN;
               if(errMsg!=null){
                   inputDisplay.setText("");
                   outputDisplay.setText(errMsg);
                   errMsg=null;
                   firstValue=Double.NaN;
               }
           }
       });

       c.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               firstValue=Double.NaN;
               secondValue=Double.NaN;
               currentSymbol='0';
               inputDisplay.setText("");
               outputDisplay.setText("");
           }
       });
       off.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
       negative.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             if(inputDisplay.getText().toString().isEmpty()){
                 inputDisplay.setText("-");
             } else if (inputDisplay.getText().toString()=="-") {
                 inputDisplay.setText("");
             }else {

                 allCalculations();
                 firstValue *= -1;
                 inputDisplay.setText(firstValue + "");
             }
           }
       });
    }
    public void allCalculations(){
        Calculator mCalculator=new Calculator();
        if(!Double.isNaN(firstValue)){
        secondValue=Double.parseDouble(inputDisplay.getText().toString());
        switch (currentSymbol){
            case ADDITION: this.firstValue=mCalculator.add(firstValue,secondValue);
                 break;
            case SUBTRACTION:this.firstValue=mCalculator.sub(firstValue,secondValue);
                 break;
            case MULTIPLICATION: this.firstValue=mCalculator.multi(firstValue,secondValue);
                 break;
            case DIVISION:
                try{
                this.firstValue=mCalculator.div(firstValue,secondValue);}
                catch (IllegalArgumentException e){
                    errMsg="cann't divide by zero";
                    }
                break;
            case MOD:
                this.firstValue=mCalculator.mod(firstValue,secondValue);
                break;


        }
        }
        else {
            firstValue=Double.parseDouble(inputDisplay.getText().toString());
        }
    }
}