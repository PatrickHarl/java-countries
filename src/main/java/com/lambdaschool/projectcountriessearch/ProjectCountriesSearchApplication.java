package com.lambdaschool.projectcountriessearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectCountriesSearchApplication {

    public static CountryList ourCountryList;

    public static void main(String[] args) {

        ourCountryList = new CountryList();
        SpringApplication.run(ProjectCountriesSearchApplication.class, args);
    }

}
