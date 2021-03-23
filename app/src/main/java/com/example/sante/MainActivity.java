package com.example.sante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText poids;
    private EditText taille;
    private Button btnCalculer;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poids = findViewById(R.id.EditTextPoids);
        taille = findViewById(R.id.EditTextTaille);
        btnCalculer = findViewById(R.id.ButtonCalculer);
        result = findViewById(R.id.TextViewResult);

        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double t = Double.parseDouble(taille.getText().toString());
                double p = Double.parseDouble(poids.getText().toString());

                if(t == 0 || p == 0)
                    Log.e("Error","Vous n'avez pas saisi la taille ou le poids");

                double resultat = p/(t*t);

                String res = "";

                if(resultat > 40)
                    res = "obésité morbide ou massive";

                else if (35<=resultat && resultat<=40 )
                    res = "obésité sévère";

                else if(30<=resultat && resultat<=35)
                    res = "obésité modérée";

                else if(25<=resultat && resultat<=30)
                    res = "Surpoids";

                else if(18.5<=resultat && resultat<=25)
                    res = "corpulence normal";

                else if(16.5<=resultat && resultat<=18.5)
                    res = "maigreur";

                else if(resultat < 16.5)
                    res = "famine";

                result.setText(res);

            }
        });



    }
}