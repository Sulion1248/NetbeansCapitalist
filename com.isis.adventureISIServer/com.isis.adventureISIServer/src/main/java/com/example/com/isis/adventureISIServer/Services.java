/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.com.isis.adventureISIServer;

import generated.World;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author tschwarz
 */
public class Services {
    public World russie;
    
    
    
    public void saveWorldToXml(String username,World world) throws JAXBException{
    JAXBContext cont = JAXBContext.newInstance(World.class);
    Marshaller m = cont.createMarshaller();
    m.marshal(world, new File(username+"Russie.xml"));
    }

    public World readWorldFromXml(String username) {
        try {JAXBContext cont = JAXBContext.newInstance(World.class);
    Unmarshaller u = cont.createUnmarshaller();
    System.out.print(u sername);
    russie = (World) u.unmarshal(new File(username+"Russie.xml"));}
    catch (Exception e) {
        try {JAXBContext cont = JAXBContext.newInstance(World.class);
    Unmarshaller u = cont.createUnmarshaller();
    russie = (World) u.unmarshal(new File("Russie.xml"));
        System.out.print("Monde de base");}
    catch (Exception f) {
        e.printStackTrace();
        }
    }
    return russie;
    }
}
