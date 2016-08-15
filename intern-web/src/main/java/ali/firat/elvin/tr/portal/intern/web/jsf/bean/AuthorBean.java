package ali.firat.elvin.tr.portal.intern.web.jsf.bean;

import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import ali.firat.elvin.tr.portal.intern.core.framework.service.AuthorServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Authors;
import ali.firat.elvin.tr.portal.intern.web.jsf.converter.AuthorConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yektan on 27.07.2016.
 */

@Component("authorBean")
@Scope("session")
public class AuthorBean implements Serializable {

    private Authors authors = new Authors();
    private AuthorServiceImpl authorService = new AuthorServiceImpl();
    private NavigatorBean navi = new NavigatorBean();
    private List<Authors> allAuths;
    private AuthorConverter conv = new AuthorConverter();

    //////////////////////////////////////////////////////////////////
    // GETTER SETTER ////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public NavigatorBean getNavi() {
        return navi;
    }

    public void setNavi(NavigatorBean navi) {
        this.navi = navi;
    }

    @Autowired
    public void setAuthorService(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    public AuthorServiceImpl getAuthorService() {
        return authorService;
    }

    public void setAllAuths(List<Authors> allAuths) {
        this.allAuths = allAuths;
    }

    public List<Authors> getAllAuths() {
        return allAuths;
    }


    //////////////////////////////////////////////////////////////////////////////
    ////////////////////FUNCTIONS ///////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    public void createAuthor(Authors author) throws DaoException {
        authorService.save(author);
    }

    public void deleteAuthor(int id) throws DaoException {
        authorService.delete(id);
    }


    public Authors findAuthor(int id) throws DaoException {
        authors = authorService.get(id);
        return authors;
    }

    public List<Authors> findAllAuthors() throws DaoException {
        allAuths = authorService.findAll();
        return allAuths;
    }


    public void updateAuthor(Authors authors) throws DaoException {
        authorService.update(authors);
    }
}
