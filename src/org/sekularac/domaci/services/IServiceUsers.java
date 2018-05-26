package org.sekularac.domaci.services;

import org.sekularac.domaci.entities.Users;

public interface IServiceUsers extends IServiceAbstract<Users> {
    boolean login(String username, String password);
}
