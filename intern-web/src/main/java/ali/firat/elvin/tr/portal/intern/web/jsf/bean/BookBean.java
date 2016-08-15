package ali.firat.elvin.tr.portal.intern.web.jsf.bean;

import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import ali.firat.elvin.tr.portal.intern.core.framework.service.AuthorServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.framework.service.BooksServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.framework.service.GenreServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Authors;
import ali.firat.elvin.tr.portal.intern.core.model.Books;
import ali.firat.elvin.tr.portal.intern.core.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

/**
 * Created by yektan on 27.07.2016.
 */

@Component("bookBean")
@Scope("session")
public class BookBean implements Serializable {

    private Books books = new Books();
    private BooksServiceImpl booksService = new BooksServiceImpl();
    private AuthorServiceImpl authorService = new AuthorServiceImpl();
    private NavigatorBean navi = new NavigatorBean();
    private Authors author = new Authors();
    private Genre genre = new Genre();
    private Set<Authors> authorsSet = new HashSet<Authors>();
    private Set<Genre> genreSet = new HashSet<Genre>();
    private List<Books> booksList = new ArrayList<Books>();
    private GenreServiceImpl genreService = new GenreServiceImpl();


    public GenreServiceImpl getGenreService() {
        return genreService;
    }

    @Autowired
    public void setGenreService(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    public AuthorServiceImpl getAuthorService() {
        return authorService;
    }

    @Autowired
    public void setAuthorService(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setGenreSet(Set<Genre> genreSet) {
        this.genreSet = genreSet;
    }

    public Set<Genre> getGenreSet() {
        return genreSet;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public NavigatorBean getNavi() {
        return navi;
    }

    public void setNavi(NavigatorBean navi) {
        this.navi = navi;
    }

    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    @Autowired
    public void setBooksService(BooksServiceImpl booksService) {
        this.booksService = booksService;
    }

    public BooksServiceImpl getBooksService() {
        return booksService;
    }

    public Books findBook(int id) throws DaoException {
        books = booksService.get(id);
        return books;
    }

    public List<Books> findAllBooks() throws DaoException {
        booksList = booksService.findAll();
        return booksList;
    }

    public String getAuthorName(Books book) {
        String name = "";
        String fullname = "";
        for (Authors au : book.getAuthors()) {
            int size = book.getAuthors().size();
            if (size > 1) {
                name = au.getName() + " ";
                fullname = name + au.getSurname() + ", ";
            } else {
                name = au.getName() + " ";
                fullname = name + au.getSurname();
            }
        }
        return fullname;
    }

    public String getGenreName(Books book) {
        String name = "";
        for (Genre ge : book.getGenres()) {
            name = name + ge.getName();
        }
        return name;
    }

    public void createEverything(Books book, Integer id, Integer id2) throws DaoException {
        author = authorService.get(id);
        genre = genreService.get(id2);
        genreSet.clear();
        genreSet.add(genre);
        authorsSet.clear();
        authorsSet.add(author);
        book.setAuthors(authorsSet);
        book.setGenres(genreSet);
        booksService.save(book);
    }

    public void updateBook(Books book, Integer id, Integer id2) throws DaoException {
        author = authorService.get(id);
        genre = genreService.get(id2);
        genreSet.clear();
        genreSet.add(genre);
        authorsSet.clear();
        authorsSet.add(author);
        book.setAuthors(authorsSet);
        book.setGenres(genreSet);
        booksService.update(book);
    }

    public void deleteBook(int id) throws DaoException {
        booksService.delete(id);
    }

}
