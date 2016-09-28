public class Dwarf {
    private int vida;
    
    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
    }

    public int getVida() {
        return vida;
    }
    
    public void fuiAtingido(){
        vida -= 10;
    }
    
    public void fuiAtingido(int flechas){ 
        vida -= flechas*10; 
    } 
}
// Dwarf gimli;