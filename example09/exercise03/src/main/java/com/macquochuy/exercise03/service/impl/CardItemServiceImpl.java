package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.CardItem;
import com.macquochuy.exercise03.Repository.CardItemRepository;
import com.macquochuy.exercise03.service.CardItemService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CardItemServiceImpl implements CardItemService {
    private CardItemRepository cardItemRepository;

    @Override
    public CardItem createCardItem(CardItem cardItem) {
        return cardItemRepository.save(cardItem);
    }

    @Override
    public CardItem getCardItemById(UUID cardItemId) {
        Optional<CardItem> optionalCardItem = cardItemRepository.findById(cardItemId);
        return optionalCardItem.orElse(null);
    }

    @Override
    public List<CardItem> getAllCardItems() {
        return cardItemRepository.findAll();
    }

    @Override
    public CardItem updateCardItem(CardItem cardItem) {
        Optional<CardItem> optionalExistingCardItem = cardItemRepository.findById(cardItem.getId());
        if (optionalExistingCardItem.isPresent()) {
            CardItem existingCardItem = optionalExistingCardItem.get();
            existingCardItem.setCard_id(cardItem.getCard_id());
            existingCardItem.setProduct_id(cardItem.getProduct_id());
            existingCardItem.setQuantity(cardItem.getQuantity());

            CardItem updatedCardItem = cardItemRepository.save(existingCardItem);
            return updatedCardItem;
        }

        return null;
    }

    @Override
    public void deleteCardItem(UUID cardItemId) {
        cardItemRepository.deleteById(cardItemId);
    }
}
