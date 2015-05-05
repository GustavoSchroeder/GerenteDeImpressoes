package gerentedeimpressoes;

/**
 *
 * @author gschroeder
 */
public class ImpressoraColorida {
    private Arquivos arquivo;

    public ImpressoraColorida(Arquivos arquivo) {
        this.arquivo = arquivo;
    }

    public void imprime(String arquivo, String usuario){
        System.out.println("Arquivo Imprimido: " + arquivo + 
                "  Por: " + usuario);
    }
    


}
