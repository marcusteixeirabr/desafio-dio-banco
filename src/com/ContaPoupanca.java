package com;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Banco banco,Cliente proprietario) {
        super(banco, proprietario);
    }
    
    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirExtrato();
    }
}
