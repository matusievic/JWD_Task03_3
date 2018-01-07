package by.tc.dao.parser;

import by.tc.dao.exception.DAOException;
import by.tc.entity.Card;

import java.util.List;

public interface CardsParser {
    void parse(String file) throws DAOException;
    List<Card> getCards();
}
