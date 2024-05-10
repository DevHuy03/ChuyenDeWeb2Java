package com.aaa.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.aaa.exercise03.entity.Card;

public interface CardService {

    Card createCard(Card card);

    Card getCardById(UUID cardId);

    List<Card> getAllCards();

    Card updateCard(Card card);
    
    void deleteCard(UUID cardId);
}