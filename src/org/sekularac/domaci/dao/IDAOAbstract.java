package org.sekularac.domaci.dao;

import org.sekularac.domaci.entities.BasicEntity;

import java.util.List;

public interface IDAOAbstract<T extends BasicEntity> {
    public boolean add(T entity);
    public boolean removeById(int id);
    public boolean update(T entity);
    public List<T> getAll();
    public T getById(int id);
}
