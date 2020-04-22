package Trab3;

public class Canal {
    public int numero = 0;
    public String nome = " ";
    public boolean HD = false;
    public boolean getHD(){
        return HD;
    }
    public String getNome() {
        return nome;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setHD(boolean HD) {
        this.HD = HD;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Canal(Integer numero, String nome, boolean HD) {
        this.numero = numero;
        this.nome = nome;
        this.HD = HD;
    }
}
