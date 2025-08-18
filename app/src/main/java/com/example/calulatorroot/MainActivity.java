package com.example.calulatorroot;

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

public class MainActivity extends AppCompatActivity {
    private Button btncalcular;
    private EditText number;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        number = findViewById(R.id.numberInput);
        result = findViewById(R.id.viewResult);
        btncalcular = findViewById(R.id.btnCalcular);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = number.getText().toString().trim();

                if (!input.isEmpty()) {
                    double numero = Double.parseDouble(input);

                    if (numero >= 0) {
                        double resultado = Math.sqrt(numero);

                        // Formatear con 5 cifras significativas
                        String resultadoFormateado = String.format("%.5g", resultado);

                        result.setText("Resultado: " + resultadoFormateado);
                    } else {
                        result.setText("Error: número negativo");
                    }
                } else {
                    result.setText("Por favor, ingresa un número");
                }
            }
        });
    }

}