package com.trabalhop2.artistaseestilos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Artista {

    private int id;
    private String nome, estilo;

    public Artista() {}

    public Artista(String nome, String estilo) {
        this.nome = nome;
        this.estilo = estilo;
    }

    public Artista(int id, String nome, String estilo) {
        this.id = id;
        this.nome = nome;
        this.estilo = estilo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome != null ? nome.toUpperCase() : null;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstilo() {
        return estilo != null ? estilo.toUpperCase() : null;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public static Artista converter(Map<String, Object> registro) {
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        String estilo = (String) registro.get("estilo");

        return new Artista(id, nome, estilo);
    }

    public static List<Artista> converterVarios(List<Map<String, Object>> registros) {
        ArrayList<Artista> lista = new ArrayList<>();
        for (Map<String, Object> reg : registros) {
            lista.add(converter(reg));
        }
        return lista;
    }
}