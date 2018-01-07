package by.tc.dao.parser.impl;

import by.tc.dao.builder.CardBuilder;
import by.tc.dao.parser.CardsParser;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Author;
import by.tc.entity.Card;
import by.tc.entity.enums.Theme;
import by.tc.entity.enums.Type;
import by.tc.entity.enums.Valuable;
import com.sun.org.apache.xerces.internal.impl.PropertyManager;
import com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a CardsParser class implementation for the StAX parser
 */
public class CardsStAXParser implements CardsParser {
    private List<Card> cards = new ArrayList<>();
    private XMLStreamReader reader;
    private static Logger logger = Logger.getLogger("log4j");
    private CardBuilder currentCard;
    private CardParams currentElement;
    private List<Author> authors;
    private Author currentAuthor;

    @Override
    public void parse(String file) throws DAOException {
        try {
            reader = new XMLStreamReaderImpl(new FileInputStream(file), new PropertyManager(PropertyManager.CONTEXT_READER));
            logger.log(Level.INFO, "Parsing started");
            process(reader);
            logger.log(Level.INFO, "Parsing ended");
        } catch (FileNotFoundException | XMLStreamException e) {
            logger.log(Level.WARNING, "Exception: " + e.getMessage());
            throw new DAOException(e);
        }
    }

    private void process(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    logger.log(Level.INFO, "START ELEMENT -> " + reader.getLocalName());
                    processStartElement();
                    break;
                case XMLStreamConstants.CHARACTERS:
                    logger.log(Level.INFO, "CHARACTERS    -> " + reader.getText().trim());
                    processCharacters();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    logger.log(Level.INFO, "END ELEMENT   -> " + reader.getLocalName());
                    processEndElement();
                    break;
            }
        }
    }


    private void processStartElement() {
        currentElement = CardParams.valueOf(reader.getLocalName().toUpperCase().replace(':', '_'));
        switch (currentElement) {
            case CARD:
                currentCard = new CardBuilder();
                currentCard.id(reader.getAttributeValue("", "id"));
                if (reader.getAttributeCount() == 2) {
                    currentCard.sent(Boolean.parseBoolean(reader.getAttributeValue("", "isSent")));
                }
                break;
            case AUTHORS:
                authors = new ArrayList<>();
                currentCard.hasAuthor(Boolean.parseBoolean(reader.getAttributeValue("", "isKnown")));
                break;
            case AUTHOR:
                currentAuthor = new Author();
                if (reader.getAttributeCount() == 1) {
                    currentCard.hasAuthor(Boolean.parseBoolean(reader.getAttributeValue("", "isSent")));
                }
                break;
        }
    }


    private void processCharacters() {
        String value = reader.getText().trim();

        if (value.isEmpty()) {
            return;
        }

        switch (currentElement) {
            case COUNTRY:
                currentCard.country(value);
                break;
            case YEAR:
                currentCard.year(Integer.parseInt(value));
                break;
            case NAME:
                currentAuthor.setName(value);
                break;
            case SURNAME:
                currentAuthor.setSurname(value);
                break;
            case THEME:
                currentCard.theme(Theme.valueOf(value.toUpperCase()));
                break;
            case VALUABLE:
                currentCard.valuable(Valuable.valueOf(value.toUpperCase()));
                break;
            case TYPE:
                currentCard.type(Type.valueOf(value.toUpperCase()));
        }
    }

    private void processEndElement() {
        currentElement = CardParams.valueOf(reader.getLocalName().toUpperCase().replace(':', '_'));

        switch (currentElement) {
            case AUTHOR:
                authors.add(currentAuthor);
                break;
            case AUTHORS:
                currentCard.authors(authors);
                break;
            case CARD:
                cards.add(currentCard.build());
                break;
        }
    }


    @Override
    public List<Card> getCards() {
        return cards;
    }
}
