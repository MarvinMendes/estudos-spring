package com.devdojo.estudosspring.mapper;

import com.devdojo.estudosspring.domain.Anime;
import com.devdojo.estudosspring.dto.AnimeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimeMapper {

    AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    Anime toEntity(AnimeDTO dto);
    AnimeDTO toDTO(Anime anime);
}
