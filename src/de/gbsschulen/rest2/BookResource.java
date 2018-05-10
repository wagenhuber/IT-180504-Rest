package de.gbsschulen.rest2;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bookstore2")
public class BookResource {

    private BookService bookService = new BookService();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Book getBook(@PathParam("id") int id) {
        return bookService.getBook(id);
    }

    @GET
    @Path("/query/")
    public Book getBookWithQueryParam(@QueryParam("id") int id) {
        return bookService.getBook(id);
    }


    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    @Path("{id}")
    public String deleteBook(@PathParam("id") int id) {
        return bookService.deleteBook(id).toString();
    }


    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/insert/")
    public String addBook(@QueryParam("id") int id,@QueryParam("titel") String titel,@QueryParam("author") String author,@QueryParam("isbn") String isbn) {
        bookService.addBook(id, titel, author, isbn);
        return "Object angelegt!";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/insert/")
    public String editBook(@QueryParam("id") int id,@QueryParam("titel") String titel,@QueryParam("author") String author,@QueryParam("isbn") String isbn) {
        bookService.addBook(id, titel, author, isbn);
        return "Object geändert!";
    }


}
