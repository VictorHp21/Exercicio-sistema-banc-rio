package Model.entities;

import Model.exceptions.DomainException;

public class ContaEmpresarial extends Conta {
    private double limiteCredito;

    public ContaEmpresarial(int id, String titular, double saldo, double limiteCredito) {
        super(id, titular, saldo);
        this.limiteCredito = limiteCredito;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void sacar(double quantia) throws DomainException {
        if(quantia <= 0){
            throw new DomainException("Quantia negativa");
        }
        if(quantia > getSaldo() + limiteCredito) {
            throw new DomainException("Saldo insuficiente (mesmo com o crédito)");
        }


       setSaldo(getSaldo() - quantia);
    }

}
