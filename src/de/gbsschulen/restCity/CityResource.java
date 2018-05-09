package de.gbsschulen.restCity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cities")
public class CityResource {

    private CityService cityService = new CityService();

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public City getCity(@PathParam("id") int id) {
        City city = cityService.getCity(id);
        return city;
    }


}
