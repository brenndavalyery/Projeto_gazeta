package com.example.exercicioGazeta.controller;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;

import com.example.exercicioGazeta.model.Gazeta;
import com.example.exercicioGazeta.view.GazetaActivity;

public class GazetaController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public GazetaController (GazetaActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override

    public String toString(){
        Log.d("MVC_Controller", "Controller iniciado: ");
        return super.toString();
    }

    public Gazeta salvar(Gazeta gazeta) {
        Log.d("MVC_Controller", "Salvo: " + gazeta.toString());
        listaVip.putString("Etanol: ", gazeta.getEtanol());
        listaVip.putString("Gasolina: ", gazeta.getGasolina());
        listaVip.putString("Resultado: ", gazeta.getResultado());
        listaVip.apply();
        return gazeta;
    }

    public Gazeta buscar(Gazeta outroGazeta) {
        outroGazeta.setEtanol(preferences.getString("Etanol: ", ""));
        outroGazeta.setGasolina(preferences.getString("Gasolina: ", ""));
        outroGazeta.setResultado(preferences.getString("Resultado: ", ""));
        return outroGazeta;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }

}
