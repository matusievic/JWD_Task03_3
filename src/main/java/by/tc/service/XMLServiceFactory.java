package by.tc.service;

import by.tc.service.impl.XMLServiceImpl;

public final class XMLServiceFactory {
    private final XMLServiceFactory instance = new XMLServiceFactory();
    private final XMLService xmlService = new XMLServiceImpl();

    private XMLServiceFactory() {}

    public XMLServiceFactory getInstance() {
        return instance;
    }

    public XMLService getXmlService() {
        return xmlService;
    }
}
