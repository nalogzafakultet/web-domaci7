package org.sekularac.domaci.services.impl;

import org.sekularac.domaci.dao.impl.DAOUsers;
import org.sekularac.domaci.entities.Users;
import org.sekularac.domaci.services.IServiceUsers;

public class ServiceUsers extends ServiceAbstract<Users, DAOUsers> implements IServiceUsers {

    public ServiceUsers(DAOUsers daoUsers) {
        super(daoUsers);
    }

    @Override
    public boolean login(String username, String password) {
        return getDao().login(username, password);
    }
}
