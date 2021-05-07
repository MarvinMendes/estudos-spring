package com.devdojo.estudosspring.controller;

import com.devdojo.estudosspring.domain.Anime;
import com.devdojo.estudosspring.dto.AnimeDTO;
import com.devdojo.estudosspring.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/animes")
public class AnimeController {

    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> listAll() {
        return new ResponseEntity<List<Anime>>(animeService.listAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AnimeDTO> create(@RequestBody AnimeDTO dto) {
        return new ResponseEntity<>(animeService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AnimeDTO> replace(@RequestBody AnimeDTO dto) {
        return new ResponseEntity<>(animeService.replace(dto), HttpStatus.OK);
    }

    @RequestMapping("/name")
    ResponseEntity<Stream<AnimeDTO>> findByName(@RequestBody AnimeDTO dto) {
        return new ResponseEntity<>( animeService.findByName(dto), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    ResponseEntity<AnimeDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(animeService.getById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        animeService.remove(id);
    }

}
