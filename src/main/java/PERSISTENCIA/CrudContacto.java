/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PERSISTENCIA;

//import com.mysql.jdbc.Connection;
import LOGICA.Contacto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CrudContacto extends Conexion {
    PreparedStatement ps;
    ResultSet rs;
    
    
     public boolean ingresar (Contacto persona){
        
        Connection conexion = getConnection();
        try{
            ps = conexion.prepareStatement("insert into persona(nombre, apellido, "
                    + "tipoIdentificacion, telefono, dirección, correo  )"+ " values (?,?,?,?,?,?,?)");
           
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getTipoIdentificacion());
            ps.setString(4, persona.getTelefono());
            ps.setString(5, persona.getDirección());
            ps.setString(6, persona.getCorreo());
            
           int consulta = ps.executeUpdate();
           if(consulta>0){
               return true;
           }
           else{
               return false;
           }
        }catch(Exception e)
                {
                    System.out.println("Error: "+ e);
                    return false;
        }
        finally{
            try{
            
                conexion.close();
            }
            catch(Exception e){
                System.out.println("Error: "+ e);
                return false;
            }
        }
    
    }
    
    public boolean actualizar (Contacto persona){
        
        Connection conexion = getConnection();
        try{
            ps = conexion.prepareStatement("update persona set nombre=?, apellido=?, "
                    + "tipoIdentificacion=?, telefono=?, dirección=?, correo=? where id=? )"+"");
           
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getTipoIdentificacion());
            ps.setString(4, persona.getTelefono());
            ps.setString(5, persona.getDirección());
            ps.setString(6, persona.getCorreo());
            
           int consulta = ps.executeUpdate();
           if(consulta>0){
               return true;
           }
           else{
               return false;
           }
        }catch(Exception e)
                {
                    System.out.println("Error: "+ e);
                    return false;
        }
        finally{
            try{
            
                conexion.close();
            }
            catch(Exception e){
                System.out.println("Error: "+ e);
                return false;
            }
        }
    
    }
    
    public boolean eliminar (Contacto persona){
        
        Connection conexion = getConnection();
        try{
            ps = conexion.prepareStatement("delete from persona where id=? ");
           
           ps.setInt(1, persona.getIdentificacion());
            
           int consulta = ps.executeUpdate();
           if(consulta>0){
               return true;
           }
           else{
               return false;
           }
        }catch(Exception e)
                {
                    System.out.println("Error: "+ e);
                    return false;
        }
        finally{
            try{
            
                conexion.close();
            }
            catch(Exception e){
                System.out.println("Error: "+ e);
                return false;
            }
        }
    
    }
    
    public boolean consultar (Contacto persona){
        
        Connection conexion = getConnection();
        try{
            ps = conexion.prepareStatement("select * from persona where id=?");
           
           ps.setInt(1, persona.getIdentificacion());
           rs = ps.executeQuery();
           
           int consulta = ps.executeUpdate();
           if(consulta>0){
               return true;
           }
           else{
               return false;
           }
        }catch(Exception e)
                {
                    System.out.println("Error: "+ e);
                    return false;
        }
        finally{
            try{
            
                conexion.close();
            }
            catch(Exception e){
                System.out.println("Error: "+ e);
                return false;
            }
        }
    
    }
}
