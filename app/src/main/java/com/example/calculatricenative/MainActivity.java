package com.example.calculatricenative;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public String firstNumber ="";
            String secondNumber ="";
            String calculResult ="0";
            String signe="";
            TextView textResult;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnDiv,btnFois,btnMinus,btnAC,btnEquals,btnPlus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDiv = findViewById(R.id.btnDiv);
        btnFois = findViewById(R.id.btnfois);
        btnMinus = findViewById(R.id.btnMinus);
        btnAC = findViewById(R.id.btnAC);
        btnEquals = findViewById(R.id.btnEquals);
        btnPlus = findViewById(R.id.btnPlus);
        textResult = findViewById(R.id.textResult);
        AddListener();
    }

    private void AddListener() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnFois.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
    }

    public void onSigneClicked(String signeValue)
    {
        if(!firstNumber.isEmpty() && !secondNumber.isEmpty() && !signe .isEmpty() )
        {
            return;
        }
        if(!firstNumber.isEmpty())
        {
            String newText = firstNumber+signeValue;
            signe=signeValue;
            calculResult=newText;
        }
        textResult.setText(calculResult);

    }
    public void onchangValue(int value)
    {
        try {
            if(!firstNumber.isEmpty() && !secondNumber.isEmpty() && !signe.isEmpty() )
            {
                String secondText = secondNumber +"" +value;
                secondNumber = secondText;
                String newTextResult = firstNumber +""+ signe+""+ secondNumber;
                calculResult = newTextResult;

                textResult.setText(calculResult);

            }
            else if(!firstNumber.isEmpty() && !signe.isEmpty())
            {
                String newTextResult = firstNumber+""+signe+""+value;
                calculResult = newTextResult;
                secondNumber = String.valueOf(value);

                textResult.setText(calculResult);
            }

            else if(!this.calculResult.equals("0"))
            {
                String newText = calculResult+"" + value;
                calculResult=newText;
                firstNumber=newText;

                textResult.setText(calculResult);
            }
            else{
                calculResult=String.valueOf(value);
                firstNumber=String.valueOf(value);

                textResult.setText(calculResult);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public  void onResetClicked()
    {
        calculResult="0";
        firstNumber="0";
         secondNumber="0";
        signe="";
        textResult.setText("0");
    }

    public void onEqualsClicked()
    {
        try {

            if(!firstNumber.isEmpty() && !secondNumber.isEmpty() && !signe.isEmpty() )
            {
                if(signe.equals("+"))
                {
                    String resultValue = String.valueOf(Integer.valueOf(firstNumber) +Integer.valueOf(secondNumber));
                    calculResult=resultValue;
                    firstNumber="";
                    secondNumber="";
                    signe="";
                    //needReset=true;

                    textResult.setText(calculResult);
                    return;
                }
                if(signe.equals("x"))
                {
                    String resultValue = String.valueOf(Integer.valueOf(firstNumber) * Integer.valueOf(secondNumber));
                    calculResult=resultValue;
                    firstNumber="";
                    secondNumber="";
                    signe="";
                    //needReset=true;

                    textResult.setText(calculResult);
                    return;
                }
                if(signe.equals("÷"))
                {
                    String resultValue = String.valueOf(Integer.valueOf(firstNumber )/ Integer.valueOf(secondNumber));
                    calculResult=resultValue;
                    firstNumber="";
                    secondNumber="";
                    signe="";
                    //needReset:true});

                    textResult.setText(calculResult);
                    return;
                }
                if(signe.equals("-"))
                {
                    String resultValue =String.valueOf(Integer.valueOf(firstNumber) - Integer.valueOf(secondNumber)) ;
                    calculResult=resultValue;
                    firstNumber="";
                    secondNumber="";
                    signe="";
                    //needReset:true});

                    textResult.setText(calculResult);
                    return;
                }
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()){
                case R.id.btn0:
                    onchangValue(0);
                    break;
                case R.id.btn1:
                    onchangValue(1);
                    break;
                case R.id.btn2:
                    onchangValue(2);
                    break;
                case R.id.btn3:
                    onchangValue(3);
                    break;
                case R.id.btn4:
                    onchangValue(4);
                    break;
                case R.id.btn5:
                    onchangValue(5);
                    break;
                case R.id.btn6:
                    onchangValue(6);
                    break;
                case R.id.btn7:
                    onchangValue(7);
                    break;
                case R.id.btn8:
                    onchangValue(8);
                    break;
                case R.id.btn9:
                    onchangValue(9);
                    break;
                case R.id.btnDiv:
                    onSigneClicked("÷");

                    break;
                case R.id.btnfois:
                    onSigneClicked("x");
                    break;
                case R.id.btnMinus:
                    onSigneClicked("-");
                    break;
                case R.id.btnPlus:
                    onSigneClicked("+");
                    break;
                case R.id.btnAC:
                    onResetClicked();
                    break;
                case R.id.btnEquals:
                    onEqualsClicked();

                    break;

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}