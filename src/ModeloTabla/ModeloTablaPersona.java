

package ModeloTabla;

import entidades.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModeloTablaPersona extends AbstractTableModel{
    private ArrayList<Persona> personas = new ArrayList<>();
    private final String[] columnas = {"Apellidos","Nombre","N° Cel fijo","N° Celular","Correo Electronico"};
    
    public ModeloTablaPersona(ArrayList<Persona> personas){
        this.personas=personas;
    }
    
    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
        case 0:
            return personas.get(rowIndex).getApellido();
        case 1:
            return personas.get(rowIndex).getNombre();
        case 2: 
            return personas.get(rowIndex).getTelefonoFijo();
        case 3:
            return personas.get(rowIndex).getTelefonoCel();
        case 4: 
            return personas.get(rowIndex).getCorreo();           
    }
    return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
}
