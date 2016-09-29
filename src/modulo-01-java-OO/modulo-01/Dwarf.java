public class Dwarf {
    private int vida;
    private String nome;
    private DataTerceiraEra dataNascimento;
    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
    }
    public Dwarf(){};
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
        vida -= 10;
    }
    
    public void fuiAtingido(int flechas){ 
        vida -= flechas*10; 
    } 
}
// Dwarf gimli;