package by.tc.entity;

import by.tc.entity.enums.Theme;
import by.tc.entity.enums.Type;
import by.tc.entity.enums.Valuable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Card implements Serializable {
    private static final long serialVersionUID = 3949634838122577255L;
    private String id;
    private boolean sent;
    private String country;
    private int year;
    private List<Author> authors = new ArrayList<>();
    private boolean hasAuthor;
    private Theme theme;
    private Valuable valuable;
    private Type type;

    public Card() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public boolean isHasAuthor() {
        return hasAuthor;
    }

    public void setHasAuthor(boolean hasAuthor) {
        this.hasAuthor = hasAuthor;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Valuable getValuable() {
        return valuable;
    }

    public void setValuable(Valuable valuable) {
        this.valuable = valuable;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || getClass() != obj.getClass()) { return false; }

        Card card = (Card) obj;

        if (sent != card.sent) { return false; }
        if (year != card.year) { return false; }
        if (hasAuthor != card.hasAuthor) { return false; }
        if (id != null ? !id.equals(card.id) : card.id != null) { return false; }
        if (country != null ? !country.equals(card.country) : card.country != null) { return false; }
        if (authors != null ? !authors.equals(card.authors) : card.authors != null) { return false; }
        if (theme != card.theme) { return false; }
        if (valuable != card.valuable) { return false; }
        return type == card.type;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sent ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (hasAuthor ? 1 : 0);
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (valuable != null ? valuable.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + id + ", sent=" + sent + ", country=" + country + ", year=" + year
                + ", authors=" + authors + ", hasAuthor=" + hasAuthor + ", theme=" + theme + ", valuable=" + valuable + ", type=" + type + ']';
    }
}
