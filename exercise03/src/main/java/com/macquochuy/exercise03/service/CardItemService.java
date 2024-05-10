package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.CardItem;

public interface CardItemService {

    CardItem createCardItem(CardItem cardItem);

    CardItem getCardItemById(UuidGenerator cardItemId);

    List<CardItem> getAllCardItems();

    CardItem updateCardItem(CardItem cardItem);
    
    void deleteCardItem(UuidGenerator cardItemId);
}