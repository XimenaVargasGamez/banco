package bancoproject;

public class SolicitudB {
    private String idNum;
    private long moni;
    private String nombre;

    public SolicitudB(String idNum, long moni, String nombre) {
        this.idNum = idNum;
        this.moni = moni;
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public String getIdNum(){
        return idNum;
    }

    public double getMoni() {
        return moni;
    }
}
