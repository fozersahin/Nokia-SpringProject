package ali.firat.elvin.tr.portal.intern.web.jsf.bean;

import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import ali.firat.elvin.tr.portal.intern.core.framework.service.GenreServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yektan on 27.07.2016.
 */

@Component("genreBean")
@Scope("session")
public class GenreBean implements Serializable {

    private Genre genre = new Genre();
    private GenreServiceImpl genreService = new GenreServiceImpl();
    private NavigatorBean navi = new NavigatorBean();
    private List<Genre> allGenres;

    public List<Genre> getAllGenres() {
        return allGenres;
    }

    public void setAllGenres(List<Genre> allGenres) {
        this.allGenres = allGenres;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public GenreServiceImpl getGenreService() {
        return genreService;
    }

    @Autowired
    public void setGenreService(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    public NavigatorBean getNavi() {
        return navi;
    }

    public void setNavi(NavigatorBean navi) {
        this.navi = navi;
    }

    public void createGenre(Genre genre) throws DaoException {
        genreService.save(genre);
        this.genre=null;
    }

    public void deleteGenre(int id) throws DaoException {
        genreService.delete(id);
    }

    public Genre findGenre(int id) throws DaoException {
        genre = genreService.get(id);
        return genre;
    }

    public List<Genre> findAllGenres() throws DaoException {
            allGenres = genreService.findAll();
        return allGenres;
    }

    public void updateGenre(Genre genre) throws DaoException {
        genreService.update(genre);
    }
}
