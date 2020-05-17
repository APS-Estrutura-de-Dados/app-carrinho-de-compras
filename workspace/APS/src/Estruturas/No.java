
package Estruturas;


public class No {
    
    private int dado;
    private No proxNo;
    
    public No(int dado){
        this.dado = dado;
        this.proxNo = null;
    }
    
   
    public void setDado(int dado){
        this.dado = dado;
    }
    
    public int getDado(){
        return this.dado;
    }
    
    public void setProxNo(No proxNo){
        this.proxNo = proxNo;
    }
    
    public No getProxNo(){
        return this.proxNo;
    }
    
}
