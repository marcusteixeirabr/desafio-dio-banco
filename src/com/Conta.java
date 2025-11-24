package com;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private final Cliente proprietario;
    private final Banco banco;
    private final int agencia;
    private final int numero;
    private double saldo;

    public Conta(Banco banco, Cliente proprietario) {
        this.proprietario = proprietario;
        this.banco = banco;
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0.0;
        registrar();
    }
    
    private void registrar() {
        proprietario.adicionarConta(this);
        banco.adicionarConta(this);
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public Banco getBanco() {
        return banco;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente para a operação.");
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;

    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Cliente: " + this.proprietario.getNome());
        System.out.println("Banco: " + this.banco.getNome());
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.printf("Saldo: R$ %.2f%n", this.saldo);
    }

}
