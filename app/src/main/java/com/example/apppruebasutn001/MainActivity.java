package com.example.apppruebasutn001;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtValor1;
    EditText txtValor2;
    Button cmdSuma;
    Button cmdResta;
    Button cmdMultiplicacion;
    Button cmdDivision;
    TextView lblResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciar objetos
        txtValor1 = findViewById(R.id.txtValor1);
        txtValor2 = findViewById(R.id.txtValor2);
        cmdSuma = findViewById(R.id.cmdSuma);
        cmdResta = findViewById(R.id.cmdResta);
        cmdMultiplicacion = findViewById(R.id.cmdMultiplicacion);
        cmdDivision = findViewById(R.id.cmdDivision);
        lblResultado = findViewById(R.id.lblResultado);
    }
    public void cmdCalcular_onClick(View v) {
        // Obtener los valores ingresados
        String valor1Str = txtValor1.getText().toString();
        String valor2Str = txtValor2.getText().toString();

        if (!valor1Str.isEmpty() && !valor2Str.isEmpty()) {
            // Convertir los valores a números
            double valor1 = Double.parseDouble(valor1Str);
            double valor2 = Double.parseDouble(valor2Str);
            double resultado = 0;

            // Determinar la operación a realizar según el botón presionado
            if (v.getId() == R.id.cmdSuma) {
                resultado = valor1 + valor2;
            } else if (v.getId() == R.id.cmdResta) {
                resultado = valor1 - valor2;
            } else if (v.getId() == R.id.cmdMultiplicacion) {
                resultado = valor1 * valor2;
            } else if (v.getId() == R.id.cmdDivision) {
                if (valor2 != 0) {
                    resultado = valor1 / valor2;
                } else {
                    lblResultado.setText("Error: División por cero");
                    return;
                }
            }
            // Mostrar el resultado en el TextView
            lblResultado.setText(String.valueOf(resultado));
        } else {
            // Mostrar un mensaje de error si falta algún valor
            lblResultado.setText("Ingrese ambos valores");
        }
    }
}