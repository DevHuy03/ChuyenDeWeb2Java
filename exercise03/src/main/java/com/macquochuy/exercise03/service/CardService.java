package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Card;

public interface CardService {

    Card createCard(Card card);

    Card getCardById(UuidGenerator cardId);

    List<Card> getAllCards();

    Card updateCard(Card card);
    
    void deleteCard(UuidGenerator cardId);
}