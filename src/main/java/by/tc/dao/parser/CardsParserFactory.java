package by.tc.dao.parser;

import by.tc.dao.parser.impl.CardsDOMParser;
import by.tc.dao.parser.impl.CardsSAXParser;
import by.tc.dao.parser.impl.CardsStAXParser;

/**
 * This is a factory class for different CardBuilder implementations
 */
public final class CardsParserFactory {
    private static final CardsParserFactory instance = new CardsParserFactory();

    public static CardsParserFactory getInstance() {
        return instance;
    }

    public CardsParser getSAXBuilder() {
        return new CardsSAXParser();
    }

    public CardsParser getStAXBuilder() {
        return new CardsStAXParser();
    }

    public CardsParser getDOMBuilder() {
        return new CardsDOMParser();
    }
}
