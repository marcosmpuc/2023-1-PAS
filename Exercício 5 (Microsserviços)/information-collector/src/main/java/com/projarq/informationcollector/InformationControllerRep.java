package com.projarq.informationcollector;

import org.springframework.data.repository.CrudRepository;

public interface InformationControllerRep extends CrudRepository<Information,Long> {
    @Override
    <S extends Information> S save(S entity);
}
