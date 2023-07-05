package com.example.exercicioGazeta.model;

public class Gazeta {

    private String gasolina;
    private String etanol;
    private String resultado;

    public Gazeta() {

    }

    public Gazeta(String gasolina, String etanol, String resultado) {
        this.gasolina = gasolina;
        this.etanol = etanol;
        this.resultado = resultado;
    }

    public String getGasolina() {
        return gasolina;
    }

    public void setGasolina(String gasolina) {
        this.gasolina = gasolina;
    }

    public String getEtanol() {
        return etanol;
    }

    public void setEtanol(String etanol) {
        this.etanol = etanol;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}

