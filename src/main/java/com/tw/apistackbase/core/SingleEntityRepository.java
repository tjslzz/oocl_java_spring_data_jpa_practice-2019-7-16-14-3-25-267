package com.tw.apistackbase.core;

import org.springframework.data.repository.CrudRepository;

public interface SingleEntityRepository extends CrudRepository<SingleEntity,Long> {
}
