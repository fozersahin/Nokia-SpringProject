package ali.firat.elvin.tr.portal.intern.core.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yektan on 26.07.2016.
 */
@Entity
@Table(name = "Genre",catalog = "intern")
public class Genre implements Serializable{
    private int id;
    private String name;
    private Set<Books> books = new HashSet<Books>();


    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != genre.id) return false;
        if (name != null ? !name.equals(genre.name) : genre.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "genres")
    public Set<Books> getBooks() {
        return books;
    }
    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}
