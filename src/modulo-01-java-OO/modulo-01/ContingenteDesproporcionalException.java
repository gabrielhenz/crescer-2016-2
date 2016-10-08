public class ContingenteDesproporcionalException extends Exception
{
    public ContingenteDesproporcionalException(){
        super("O contingente está desproporcional. É necessário ter 50% de elfos verdes e 50% de elfos noturnos");
    }
    
    public ContingenteDesproporcionalException(String erro){
        super(erro);
    }
}
