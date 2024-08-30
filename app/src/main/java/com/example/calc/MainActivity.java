package com.example.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declaración:
    private EditText etNumero;
    private TextView tvResultado;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir, btnIgual;
    private List<Double> numeros = new ArrayList<>();
    private List<String> operaciones = new ArrayList<>();
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincular elementos de la UI
        etNumero = findViewById(R.id.etNumero);
        tvResultado = findViewById(R.id.tvResultado);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnIgual = findViewById(R.id.btnIgual);
        btnReset = findViewById(R.id.btnReset);

        // Configurar botones de operaciones
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarNumeroYOperacion("+");
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarNumeroYOperacion("-");
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarNumeroYOperacion("*");
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarNumeroYOperacion("/");
            }
        });

        // Configurar botón de igual
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });

        // Configurar botón de reset
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetearValores();
            }
        });
    }

    private void guardarNumeroYOperacion(String op) {
        String numeroIngresado = etNumero.getText().toString();
        if (!numeroIngresado.isEmpty()) {
            double numero = Double.parseDouble(numeroIngresado);
            numeros.add(numero);
            operaciones.add(op);
            etNumero.setText("");
        } else {
            Toast.makeText(this, "Por favor ingrese un número", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetearValores() {
        numeros.clear();
        operaciones.clear();
        etNumero.setText("");
        tvResultado.setText("");
    }

    private void calcularResultado() {
        String numeroIngresado = etNumero.getText().toString();
        if (!numeroIngresado.isEmpty()) {
            double numero = Double.parseDouble(numeroIngresado);
            numeros.add(numero);
            etNumero.setText("");

            if (numeros.size() > 1) {
                double resultado = numeros.get(0);
                for (int i = 1; i < numeros.size(); i++) {
                    switch (operaciones.get(i - 1)) {
                        case "+":
                            resultado += numeros.get(i);
                            break;
                        case "-":
                            resultado -= numeros.get(i);
                            break;
                        case "*":
                            resultado *= numeros.get(i);
                            break;
                        case "/":
                            if (numeros.get(i) != 0) {
                                resultado /= numeros.get(i);
                            } else {
                                Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            break;
                    }
                }

                // Formateo el resultado con 2 números decimales (#):
                DecimalFormat decimales = new DecimalFormat("#.##");
                tvResultado.setText("Resultado: " + decimales.format(resultado));
                numeros.clear();
            }
        } else {
            Toast.makeText(this, "Por favor ingrese un número", Toast.LENGTH_SHORT).show();
        }
    }

}
