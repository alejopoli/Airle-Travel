package Persistencia;

import Entidades.AvionEnt;

public class AvionDts {

    public static AvionEnt inicio, fin, nodo, nodo1, nodo2, nodoI;

    static {
        inicio = new AvionEnt(null, null, null);
        nodo = inicio.Liga = new AvionEnt("123", "1", "Activo");
        nodo1 = nodo.Liga = new AvionEnt("321", "2", "Inactivo");
        nodo2 = nodo1.Liga = new AvionEnt("213", "3", "Inactivo");
        fin = nodo2.Liga = new AvionEnt("312", "4", "Activo");
        fin.Liga = null;
    }

    public AvionEnt buscarAvionCodigo(String cr) {
        AvionEnt respuesta = null;
        AvionEnt aux = inicio.Liga;
        while (aux != fin && !cr.equals(aux.Codigo)) {
            aux = aux.Liga;
        }
        if (cr.equals(aux.Codigo)) {
            respuesta = new AvionEnt();
            respuesta.setCodigo(aux.Codigo);
            respuesta.setCapacidad(aux.Capacidad);
            respuesta.setEstado(aux.Estado);
            return respuesta;
        }
        return respuesta;
    }

    public boolean modificarAvion(AvionEnt aviones) {
        AvionEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Codigo.equals(aviones.getCodigo())) {
            aux = aux.Liga;
        }
        aux.Codigo = aviones.getCodigo();
        aux.Capacidad = aviones.getCapacidad();
        aux.Estado = aviones.getEstado();
        return true;
    }

}
