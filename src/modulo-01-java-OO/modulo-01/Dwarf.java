public class Dwarf {
    private int vida, experiencia;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private Status status;
    
    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
    }

    public Dwarf(){
        this(null, new DataTerceiraEra(1, 1, 1));
    }
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        status = Status.VIVO;
    }
    
    public Status getStatus(){
        return status;
    }

  
    public void perderVida() {
        double numero = this.getNumeroSorte();
        if (numero < 0) {
            this.experiencia += 2;
        }
        if (numero > 100) {
            vida -= 10;
        }
    }
    
    public int getVida() {
        return vida;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
    }
    
    public void fuiAtingido(){
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
}
// Dwarf gimli;