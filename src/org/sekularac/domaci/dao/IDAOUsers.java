package org.sekularac.domaci.dao;

import org.sekularac.domaci.dao.IDAOAbstract;
import org.sekularac.domaci.entities.Users;

public interface IDAOUsers extends IDAOAbstract<Users> {
    boolean login(String username, String password);
}
