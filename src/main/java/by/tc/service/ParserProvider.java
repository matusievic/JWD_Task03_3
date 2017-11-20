package by.tc.service;

import by.tc.dao.CardsDAO;
import by.tc.dao.DAOFactory;
import by.tc.service.exception.ServiceException;

import java.util.HashMap;
import java.util.Map;

public final class ParserProvider {
    private static final Map<String, CardsDAO> parsers = new HashMap<>();

    static {
        parsers.put("SAX", DAOFactory.getInstance().getSAXCardsDAO());
        parsers.put("StAX", DAOFactory.getInstance().getStAXCardsDAO());
        parsers.put("DOM", DAOFactory.getInstance().getDOMCardsDAO());
    }

    public CardsDAO getParser(String type) throws ServiceException {
        CardsDAO parser = parsers.get(type);
        if (parser == null) {
            throw new ServiceException("Incorrect parser type");
        }
        return parser;
    }
}
