package Blockchain;

import java.util.*;

public class Blockchain {
    private final ArrayList<Bloco> blocos;

    public Blockchain() {
        this.blocos = new ArrayList<>();
        this.blocos.add(new Bloco("Bloco Gênesis", "0", 0));
    }
    
    public void adicionar_bloco(Object transacao) {
        if (blockchain_valida() || tamanho() == 1) {
            getBlocos().add(new Bloco(transacao, ultimo_bloco().getHash_atual(), tamanho()));
        }
    }

    public ArrayList<Bloco> getBlocos() {
        return blocos;
    }
    
    public boolean blockchain_valida() {
        for (int i = 1; i < tamanho(); i++) {
            if (!retornar_bloco(i-1).getHash_atual().equals(retornar_bloco(i).getHash_anterior()) ||
                retornar_bloco(i-1).getTempo_criacao() > retornar_bloco(i).getTempo_criacao() ||
                retornar_bloco(i-1).getIndice() > retornar_bloco(i).getIndice()) {
                return false;
            }
        }
        return true;
    }
    
    public int tamanho() {
        return getBlocos().size();
    }
    
    public Bloco retornar_bloco(int i) {
        return getBlocos().get(i);
    }
    
    public Bloco ultimo_bloco() {
        return getBlocos().get(tamanho()-1);
    }
    
    public void imprimir() {
        System.out.println("##### Blockchain #####");
        System.out.println("Tamanho: " + tamanho());
        System.out.println("######################");
        for (int i = 0; i < tamanho(); i++) {
            System.out.println(retornar_bloco(i));
            System.out.println("######################");
        }
    }
}
