package by.tc.dao;

import by.tc.dao.parser.CardsParser;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Card;

import java.util.List;

/**
 * This class parsers an XML-document using a CardsParser implementation for some parser type
 */
public final class CardsProvider {
    public static List<Card> createCards(CardsParser builder, String file) throws DAOException {
        builder.parse(file);
        return builder.getCards();
    }
}
