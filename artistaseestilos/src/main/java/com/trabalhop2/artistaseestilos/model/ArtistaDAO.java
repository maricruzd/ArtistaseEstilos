package com.trabalhop2.artistaseestilos.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;


@Repository
public class ArtistaDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirArtista(Artista artista) {
        String sql = "INSERT INTO artista(nome, estilo) VALUES(?, ?)";
        Object[] parametros = new Object[2];
        parametros[0] = artista.getNome();
        parametros[1] = artista.getEstilo();
        jdbc.update(sql, parametros);
    }

    public List<Map<String, Object>> puxarTodosArtistas() {
        String sql = "SELECT * FROM artista ORDER BY id";
        return jdbc.queryForList(sql);
    }

    public Map<String, Object> puxarArtista(int id) {
        String sql = "SELECT * FROM artista WHERE id = ?";
        return jdbc.queryForMap(sql, id);
    }

    public void atualizarArtista(int id, Artista novo) {
        String sql = "UPDATE artista SET nome = ?, estilo = ? WHERE id = ?";
        Object[] parametros = new Object[3];
        parametros[0] = novo.getNome();
        parametros[1] = novo.getEstilo();
        parametros[2] = id;
        jdbc.update(sql, parametros);
    }

    public void deletar(int id) {
        String sql = "DELETE FROM artista WHERE id = ?";
        jdbc.update(sql, id);
    }
}