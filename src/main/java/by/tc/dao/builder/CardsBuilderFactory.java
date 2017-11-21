package by.tc.dao.builder;

import by.tc.dao.builder.impl.CardsSAXBuilder;
import by.tc.dao.exception.DAOException;

public final class CardsBuilderFactory {
    private static final CardsBuilderFactory instance = new CardsBuilderFactory();

    public static CardsBuilderFactory getInstance() {
        return instance;
    }

    public CardsBuilder getSAXBuilder() {
        return new CardsSAXBuilder();
    }

    public CardsBuilder getStAXBuilder() {
        return null;
    }

    public CardsBuilder getDOMBuilder() {
        return null;
    }
}
