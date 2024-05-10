package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.CardItem;

public interface CardItemService {

    CardItem createCardItem(CardItem cardItem);

    CardItem getCardItemById(UUID cardItemId);

    List<CardItem> getAllCardItems();

    CardItem updateCardItem(CardItem cardItem);
    
    void deleteCardItem(UUID cardItemId);
}