
import com.*;

public class App {

    public static void main(String[] args) throws Exception {

        Banco masterBank = new Banco("Master Bank");

        Cliente marcus = new Cliente("Marcus");

        Conta minhaCC = new ContaCorrente(marcus);
        Conta minhaPoup = new ContaPoupanca(marcus);

        minhaCC.depositar(100);
        minhaCC.transferir(101, minhaPoup);
        minhaCC.transferir(40, minhaPoup);

        minhaCC.imprimirExtrato();
        minhaPoup.imprimirExtrato();

    }
}
