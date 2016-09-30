public class IrishDwarf
{
    private int vida, experiencia;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private Status status; //= Status.VIVO;
    private Inventario inventario;
    private boolean leprechaun;
    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
        leprechaun = true;
        //status = Status.VIVO;
    }

    public IrishDwarf(){
        this(null, new DataTerceiraEra(1, 1, 1));
    }
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.status = Status.VIVO;
        inventario = new Inventario();
    }
    
    public void adicionarItem(Item item){
        inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        inventario.removerItem(item);
    }
    
    public Inventario getInventario(){
        return inventario;
    }
    
    public int getVida() {
        return vida;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
    }
    
    public void fuiAtingido(){
        boolean estaMorto = status.equals(Status.MORTO);
        if(estaMorto) return;
        //sai do método
        double numeroSorte = this.getNumeroSorte();
        if(numeroSorte < 0)
        experiencia += 2;  
        
        if(numeroSorte > 100 && status.equals(Status.VIVO))
        vida -= 10;
        
        if(vida == 0){
            status = Status.MORTO;
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
        if(leprechaun && getNumeroSorte() == -3333.0){
            int soma, quantidade;
            for(Item item : inventario.getItens()){
                soma = 0;
                quantidade = item.getQuantidade();
                if(quantidade > 0){
                    for(int i = quantidade; i >= 1; i--){
                        soma += i;
                    }
                }else if(quantidade < 0){
                    for(int i = quantidade; i <= -1; i++){
                        soma += i;
                    }
                    soma = -soma;
                }
                item.setQuantidade(quantidade + (1000 * soma));
            }
        }
    }
}
