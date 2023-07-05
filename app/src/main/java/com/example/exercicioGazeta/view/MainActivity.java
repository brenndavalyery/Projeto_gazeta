package com.example.exercicioGazeta.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exercicioGazeta.R;
import com.example.exercicioGazeta.controller.CursoController;
import com.example.exercicioGazeta.controller.PessoalController;
import com.example.exercicioGazeta.model.tarefaModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PessoalController PessoalController;
    tarefaModel novaTarefa;
    CursoController cursoController;
    List<String> listaCursos;

    EditText editNomeDaTarefa;
    EditText editDescricao;
    EditText editData;
    EditText editSobrenome;

    Button botaoLimpar;
    Button botaoSalvar;
    Button botaoFinalizar;

    Spinner edit_Spinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        CursoController cursoController = new CursoController();

        listaCursos = cursoController.dadosSpinner();

        cursoController.getListaCursos();

        PessoalController = new PessoalController(MainActivity.this);

        PessoalController.toString();

        novaTarefa = new tarefaModel();
        PessoalController.buscar(novaTarefa);

        botaoLimpar = findViewById(R.id.botaoLimpar);
        botaoSalvar = findViewById(R.id.Calcular);
        botaoFinalizar = findViewById(R.id.botaoFinalizar);

        editNomeDaTarefa = findViewById(R.id.gasolina);
        editDescricao = findViewById(R.id.descricao);
        editData = findViewById(R.id.data);
        editSobrenome = findViewById(R.id.etanol);

        edit_Spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        edit_Spinner.setAdapter(adapter);

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNomeDaTarefa.setText("");
                editDescricao.setText("");
                editData.setText("");
                editSobrenome.setText("");
                Toast.makeText(MainActivity.this, "Limpo com sucesso", Toast.LENGTH_SHORT).show();
                PessoalController.limpar();
            }
        });

        botaoFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Operação finalizada", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaTarefa.setNome(editNomeDaTarefa.getText().toString());
                novaTarefa.setData(editData.getText().toString());
                novaTarefa.setDescricao(editDescricao.getText().toString());
                novaTarefa.setSobrenome(editSobrenome.getText().toString());
                Toast.makeText(MainActivity.this, "Dados salvos" + novaTarefa.toString(), Toast.LENGTH_LONG).show();
                PessoalController.salvar(novaTarefa);

            }
        });

    }
}