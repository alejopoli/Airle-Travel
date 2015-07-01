package Persistencia;

import Entidades.UsuarioEnt;

public class UsuarioDts {
    
    public static UsuarioEnt inicio, fin, nodo, nodo1, nodo2, nodoI;

    static {
        inicio = new UsuarioEnt(null, null, null, null, null, null, null, null, null, null);
        nodo = inicio.Liga = new UsuarioEnt("13432", "admin@hotmail.com", "admin123", "Admin", "Activo", "2177371", "3126386384", "Administrador", "Activo", null);
        nodo1 = nodo.Liga = new UsuarioEnt("53443", "secre@hotmail.com", "secre123", "Secre", "Activo", "2177371", "3126386384", "Secretaria", "Activo", null);
        nodo2 = nodo1.Liga = new UsuarioEnt("768786", "inactivo@hotmail.com", "inactivo123", "Admin", "Inactivo", "2177371", "3126386384", "Administrador", "Inactivo", null);
        fin = nodo2.Liga = new UsuarioEnt("890877", "cliente@hotmail.com", "cliente123", "Cliente", "Activo", "2177371", "3126386384", "Cliente", "Activo", null);
        fin.Liga = null;
    }

    public UsuarioEnt buscarUsuario(String correo) {
        UsuarioEnt respuesta = null;
        UsuarioEnt aux = inicio.Liga;
        while (aux != fin && !correo.equals(aux.Correo)) {
            aux = aux.Liga;
        }
        if (correo.equals(aux.Correo)) {
            respuesta = new UsuarioEnt();
            respuesta.setDocumento(aux.Documento);
            respuesta.setCorreo(aux.Correo);
            respuesta.setClave(aux.Clave);
            respuesta.setNombre(aux.Nombre);
            respuesta.setApellido(aux.Apellido);
            respuesta.setTelefono(aux.Telefono);
            respuesta.setCelular(aux.Celular);
            respuesta.setPerfil(aux.Perfil);
            respuesta.setEstado(aux.Estado);
            respuesta.setImage(aux.image);
            return respuesta;
        }
        return respuesta;
    }

    public UsuarioEnt buscarUsuarioCorreo(String cr) {
        UsuarioEnt respuesta = null;
        UsuarioEnt aux = inicio.Liga;
        while (aux != fin && !cr.equals(aux.Correo)) {
            aux = aux.Liga;
        }
        if (cr.equals(aux.Correo)) {
            respuesta = new UsuarioEnt();
            respuesta.setDocumento(aux.Documento);
            respuesta.setCorreo(aux.Correo);
            respuesta.setClave(aux.Clave);
            respuesta.setNombre(aux.Nombre);
            respuesta.setApellido(aux.Apellido);
            respuesta.setTelefono(aux.Telefono);
            respuesta.setCelular(aux.Celular);
            respuesta.setPerfil(aux.Perfil);
            respuesta.setEstado(aux.Estado);
            respuesta.setImage(aux.image);
            return respuesta;
        }
        return respuesta;
    }

    public UsuarioEnt buscarUsuarioDocumento(String cr) {
        UsuarioEnt respuesta = null;
        UsuarioEnt aux = inicio.Liga;
        while (aux != fin && !cr.equals(aux.Documento)) {
            aux = aux.Liga;
        }
        if (cr.equals(aux.Documento)) {
            respuesta = new UsuarioEnt();
            respuesta.setDocumento(aux.Documento);
            respuesta.setCorreo(aux.Correo);
            respuesta.setClave(aux.Clave);
            respuesta.setNombre(aux.Nombre);
            respuesta.setApellido(aux.Apellido);
            respuesta.setTelefono(aux.Telefono);
            respuesta.setCelular(aux.Celular);
            respuesta.setPerfil(aux.Perfil);
            respuesta.setEstado(aux.Estado);
            respuesta.setImage(aux.image);
            return respuesta;
        }
        return respuesta;
    }

    public boolean guardarUsuario(UsuarioEnt nueva) {
        nodoI = new UsuarioEnt(nueva.Documento, nueva.Correo, nueva.Clave, nueva.Nombre, nueva.Apellido, nueva.Telefono, nueva.Celular, nueva.Perfil, nueva.Estado, nueva.image);
        nodoI.Liga = null;
        fin.Liga = nodoI;
        fin = nodoI;
        return true;
    }

    public boolean modificarImagen(UsuarioEnt usuarios) {
        UsuarioEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Correo.equals(usuarios.getCorreo())) {
            aux = aux.Liga;
        }
        aux.image = usuarios.getImage();
        return true;
    }

    public boolean modificarUsuario(UsuarioEnt usuarios) {
        UsuarioEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Documento.equals(usuarios.getDocumento())) {
            aux = aux.Liga;
        }
        aux.Correo = usuarios.getCorreo();
        aux.Clave = usuarios.getClave();
        aux.Nombre = usuarios.getNombre();
        aux.Apellido = usuarios.getApellido();
        aux.Telefono = usuarios.getTelefono();
        aux.Celular = usuarios.getCelular();
        aux.Perfil = usuarios.getPerfil();
        aux.Estado = usuarios.getEstado();
        return true;
    }

    public boolean eliminarUsuario(String usuario) {
        UsuarioEnt aux, con;
        aux = inicio.Liga;
        con = inicio;
        while (aux != fin && !usuario.equals(aux.Documento)) {
            con = aux;
            aux = aux.Liga;
        }
        aux.Correo = null;
        aux.Clave = null;
        aux.Nombre = null;
        aux.Apellido = null;
        aux.Telefono = null;
        aux.Celular = null;
        aux.Perfil = null;
        aux.Estado = null;
        aux.image = null;
        if (aux.Liga == null && inicio.Liga == aux) {
            inicio.Liga = null;
        } else {
            con.Liga = aux.Liga;
            if (aux.Liga == null) {
                fin = con;
            }
        }

        return true;
    }

}
