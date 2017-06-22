package developer.dao;
import java.util.Collection;

/**
 * Created by Zver on 20.06.2017.
 */
public interface GenericDAO<T , ID> {
    void save(T entity);
    void update(T entity);
    T getById(ID id);
    boolean remove(T entity);
    Collection<T>getAll();


}
