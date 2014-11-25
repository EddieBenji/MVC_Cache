package Clases;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

/**
 *
 * @author Lalo
 */
public class ControladorCache {

    private JCS jcsCache;

    public ControladorCache() {
    }

    /**
     * Este método es el encargado de cargar el archivo de configuración de la
     * caché. Si se desea manipular la caché, será este método que se deba
     * llamar en primer lugar.
     */
    public void configLoad() {
        try {
            // Se carga el cache usando el archivo de configuracion
            jcsCache = JCS.getInstance("mvcDetailsCache");
        } catch (CacheException ex) {
            ex.printStackTrace();
        }
    }


    /**
     *Método encargado de agregar la información del candidato a la caché.
     * @param id es el identificador del objeto que se introducirá a la caché.
     * @param objeto es el objeto que se introducirá a la caché.
     */
    public void put(int id, Cacheable objeto) {
        String ID = String.valueOf(id);
        try {
            jcsCache.put(ID, objeto);
            
        } catch (CacheException ex) {
            System.out.println("**ERROR!**");
            ex.printStackTrace();
        }

    }

    /**
     * Método encargado de devolver de la caché, el candidato que se desea, a
     * partir de la clave que se le pase.
     *
     * @param claveObjeto, que es el identificador del candidato que se desea
     * obtener de la caché.
     * @return el objeto del candidato.
     */
    public Cacheable get(int claveObjeto) {
        String id = String.valueOf(claveObjeto);
        return  (Cacheable) jcsCache.get(id);
    }
    
    /**
     * Método encargado de limpiar la caché. (la deja sin datos completamente)
     */
    public void limpiarCache() {
        try {
            jcsCache.clear();
        } catch (CacheException ex) {
            System.out.println("**ERROR!**");
            ex.printStackTrace();
        }
    }
    
    
    
}