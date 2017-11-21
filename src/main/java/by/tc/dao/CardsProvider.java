package by.tc.dao;

import by.tc.dao.builder.CardsBuilder;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Card;

import java.util.List;

/**
 * This class parsers an XML-document using a CardsBuilder implementation for some parser type
 */
public final class CardsProvider {
    public static List<Card> createCards(CardsBuilder builder, String file) throws DAOException {
        builder.buildCards(file);
        return builder.getCards();
    }
}
