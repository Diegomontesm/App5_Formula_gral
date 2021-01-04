package com.example.a5_formula_general;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    //Declaración de variables globales
    EditText et_a, et_b, et_c;
    TextView tv_resultado;
    Button BTN_Calcular, BTN_Borrar;

    Double a,b,c,d,x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar, enlazar los controles
        et_a = findViewById(R.id.valor_a_et);
        et_b = findViewById(R.id.valor_b_et);
        et_c = findViewById(R.id.valor_c_et);

        BTN_Calcular = (Button) findViewById(R.id.CalcularBTN);
        BTN_Borrar = (Button) findViewById(R.id.BorrarBTN);

        tv_resultado = (TextView)findViewById(R.id.resultadoTv);

        BTN_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //VALIDAR QUE TENGA CONTENIDO
                if(!et_a.getText().toString().equals("") && !et_b.getText().toString().equals("") && !et_c.getText().toString().equals("")){
                    a = Double.parseDouble(et_a.getText().toString());
                    b = Double.parseDouble(et_b.getText().toString());
                    c = Double.parseDouble(et_c.getText().toString());

                    d = Math.pow(b,2) - 4*a*c;

                    if(d == 0){
                        x1 = -b / (2*a);
                        tv_resultado.setText("d = " + d + "\nx = " + x1);
                    }else if(d < 0){
                        tv_resultado.setText("No hay raíces");
                    }else if(d > 0){
                        x1 = (-b + Math.sqrt(d)/(2*a));
                        x2 = (-b - Math.sqrt(d)/(2*a));

                        tv_resultado.setText("d = " + d + "\nx1 = " + x1 + "\nx2 = " + x2);
                    }
                }
            }
        });

        BTN_Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BORRAR LAS CAJAS
                et_a.setText("");
                et_b.setText("");
                et_c.setText("");
                tv_resultado.setText("");
            }
        });
    }
}