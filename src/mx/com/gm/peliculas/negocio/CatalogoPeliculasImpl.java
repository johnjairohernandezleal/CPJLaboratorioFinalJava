/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.negocio;
import java.util.List;
import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;

/**
 *
 * @author john hernandez
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo){
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);
            datos.escribir(pelicula, nombreArchivo, anexar);
        } catch (AccesoDatosEx e) {
            System.out.println("error de acceso a datos");
            e.printStackTrace();
        }
    }
    
    public void listarPeliculas(String nombreArchivo){
        try {
            List<Pelicula> peliculas = datos.listar(nombreArchivo);
            for (Pelicula pelicula : peliculas) {
                System.out.println("Pelicula :" + pelicula);
                
            }
        } catch (AccesoDatosEx e) {
             System.out.println("error de acceso a datos");
            e.printStackTrace();
            
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        String resultado = null;
        try {
           resultado = datos.buscar(nombreArchivo, buscar);
           
                
            }catch (LecturaDatosEx e) {
            System.out.println("error al buscar la pelicula ");
            e.printStackTrace();
        } 
        System.out.println("Resultado de la busqueda :" + resultado);
        }
    
      @Override
      public void iniciarArchivo(String nombreArchivo){
          try {
              if (datos.existe(nombreArchivo)) {
                  datos.borrar(nombreArchivo);
                  datos.crear(nombreArchivo);
                  
              }else{
                  //creamos el archivo
                  datos.crear(nombreArchivo);
              }
          } catch (AccesoDatosEx e) {
              System.out.println("Error acceso a datos");
              e.printStackTrace();
          }
        
    }
    
    
    
    
    
}
