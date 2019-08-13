/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpjlaboratoriofinal;
import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

/**
 *
 * @author john hernandez
 */
public class CPJLaboratorioFinal {
    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo ="C:\\Users\\john hernandez\\Desktop\\pruebafinal\\prueba.txt";
    private static final CatalogoPeliculas catalogoPeli = new CatalogoPeliculasImpl();
    
    
    public static void main(String[] args) {
        
        /**
         * mientras la opcion elegida sea 0, preguntamos al usuario
         */
        
        while (opcion!=0) {
            try {
                System.out.println("Elige la Opcion: \n1-Iniciar catalogo peliculas"
                + "\n2.agregar pelicula\n"
                +"\n3.listar peliculas\n"
                +"\n4.buscar peliculas\n"
                +"\n0.salir");
                
                opcion = Integer.parseInt(scanner.nextLine());
                switch(opcion){
                    case 1:
                        catalogoPeli.iniciarArchivo(nombreArchivo);
                        break;
                        case 2:
                            catalogoPeli.agregarPelicula(nombreArchivo, nombreArchivo);
                            break;
                            case 3:
                                catalogoPeli.listarPeliculas(nombreArchivo);
                                break;
                                case 4:
                                    catalogoPeli.buscarPelicula(nombreArchivo, nombreArchivo);
                                    break;
                                    case 0:
                                        System.out.println("hasta pronto");
                                        break;
                                        
                                        default:
                                            System.out.println("la opcion no es correcta");
                                            break;
                }
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println("error!");
            }
            
            
        }
       
    }
    
}
