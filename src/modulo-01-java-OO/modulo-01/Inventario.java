import java.util.ArrayList;
public class Inventario
{
    private ArrayList<Item> itens;
    
    {
        itens = new ArrayList<Item>();
    }
    
    public ArrayList<Item> getItens(){
        return itens;
    }
    
    public void adicionarItem(Item item){
        itens.add(item);
    }
    
    public void removerItem(Item item){
        itens.remove(item);
    }
}
