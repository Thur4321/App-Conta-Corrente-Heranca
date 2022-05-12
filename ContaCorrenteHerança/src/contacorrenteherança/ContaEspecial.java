
package contacorrenteherança;

public class ContaEspecial extends ContaCorrente {
    
    private float limite;

    public ContaEspecial(float limite, String nomes, int númeroConta) {
        super(nomes, númeroConta);
        this.limite = limite;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }
    
    public boolean limite(){
        if(saldo <= limite){
            return true;
        } else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
    
    @Override
    public boolean saque(float saque){
        if (saque <= saldo){
            saldo = saldo - saque;
            return true;
        }
        return false;
    }
    
    @Override
    public void depósito(float depósito) {
        if(saldo+depósito <= limite){
            saldo += depósito;
        }
        
    }
    
}
    
    
    
    
