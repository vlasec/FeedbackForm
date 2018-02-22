package com.github.vlasec.feedback.rest.dto.extract;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A common interface for all DTO extractors. Input and output types are defined by generic parameters.
 * @param <DTO> type parameter of the DTO
 * @param <ENTITY> type parameter of the entity
 */
public interface DtoExtractor<DTO, ENTITY> {
    /**
     * Extracts the data from a single DTO into a new entity
     * @param dto input DTO
     * @return new entity using data from DTO
     */
    ENTITY extract(DTO dto);

    /**
     * Extracts the data from a collection of DTOs and returns a list of entities.
     * Default implementation calls {@link #extract(Object)} method repeatedly, override this behavior if needed.
     * @param dtoList list of DTOs
     * @return list of new entities using data from DTOs.
     */
    default List<ENTITY> extract(Collection<DTO> dtoList) {
        return dtoList.stream().map(this::extract).collect(Collectors.toList());
    }
}
