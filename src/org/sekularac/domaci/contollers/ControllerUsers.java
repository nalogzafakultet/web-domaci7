package org.sekularac.domaci.contollers;

import org.sekularac.domaci.dao.impl.DAOUsers;
import org.sekularac.domaci.entities.Users;
import org.sekularac.domaci.services.IServiceUsers;
import org.sekularac.domaci.services.impl.ServiceUsers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;

@Stateless
@LocalBean
@Path("/users")
public class ControllerUsers {

    private IServiceUsers serviceUsers;

    public ControllerUsers() {
        this.serviceUsers = new ServiceUsers(new DAOUsers());
    }

    @POST
    @Consumes("application/json")
    @Produces("text/json")
    public boolean registerUser(Users user) {
        return this.serviceUsers.add(user);
    }

    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("text/json")
    public boolean login(String username, String password) {
        return serviceUsers.login(username, password);
    }

}
