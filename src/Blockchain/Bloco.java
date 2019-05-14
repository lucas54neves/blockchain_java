package Blockchain;

import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

public class Bloco {
    private final long indice;
    private final long tempo_criacao;
    private final Object transacao;
    private final String hash_atual;
    private final String hash_anterior;

    public Bloco(Object transacao, String hash_anterior, long i) {
        this.indice = i;
        this.tempo_criacao = new Date().getTime();
        this.transacao = transacao;
        this.hash_atual = calcular_hash();
        this.hash_anterior = hash_anterior;
    }
    
    private String calcular_hash() {
        return DigestUtils.sha256Hex(""+getIndice()+getTempo_criacao()+getTransacao()+getHash_atual()+getHash_anterior());
    }

    public long getIndice() {
        return indice;
    }

    public long getTempo_criacao() {
        return tempo_criacao;
    }

    public Object getTransacao() {
        return transacao;
    }

    public String getHash_atual() {
        return hash_atual;
    }

    public String getHash_anterior() {
        return hash_anterior;
    }
    
    @Override
    public String toString() {
        return
                "Bloco: " + getIndice() + "\n" +
                "Tempo de criação: " + getTempo_criacao() + "\n" +
                "Transação: " + getTransacao() + "\n" +
                "Hash atual: " + getHash_atual() + "\n" +
                "Hash anterior: " + getHash_anterior();
    }
}