package com.example.exercicioGazeta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.exercicioGazeta.model.tarefaModel;
import com.example.exercicioGazeta.view.MainActivity;

public class PessoalController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";
    public PessoalController (MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override

    public String toString(){
        Log.d("MVC_Controller", "Controller iniciado: ");
        return super.toString();
    }

    public void salvar(tarefaModel novaTarefa) {
        Log.d("MVC_Controller", "Salvo: " + novaTarefa.toString());
        listaVip.putString("Nome do aluno: ", novaTarefa.getNome());
        listaVip.putString("Telefone: ", novaTarefa.getData());
        listaVip.putString("Nome do curso: ", novaTarefa.getDescricao());
        listaVip.putString("Sobrenome: ", novaTarefa.getSobrenome());
        listaVip.apply();
    }

    public tarefaModel buscar(tarefaModel novaTarefa) {
        novaTarefa.setNome(preferences.getString("Nome do aluno: ", ""));
        novaTarefa.setDescricao(preferences.getString("Telefone: ", ""));
        novaTarefa.setData(preferences.getString("Nome do curso: ", ""));
        novaTarefa.setSobrenome(preferences.getString("Sobrenome: ", ""));
        return novaTarefa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }
}