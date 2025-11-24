
import com.*;

public class App {

    public static void main(String[] args) {

        Banco masterBank = new Banco("Master Bank");
        Banco bradesco = new Banco("Bradesco");

        Cliente marcus = new Cliente("Marcus");
        Cliente ana = new Cliente("Ana");
        Cliente joao = new Cliente("João");

        Conta marcusMasterCC = new ContaCorrente(masterBank, marcus);
        Conta marcusMasterPoup = new ContaPoupanca(masterBank, marcus);
        Conta anaCC = new ContaCorrente(masterBank, ana);
        Conta anaPoup = new ContaPoupanca(masterBank, ana);
        Conta joaoCC = new ContaCorrente(masterBank, joao);
        Conta joaoPoup = new ContaPoupanca(masterBank, joao);

        Conta marcusBradescoCC = new ContaCorrente(bradesco, marcus);
        Conta marcusBradescoPoup = new ContaPoupanca(bradesco, marcus);

        marcusMasterCC.depositar(100);
        marcusMasterCC.transferir(50, marcusMasterPoup);
        marcusMasterCC.imprimirExtrato();
        marcusMasterPoup.imprimirExtrato();

        marcusBradescoCC.depositar(150);
        marcusBradescoCC.transferir(70, marcusBradescoPoup);
        marcusBradescoCC.imprimirExtrato();
        marcusBradescoPoup.imprimirExtrato();

        anaCC.depositar(200);
        anaCC.transferir(80, anaPoup);
        anaCC.imprimirExtrato();
        anaPoup.imprimirExtrato();

        joaoCC.depositar(300);
        joaoCC.transferir(150, joaoPoup);
        joaoCC.imprimirExtrato();
        joaoPoup.imprimirExtrato();

        marcusMasterCC.sacar(30);
        anaPoup.sacar(50);
        joaoCC.sacar(100);

        marcusMasterCC.transferir(10, joaoPoup);
        anaPoup.transferir(20, marcusMasterPoup);
        joaoCC.transferir(30, anaCC);

        masterBank.listarContas();

        masterBank.listarClientes();

        masterBank.calcularTotalDepositos();

        masterBank.mostrarSaldoTotalCliente(marcus);

        marcus.listarContas();

        marcus.listaBancos();

        marcus.mostrarSaldoTotal();

    }

}
