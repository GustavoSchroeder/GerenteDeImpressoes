
package gerentedeimpressoes;

/**
 *
 * @author gschroeder
 */
public class ImpressaoPB {
    private Arquivos arquivo;

    public ImpressaoPB(Arquivos arquivo) {
        this.arquivo = arquivo;
    }

    public void imprime(){
        System.out.println("Arquivo Imprimido: " + arquivo.getNomeArquivo() + 
                "  Por: " + arquivo.getUsuario());
    }
    
    
}
