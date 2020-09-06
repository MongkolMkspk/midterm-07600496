package th.ac.su.cp.speedcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import th.ac.su.cp.speedcalculator.model.Calculator;

public class MainActivity extends AppCompatActivity {
    Calculator c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText sEdit = findViewById(R.id.s_editTextNumberDecimal);
        final EditText tEdit = findViewById(R.id.t_editTextNumberDecimal);
        final TextView answerText = findViewById(R.id.showResult);
        Button clearButton = findViewById(R.id.clear_button);
        Button calculateButton = findViewById(R.id.process_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sEdit.setText("");
                tEdit.setText("");
                answerText.setText("");
            }
        });
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sString = sEdit.getText().toString();
                String tString = tEdit.getText().toString();
                if (tString.equals("0")) {
                    Toast toast = Toast.makeText(MainActivity.this, R.string.above_zero, Toast.LENGTH_LONG);
                    toast.show();

                } else if (sString.isEmpty() || tString.isEmpty()) {
                    Toast toast = Toast.makeText(MainActivity.this, R.string.requirement, Toast.LENGTH_LONG);
                    toast.show();
                } else {

                    double s = Double.parseDouble(sString);
                    double t = Double.parseDouble(tString);
                    c = new Calculator(s, t);
                    double answer = c.calculate();
                    String str = String.format(
                            Locale.getDefault(), "%.2f", answer
                    );
                    answerText.setText(str);
                    if (answer > 80) {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("SPEED CALCULATOR");
                        dialog.setMessage("speed is over limit!");
                        dialog.setPositiveButton("OK", null);
                        dialog.show();
                    }
                }

            }
        });
    }
}