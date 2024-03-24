package src;

public class Contador {
    private int contador;

    public Contador(){
        this.contador = 0;
    }

    public int getContador(){
        return this.contador;
    }

    public void setContador(int contador){
        this.contador = contador;
    }

    public void incrementarPartida(){
        contador++;
        //System.out.println(contador);
    }
}
