public class ElfoVerde extends Elfo
{
    public ElfoVerde(String n) {
       this(n, 42);
    }
    
    public ElfoVerde(String nome, int quantidadeFlechas){
        super(nome, quantidadeFlechas);
    }
    
    public void adicionarItens(int quantidadeFlechas){
        this.inventario.adicionarItem(new Item("Arco de Vidro", 1));
        this.inventario.adicionarItem(new Item("Flechas de Vidro", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        experiencia++;
    }
}
