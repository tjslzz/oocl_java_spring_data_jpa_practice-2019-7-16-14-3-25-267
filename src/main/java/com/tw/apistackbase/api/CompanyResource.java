package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Company;
import com.tw.apistackbase.core.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(produces = {"application/json"})
    public Iterable<Company> list() {
        return companyRepository.findAll();
    }
    
    @PostMapping(produces = {"application/json"})
    public Company add(@RequestBody Company company) {
        companyRepository.save(company);
        return company;
    }

    @PutMapping(produces = {"application/json;charset=UTF-8"})
    public Company put(@RequestBody Company company){
        companyRepository.save(company);
        return company;
    }

    @DeleteMapping
    public String delete(@RequestParam(value = "id",required = false) Long id){
        if (id == null){
            companyRepository.deleteAll();
        }
        else {
            companyRepository.deleteById(Long.valueOf(id));
        }
        return "ok";
    }

    @DeleteMapping("/{id}")
    public String deleteByPath(@PathVariable Long id){
        companyRepository.deleteById(id);
        return "ok";
    }

    @GetMapping("/{name}")
    public Company findByName(@PathVariable String name){
        return companyRepository.findByName(name);
    }

}
