package it.unibs.arnaldo.bang.game;

public class Role {
    private String nome;
    private String descrizione;

    public Role(String nome , String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
