package org.sekularac.domaci.dao;

import org.sekularac.domaci.entities.BasicEntity;

import java.util.List;

public interface IDAOAbstract<T extends BasicEntity> {
    public boolean add(T object);
    public boolean removeById(int id);
    public boolean update(T object);
    public List<T> getAll();
    public T getById(int id);
}
