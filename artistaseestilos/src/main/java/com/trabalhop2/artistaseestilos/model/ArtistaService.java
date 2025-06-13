package com.trabalhop2.artistaseestilos.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaDAO dao;

    public void inserirArtista(Artista artista) {
        dao.inserirArtista(artista);
    }

    public List<Artista> puxarTodosArtistas() {
        List<Map<String, Object>> registros = dao.puxarTodosArtistas();
        return Artista.converterVarios(registros);
    }

    public Artista puxarArtista(int id) {
        Map<String, Object> registro = dao.puxarArtista(id);
        return Artista.converter(registro);
    }

    public void atualizarArtista(int id, Artista artista) {
        dao.atualizarArtista(id, artista);
    }

    public void deletar(int id) {
        dao.deletar(id);
    }

        public List<Artista> buscarPorEstilo(String estilo) {
        List<Map<String, Object>> registros = dao.buscarPorEstilo(estilo);
        return Artista.converterVarios(registros);
    }

}