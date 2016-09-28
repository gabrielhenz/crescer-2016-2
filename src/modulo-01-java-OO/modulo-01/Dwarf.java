
/**
 * Escreva a descrição da classe Dwarf aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Dwarf
{
    private int vida;
    private Item machado;
    
    public Dwarf(){
        vida = 110;
        machado = new Item("Machado", 1);
    }
    
    
    public int getVida(){
        return vida;
    }
    
    public void setVida(int vida){
        this.vida = vida;
    }
    
    public Item getMachado(){
        return machado;
    }
}
