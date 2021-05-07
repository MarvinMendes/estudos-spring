package com.devdojo.estudosspring.service;

import com.devdojo.estudosspring.domain.Anime;
import com.devdojo.estudosspring.dto.AnimeDTO;
import com.devdojo.estudosspring.mapper.AnimeMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

@Service
public class AnimeService {

    private static final  List<Anime> animes;
    private final AnimeMapper mapper = AnimeMapper.INSTANCE;

    static {
        animes = new ArrayList<>(List.of(new Anime(1L, "Neon Genesis Evangelion"), new Anime(2L, "Attack on titan"),
                new Anime(3L, "Demon Slayer")));
    }

    public List<Anime> listAll() {
        return animes;
    }

    public AnimeDTO save(AnimeDTO dto) {
        dto.setId(ThreadLocalRandom.current().nextLong(4, 1000));
        animes.add(mapper.toEntity(dto));
        return dto;
    }

    public AnimeDTO replace(AnimeDTO dto) {
        delete(dto.getId());
        animes.add(mapper.toEntity(dto));
        return dto;
    }

    private Anime findById(Long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException());
    }

    private void delete(Long id) {
        Anime anime = findById(id);
        animes.remove(anime);
    }

    //vai buscar na collection se existe algum anime com o parêmetro passado
    //EX: você pode passar na propriedade "name" somente "evangelion" que ele vai conseguir fazer essa busca
    public Stream<AnimeDTO> findByName(AnimeDTO dto) {
        boolean exists = animes.stream().anyMatch(anime ->  anime.getName().toLowerCase().contains(dto.getName()));
        if (!exists) {
            throw new NoSuchElementException();
        }
        Stream<AnimeDTO> animeFounded = animes.stream().filter(anime -> anime.getName().toLowerCase().contains(dto.getName()))
                .map(mapper::toDTO);
        return animeFounded;
    }

    public AnimeDTO getById(Long id) {
        return mapper.toDTO(findById(id));
    }

    public void remove(Long id) {
        delete(id);
    }
}
