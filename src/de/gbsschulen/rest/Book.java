package de.gbsschulen.rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@Entity
public class Book {

    @Id
    private int id;
    private String author;
    private String titel;
    private String isbn;


    public Book() {
    }

    public Book(int id, String author, String titel, String isbn) {
        this.id = id;
        this.author = author;
        this.titel = titel;
        this.isbn = isbn;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(author, book.author) &&
                Objects.equals(titel, book.titel) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, author, titel, isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", titel='" + titel + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
