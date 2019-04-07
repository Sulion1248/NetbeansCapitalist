/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.com.isis.adventureISIServer;

import generated.World;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 *
 * @author tschwarz
 */
@Path("generic")
public class Webservice {
    Services services;
    
    public Webservice(){
        services = new Services();
    }
    
    @GET
    @Path("world")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getXml(@Context HttpServletRequest request){
        String username= request.getHeader("X-user");
        return Response.ok(services.readWorldFromXml(username)).build();
    }
  
    @PUT
    @Path("save")
    @Consumes(MediaType.APPLICATION_XML)
    public void getWorld(@Context HttpServletRequest request,String data) throws JAXBException{
        String username= request.getHeader("X-user");
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        World world=gson.fromJson(data, World.class) ;
        services.saveWorldToXml(username, world);
    }
        
        
    
    
}
