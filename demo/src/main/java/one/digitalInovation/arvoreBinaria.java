import one.digitalInovation.BinNo;

public class ArvoreBinaria <T extends Comparable<T>>{

    private BinNo<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo){
        if(atual == null){
            return novoNo;
        } else if(novoNo.getConteudo().compareTo(atual.getConteudo()) < 0){
            atual.setNoEsquerda(inserir(atual.getNoEsquerda(), novoNo));
        } else{
            atual.setNoDireita(inserir(atual.getNoDireita(), novoNo));
        }
        return atual;
    }

    public void exibirInOrdem(){
        System.out.println("\n Exibindo InOrdem");
        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(BinNo<T> atual){
        if(atual != null){
            exibirInOrdem(atual.getNoEsquerda());
            System.out.println(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDireita());
        }
    }

     public void exibirPosOrdem(){
        System.out.println("\n Exibindo PosOrdem");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(BinNo<T> atual){
        if(atual != null){
            exibirPosOrdem(atual.getNoEsquerda());
            exibirPosOrdem(atual.getNoDireita());
            System.out.println(atual.getConteudo() + ", ");
        }
    }

      public void exibirPreOrdem(){
        System.out.println("\n Exibindo PreOrdem");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(BinNo<T> atual){
        if(atual != null){
            System.out.println(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsquerda());
            exibirPreOrdem(atual.getNoDireita());
        }
    }
}
