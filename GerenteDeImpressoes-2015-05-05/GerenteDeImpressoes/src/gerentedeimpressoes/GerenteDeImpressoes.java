package gerentedeimpressoes;

import javax.swing.JOptionPane;
import singlylinkedqueue.UnderflowException;
import singlylinkedqueue.OverflowException;
import singlylinkedqueue.SinglyLinkedQueue;

/**
 *
 * @author gschroeder
 */
public class GerenteDeImpressoes {

    public static void main(String[] args) throws UnderflowException {
        SinglyLinkedQueue<Arquivos> impressoraPB = new SinglyLinkedQueue();
        SinglyLinkedQueue<Arquivos> impressoraCor = new SinglyLinkedQueue();

        ReadDate rd = new ReadDate();
        int turnos = rd.readInt("Numero de turnos a serem simulados");
        int contColorido = 0;
        int contImpressos = 0;
        int contpb = 0;
        int contc = 0;
        int contGerente = 0;
        try {
            while (turnos > 0) {

                int numeroDeImpressoesPb = (int) Math.floor((Math.random() * 3) + 1);
                int numeroImpressoesC = (int) Math.floor((Math.random() * 2) + 1);
                int tipo = rd.readInt("Tipo de Impressao: 1 - P/B    2 - Colorido");
                if (tipo == 1) {
                    for (int i = 0; i < numeroDeImpressoesPb; i++) {
                        String nomeArquivos = rd.readString("Nome do Arquivo: ");
                        String usuario = rd.readString("Usuario: ");
                        Arquivos arq = new Arquivos(nomeArquivos, usuario, tipo);
                        impressoraPB.enqueue(arq);
                        }
                } else if (tipo == 2) {
                    for (int i = 0; i < numeroImpressoesC; i++) {
                        String nomeArquivos = rd.readString("Nome do Arquivo: ");
                        String usuario = rd.readString("Usuario: ");
                        Arquivos arq = new Arquivos(nomeArquivos, usuario, tipo);
                        impressoraCor.enqueue(arq);
                       }
                }
                if (contColorido >= 2 && impressoraCor.isEmpty() == false) {
                    contColorido = 0;
                    for (int i = 0; i < impressoraCor.numElements(); i++) {
                        Arquivos aux = impressoraCor.dequeue();

                        if (aux.getPrioridade() == 3) {
                            System.out.println("Arquivo Imprimido: " + aux.getNomeArquivo()
                                    + " Usuario: " + aux.getUsuario() + " Tipo: " + aux.getPrioridade());
                            contImpressos++;
                        } else {
                            impressoraCor.enqueue(aux);
                        }
                    }
                    for (int i = 0; i < impressoraCor.numElements(); i++) {
                        Arquivos aux = impressoraCor.dequeue();

                        if (aux.getPrioridade() == 2) {
                            System.out.println("Arquivo Imprimido: " + aux.getNomeArquivo()
                                    + " Usuario: " + aux.getUsuario() + " Tipo: " + aux.getPrioridade());
                            contImpressos++;
                        } else {
                            impressoraCor.enqueue(aux);
                        }
                    }
                    for (int i = 0; i < impressoraCor.numElements(); i++) {
                        Arquivos aux = impressoraCor.dequeue();

                        if (aux.getPrioridade() == 1) {
                           System.out.println("Arquivo Imprimido: " + aux.getNomeArquivo()
                                    + " Usuario: " + aux.getUsuario() + " Tipo: " + aux.getPrioridade());
                            contImpressos++;
                        } else {
                            impressoraCor.enqueue(aux);
                        }
                    }
                }

                if (impressoraPB.isEmpty() == false) {
                    Arquivos aux = impressoraPB.dequeue();

                    if (aux.getPrioridade() == 3) {

                        contImpressos++;
                    } else {
                        impressoraPB.enqueue(aux);
                    }
                }
                for (int i = 0; i < impressoraCor.numElements(); i++) {
                    Arquivos aux = impressoraPB.dequeue();

                    if (aux.getPrioridade() == 2) {
                        System.out.println("Arquivo Imprimido: " + aux.getNomeArquivo()
                                    + " Usuario: " + aux.getUsuario() + " Tipo: " + aux.getPrioridade());
                        contImpressos++;
                    } else {
                        impressoraPB.enqueue(aux);
                    }
                }
                for (int i = 0; i < impressoraCor.numElements(); i++) {
                    Arquivos aux = impressoraPB.dequeue();

                    if (aux.getPrioridade() == 1) {
                         System.out.println("Arquivo Imprimido: " + aux.getNomeArquivo()
                                    + " Usuario: " + aux.getUsuario() + " Tipo: " + aux.getPrioridade());
                        contImpressos++;
                    } else {
                        impressoraPB.enqueue(aux);
                    }
                }

                if (turnos == 1) {
                    for (int i = 0; i < impressoraPB.numElements(); i++) {
                        contpb++;
                    }
                    for (int i = 0; i < impressoraCor.numElements(); i++) {
                        contc++;

                    }
                    contGerente = contpb + contc + contImpressos;
                    JOptionPane.showMessageDialog(null, "Arquivos no Gerente: " + (contGerente)
                            + " \nNa Fila Preto e Branco: " + contpb + "\nNa fila Colorida: "
                            + contc + "\n --TOTAL DE IMPRESSOES-- " + contImpressos);
                }
                turnos--;
                contColorido++;
            }
        } catch (OverflowException e) {
            e.showMessage();
        } catch (UnderflowException ex) {
            JOptionPane.showMessageDialog(null, "Nao ha o que retirar!");
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Programa Finalizado!");
        }
    }
}
