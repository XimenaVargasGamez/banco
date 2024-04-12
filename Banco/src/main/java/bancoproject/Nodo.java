package bancoproject;

public class Nodo {
    SolicitudB solicitud;
    Nodo siguiente;

    Nodo(SolicitudB solicitud){
        this.solicitud = solicitud;
        this.siguiente = null;
    }

    public void setValor(SolicitudB solicitud) {
        this.solicitud = solicitud;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public SolicitudB getSolicitud() {
        return solicitud;
    }
}
