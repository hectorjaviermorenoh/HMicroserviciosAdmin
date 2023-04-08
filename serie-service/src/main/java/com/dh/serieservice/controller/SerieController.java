package com.dh.serieservice.controller;

import com.dh.serieservice.service.SerieService;
import com.dh.serieservice.queue.SerieSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dh.serieservice.model.Serie;

import java.util.List;


@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servicedatos;
    @Autowired
    private SerieSender SerieSender;


    public SerieController(SerieService serieService) {
        this.servicedatos = serieService;
    }

    @GetMapping
    public List<Serie> getAll() {
        return servicedatos.getAll();
    }

    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {

        return servicedatos.getSeriesBygGenre(genre);
    }

    @PostMapping("/save")
    ResponseEntity<?> saveSerie(@RequestBody Serie serie) {
        return ResponseEntity.ok().body(servicedatos.create(serie));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Serie serie) {
        servicedatos.create(serie);
        return serie.getId();
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> savePersona(@RequestBody Serie serie) {
        SerieSender.send(serie);
        return ResponseEntity.noContent().build();
    }


}
