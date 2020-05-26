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
    
    public void insertAtFront(String dado){
        No novoNo = new No(dado);
        if(isEmpty()){
            inicio = novoNo;
            fim = novoNo;
        }else{
            novoNo.setProxNo(inicio);
            inicio = novoNo;
        }
    }
    
    
    public void insertAtBack(String dado){
        No novoNo = new No(dado);
        if(isEmpty()){
            inicio = novoNo;
            fim = novoNo;
        }else{
            fim.setProxNo(novoNo);
            fim = novoNo;
        }
    }
    
    public String print(){
    	String data = "";
        if (isEmpty()){
            return ("Lista Vazia");
        }else{
            No auxiliar = inicio;
            while(auxiliar != null){
                data += (auxiliar.getDado())+" , ";
                auxiliar = auxiliar.getProxNo();
            }
        }
        return data;
    }
    
    public String removeFromFront(){
        if(isEmpty()){
            return null; // flag lista vazia
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
    
    public String removeFromBack(){
        if(isEmpty()){
            return null;
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
    
    public No find(String dado){
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
    
    public String find(int posicao){
    	No temp;

        //é posição zero?
        if (posicao == 0) {
            temp = inicio;
            if (size() == 1) {
            	
            } else {
                
            }
        } else { //para as demais posições
            No aux = inicio; //cria nó auxiliar que aponta para o inicio
            int cont = 0; //cria um contador de posicao
            //então caminha na lista enquanto não for null e 
            //até que atinga a posição anterior de remoção
            while (aux != null && !(cont == posicao - 1)) {
                aux = aux.getProxNo();
                cont++;
            }
            temp = aux.getProxNo(); //temp aponta para o proximo do auxiliar
        }
        return temp.getDado();
    }
    
    
    public String remove(String dado){
        if(isEmpty()){
            return null;
        }
        No anterior = inicio;
        No atual = inicio;
        while(atual != null && !atual.getDado().equals(dado)){
            anterior = atual;
            atual = atual.getProxNo();
        }
        
        if(atual == null){
            return null;
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
