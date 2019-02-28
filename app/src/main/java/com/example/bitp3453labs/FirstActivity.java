package com.example.bitp3453labs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Year;

public class FirstActivity extends AppCompatActivity {

    TextView greeting;
    EditText edtTxtName, edtTxtYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activity);

        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtYear = findViewById(R.id.edtTxtYear);
        greeting = findViewById(R.id.tvGreet);
    }

    public void fnGreet(View vw)
    {
        String strName = edtTxtName.getText().toString();
        greeting.setText("Hi " + strName +" (" + countAge() + ") \n" + "Nice to meet you!");
    }

    public int countAge()
    {
        int result = 0;
        Integer inputtedYear = Integer.parseInt(edtTxtYear.getText().toString());
        Integer curYear = Year.now().getValue();
        result = curYear - inputtedYear;

        return result;
    }

    public void fnThreadActivity(View vw)
    {
        Intent intent = new Intent(this, ThreadedActivity.class);
        String strName = edtTxtName.getText().toString();
        Integer intAge = countAge();

        intent.putExtra("varName", strName);
        intent.putExtra("varAge", intAge);

        startActivity(intent);
    }
}
