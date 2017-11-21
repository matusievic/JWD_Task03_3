package by.tc.service.impl;

import by.tc.dao.builder.CardsBuilderFactory;
import by.tc.dao.CardsProvider;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Card;
import by.tc.service.CardsBuilderProvider;
import by.tc.service.XMLService;
import by.tc.service.exception.ServiceException;

import java.util.List;

public class XMLServiceImpl implements XMLService {
    private  List<Card> cards;
    @Override
    public List<Card> parse(String parser, String file) throws ServiceException {
        try {
            cards = CardsProvider.createCards(CardsBuilderProvider.getBuilder(parser), file);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return cards;
    }

    @Override
    public List<Card> parse(int recordsPerPage, int currentPage) {
        return cards.subList(recordsPerPage * currentPage, (currentPage + 1) * recordsPerPage);
    }

    @Override
    public int getPageCount(int recordsPerPage) {
        if (cards == null) {
            return 0;
        }
        return cards.size() / recordsPerPage;
    }


}
