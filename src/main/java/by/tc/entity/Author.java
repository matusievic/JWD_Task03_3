package by.tc.entity;

import java.io.Serializable;
import java.util.Objects;

public class Author implements Serializable {
    private static final long serialVersionUID = 6979987522943389518L;
    private String name;
    private String surname;
    private float salary;

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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Author author = (Author) o;

        if (!Objects.equals(name, author.name)) { return false; }
        if (!Objects.equals(surname, author.surname)) { return false; }
        if (!Objects.equals(salary, author.salary)) { return false; }
        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Objects.hashCode(surname);
        result = 31 * result + (int) salary;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ", surname=" + surname + ']';
    }
}
