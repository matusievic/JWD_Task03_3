package by.tc.service.impl;

import by.tc.dao.CardsProvider;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Card;
import by.tc.service.CardsParserProvider;
import by.tc.service.XMLService;
import by.tc.service.exception.ServiceException;

import java.util.List;

public class XMLServiceImpl implements XMLService {
    private  List<Card> cards;
    @Override
    public List<Card> parse(String parser, String file) throws ServiceException {
        try {
            cards = CardsProvider.createCards(CardsParserProvider.getParser(parser), file);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return cards;
    }

    @Override
    public List<Card> getPageRecords(int recordsPerPage, int currentPage) {
        return cards.subList(recordsPerPage * (currentPage - 1), (currentPage * recordsPerPage > cards.size())? cards.size(): (currentPage * recordsPerPage));
    }

    @Override
    public int getPageCount(int recordsPerPage) {
        if (cards == null) {
            return 0;
        }
        return cards.size() / recordsPerPage;
    }


}
