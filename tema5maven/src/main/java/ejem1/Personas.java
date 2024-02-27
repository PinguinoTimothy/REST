package ejem1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.xml.bind.annotation.XmlElement;

@Path("/personas")
public class Personas {
    

    static ArrayList<Persona> personas = new ArrayList<>();

    @POST
    @Consumes ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces  ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response guardar(Persona persona){
        personas.add(persona);
        return Response.ok(persona).build();
    }


    @GET
    @Produces (MediaType.APPLICATION_XML)
    public ArrayList<Persona> listar(){
        return Personas.personas;
    }

    @GET
    @Path("{nombre}")
    @Produces (MediaType.APPLICATION_JSON)
    public Persona ver(@PathParam("nombre") String nombre){
        for (Persona persona : Personas.personas) {
            if (persona.getNombre().equals(nombre)) {
                return persona;
            }
        }
        return null;
    }


    @GET
    @Path("buscar")
    @Produces (MediaType.APPLICATION_JSON)
    public ArrayList<Persona> ver2( @DefaultValue("ian") @QueryParam("nombre") String nombre){
        ArrayList<Persona> aux = new ArrayList<>();
        for (Persona persona : Personas.personas) {
            if (persona.getNombre().toUpperCase().contains(nombre.toUpperCase())) {
            aux.add(persona);
            }
        }
        return aux;

    }

    @POST
    @Path("add")
    @Consumes ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces  ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response multiAdd(Persona[] personas){
        Personas.personas.addAll(Arrays.asList(personas));
        return Response.ok(personas).build();
    }


    @DELETE
    @Path("id/{idPersona}")
    @Produces (MediaType.TEXT_PLAIN)
    public Response borrar(@PathParam("idPersona") int id){

        for (Persona persona : Personas.personas) {
            if (persona.getId() == id ) {
            Personas.personas.remove(persona);
            return Response.ok("Borrada satisfactoriamente").build();
            }
        }
        return  Response.status(Status.NO_CONTENT).entity("Sin datos").type("text/plain").build();

    }


    @GET
    @Path("XML")
    @Produces  ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response ejercicio10(@QueryParam("id") int id){

        for (Persona persona : Personas.personas) {
            if (persona.getId() == id ) {
          return Response.ok(persona).build();
            }
        }

      return  Response.status(Status.NO_CONTENT).entity("Sin datos").type("text/plain").build();

    }

    @GET
    @Path("galego/{id}")
    @Produces  ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response ejercicio11(@PathParam("id") int id){

        for (Persona persona : Personas.personas) {
            if (persona.getId() == id ) {
          return Response.ok(persona).build();
            }
        }

        return  Response.status(Status.NO_CONTENT).entity("Sin datos").type("text/plain").build();

    }
   
}
