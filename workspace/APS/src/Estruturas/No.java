
package Estruturas;


public class No {
    
    private String dado;
    private No proxNo;
    
    public No(String dado){
        this.dado = dado;
        this.proxNo = null;
    }
    
   
    public void setDado(String dado){
        this.dado = dado;
    }
    
    public String getDado(){
        return this.dado;
    }
    
    public void setProxNo(No proxNo){
        this.proxNo = proxNo;
    }
    
    public No getProxNo(){
        return this.proxNo;
    }
    
}
