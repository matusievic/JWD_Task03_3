package by.tc.dao.builder;

import by.tc.dao.builder.impl.CardsDOMBuilder;
import by.tc.dao.builder.impl.CardsSAXBuilder;
import by.tc.dao.builder.impl.CardsStAXBuilder;

/**
 * This is a factory class for different CardBuilder implementations
 */
public final class CardsBuilderFactory {
    private static final CardsBuilderFactory instance = new CardsBuilderFactory();

    public static CardsBuilderFactory getInstance() {
        return instance;
    }

    public CardsBuilder getSAXBuilder() {
        return new CardsSAXBuilder();
    }

    public CardsBuilder getStAXBuilder() {
        return new CardsStAXBuilder();
    }

    public CardsBuilder getDOMBuilder() {
        return new CardsDOMBuilder();
    }
}
