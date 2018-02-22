package com.github.vlasec.feedback.rest.dto.create;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A common interface for all DTO creators. Input and output types are defined by generic parameters.
 * @param <ENTITY> type parameter of the entity
 * @param <DTO> type parameter of the DTO
 */
public interface DtoCreator<ENTITY, DTO> {
    /**
     * Creates a DTO using data from provided entity.
     * @param entity input entity
     * @return a new DTO, using data from entity
     */
    DTO create(ENTITY entity);

    /**
     * Creates a collection of DTOs using a provided list of entity objects.
     * Default implementation calls {@link #create(Object)} method repeatedly, override this behavior if needed.
     * @param dtoList list of entities
     * @return a list of new DTOs, using data from entities.
     */
    default List<DTO> create(Collection<ENTITY> dtoList) {
        return dtoList.stream().map(this::create).collect(Collectors.toList());
    }
}
