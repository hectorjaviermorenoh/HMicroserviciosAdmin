package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.client.IMovieService;
import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private IMovieService MovieService;

//    private final CatalogService service;

//    public CatalogController(CatalogService service) {
//        this.service = service;
//    }
//

//    @GetMapping("/{genre}")
//    ResponseEntity<List<Movie>> getGenre(@PathVariable String genre) {
//
//        return ResponseEntity.ok().body(service.getMovieByGenre(genre));
//    }

//    @GetMapping("/{genre}")
//    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
//        return ResponseEntity.ok().body(service.findByGenre(genre));
//    }

    @GetMapping("/prueba")
    public String prueba(){
        return "hola microservicio Catalogo responde";
    }



//    @GetMapping("/{genre}")
//    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
//        return ResponseEntity.ok().body(MovieService.getMovieByGenre(genre));
//    }
    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
          return ResponseEntity.ok().body(MovieService.getMovieByGenre(genre));
    }




}
