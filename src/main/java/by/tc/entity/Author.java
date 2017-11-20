package by.tc.entity;

import java.io.Serializable;

public class Author implements Serializable {
    private static final long serialVersionUID = 6979987522943389518L;
    private String name;
    private String surname;
    private boolean isKnown;

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isKnown() {
        return isKnown;
    }

    public void setKnown(boolean known) {
        isKnown = known;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Author author = (Author) o;

        if (isKnown != author.isKnown) { return false; }
        if (name != null ? !name.equals(author.name) : author.name != null) { return false; }
        return surname != null ? surname.equals(author.surname) : author.surname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (isKnown ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ", surname=" + surname + ", isKnown=" + isKnown + ']';
    }
}
