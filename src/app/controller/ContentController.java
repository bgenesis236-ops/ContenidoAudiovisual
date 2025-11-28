package app.controller;

import app.model.*;
import app.repository.Repository;

import java.util.*;

public class ContentController {
    private final Repository repo;
    private final List<ContenidoAudiovisual> contenidos = new ArrayList<>();

    public ContentController(Repository repo) {
        this.repo = repo;
    }

    public void load() throws Exception {
        contenidos.clear();
        contenidos.addAll(repo.loadAll());
    }

    public void save() throws Exception {
        repo.saveAll(contenidos);
    }

    public void addPelicula(String title, String genero, int year, int dur, String dir) {
        contenidos.add(new Pelicula(UUID.randomUUID().toString(), title, genero, year, dur, dir));
    }

    public void addSerie(String title, String genero, int year) {
        contenidos.add(new Serie(UUID.randomUUID().toString(), title, genero, year));
    }

    public void addDocumental(String title, String genero, int year, String tema, String inv) {
        contenidos.add(new Documental(UUID.randomUUID().toString(), title, genero, year, tema, inv));
    }

    public List<ContenidoAudiovisual> getAll() {
        return contenidos;
    }
}
