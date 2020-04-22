package Trab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Televisão {
    private String iD;
    public int volume = 0;
    private Canal canalAtual;
    public ArrayList<Canal> canaisCadastrados = new ArrayList<>();
    public static ArrayList<Canal> canaisDisponiveis = new ArrayList<>();
    private static int volumeMaximo = 10;
    private static int volumeMinimo = 0;
    private  int volumeAtual = 0;
    public int getVolumeAtual() {
        return volumeAtual;
    }
    public void setVolumeAtual(int volumeAtual) {
        this.volumeAtual = volumeAtual;
    }
    public String getiD() {
        return iD;
    }
    public void setiD(String iD) {
        this.iD = iD;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public Canal getCanalAtual() {
        return canalAtual;
    }
    public void setCanalAtual(Canal canalAtual) {
        this.canalAtual = canalAtual;
    }
    public Televisão(ArrayList<Canal> canaisDisponiveis) {
        ArrayList<Canal> listaInterna = new ArrayList<>();
        for (int i = 0; i < canaisDisponiveis.size(); i++){
            listaInterna.add(i, canaisDisponiveis.get(i));
        }
        volumeAtual = 5;
    }

    public ArrayList<Canal> getCanaisCadastrados() {
        return canaisCadastrados;
    }

    public void mudarvolume(String volume) {
        if (volume == "Aumentar") {
            setVolumeAtual(getVolumeAtual()+1);
            if (getVolumeAtual() > 10) {
                setVolumeAtual(getVolumeAtual()+-1);
            }
        }
        if (volume == "Diminuir") {
            setVolumeAtual(getVolumeAtual()+-1);
            if (getVolumeAtual() < 0) {
                setVolumeAtual(getVolumeAtual()+1);
            }
        }
    }
    public abstract void cadastraCanal();
    public boolean verificarCanal(int canal) {
        boolean contem = false;
        for (int i = 0; i < getCanaisCadastrados().size() ; i++) {
            if (getCanaisCadastrados().get(i).getNumero()==canal){
                contem = true;
                break;
            } else {
                contem =false;
            }
        }
        if (contem){
            return true;
        } else {return false;}
    }

    public void sintonizar(int canal) throws Exception{

        boolean a = false;
        for (int i = 0; i < getCanaisCadastrados().size() ; i++) {
            if (canal==getCanaisCadastrados().get(i).getNumero()){
                a = true;
                setCanalAtual(getCanaisCadastrados().get(i));
                break;
            }
            }
            if (!a){
                throw new Exception("Canal inexistente.");
            }

    }
    public void informarDados() {
        System.out.println(canalAtual.getNome() + " - " + canalAtual.getNumero() + " - " + canalAtual.getHD());
    }
    public void gradeDeCanais(String iD) {
        for (int i = 0; i < getCanaisCadastrados().size() ; i++) {
            System.out.println(getCanaisCadastrados().get(i).getNome() + " - " + getCanaisCadastrados().get(i).getNumero() + " - " + getCanaisCadastrados().get(i).getHD());
        }
    }
    public void alterarCanal (String altera){
        switch(altera) {
            case "Proximo":
                if (getCanalAtual() == getCanaisCadastrados().get(getCanaisCadastrados().size() - 1)) {
                    setCanalAtual(getCanaisCadastrados().get(0));
                } else {
                    setCanalAtual(getCanaisCadastrados().get(getCanaisCadastrados().indexOf(getCanalAtual()) + 1));
                }
            break;

            case "Anterior":
            if (getCanalAtual() == getCanaisCadastrados().get(0)) {
                setCanalAtual(canaisCadastrados.get(canaisCadastrados.size()-1));

            } else {
                setCanalAtual(canaisCadastrados.get(canaisCadastrados.indexOf(canalAtual) - 1));
            }
            break;
        }
    }
}
