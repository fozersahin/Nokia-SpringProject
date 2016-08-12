package ali.firat.elvin.tr.portal.intern.web.jsf.converter;

import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import ali.firat.elvin.tr.portal.intern.core.framework.service.AuthorServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Authors;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import ali.firat.elvin.tr.portal.intern.web.jsf.bean.AuthorBean;
import ali.firat.elvin.tr.portal.intern.web.jsf.bean.NavigatorBean;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by yektan on 5.08.2016.
 */
@FacesConverter("authorConverter")
public class AuthorConverter implements Converter,Serializable {

    private List<Authors> authors = new ArrayList<>();
    private AuthorServiceImpl au = new AuthorServiceImpl();
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AuthorConverter.class);

    public void setAu(AuthorServiceImpl au) {
        this.au = au;
    }
    public AuthorServiceImpl getAu() {
        return au;
    }
    public List<Authors> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            authors = au.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if (authors.toString().contains(value)) {
            logger.info("SONUC : ", authors.toString().contains(value));
            return this;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
