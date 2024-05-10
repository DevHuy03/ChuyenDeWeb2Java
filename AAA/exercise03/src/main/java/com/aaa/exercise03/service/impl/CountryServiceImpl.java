package com.aaa.exercise03.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.aaa.exercise03.Repository.CountryRepository;
import com.aaa.exercise03.entity.Country;
import com.aaa.exercise03.service.CountryService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country getCountryById(Integer countryId) {
        Optional<Country> optionalCountry = countryRepository.findById(countryId);
        return optionalCountry.orElse(null);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country updateCountry(Country country) {
        Optional<Country> optionalExistingCountry = countryRepository.findById(country.getId());
        if (optionalExistingCountry.isPresent()) {
            Country existingCountry = optionalExistingCountry.get();
            existingCountry.setIso(country.getIso());
            existingCountry.setName(country.getName());
            existingCountry.setUpper_name(country.getUpper_name());
            existingCountry.setIso3(country.getIso3());
            existingCountry.setNum_code(country.getNum_code());
            existingCountry.setPhone_code(country.getPhone_code());
            Country updatedCountry = countryRepository.save(existingCountry);
            return updatedCountry;
        }

        return null;
    }

    @Override
    public void deleteCountry(Integer countryId) {
        countryRepository.deleteById(countryId);
    }
}
