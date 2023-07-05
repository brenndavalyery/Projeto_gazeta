package com.example.exercicioGazeta.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.exercicioGazeta.R;
import com.example.exercicioGazeta.controller.GazetaController;
import com.example.exercicioGazeta.model.Gazeta;

public class GazetaActivity extends AppCompatActivity {

    GazetaController gazetaController;
    Gazeta gazeta;
    Gazeta outroGazeta;

    Button botaoLimpar;
    Button botaoFinalizar;
    Button botaoSalvar;

    EditText edit_PrecoGasolina;
    EditText edit_PrecoEtanol;
    TextView text_Resultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        gazetaController = new GazetaController(GazetaActivity.this);

        botaoLimpar = findViewById(R.id.botaoLimpar);
        botaoFinalizar = findViewById(R.id.botaoFinalizar);
        botaoSalvar = findViewById(R.id.button);

        edit_PrecoGasolina = findViewById(R.id.gasolina);
        edit_PrecoEtanol = findViewById(R.id.etanol);
        text_Resultado = findViewById(R.id.resultado);

        outroGazeta = new Gazeta();
        gazetaController.buscar(outroGazeta);

        gazeta = new Gazeta();

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_PrecoGasolina.setText("");
                edit_PrecoEtanol.setText("");
                text_Resultado.setText("Resultado: ");
                gazetaController.limpar();
                botaoSalvar.setEnabled(false);
                Toast.makeText(GazetaActivity.this, "Limpo com sucesso", Toast.LENGTH_SHORT).show();

            }
        });

        botaoFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GazetaActivity.this, "Operação finalizada", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outroGazeta.setGasolina(edit_PrecoGasolina.getText().toString());
                outroGazeta.setEtanol(edit_PrecoEtanol.getText().toString());
                outroGazeta.setResultado(text_Resultado.getText().toString());
                Toast.makeText(GazetaActivity.this, "Dados salvos" + gazeta.toString(), Toast.LENGTH_LONG).show();
                gazetaController.salvar(outroGazeta);
            }
        });

    }

    public void calcular(View view) {
        text_Resultado.setText("");
        double gasolina = Double.parseDouble(edit_PrecoGasolina.getText().toString());
        double etanol = Double.parseDouble(edit_PrecoEtanol.getText().toString());
        double resultado = (etanol / gasolina);

        if (resultado <= 0.7) {
            text_Resultado.setText(String.format("Etanol %.2f", resultado));

        } else {
            text_Resultado.setText(String.format("Gasolina %.2f", resultado));
        }
        botaoSalvar.setEnabled(true);

    }


}
