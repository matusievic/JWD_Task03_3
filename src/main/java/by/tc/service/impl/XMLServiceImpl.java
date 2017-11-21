package by.tc.service.impl;

import by.tc.dao.builder.CardsBuilderFactory;
import by.tc.dao.builder.CardsProvider;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Card;
import by.tc.service.XMLService;
import by.tc.service.exception.ServiceException;

import java.util.List;

public class XMLServiceImpl implements XMLService {
    @Override
    public List<Card> parse(String parser, String file) throws ServiceException {
        List<Card> cards;
        try {
            cards = CardsProvider.createCards(CardsBuilderFactory.getInstance().getSAXBuilder(), file);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return cards;
    }
}
