import java.util.List;

public interface EstrategiaAtaqueIntercalado
{
    List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ContemElfoNormalException, ContingenteDesproporcionalException;
}
