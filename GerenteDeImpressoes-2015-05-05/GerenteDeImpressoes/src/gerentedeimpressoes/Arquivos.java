/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gerentedeimpressoes;

/**
 *
 * @author gschroeder
 */
public class Arquivos {
    private String nomeArquivo;
    private String usuario;
    private int prioridade;
    private int impressao;

    public Arquivos(String nomeArquivo, String usuario, int impressao) {
        this.nomeArquivo = nomeArquivo;
        this.usuario = usuario;
        this.prioridade = (int)Math.floor((Math.random()*3)+1);
        this.impressao = impressao;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getImpressao() {
        return impressao;
    }

    public void setImpressao(int impressao) {
        this.impressao = impressao;
    }
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    
    
    
}
