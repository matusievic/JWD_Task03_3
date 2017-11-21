package by.tc.dao.builder.impl;

import by.tc.dao.builder.CardsBuilder;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Author;
import by.tc.entity.Card;
import by.tc.entity.enums.Theme;
import by.tc.entity.enums.Type;
import by.tc.entity.enums.Valuable;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a CardsBuilder class implementation for the DOM parser
 */
public class CardsDOMBuilder implements CardsBuilder {
    private List<Card> cards;
    private DOMParser paser;
    private Document document;
    private Element root;
    private NodeList nodes;
    private static Logger logger = Logger.getLogger("log4j");

    @Override
    public void buildCards(String file) throws DAOException {
        try {
            paser = new DOMParser();
            paser.parse(file);
        } catch (SAXException | IOException e) {
            logger.log(Level.WARNING, "Exception: " + e.getMessage());
            throw new DAOException(e);
        }
        document = paser.getDocument();
        logger.log(Level.INFO, "Parser started");
        root = document.getDocumentElement();
        logger.log(Level.INFO, "Root received");
        cards = new ArrayList<>();
        nodes = root.getElementsByTagName("card");
        for (int i = 0; i < nodes.getLength(); i++) {
            logger.log(Level.INFO, "CARD READING STARTED");
            Card card = new Card();
            Element currentElement = (Element) nodes.item(i);
            card.setId(currentElement.getAttribute("id"));
            logger.log(Level.INFO, "Card -> id read");
            card.setSent(Boolean.parseBoolean(currentElement.getAttribute("isSent")));
            logger.log(Level.INFO, "Card -> isSent read");
            card.setCountry(getSingleChildValue(currentElement, "country"));
            logger.log(Level.INFO, "Card -> country read");
            card.setYear(Integer.parseInt(getSingleChildValue(currentElement, "year")));
            logger.log(Level.INFO, "Card -> year read");
            NodeList authorNodes = currentElement.getElementsByTagName("authors");
            logger.log(Level.INFO, "Card -> authors received");
            List<Author> authors = new ArrayList<>();
            for (int j = 0; j < authorNodes.getLength(); j++) {
                Author author = new Author();
                Element currentAuthor = (Element) authorNodes.item(j);
                author.setName(getSingleChildValue(currentAuthor, "name"));
                logger.log(Level.INFO, "Card -> Author -> name read");
                author.setSurname(getSingleChildValue(currentElement, "surname"));
                logger.log(Level.INFO, "Card -> Author -> surname read");
                authors.add(author);
            }
            card.setAuthors(authors);
            if (authorNodes.getLength() > 0) {
                card.setAuthorKnown(Boolean.parseBoolean(getSingleChild(currentElement, "authors").getAttribute("isKnown")));
                logger.log(Level.INFO, "Card -> isKnown read");
            }
            card.setTheme(Theme.valueOf(getSingleChildValue(currentElement, "theme").toUpperCase()));
                logger.log(Level.INFO, "Card -> theme read");
            card.setValuable(Valuable.valueOf(getSingleChildValue(currentElement, "valuable").toUpperCase()));
                logger.log(Level.INFO, "Card -> valuable read");
            card.setType(Type.valueOf(getSingleChildValue(currentElement, "type").toUpperCase()));
            logger.log(Level.INFO, "Card -> type read");
            cards.add(card);
            logger.log(Level.INFO, "CARD READING ENDED");
        }
    }

    private Element getSingleChild(Element element, String childName) {
        NodeList nodeList = element.getElementsByTagName(childName);
        return (Element) nodeList.item(0);
    }

    private String getSingleChildValue(Element element, String childName) {
        return getSingleChild(element, childName).getTextContent().trim();
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }
}
