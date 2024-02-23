package ejem1;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/persona")
public class GestionaPersona {

    static Persona persona;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Persona leer(){
            if (GestionaPersona.persona != null) {
                return GestionaPersona.persona;
            } else {
                Persona c = new Persona();
                c.setNombre("Ford");
                c.setSexo("Focus");
                c.setId(1);
                c.setCasado(false);
                GestionaPersona.persona = c;
                return GestionaPersona.persona;
            }
    
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response guardar(Persona persona){
        GestionaPersona.persona = persona;
        return Response.ok(persona).build();

    }
    
}
