package application;

import Model.entities.Conta;
import Model.entities.ContaEmpresarial;
import Model.exceptions.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Locale.setDefault(Locale.US);
       Scanner s = new Scanner(System.in);

        List<Conta> contas = new ArrayList<>();

        try {
            System.out.println("Número da conta: ");
            int id = s.nextInt();
            System.out.println("Titular: ");
            String titular = s.next();
            System.out.println("Saldo inicial: ");
            double saldo = s.nextDouble();

            System.out.println("Conta Empresarial: (s/n)? ");
            char ch = s.next().charAt(0);

            Conta c; // polimófica

            if (ch == 's'){
                System.out.println("Limite de crédito: ");
                double limiteCredito = s.nextDouble();

             c = new ContaEmpresarial(id, titular, saldo, limiteCredito);

            } else {
                c = new Conta(id, titular, saldo);
            }


            System.out.println("Valor para saque:");
            double quantia = s.nextDouble();
            c.sacar(quantia);

            System.out.printf("Novo saldo: %.2f%n", c.getSaldo());










        } catch (DomainException e) {
            System.out.println("Erro: " + e.getMessage());
        }







        s.close();

    }
}
