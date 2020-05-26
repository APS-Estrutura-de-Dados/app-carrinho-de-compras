package Estruturas;

public class Fila{

  private String[] vetorFila;
  private int fim = -1;

  public Fila(int maxSize){
    vetorFila = new String[maxSize]; 
    fim = -1;
  }

  public boolean isFull(){
    return (fim == vetorFila.length-1);
  }

  public void enqueue(String dado){
    if (!isFull()){
      fim++;
      vetorFila[fim] = dado;
    }
  }

  public String display(){
  	String data = "";
    for(int i = 0; i <= fim; i++){
      data += (vetorFila[i] + "\n");
    }
    return data;
  }

  public boolean isEmpty(){
    return (fim == -1);
  }

  public String dequeue(){
	  String elemento;
    if (!isEmpty()){
      elemento = vetorFila[0];
      for (int i = 0; i < fim; i++){
        vetorFila[i] = vetorFila[i+1];
      }
      fim--;
      return elemento;
    }
    else{
      return null;
    }
  }

  public String peek(){
    if (!isEmpty()){
      return vetorFila[0];
    }else{
      return null;
    }
  }
}
