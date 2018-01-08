package by.tc.dao.builder;

import by.tc.entity.Author;
import by.tc.entity.Card;
import by.tc.entity.enums.Theme;
import by.tc.entity.enums.Type;
import by.tc.entity.enums.Valuable;

import java.util.ArrayList;
import java.util.List;

public final class CardBuilder {
    private String id;
    private boolean sent;
    private String country;
    private int year;
    private List<Author> authors;
    private boolean hasAuthor;
    private Theme theme;
    private Valuable valuable;
    private Type type;

    public CardBuilder() {}

    public CardBuilder id(String id) {
        this.id = id;
        return this;
    }

    public CardBuilder sent(boolean sent) {
        this.sent = sent;
        return this;
    }

    public CardBuilder country(String country) {
        this.country = country;
        return this;
    }

    public CardBuilder year(int year) {
        this.year = year;
        return this;
    }

    public CardBuilder authors(List<Author> authors) {
        this.authors = authors;
        return this;
    }

    public CardBuilder hasAuthor(boolean hasAuthor) {
        this.hasAuthor = hasAuthor;
        return this;
    }

    public CardBuilder theme(Theme theme) {
        this.theme = theme;
        return this;
    }

    public CardBuilder valuable(Valuable valuable) {
        this.valuable = valuable;
        return this;
    }

    public CardBuilder type(Type type) {
        this.type = type;
        return this;
    }

    public Card build() {
        Card card = new Card();

        card.setId(id);
        card.setSent(sent);
        card.setCountry(country);
        card.setYear(year);
        card.setAuthors((authors != null) ? authors : new ArrayList<Author>());
        card.setHasAuthor(hasAuthor);
        card.setTheme(theme);
        card.setValuable(valuable);
        card.setType(type);

        return card;

        new CardBuilder().id("ID-0").hasAuthor(true).build();
    }
}
