package Negocio;
import Entidades.AvionEnt;
import Persistencia.AvionDts;

public class AvionNg {
    AvionDts AvionD = new AvionDts();
    AvionEnt AvionE = null;
    
    public AvionEnt buscarAvionCodigo(String codigo) {
        return AvionD.buscarAvionCodigo(codigo);
    }
    
    public boolean modificarAvion(AvionEnt codigo){
        return AvionD.modificarAvion(codigo);
    }
   
}
