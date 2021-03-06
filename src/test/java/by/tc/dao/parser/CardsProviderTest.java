package by.tc.dao.parser;

import by.tc.dao.CardsProvider;
import by.tc.dao.parser.impl.CardsDOMParser;
import by.tc.dao.parser.impl.CardsSAXParser;
import by.tc.dao.parser.impl.CardsStAXParser;
import by.tc.dao.exception.DAOException;
import by.tc.entity.Author;
import by.tc.entity.Card;
import by.tc.entity.enums.Theme;
import by.tc.entity.enums.Type;
import by.tc.entity.enums.Valuable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardsProviderTest {
    static List<Card> expected;

    @BeforeAll
    static void setUp() {
        expected = new ArrayList<>();
        //CARD #1
        Card card = new Card();
        card.setId("ID-0");
        card.setSent(false);
        card.setCountry("Belarus");
        card.setYear(1993);
        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setName("Mikita");
        author.setSurname("Jurevic");
        author.setSalary(2);
        authors.add(author);
        card.setHasAuthor(true);
        card.setAuthors(authors);
        card.setTheme(Theme.ARCHITECTURE);
        card.setValuable(Valuable.COLLECTIBLE);
        card.setType(Type.ORDINARY);
        expected.add(card);

        //CARD #2
        card = new Card();
        card.setId("ID-1");
        card.setSent(false);
        card.setCountry("Lithuania");
        card.setYear(2003);
        card.setAuthors(new ArrayList<Author>());
        card.setHasAuthor(false);
        card.setTheme(Theme.ARCHITECTURE);
        card.setValuable(Valuable.THEMATIC);
        card.setType(Type.CONGRATULATORY);
        expected.add(card);

        //CARD #3
        card = new Card();
        card.setId("ID-2");
        card.setSent(false);
        card.setCountry("Finland");
        card.setYear(1998);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("John");
        author.setSurname("Makarainen");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.CITY);
        card.setValuable(Valuable.THEMATIC);
        card.setType(Type.PROMOTIONAL);
        expected.add(card);

        //CARD #4
        card = new Card();
        card.setId("ID-3");
        card.setSent(false);
        card.setCountry("Belarus");
        card.setYear(2008);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Dzmitryj");
        author.setSurname("Kuzmienka");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.SPORT);
        card.setValuable(Valuable.THEMATIC);
        card.setType(Type.PROMOTIONAL);
        expected.add(card);

        //CARD #5
        card = new Card();
        card.setId("ID-4");
        card.setSent(false);
        card.setCountry("UK");
        card.setYear(2003);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Mike");
        author.setSurname("Shakespeare");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.ARCHITECTURE);
        card.setValuable(Valuable.COLLECTIBLE);
        card.setType(Type.CONGRATULATORY);
        expected.add(card);

        //CARD #6
        card = new Card();
        card.setId("ID-5");
        card.setSent(false);
        card.setCountry("Poland");
        card.setYear(2012);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Kasia");
        author.setSurname("Wozniak");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.NATURE);
        card.setValuable(Valuable.COLLECTIBLE);
        card.setType(Type.ORDINARY);
        expected.add(card);

        //CARD #7
        card = new Card();
        card.setId("ID-6");
        card.setSent(false);
        card.setCountry("USA");
        card.setYear(1992);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("John");
        author.setSurname("Doe");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.RELIGION);
        card.setValuable(Valuable.COLLECTIBLE);
        card.setType(Type.ORDINARY);
        expected.add(card);

        //CARD #8
        card = new Card();
        card.setId("ID-7");
        card.setSent(false);
        card.setCountry("BSSR");
        card.setYear(1932);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Vasil");
        author.setSurname("Mickievic");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.CITY);
        card.setValuable(Valuable.HISTORICAL);
        card.setType(Type.ORDINARY);
        expected.add(card);

        //CARD #9
        card = new Card();
        card.setId("ID-8");
        card.setSent(false);
        card.setCountry("Latvia");
        card.setYear(2001);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Andris");
        author.setSurname("Shnarskis");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.CITY);
        card.setValuable(Valuable.COLLECTIBLE);
        card.setType(Type.CONGRATULATORY);
        expected.add(card);

        //CARD #10
        card = new Card();
        card.setId("ID-9");
        card.setSent(false);
        card.setCountry("Norway");
        card.setYear(1901);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Eric");
        author.setSurname("Bjorndalen");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.NATURE);
        card.setValuable(Valuable.HISTORICAL);
        card.setType(Type.ORDINARY);
        expected.add(card);

        //CARD #11
        card = new Card();
        card.setId("ID-10");
        card.setSent(false);
        card.setCountry("Belarus");
        card.setYear(1992);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Valiancin");
        author.setSurname("Zakreuski");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.RELIGION);
        card.setValuable(Valuable.COLLECTIBLE);
        card.setType(Type.ORDINARY);
        expected.add(card);

        //CARD #12
        card = new Card();
        card.setId("ID-11");
        card.setSent(false);
        card.setCountry("BSSR");
        card.setYear(1927);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Jakub");
        author.setSurname("Kolas");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.ARCHITECTURE);
        card.setValuable(Valuable.HISTORICAL);
        card.setType(Type.ORDINARY);
        expected.add(card);

        //CARD #13
        card = new Card();
        card.setId("ID-12");
        card.setSent(false);
        card.setCountry("Estonia");
        card.setYear(2000);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Lena");
        author.setSurname("Harma");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.ARCHITECTURE);
        card.setValuable(Valuable.COLLECTIBLE);
        card.setType(Type.PROMOTIONAL);
        expected.add(card);

        //CARD #14
        card = new Card();
        card.setId("ID-13");
        card.setSent(false);
        card.setCountry("BSSR");
        card.setYear(1955);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Kastus");
        author.setSurname("Davydzionak");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.NATURE);
        card.setValuable(Valuable.HISTORICAL);
        card.setType(Type.ORDINARY);
        expected.add(card);

        //CARD #15
        card = new Card();
        card.setId("ID-14");
        card.setSent(false);
        card.setCountry("Germany");
        card.setYear(2009);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Magdalena");
        author.setSurname("Noiner");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.NATURE);
        card.setValuable(Valuable.THEMATIC);
        card.setType(Type.PROMOTIONAL);
        expected.add(card);

        //CARD #16
        card = new Card();
        card.setId("ID-15");
        card.setSent(true);
        card.setCountry("Belarus");
        card.setYear(2012);
        authors = new ArrayList<>();
        author = new Author();
        author.setName("Anastasia");
        author.setSurname("Dubarezava");
        author.setSalary(1);
        authors.add(author);
        card.setAuthors(authors);
        card.setHasAuthor(true);
        card.setTheme(Theme.ARCHITECTURE);
        card.setValuable(Valuable.THEMATIC);
        card.setType(Type.ORDINARY);
        expected.add(card);
    }

    @Test
    void createCardsUsingSAX() {
        List<Card> actual = null;
        try {
            actual = CardsProvider.createCards(new CardsSAXParser(), "src/main/resources/xml/oldcards.xml");
        } catch (DAOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        assertEquals(expected, actual);
    }

    @Test
    void createCardsUsingStAX() {
        List<Card> actual = null;
        try {
            actual = CardsProvider.createCards(new CardsStAXParser(), "src/main/resources/xml/oldcards.xml");
        } catch (DAOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        assertEquals(expected, actual);
    }

    @Test
    void createCardsUsingDOM() {
        List<Card> actual = null;
        try {
            actual = CardsProvider.createCards(new CardsDOMParser(), "src/main/resources/xml/oldcards.xml");
        } catch (DAOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        assertEquals(expected, actual);
    }
}