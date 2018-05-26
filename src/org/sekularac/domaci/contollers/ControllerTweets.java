package org.sekularac.domaci.contollers;



import org.sekularac.domaci.dao.impl.DAOTweets;
import org.sekularac.domaci.entities.Tweets;
import org.sekularac.domaci.services.IServiceTweets;
import org.sekularac.domaci.services.impl.ServiceTweets;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.Path;

@Stateless
@LocalBean
@Path("/tweets")
public class ControllerTweets {

    private IServiceTweets serviceTweets;

    public ControllerTweets() {
        this.serviceTweets = new ServiceTweets(new DAOTweets());
    }

    @GET
    @Produces("text/json")
    public List<Tweets> getAll() {
        return this.serviceTweets.getAll();
    }

    @POST
    @Consumes("application/json")
    public void add(Tweets tweet) {
        this.serviceTweets.add(tweet);
    }

    @GET
    @Path("/page/{pageNumber}")
    @Produces("text/json")
    public List<Tweets> pagination(@PathParam("pageNumber") int pageNumber) {
        return this.serviceTweets.getNextTweets(10, pageNumber);
    }

    @GET
    @Path("/search/{userName}")
    @Produces("text/json")
    public List<Tweets> searchByUsername(@PathParam("userName") String userName) {
        return this.serviceTweets.searchTweetsByUsername(userName);
    }
}
