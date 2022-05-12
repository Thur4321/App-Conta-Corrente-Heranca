
package contacorrenteherança;

public class ContaCorrente {
    private String nomes;
    
    protected float saldo;
    
    protected int númeroConta;

    public ContaCorrente(String nomes, int númeroConta) {
        this.nomes = nomes;
        this.númeroConta = númeroConta;
    }

    public String getNomes() {
        return nomes;
    }

    public void setNomes(String nomes) {
        this.nomes = nomes;
    }

    public int getNúmeroConta() {
        return númeroConta;
    }

    public void setNúmeroConta(int númeroConta) {
        this.númeroConta = númeroConta;
    }
    
    @Override
    public String toString(){
        return "Número da conta: "+númeroConta
                +"\nNome dos titulares: "+nomes
                +"\nSaldo disponível: R$"+saldo;
    }
    
    public boolean saque(float saque){
        if (saque <= saldo){
            saldo = saldo - saque;
            return true;
        }
        return false;
    }
    
    public void depósito(float depósito) {
        saldo += depósito;
    }
}
