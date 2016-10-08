public class ContemElfoNormalException extends Exception
{
    public ContemElfoNormalException(){
        super("Não foi possível fazer a ordenação do ataque, pois dentre os atacantes existe um Elfo normal.");
    }
    
    public ContemElfoNormalException(String erro){
        super(erro);
    }
}
