package com.lambdaschool.projectcountriessearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/names")
public class CountryController {

    // http://localhost:2019/names/all
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {

        ProjectCountriesSearchApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(ProjectCountriesSearchApplication.ourCountryList.countryList, HttpStatus.OK);

    }

    // http://localhost:2019/names/start/u
    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getAllCountriesByNameFirstLetter(@PathVariable char letter) {

        ProjectCountriesSearchApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        List<Country> rtnCountries = ProjectCountriesSearchApplication.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));

        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

    }

    // http://localhost:2019/names/size/20
    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getAllCountriesByNameSize(@PathVariable long number) {

        ProjectCountriesSearchApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        List<Country> rtnCountries = ProjectCountriesSearchApplication.ourCountryList.findCountries(c -> c.getName().length() >= (int)number);

        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

    }

}
