public class Dwarf {
    private int vida;
    private String nome;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
    }
    public Dwarf(){
        this("", new DataTerceiraEra(1, 1, 1));
    };
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public int getVida() {
        return vida;
    }
    
    public String getNome(){
        return nome;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
    }
    
    public void fuiAtingido(){
        double numeroSorte = this.getNumeroSorte();
        if(numeroSorte < 0)
        experiencia += 2;
        
        if(numeroSorte > 100)
        vida -= 10;
    }
    
    public void fuiAtingido(int flechas){ 
        double numeroSorte = this.getNumeroSorte();
        if(numeroSorte < 0)
        experiencia += 2 * flechas;
        
        if(numeroSorte > 100)
        vida -= 10 * flechas;
    } 
    
    public double getNumeroSorte(){
        double numeroSorte = 101.0;
        if(dataNascimento.ehBissexto()){
            if(vida >= 80 && vida <= 90) numeroSorte *= -33;
        }else{
            if(nome.equals("Seixas") || nome.equals("Meireles")){
                numeroSorte = numeroSorte * 33 % 100;
            }
        }
        return numeroSorte;
    }
}
// Dwarf gimli;