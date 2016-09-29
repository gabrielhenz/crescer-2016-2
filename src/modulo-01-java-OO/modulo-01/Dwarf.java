public class Dwarf {
    private int vida, experiencia;
    private DataTerceiraEra dataNascimento;
    private String nome;

    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
    }
<<<<<<<
    public Dwarf(){
        this(null, new DataTerceiraEra(1, 1, 1));
    };
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
=======

    public Dwarf() {
        this(null, new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void perderVida() {
        double numero = this.getNumeroSorte();
        if (numero < 0) {
            this.experiencia += 2;
        }
        if (numero > 100) {
            vida -= 10;
        }
>>>>>>>
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