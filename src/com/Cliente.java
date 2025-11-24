package com;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String nome;
    private final List<Conta> contas;

    public Cliente(String nome) {
        this.nome = nome;
        contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println(this.nome + " não tem contas cadastradas.");
            return;
        }
        System.out.println("=== Contas de " + this.nome + ":");
        contas.forEach(conta -> {
            System.out.println(conta.getClass().getSimpleName() + " do " + conta.getBanco().getNome()
                    + " - Agência " + conta.getAgencia()
                    + ", Número: " + conta.getNumero()
                    + ", Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
        });
    }

    public void listaBancos() {
        List<Banco> bancosUnicos = contas.stream()
                .map(Conta::getBanco)
                .distinct()
                .toList();

        if (bancosUnicos.isEmpty()) {
            System.out.println(this.nome + " não tem bancos cadastrados.");
            return;
        }

        System.out.println("=== Bancos de " + this.nome + ":");
        bancosUnicos.forEach(banco -> {
            System.out.println(banco.getNome());
        });     
    }

    public void mostrarSaldoTotal() {
        double saldoTotal = contas.stream()
                .mapToDouble(Conta::getSaldo)
                .sum();
        System.out.printf("=== Saldo total de %s: R$ %.2f%n", this.nome, saldoTotal);
    }

}
