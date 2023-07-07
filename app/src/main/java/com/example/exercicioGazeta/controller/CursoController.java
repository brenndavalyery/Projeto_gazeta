package com.example.exercicioGazeta.controller;
//import com.example.exercicioGazeta.model.Curso;
//
//import java.util.ArrayList;
//import java.util.List;

//public class CursoController {
//    private List listaCursos;
//
//    public CursoController() {
//        listaCursos = new ArrayList<>();
//        lista();
//    }
//
//    public List<Curso> getListaCursos() {
//        return listaCursos;
//    }
//
//    private List lista() {
//        listaCursos = new ArrayList<Curso>();
//        listaCursos.add(new Curso("Medicina"));
//        listaCursos.add(new Curso("Fisioterapia"));
//        listaCursos.add(new Curso("Psicologia"));
//        listaCursos.add(new Curso("Enfermagem"));
//
//        return listaCursos;
//    }
//
//    public ArrayList<String> dadosSpinner() {
//        ArrayList<String> dados= new ArrayList<>();
//        for (int i = 0; i < getListaCursos().size(); i++) {
//            Curso objeto = (Curso) getListaCursos().get(i);
//            dados.add(objeto.getCursoDesejado());
//            }
//        return dados;
//    }
//}