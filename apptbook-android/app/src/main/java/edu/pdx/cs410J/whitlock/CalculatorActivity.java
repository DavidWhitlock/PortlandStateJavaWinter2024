package edu.pdx.cs410J.whitlock;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void computeSum(View view) {
        EditText left = findViewById(R.id.left_operand);
        EditText right = findViewById(R.id.right_operand);
        String leftText = left.getText().toString();
        String rightText = right.getText().toString();

        int sum = Integer.parseInt(leftText) + Integer.parseInt(rightText);

        TextView sumField = findViewById(R.id.sum);
        sumField.setText(String.valueOf(sum));
    }
}