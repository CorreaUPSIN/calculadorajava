package com.example.calculadorajava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class CalculadorActivity extends AppCompatActivity {

    // Variables miembro de la clase MainActivity
    private EditText inputNum1;
    private EditText inputNum2;
    private TextView lblResultado;
    private TextView lblMostrarNombreUser;
    private int num1;
    private int num2;
    private Calculadora calculadora;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculador);

        // Obtener una referencia al EditText
        inputNum1 = findViewById(R.id.inputNum1);
        inputNum2 = findViewById(R.id.inputNum2);

        lblResultado = findViewById(R.id.lblResultado);
        lblMostrarNombreUser = findViewById(R.id.lblMostrarNombreUser);


        // Obtener una referencia al botón
        Button btnSumar = findViewById(R.id.btnSumar);
        Button btnRestar = findViewById(R.id.btnRestar);
        Button btnMultiplicar = findViewById(R.id.btnMultiplicar);
        Button btnDividir = findViewById(R.id.btnDividir);
        Button btnLimpiar = findViewById(R.id.btnLimpiar);
        Button btnCerrarSesion = findViewById(R.id.btnCerrarSesion);


        // Obtener los datos del Bundle
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String usuario = bundle.getString("Usuario");
            // Haz algo con el valor del usuario
            // Por ejemplo, muestra el usuario en un TextView
            TextView txtUsuario = findViewById(R.id.lblMostrarNombreUser);
            txtUsuario.setText("Usuario:" + usuario);
        }

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringNum1 = inputNum1.getText().toString();
                String stringNum2 = inputNum2.getText().toString();

                if (!TextUtils.isEmpty(stringNum1) && !TextUtils.isEmpty(stringNum2)) {
                    double num1 = Double.parseDouble(stringNum1);
                    double num2 = Double.parseDouble(stringNum2);

                    calculadora = new Calculadora(num1, num2);

                    // Realiza otras operaciones con la calculadora si es necesario
                    double resultado = calculadora.sumar();
                    String resultadoTexto = String.valueOf(resultado);
                    lblResultado.setText(resultadoTexto);
                } else {
                    Toast.makeText(getApplicationContext(), "Llene todos los campos.", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringNum1 = inputNum1.getText().toString();
                String stringNum2 = inputNum2.getText().toString();

                if (!TextUtils.isEmpty(stringNum1) && !TextUtils.isEmpty(stringNum2)) {
                    double num1 = Double.parseDouble(stringNum1);
                    double num2 = Double.parseDouble(stringNum2);

                    calculadora = new Calculadora(num1, num2);

                    // Realiza otras operaciones con la calculadora si es necesario
                    double resultado = calculadora.restar();
                    String resultadoTexto = String.valueOf(resultado);
                    lblResultado.setText(resultadoTexto);
                } else {
                    Toast.makeText(getApplicationContext(), "Llene todos los campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringNum1 = inputNum1.getText().toString();
                String stringNum2 = inputNum2.getText().toString();

                if (!TextUtils.isEmpty(stringNum1) && !TextUtils.isEmpty(stringNum2)) {
                    double num1 = Double.parseDouble(stringNum1);
                    double num2 = Double.parseDouble(stringNum2);

                    calculadora = new Calculadora(num1, num2);

                    // Realiza otras operaciones con la calculadora si es necesario
                    double resultado = calculadora.multiplicar();
                    String resultadoTexto = String.valueOf(resultado);
                    lblResultado.setText(resultadoTexto);
                } else {
                    Toast.makeText(getApplicationContext(), "Llene todos los campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringNum1 = inputNum1.getText().toString();
                String stringNum2 = inputNum2.getText().toString();

                if (!TextUtils.isEmpty(stringNum1) && !TextUtils.isEmpty(stringNum2)) {
                    double num1 = Double.parseDouble(stringNum1);
                    double num2 = Double.parseDouble(stringNum2);


                    if (num2 <= 0){
                        Toast.makeText(getApplicationContext(), "No se puede dividir entre " + num2 + ".", Toast.LENGTH_SHORT).show();
                    } else {

                        calculadora = new Calculadora(num1, num2);

                        // Realiza otras operaciones con la calculadora si es necesario
                        double resultado = calculadora.dividir();
                        String resultadoTexto = String.valueOf(resultado);
                        lblResultado.setText(resultadoTexto);
                    }

                }  else {
                    Toast.makeText(getApplicationContext(), "Llene todos los campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum1.setText("");
                inputNum2.setText("");

                lblResultado.setText("");

            }
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculadorActivity.this);
                builder.setTitle("Confirmación");
                builder.setMessage("¿Estás seguro de querer cerrar sesión?");
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acciones a realizar si se selecciona "Sí"
                        Intent intent = new Intent(CalculadorActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Finaliza la actividad actual (CalculadorActivity)
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acciones a realizar si se selecciona "No"
                        dialog.dismiss(); // Cierra el diálogo sin realizar ninguna acción adicional
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    public class Calculadora {
        private double numero1;
        private double numero2;

        public Calculadora(double num1, double num2) {
            this.numero1 = num1;
            this.numero2 = num2;
        }

        // Resto de métodos de la clase Calculadora

        public double sumar() {
            return numero1 + numero2;
        }

        public double restar() {
            return numero1 - numero2;
        }

        public double multiplicar() {
            return numero1 * numero2;
        }

        public double dividir() {
            if (numero2 != 0) {
                return numero1 / numero2;
            } else {
                throw new ArithmeticException("Error: No se puede dividir entre cero");
            }
        }
    }
}