package Blockchain;

public class Teste {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        for (int i = 0; i < 10; i++) {
            blockchain.adicionar_bloco(i+20);
        }
        blockchain.imprimir();
    }
}
