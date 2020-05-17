package Estruturas;


public class ListaDinamica {
    
    private No inicio;
    private No fim;
    
    
    public ListaDinamica(){
        this.inicio = null;
        this.fim = null;
    }
    
    public boolean isEmpty(){
        return (inicio == null);
    }
    
    public void insertAtFront(int dado){
        No novoNo = new No(dado);
        if(isEmpty()){
            inicio = novoNo;
            fim = novoNo;
        }else{
            novoNo.setProxNo(inicio);
            inicio = novoNo;
        }
    }
    
    
    public void insertAtBack(int dado){
        No novoNo = new No(dado);
        if(isEmpty()){
            inicio = novoNo;
            fim = novoNo;
        }else{
            fim.setProxNo(novoNo);
            fim = novoNo;
        }
    }
    
    public void print(){
        if (isEmpty()){
            System.out.println("Lista Vazia");
        }else{
            No auxiliar = inicio;
            while(auxiliar != null){
                System.out.println(auxiliar.getDado());
                auxiliar = auxiliar.getProxNo();
            }
        }
    }
    
    public int removeFromFront(){
        if(isEmpty()){
            return -1; // flag lista vazia
        }
        No auxiliar = inicio;
        if(inicio == fim){
            inicio = null;
            fim = null;
        }else{
            inicio = inicio.getProxNo();
        }
        return auxiliar.getDado();
    }
    
    public int removeFromBack(){
        if(isEmpty()){
            return -1;
        }
        No auxiliar = fim;
        if (inicio == fim){
            inicio = null;
            fim = null;
        }else{
            No atual = inicio;
            while (atual.getProxNo() != fim){
                atual = atual.getProxNo();
            }
            fim = atual;
            atual.setProxNo(null);
        }
        return auxiliar.getDado();
    }
    
    public No find(int dado){
        if(isEmpty()){
            return null;
        }
        No auxiliar = inicio;
        while(auxiliar != null){
            if(auxiliar.getDado() == dado){
                return auxiliar;
            }
            auxiliar = auxiliar.getProxNo();
        }
        return null;
    }
    
    
    public int remove(int dado){
        if(isEmpty()){
            return -1;
        }
        No anterior = inicio;
        No atual = inicio;
        while(atual != null && atual.getDado() != dado){
            anterior = atual;
            atual = atual.getProxNo();
        }
        
        if(atual == null){
            return -1;
        }
        
        No auxiliar = atual;
        if(atual == inicio){
            return removeFromFront();
        }else{
            if( atual == fim){
                return removeFromBack();
            }else{
                anterior.setProxNo(atual.getProxNo());
            }
        }
        return auxiliar.getDado();
    }
    
    public int size(){
        // contador
        int contador = 0;
        // percorrer a lista
        No auxiliar = inicio;
        while( auxiliar != null ){
            // sempre que encontrar um no
            // incrementa o contador
            contador++;
            auxiliar = auxiliar.getProxNo();
        }
        
        // retorna a contagem
        return contador;
    }
    
    
    
}
