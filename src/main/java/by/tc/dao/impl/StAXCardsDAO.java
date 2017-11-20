package by.tc.dao.impl;

import by.tc.dao.CardsDAO;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Card;

import java.util.List;

public class StAXCardsDAO implements CardsDAO {
    @Override
    public List<Card> parse(String file) throws DAOException {
        return null;
    }
}
