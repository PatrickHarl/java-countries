package com.lambdaschool.projectcountriessearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/age")
public class CountryAgeController {

    // http://localhost:2019/age/age/25
    @GetMapping(value = "/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getAllCountriesByMedianAge(@PathVariable long age) {

        List<Country> rtnCountries = ProjectCountriesSearchApplication.ourCountryList.findCountries(c -> c.getMedianAge() >= age);

        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

    }

    // http://localhost:2019/age/min
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryMinMedianAge() {

        ProjectCountriesSearchApplication.ourCountryList.countryList.sort((c1, c2) -> (int)(c1.getMedianAge() - c2.getMedianAge()));

        return new ResponseEntity<>(ProjectCountriesSearchApplication.ourCountryList.countryList.get(0), HttpStatus.OK);

    }

    // http://localhost:2019/age/max
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryMaxMedianAge() {

        ProjectCountriesSearchApplication.ourCountryList.countryList.sort((c1, c2) -> (int)(c2.getMedianAge() - c1.getMedianAge()));

        return new ResponseEntity<>(ProjectCountriesSearchApplication.ourCountryList.countryList.get(0), HttpStatus.OK);

    }

    // http://localhost:2019/age/median
    @GetMapping(value = "/median", produces = {"application/json"})
    public ResponseEntity<?> getCountryMedianMedianAge() {

        ProjectCountriesSearchApplication.ourCountryList.countryList.sort((c1, c2) -> (int)(c2.getMedianAge() - c1.getMedianAge()));

        long medianAgeIndex = (int)(ProjectCountriesSearchApplication.ourCountryList.countryList.size() / 2) -1;

        return new ResponseEntity<>(ProjectCountriesSearchApplication.ourCountryList.countryList.get((int)medianAgeIndex), HttpStatus.OK);

    }

}
