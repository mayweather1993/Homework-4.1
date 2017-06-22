package developer.controller;

import developer.dao.JavaIODeveloperDAOImpl;
import developer.model.Developer;

import java.util.Collection;

/**
 * Created by Zver on 21.06.2017.
 */
public class DeveloperController {
    private JavaIODeveloperDAOImpl javaIODeveloperDAO = new JavaIODeveloperDAOImpl();

    public void save(Developer developer) {
        javaIODeveloperDAO.save(developer);
    }

    public void update(Developer developerr) {
        javaIODeveloperDAO.update(developerr);
    }

    public Developer getById(Long id) {
        return javaIODeveloperDAO.getById(id);
    }

    public boolean remove(Developer developer) {
        return javaIODeveloperDAO.remove(developer);
    }

    public Collection<Developer> getAll() {
        return javaIODeveloperDAO.getAll();
    }
}


