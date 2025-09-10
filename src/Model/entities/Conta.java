package Model.entities;

import Model.exceptions.DomainException;

public class Conta {
    protected int id;
    protected  String titular;
    protected double saldo;

    public Conta() {}

    public Conta(int id, String titular, double saldo) {
        this.id = id;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // metodos
    public  void depositar(double quantia) {
        saldo += quantia;
    }

    public void sacar(double quantia) throws DomainException {
        if (quantia > saldo) {
            throw new DomainException("Saldo insuficiente");
        }
        if (quantia < 0) {
            throw new DomainException("Quantia negativa");
        }

        saldo -= quantia;
        // precisa lançar execessão se saldo insuficiente
    }
}
