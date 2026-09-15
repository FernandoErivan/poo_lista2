package ZOO;

public class Gato extends Animal{
    Gato(long id, String nome, int idade, double peso){
        super(id, nome, idade, peso);
        getHabilidades().add("Agilidade");
    }

    @Override
    public String emitirSom() {
        return "Miau Miau";
    }
    
}
