package com.lambdaschool.projectcountriessearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/population")
public class CountryPopController {

        // http://localhost:2019/population/size/1000000000
        @GetMapping(value = "/size/{people}", produces = {"application/json"})
        public ResponseEntity<?> getAllCountriesByPopulationSize(@PathVariable long people) {

            List<Country> rtnCountries = ProjectCountriesSearchApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people);

            return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

        }

        // http://localhost:2019/population/min
        @GetMapping(value = "/min", produces = {"application/json"})
        public ResponseEntity<?> getCountryMinPop() {

            ProjectCountriesSearchApplication.ourCountryList.countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));

            return new ResponseEntity<>(ProjectCountriesSearchApplication.ourCountryList.countryList.get(0), HttpStatus.OK);

        }

        // http://localhost:2019/population/max
        @GetMapping(value = "/max", produces = {"application/json"})
        public ResponseEntity<?> getCountryMaxPop() {

            ProjectCountriesSearchApplication.ourCountryList.countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));

            return new ResponseEntity<>(ProjectCountriesSearchApplication.ourCountryList.countryList.get(0), HttpStatus.OK);

        }

        // http://localhost:2019/population/median
        @GetMapping(value = "/median", produces = {"application/json"})
        public ResponseEntity<?> getCountryPopMedian() {

            ProjectCountriesSearchApplication.ourCountryList.countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));


            int index = (int)(ProjectCountriesSearchApplication.ourCountryList.countryList.size() / 2) -1;


            return new ResponseEntity<>(ProjectCountriesSearchApplication.ourCountryList.countryList.get(index), HttpStatus.OK);

        }

}
