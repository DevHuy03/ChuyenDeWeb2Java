package com.aaa.exercise03.service;

import java.util.List;

import com.aaa.exercise03.entity.Sell;

public interface SellService {

    Sell createSell(Sell sell);

    Sell getSellById(Integer sellId);

    List<Sell> getAllSells();

    Sell updateSell(Sell sell);

    void deleteSell(Integer sellId);
    
}