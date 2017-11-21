package by.tc.dao.builder;

import by.tc.dao.exception.DAOException;
import by.tc.entity.Card;

import java.util.List;

public final class CardsProvider {
    public static List<Card> createCards(CardsBuilder builder, String file) throws DAOException {
        builder.buildCards(file);
        return builder.getCards();
    }
}
