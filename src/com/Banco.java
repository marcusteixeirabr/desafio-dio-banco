package com;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private final String nome;
    private final List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada no banco.");
            return;
        }

        System.out.println("=== Contas cadastradas no " + this.nome + ":");
        contas.forEach(conta -> {
            System.out.println(conta.getClass().getSimpleName() + " de " + conta.getProprietario().getNome()
                    + ", Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
        });
    }

    public void listarClientes() {
        List<Cliente> clientesUnicos = contas.stream()
                .map(Conta::getProprietario)
                .distinct()
                .toList();

        if (clientesUnicos.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado no banco.");
            return;
        }

        System.out.println("=== Clientes cadastrados no " + this.nome + ":");
        clientesUnicos.forEach(cliente -> {
            System.out.println(cliente.getNome());
        });
    }

    public void calcularTotalDepositos() {
        double totalDepositos = contas.stream()
                .mapToDouble(Conta::getSaldo)
                .sum();
        System.out.printf("=== Total de depósitos no %s: R$ %.2f%n", this.nome, totalDepositos);
    }

    public void mostrarSaldoTotalCliente(Cliente cliente) {
        double saldoTotal = contas.stream()
            .filter(conta -> conta.getProprietario().equals(cliente))
            .mapToDouble(Conta::getSaldo)
            .sum();
        System.out.printf("=== Saldo total do cliente %s no %s: R$ %.2f%n", cliente.getNome(), this.nome, saldoTotal);
    }

}
