package de.gbsschulen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/bookstore")
public class BookResource {

    private BookService bookService = new BookService();

    //http://localhost:8080/rest/bookstore/1

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book getBook(@PathParam("id") int id) {
        Book book = bookService.getBooks(id);
        return book;
    }


    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

}
