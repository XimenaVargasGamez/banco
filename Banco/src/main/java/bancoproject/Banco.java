
package bancoproject;


import java.util.LinkedList;

public class Banco {
    private LinkedList<CuentaB> cuentas;
    private LinkedList<Nodo> solicitudes;
    private static  Banco banco;
    
    public Banco(){
        cuentas = new LinkedList<>();
        solicitudes = new LinkedList<>();
    }
    public void crearCuenta(CuentaB cuenta){
        int numCuenta = cuentas.size() - 1;
        cuentas.add(cuenta);
    }
    
    public static Banco getBanco(){
        if(banco==null){
            banco = new Banco();
        }
        return banco;
    }
    public int verification(){
        if(solicitudes.isEmpty()){
            return -1;
        }
        SolicitudB solicitud = solicitudes.getFirst().solicitud;
        String idNum = solicitud.getIdNum();

        int posicion = buscar(idNum);
        if(posicion == -1){
            CuentaB newCuenta = new CuentaB(idNum,0);
            cuentas.add(newCuenta);
            return cuentas.size() - 1;
        }
        else{
            return posicion;
        }
    }
    public int buscar(String idNum){
        for(int i = 0; i < cuentas.size(); i++){
            if(cuentas.get(i).getIdNum().equals(idNum)){
                return i;
            }
        }
        return -1;
    }
    public void darDeBaja(String idNum){
        for(int i = 0; i < cuentas.size(); i++){
            if(cuentas.get(i).getIdNum().equals(idNum)){
                cuentas.remove(i);
                i--;
            }
        }

    }
    public LinkedList<CuentaB> borrarMillonarios(){
        LinkedList<CuentaB>  millonario = new LinkedList<>();
        for(int i = 0; i < cuentas.size(); i++){
            if(cuentas.get(i).getSaldo() > 1000000){
                millonario.add(cuentas.remove(i));
                i--;
            }
        }
        return millonario;

    }
    public void aceptarSolicitud(){
        while(!solicitudes.isEmpty()){
            Nodo nodo = solicitudes.removeFirst();
            SolicitudB solicitud = nodo.solicitud;
            int index= verification();
            if (index == -1){
                index = cuentas.size();
            }
            cuentas.get(index).deposit(solicitud.getMoni());
        }
    }
    public void nuevaSolicitud(SolicitudB solicitud){
        solicitudes.addLast(new Nodo(solicitud));
    }

}
