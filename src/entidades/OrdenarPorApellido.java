/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.Comparator;

/**
 *
 * @author Jsmith
 */
public class OrdenarPorApellido implements Comparator<Persona>{

    @Override
    public int compare(Persona o1, Persona o2) {
    return o1.getApellido().compareToIgnoreCase(o2.getApellido());    
    }

}
