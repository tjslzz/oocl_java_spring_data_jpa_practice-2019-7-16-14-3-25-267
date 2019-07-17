package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Company;
import com.tw.apistackbase.core.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
