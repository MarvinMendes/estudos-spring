package com.devdojo.estudosspring.mapper;

import com.devdojo.estudosspring.domain.Anime;
import com.devdojo.estudosspring.dto.AnimeDTO;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public interface AnimeMapper {

    AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    Anime toEntity(AnimeDTO dto);
    AnimeDTO toDTO(Anime anime);
}
