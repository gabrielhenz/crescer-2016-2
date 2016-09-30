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
    
    public String getDescricoesItens(){
        if(itens.size() > 0){
            String imprime = itens.get(0).getDescricao();
            for(int i = 1; i < itens.size(); i++){
                imprime += String.format(",%s", itens.get(i).getDescricao());
            }
            return imprime;
        }else{
            return null;
        }
    }
    
    public Item itemMaisPopular(){
        if(itens.size() > 1){
            Item itemMaisPopular = new Item();
            int maiorQtde = 0;
            for(Item item : itens){
                if(maiorQtde < item.getQuantidade())
                    maiorQtde = item.getQuantidade();
                    itemMaisPopular = item;
            }
            return itemMaisPopular;
        }else if(itens.size() == 1){
            return itens.get(0);
        }else{
            return null;
        }
    }
}
