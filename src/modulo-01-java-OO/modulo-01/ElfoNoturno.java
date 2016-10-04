public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String n) {
       this(n, 42);
    }
    
    public ElfoNoturno(String nome, int quantidadeFlechas){
        super(nome, quantidadeFlechas);
    }
    
    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
    }
    
    public void atirarFlecha(Dwarf dwarf, int quantidade){
        super.atirarFlecha(dwarf, quantidade);
        diminuirVidaEm5PorCento();
        experiencia += 2;
    }
    
    private void diminuirVidaEm5PorCento(){
        this.setVida(getVida() - (getVida() * 5) / 100);
        if(getVida()>= 0 && getVida() < 1)
        setStatus(Status.MORTO);
    }
}
