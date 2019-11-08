/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DenniseSandoval
 */
@Path("student")
public class Student {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of student
     */
    public Student() {
    }

    /**
     * Retrieves representation of an instance of university.student
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() throws SQLException {
        DBCconnect conexion = new DBCconnect();
        ArrayList <Person> persona = new ArrayList();
        Person tempStudent;
        PreparedStatement consulta = conexion.connect().prepareStatement("SELECT * FROM student");
        ResultSet resultado = consulta.executeQuery();
        while (resultado.next()) {
            tempStudent = new Person(resultado.getInt("id"), resultado.getString("name"), resultado.getString("lastname"), resultado.getString("telephone"), resultado.getString("address"));
            persona.add(tempStudent);
        }
        return persona.toString();
    }
    /**
     * PUT method for updating or creating an instance of student
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
