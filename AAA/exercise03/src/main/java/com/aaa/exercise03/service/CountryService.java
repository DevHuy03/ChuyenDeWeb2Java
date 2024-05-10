package com.aaa.exercise03.service;

import java.util.List;

import com.aaa.exercise03.entity.Country;

public interface CountryService {

    Country createCountry(Country country);

    Country getCountryById(Integer countryId);

    List<Country> getAllCountries();

    Country updateCountry(Country country);
    
    void deleteCountry(Integer countryId);
}