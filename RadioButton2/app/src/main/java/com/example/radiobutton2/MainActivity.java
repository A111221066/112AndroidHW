package com.example.radiobutton2;
//A111221066
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton boy = findViewById(R.id.rdbBoy);
                RadioButton girl = findViewById(R.id.rdbGirl);
                String gender = "";
                if (boy.isChecked())
                    gender = "男生";
                else if (girl.isChecked())
                    gender = "女生";

                RadioGroup type = findViewById(R.id.rgType);
                int ticketPrice = 0;
                int selectedTypeId = type.getCheckedRadioButtonId();
                if (selectedTypeId == R.id.rdbAdult)
                    ticketPrice = 500;
                else if (selectedTypeId == R.id.rdbChild)
                    ticketPrice = 250;
                else if (selectedTypeId == R.id.rdbStudent)
                    ticketPrice = 300;

                EditText editTextNumber = findViewById(R.id.editTextNumber);
                int numberOfTickets = Integer.parseInt(editTextNumber.getText().toString());

                int totalPrice = ticketPrice * numberOfTickets;

                TextView output = findViewById(R.id.lblOutput);
                String outputStr = "性別: " + gender + "\n" +
                        "票種: " + getTicketType(selectedTypeId) + "\n" +
                        "張數: " + numberOfTickets + "\n" +
                        "票價: " + totalPrice;
                output.setText(outputStr);
            }
        });
    }

    private String getTicketType(int typeId) {
        if (typeId == R.id.rdbAdult)
            return "全票";
        else if (typeId == R.id.rdbChild)
            return "兒童票";
        else if (typeId == R.id.rdbStudent)
            return "學生票";
        else
            return "";
    }
}