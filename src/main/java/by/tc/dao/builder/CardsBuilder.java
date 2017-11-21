package by.tc.dao.builder;

import by.tc.dao.exception.DAOException;
import by.tc.entity.Card;

import java.util.List;

public interface CardsBuilder {
    void buildCards(String file) throws DAOException;
    List<Card> getCards();
}
