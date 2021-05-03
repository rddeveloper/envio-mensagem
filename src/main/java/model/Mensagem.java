package model;

import java.util.UUID;

public class Mensagem {

    private UUID idMensagem;

    private String conteudo;

    private String titulo;

    private String autor;

    public Mensagem() {

    }

    public Mensagem(UUID idMensagem, String conteudo, String titulo, String autor) {
        this.idMensagem = idMensagem;
        this.conteudo = conteudo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public UUID getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(UUID idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
