package by.tc.service;

import by.tc.dao.builder.CardsBuilder;
import by.tc.dao.builder.CardsBuilderFactory;
import by.tc.service.exception.ServiceException;

import java.util.HashMap;
import java.util.Map;

public final class CardsBuilderProvider {
    private static final Map<String, CardsBuilder> builders = new HashMap<>();

    static {
            builders.put("SAX", CardsBuilderFactory.getInstance().getSAXBuilder());
            builders.put("StAX", CardsBuilderFactory.getInstance().getStAXBuilder());
            builders.put("DOM", CardsBuilderFactory.getInstance().getDOMBuilder());
    }

    public static CardsBuilder getParser(String type) throws ServiceException {
        CardsBuilder builder = builders.get(type);
        if (builder == null) {
            throw new ServiceException("Incorrect parser type");
        }
        return builder;
    }
}
