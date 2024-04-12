package bancoproject;

public class CuentaB {
    private String idNum;
    private double saldo;
    private int numCuenta;

    public CuentaB(String idNum, double saldo) {
        this.idNum = idNum;
        this.saldo = saldo;
    }

    public String getIdNum() {
        return idNum;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposit(double moni){
        saldo += moni;
    }
}
