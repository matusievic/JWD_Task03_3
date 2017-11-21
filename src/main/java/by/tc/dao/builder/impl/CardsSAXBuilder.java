package by.tc.dao.builder.impl;

import by.tc.dao.builder.CardsBuilder;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Author;
import by.tc.entity.Card;
import by.tc.entity.enums.Theme;
import by.tc.entity.enums.Type;
import by.tc.entity.enums.Valuable;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a CardsBuilder class implementation for the SAX parser
 */
public class CardsSAXBuilder implements CardsBuilder {
    private List<Card> cards = new ArrayList<>();
    private CardsHandler ch;
    private XMLReader reader;
    private static Logger logger = Logger.getLogger("log4j");

    public CardsSAXBuilder() {
        ch = new CardsHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(ch);
        } catch (SAXException e) {
            logger.log(Level.WARNING, "Exception: " + e.getMessage());
        }
    }

    @Override
    public void buildCards(String file) throws DAOException {
        try {
            reader.parse(new InputSource(file));
        } catch (SAXException | IOException e) {
            logger.log(Level.WARNING, "Exception: " + e.getMessage());
            throw new DAOException(e);
        }
        cards = ch.getCards();
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }


    /**
     * This is a nested handler-class for the SAX parser
     */
    static class CardsHandler extends DefaultHandler {
        private List<Card> cards = new ArrayList<>();
        private Card currentCard;
        private StringBuilder buffer;
        private List<Author> authors;
        private Author currentAuthor;

        public List<Card> getCards() {
            return cards;
        }

        @Override
        public void startDocument() throws SAXException {
            logger.log(Level.INFO, "PARSING STARTED");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            logger.log(Level.INFO, "START ELEMENT -> " + "uri= " + uri + " , localName= " + " , qName=" + qName);

            CardParams param = CardParams.valueOf(qName.toUpperCase().replace(':', '_'));
            buffer = new StringBuilder();
            switch (param) {
                case CARD:
                    currentCard = new Card();
                    currentCard.setId(attributes.getValue("id"));
                    if (attributes.getLength() == 2) {
                        currentCard.setSent(Boolean.parseBoolean(attributes.getValue("isSent")));
                    }
                    break;
                case AUTHORS:
                    authors = new ArrayList<>();
                    break;
                case AUTHOR:
                    currentAuthor = new Author();
                    if (attributes.getLength() == 1) {
                        currentCard.setAuthorKnown(Boolean.parseBoolean(attributes.getValue("isSent")));
                    }
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            logger.log(Level.INFO, "CHARACTERS    -> " + ch);
            buffer.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            logger.log(Level.INFO, "END ELEMENT   -> " + "uri= " + uri + " , localName= " + " , qName=" + qName);

            CardParams param = CardParams.valueOf(qName.toUpperCase().replace(':', '_'));
            switch (param) {
                case CARD:
                    cards.add(currentCard);
                    break;
                case COUNTRY:
                    currentCard.setCountry(buffer.toString());
                    break;
                case YEAR:
                    currentCard.setYear(Integer.parseInt(buffer.toString()));
                    break;
                case AUTHORS:
                    currentCard.setAuthors(authors);
                    break;
                case AUTHOR:
                    authors.add(currentAuthor);
                    break;
                case NAME:
                    currentAuthor.setName(buffer.toString());
                    break;
                case SURNAME:
                    currentAuthor.setSurname(buffer.toString());
                    break;
                case THEME:
                    currentCard.setTheme(Theme.valueOf(buffer.toString().toUpperCase()));
                    break;
                case VALUABLE:
                    currentCard.setValuable(Valuable.valueOf(buffer.toString().toUpperCase()));
                    break;
                case TYPE:
                    currentCard.setType(Type.valueOf(buffer.toString().toUpperCase()));
            }
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            logger.log(Level.WARNING, "WARNING: line " + e.getLineNumber() + " : " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            logger.log(Level.WARNING, "ERROR: line " + e.getLineNumber() + " : " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            logger.log(Level.WARNING, "FATAL ERROR: line " + e.getLineNumber() + " : " + e.getMessage());
        }
    }
}
