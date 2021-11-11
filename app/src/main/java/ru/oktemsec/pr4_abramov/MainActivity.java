package ru.oktemsec.pr4_abramov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.textView);
        etInput = (EditText) findViewById(R.id.editText);
        bControl = (Button) findViewById(R.id.button);

        guess = (int) (Math.random()*100);
        gameFinished = false;
    }

    public void onClick(View v) {
        if (!gameFinished && !etInput.getText().toString().equals("")) {
            int inp = Integer.parseInt(etInput.getText().toString());
            if (inp > guess)
                tvInfo.setText(R.string.ahead);
            if (inp < guess)
                tvInfo.setText(R.string.behind);
            if (inp == guess) {
                tvInfo.setText(R.string.hit);
                bControl.setText(R.string.play_more);
                gameFinished = true;
            }
        }
        else {
            guess = (int) (Math.random()*100);
            bControl.setText(R.string.input_value);
            tvInfo.setText(R.string.try_to_guess);
            gameFinished = false;
        }

        etInput.setText("");
    }
}