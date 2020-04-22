package Trab3;
import java.util.ArrayList;
public class ControleRemoto {
    static ArrayList<Televisão> televisões = new ArrayList<>();
    public void adicionaTV(Televisão tv) throws Exception{
        if (!televisões.contains(tv)){
        televisões.add(tv);
        } else {
            throw new Exception("Televisão já existente");
        }

    }
    public void mudarVolume(String iD, String mudar) {
        for (int i = 0; i < televisões.size(); i++) {
            if (televisões.get(i).getiD() == iD) {
                Televisão tv = televisões.get(i);
                switch (mudar) {
                    case "Aumentar":
                        tv.mudarvolume("Aumentar");
                        break;
                    case "Diminuir":
                        tv.mudarvolume("Diminuir");
                        break;
                }
            }
        }
    }
    public void mudarCanal(String iD, String mudar) {
        for (int i = 0; i < televisões.size() ; i++) {
            if (televisões.get(i).getiD() == iD) {
                Televisão tv = televisões.get(i);
                switch (mudar) {
                    case "Proximo":
                        tv.alterarCanal("Proximo");
                        break;
                    case "Anterior":
                        tv.alterarCanal("Anterior");
                        break;
                }
            }
        }
    }
    public void sintonizar(String iD, int sintonizar) throws Exception {
        for (int i = 0; i < televisões.size(); i++) {
            if (televisões.get(i).getiD() == iD) {
                Televisão tv = televisões.get(i);
                tv.sintonizar(sintonizar);
            }
        }
    }
    public void informarDados(String iD) {
        for (int i = 0; i < televisões.size() ; i++) {
            if (iD == televisões.get(i).getiD()) {
                Televisão tv = televisões.get(i);
                System.out.println(tv.getCanalAtual().getNome() + " - " + tv.getCanalAtual().getNumero() + " - " + tv.getCanalAtual().getHD() + " com volume: " + tv.getVolumeAtual());
            }
        }
    }
    public void mostrarDados(String iD){
        for (int i = 0; i < televisões.size() ; i++) {
            if (iD == televisões.get(i).getiD()) {
                Televisão tv = televisões.get(i);
                tv.gradeDeCanais(iD);
            }
        }
    }
}