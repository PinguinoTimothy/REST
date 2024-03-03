package ejem1;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;

import jakarta.annotation.Generated;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/deportistas")
public class Deportistas {

    String url = String.format("jdbc:mariadb://127.0.0.1:3306/ad_tema6");

    private Connection conexion;

    public void abrirConexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.conexion = DriverManager.getConnection(url, "root", "");
            if (this.conexion != null) {
                System.out.println("Conectado a add en 127.0.0.1");
            } else {
                System.out.println("No conectado a add en 127.0.0.1");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getLocalizedMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Código error: " + e.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            if (this.conexion != null) {
                this.conexion.close();

            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getLocalizedMessage());
        }
    }

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public ArrayList<Deportista> todos() {
        ArrayList<Deportista> lista = new ArrayList<>();

        abrirConexion();

        String query = "Select * from deportistas";
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                lista.add(new Deportista(rs.getInt("id"), rs.getString("nombre"), rs.getString("deporte"),
                        rs.getBoolean("activo"), rs.getString("genero")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response buscar_jugador(@PathParam("id") int id) {

        abrirConexion();

        String query = "Select * from deportistas where id = " + id;
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            rs.next();

            Deportista dep = new Deportista(rs.getInt("id"), rs.getString("nombre"), rs.getString("deporte"),
                    rs.getBoolean("activo"), rs.getString("genero"));
            return Response.ok(dep).build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontro el registro").build();
    }

    @GET
    @Path("deporte/{nombreDeporte}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response por_deporte(@PathParam("nombreDeporte") String deporte) {

        abrirConexion();

        String query = "Select * from deportistas where deporte = " + deporte;
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            rs.next();

            Deportista dep = new Deportista(rs.getInt("id"), rs.getString("nombre"), rs.getString("deporte"),
                    rs.getBoolean("activo"), rs.getString("genero"));
            return Response.ok(dep).build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontro el registro").build();
    }

    @GET
    @Path("activos")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response activos() {

        abrirConexion();

        String query = "Select * from deportistas where activo = true";
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            rs.next();

            Deportista dep = new Deportista(rs.getInt("id"), rs.getString("nombre"), rs.getString("deporte"),
                    rs.getBoolean("activo"), rs.getString("genero"));
            return Response.ok(dep).build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontro el registro").build();
    }

    @GET
    @Path("retirados")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response retirados() {

        abrirConexion();

        String query = "Select * from deportistas where activo = false";
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            rs.next();

            Deportista dep = new Deportista(rs.getInt("id"), rs.getString("nombre"), rs.getString("deporte"),
                    rs.getBoolean("activo"), rs.getString("genero"));
            return Response.ok(dep).build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontro el registro").build();
    }

    @GET
    @Path("masculinos")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response masculinos() {

        abrirConexion();

        String query = "Select * from deportistas where genero = 'Masculino'";
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            rs.next();

            Deportista dep = new Deportista(rs.getInt("id"), rs.getString("nombre"), rs.getString("deporte"),
                    rs.getBoolean("activo"), rs.getString("genero"));
            return Response.ok(dep).build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontro el registro").build();
    }

    @GET
    @Path("femeninos")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response femeninos() {

        abrirConexion();

        String query = "Select * from deportistas where genero = 'Femeninos'";
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            rs.next();

            Deportista dep = new Deportista(rs.getInt("id"), rs.getString("nombre"), rs.getString("deporte"),
                    rs.getBoolean("activo"), rs.getString("genero"));
            return Response.ok(dep).build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontro el registro").build();
    }

    @GET
    @Path("xg")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response deportes_por_genero() {

        abrirConexion();

        ArrayList<Deportista> deportistasMasculinos = new ArrayList<>();
        ArrayList<Deportista> deportistasFemeninos = new ArrayList<>();

        String query = "Select * from deportistas where genero = 'Masculino'";
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                deportistasMasculinos
                        .add(new Deportista(rs.getInt("id"), rs.getString("nombre"), rs.getString("deporte"),
                                rs.getBoolean("activo"), rs.getString("genero")));
            }

            query = "Select * from deportistas where genero = 'Femenino'";

            rs = statement.executeQuery(query);

            while (rs.next()) {

                deportistasFemeninos
                        .add(new Deportista(rs.getInt("id"), rs.getString("nombre"), rs.getString("deporte"),
                                rs.getBoolean("activo"), rs.getString("genero")));
            }

            ArrayList<ArrayList<Deportista>> arrays = new ArrayList<>();
            arrays.add(deportistasFemeninos);
            arrays.add(deportistasMasculinos);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontro el registro").build();
    }

    @GET
    @Path("/deporte/{nombreDeporte}/activos)")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response activos_por_deporte(@PathParam("nombreDeporte") String deporte) {

        abrirConexion();

        String query = "Select * from deportistas where activo = true and deporte = " + deporte;
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            rs.next();

            Deportista dep = new Deportista(rs.getInt("id"), rs.getString("nombre"), rs.getString("deporte"),
                    rs.getBoolean("activo"), rs.getString("genero"));
            return Response.ok(dep).build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontro el registro").build();
    }

    @GET
    @Path("/sdepor)")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response contar_deportistas() {

        abrirConexion();

        String query = "Select count(*) from deportistas ";
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            rs.next();
            return Response.ok("Hay un total de " + rs.getInt(1) + " deportistas").build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontro el registro").build();
    }

    @GET
    @Path("/deportes)")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response lista_deportes() {

        abrirConexion();
        ArrayList<String> deportes = new ArrayList<>();

        String query = "Select deporte from deportistas group by deporte asc";
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                deportes.add(rs.getString(1));
            }
            Response.ok(deportes).build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontro el registro").build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response crear_deportista(Deportista deportista) {

        abrirConexion();

        String query = "Insert into deportistas values (?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conexion.prepareStatement(query);

            ps.setInt(1, deportista.getId());
            ps.setString(2, deportista.getNombre());
            ps.setBoolean(3, deportista.isActivo());
            ps.setString(4, deportista.getGenero());
            ps.setString(5, deportista.getDeporte());

            ps.executeUpdate();
            ps.close();
            return Response.ok("Deportista añadido").build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return Response.status(Status.BAD_REQUEST).entity("No se ha añadido el deportista").build();
    }

    @POST
    @Path("adds")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response crear_deportistas(Deportista[] deportistas) {

        abrirConexion();

        String query = "Insert into deportistas values (?,?,?,?,?)";
        try {
            PreparedStatement ps;

            for (Deportista deportista : deportistas) {
                ps = this.conexion.prepareStatement(query);

                ps.setInt(1, deportista.getId());
                ps.setString(2, deportista.getNombre());
                ps.setBoolean(3, deportista.isActivo());
                ps.setString(4, deportista.getGenero());
                ps.setString(5, deportista.getDeporte());

                ps.executeUpdate();
                ps.close();
            }

            Response.ok("Deportistas añadidos").build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.BAD_REQUEST).entity("No se han añadido los deportistas").build();
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response actualizar_deportista(Deportista deportista) {

        abrirConexion();

        String query = "Update deportistas set nombre = ?, deporte = ?, activo = ?, genero = ? where id = ?";
        try {
            PreparedStatement ps;

            ps = this.conexion.prepareStatement(query);

            ps.setString(1, deportista.getNombre());
            ps.setString(2, deportista.getDeporte());
            ps.setBoolean(3, deportista.isActivo());
            ps.setString(4, deportista.getGenero());
            ps.setInt(5, deportista.getId());

            ps.executeUpdate();
            ps.close();

            Response.ok("Deportista modificado").build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.BAD_REQUEST).entity("No se ha modificado el deportista").build();
    }

    @DELETE
    @Path("del/{id}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response borrar_deportista(@PathParam("id") int id) {

        abrirConexion();

        String query = "delete from deportistas where id = " + id;
        try (Statement statement = this.conexion.createStatement()) {
            statement.executeUpdate(query);

            Response.ok("Deportista eliminado").build();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.BAD_REQUEST).entity("No se ha eliminado el deportista").build();
    }

    @GET
    @Path("img/{id}/{num}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces("image/jpg")
    public Response imagen_deportista(@PathParam("id") int id, @PathParam("num") int numImagen) {

        abrirConexion();

        String query = "select nombre from imagenes where nombre like '" + id + "_" + numImagen + "_%'";
        System.out.println(query);
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                File imagen = new File(
                        "C:\\Users\\ianro\\Documents\\GitHub\\REST\\tema5maven\\src\\main\\java\\ejem1\\imagenes\\"
                                + rs.getString(1));
                System.out.println(imagen.getAbsolutePath());
                return Response.ok(new FileInputStream(imagen)).build();
            } else
                return Response.status(Status.NOT_FOUND).entity("No se ha encontrado la imagen").build();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            return Response.status(Status.NOT_FOUND).entity("No se ha encontrado la imagen").build();
        } finally {
            cerrarConexion();
        }
        return Response.status(Status.NOT_FOUND).entity("No se ha encontrado la imagen").build();
    }

    @GET
    @Path("img/{id}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces(MediaType.TEXT_HTML)
    public String imagenes_deportistas(@PathParam("id") int id) {

        abrirConexion();

        String query = "select nombre from imagenes where id = " + id;
        try (Statement statement = this.conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            String resultado = "<html><title> Imagen</title><body>";

            while (rs.next()) {
                resultado += "<img src='C:\\Users\\ianro\\Documents\\GitHub\\REST\\tema5maven\\src\\main\\java\\ejem1\\imagenes\\"
                        + rs.getString(1) + "'><h1>" + rs.getString(1) + "</h1>";
            }

            resultado += "</body></html>";

            return resultado;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return "No se ha encontrado la imagen";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String buscarJugador(@PathParam("id") int id) {

        abrirConexion();

        try (Statement statement = conexion.createStatement()) {
            String query = "Select * from deportistas where id = " + id;
            ResultSet rs = statement.executeQuery(query);
            String html = "";
            if (rs.next()) {
                String activo;
                if (rs.getInt("activo") == 1) {
                    activo = "Activo";
                } else {
                    activo = "No Activo";
                }
                html = String.format(
                        "<h1>ID: %s</h1> <h1>Nombre: %s</h1> <h1>Activo: %s</h1><h1>Genero: %s</h1> <h1>Deporte: %s</h1>",
                        rs.getString("id"), rs.getString("nombre"), activo, rs.getString("genero"),
                        rs.getString("deporte"));
                System.out.println(html);

            }
            query = "Select * from imagenes where id = " + id;
            rs = statement.executeQuery(query);
            while (rs.next()) {

                html += String.format(
                        "<img src = 'C:\\Users\\ianro\\Documents\\GitHub\\REST\\tema5maven\\src\\main\\java\\ejem1\\imagenes\\%s'>",
                        rs.getString("nombre"));
                System.out.println(html);
            }
            return html;

        } catch (Exception e) {
        } finally {
            cerrarConexion();
        }
        return null;
    }
}
