package by.tc.dao;

import by.tc.dao.builder.CardsProvider;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private CardsProvider provider = new CardsProvider();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public CardsProvider getProvider() {
        return provider;
    }
}
