package by.tc.service;

import by.tc.dao.parser.CardsParser;
import by.tc.dao.parser.CardsParserFactory;
import by.tc.service.exception.ServiceException;

import java.util.HashMap;
import java.util.Map;

public final class CardsParserProvider {
    private static final Map<String, CardsParser> parsers = new HashMap<>();

    static {
            parsers.put("SAX", CardsParserFactory.getInstance().getSAXBuilder());
            parsers.put("StAX", CardsParserFactory.getInstance().getStAXBuilder());
            parsers.put("DOM", CardsParserFactory.getInstance().getDOMBuilder());
    }

    public static CardsParser getParser(String type) throws ServiceException {
        CardsParser parser = parsers.get(type);
        if (parser == null) {
            throw new ServiceException("Incorrect parser type");
        }
        return parser;
    }
}
