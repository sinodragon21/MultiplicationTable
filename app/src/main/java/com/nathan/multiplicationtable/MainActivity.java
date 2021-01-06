package com.nathan.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int factor = 1, factorBase = 9;
    int faciend = 1, faciendBase = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshQuestion();
    }

    public void calculateMT(View view){
        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        TextView textViewHints = findViewById(R.id.textViewHints);
        int answer = Integer.parseInt(String.valueOf(editTextAnswer.getText()));
        if(answer == factor * faciend) {
            textViewHints.setText(R.string.right);
        }else{
            String strHints = String.format("%d x %d = %d", factor, faciend, factor*faciend);
            textViewHints.setText(this.getString(R.string.wrong)+"\n"+strHints);
        }
    }

    public void nextQuestion(View view){
        refreshQuestion();
    }

    void refreshQuestion(){
        Random rand = new Random();
        factor = rand.nextInt(factorBase) + 1;
        faciend = rand.nextInt(faciendBase) + 1;
        // String question = Integer.toString(factor) + "x" + Integer.toString(faciend) + "=";
        TextView textViewA = findViewById(R.id.textViewA);
        TextView textViewB = findViewById(R.id.textViewB);
        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        TextView textViewHints = findViewById(R.id.textViewHints);
        textViewA.setText(Integer.toString(factor));
        textViewB.setText(Integer.toString(faciend));
        editTextAnswer.setText("");
        textViewHints.setText("");
    }
}