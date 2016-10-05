public class Dwarf extends Personagem {
    private DataTerceiraEra dataNascimento;

    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
        //status = Status.VIVO;
    }

    public Dwarf(){
        this(null, new DataTerceiraEra(1, 1, 1));
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        super(nome);
        this.dataNascimento = dataNascimento;
    }

    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void fuiAtingido(){
        boolean estaMorto = status.equals(Status.MORTO);
        if(estaMorto) return;
        //sai do método
        double numeroSorte = this.getNumeroSorte();
        if(numeroSorte < 0)
        experiencia += 2;  
        
        if(numeroSorte > 100 && status.equals(Status.VIVO))
        setVida(getVida() - 10);
        
        if(vida == 0){
            setStatus(Status.MORTO);
        }
    }
    
    public double getNumeroSorte(){
        double numeroSorte = 101.0;
        if(dataNascimento.ehBissexto() && vida >= 80 && vida <= 90){
            numeroSorte *= -33;
        }
        if(("Seixas".equals(nome) || "Meireles".equals(nome)) && !dataNascimento.ehBissexto()){
            numeroSorte = numeroSorte * 33 % 100;
        }
        return numeroSorte;
    }
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            for(Item item : inventario.getItens()){
                item.setQuantidade(item.getQuantidade() + 1000);
            }
        }
    }
    
    public void inicializarInventario(int quantidadeFlechas) { }
}
