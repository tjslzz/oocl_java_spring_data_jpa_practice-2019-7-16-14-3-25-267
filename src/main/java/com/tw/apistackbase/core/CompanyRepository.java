package com.tw.apistackbase.core;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company,Long> {
    Company findByName(String name);

}
