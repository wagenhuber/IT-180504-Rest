package de.gbsschulen.rest2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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


    public Book find(int id) {
        return em.find(Book.class, id);
    }


    public Book getBook(int id) {
        return find(id);
    }

    public List<Book> getAllBooks() {
        TypedQuery<Book> typedQuery = em.createQuery("select b from Book b", Book.class);
        return typedQuery.getResultList();
    }

    public Book deleteBook(int id) {
        Book book = find(id);
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
        return book;
    }


    public void addBook(int id, String titel, String author, String isbn) {
        Book book = new Book(id, titel, author, isbn);
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }




}
