package org.sekularac.domaci.dao;

import org.sekularac.domaci.dao.impl.DAOAbstractDatabase;
import org.sekularac.domaci.entities.Users;

public class DAOUsers extends DAOAbstractDatabase<Users> implements IDAOAbstract<Users> {

    public DAOUsers() {
        super(Users.class);
    }
}
