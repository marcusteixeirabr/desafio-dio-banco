package com;

public class ContaCorrente extends Conta {
    
    public ContaCorrente(Banco banco,Cliente proprietario) {
        super(banco, proprietario);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirExtrato();
    }   

}
