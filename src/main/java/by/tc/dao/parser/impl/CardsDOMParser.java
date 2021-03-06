package by.tc.dao.parser.impl;

import by.tc.dao.builder.CardBuilder;
import by.tc.dao.parser.CardsParser;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Author;
import by.tc.entity.Card;
import by.tc.entity.enums.Theme;
import by.tc.entity.enums.Type;
import by.tc.entity.enums.Valuable;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a CardsParser class implementation for the DOM parser
 */
public class CardsDOMParser implements CardsParser {
    private List<Card> cards;
    private DOMParser paser;
    private Document document;
    private Element root;
    private NodeList nodes;
    private static final Logger logger = Logger.getLogger(CardsDOMParser.class);

    @Override
    public void parse(String file) throws DAOException {
        try {
            paser = new DOMParser();
            paser.parse(file);
        } catch (SAXException | IOException e) {
            logger.error("Exception: " + e.getMessage());
            throw new DAOException(e);
        }

        document = paser.getDocument();
        logger.info("Parser started");
        root = document.getDocumentElement();
        logger.info("Root received");
        cards = new ArrayList<>();
        nodes = root.getElementsByTagName("card");

        for (int i = 0; i < nodes.getLength(); i++) {
            logger.info("CARD READING STARTED");
            CardBuilder card = new CardBuilder();
            Element currentElement = (Element) nodes.item(i);
            card.id(currentElement.getAttribute("id"));
            logger.info("Card -> id read");
            card.sent(Boolean.parseBoolean(currentElement.getAttribute("isSent")));
            logger.info("Card -> isSent read");
            card.country(getSingleChildValue(currentElement, "country"));
            logger.info("Card -> country read");
            card.year(Integer.parseInt(getSingleChildValue(currentElement, "year")));
            logger.info("Card -> year read");
            NodeList authorNodes = currentElement.getElementsByTagName("authors");
            logger.info("Card -> authors received");
            List<Author> authors = new ArrayList<>();
            for (int j = 0; j < authorNodes.getLength(); j++) {
                Author author = new Author();
                Element currentAuthor = (Element) authorNodes.item(j);
                author.setName(getSingleChildValue(currentAuthor, "name"));
                logger.info("Card -> Author -> name read");
                author.setSurname(getSingleChildValue(currentElement, "surname"));
                logger.info("Card -> Author -> surname read");
                author.setSalary(Float.parseFloat(getSingleChildValue(currentElement, "salary")));
                authors.add(author);
            }

            card.authors(authors);
            if (authorNodes.getLength() > 0) {
                card.hasAuthor(Boolean.parseBoolean(getSingleChild(currentElement, "authors").getAttribute("isKnown")));
                logger.info("Card -> isKnown read");
            }
            card.theme(Theme.valueOf(getSingleChildValue(currentElement, "theme").toUpperCase()));
                logger.info("Card -> theme read");
            card.valuable(Valuable.valueOf(getSingleChildValue(currentElement, "valuable").toUpperCase()));
                logger.info("Card -> valuable read");
            card.type(Type.valueOf(getSingleChildValue(currentElement, "type").toUpperCase()));
            logger.info("Card -> type read");
            cards.add(card.build());
            logger.info("CARD READING ENDED");
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
