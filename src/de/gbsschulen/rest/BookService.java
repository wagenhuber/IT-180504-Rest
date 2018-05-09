package de.gbsschulen.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


public class BookService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public BookService() {
        emf = Persistence.createEntityManagerFactory("books");
        em = emf.createEntityManager();
    }

    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }

    }


    public Book getBooks(int id) {
        return em.find(Book.class, id);
    }


    public List<Book> getAllBooks() {
        TypedQuery<Book> typedQuery = em.createQuery("SELECT b from Book b", Book.class);
        return typedQuery.getResultList();

    }



    public static void main(String[] args) {
        BookService bookService = new BookService();

        Book book = bookService.getBooks(2);
        System.out.println(book);
        bookService.close();

    }

}
