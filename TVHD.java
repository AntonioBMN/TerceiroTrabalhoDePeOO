package Trab3;

import java.util.ArrayList;

public class TVHD extends Televisão {
    String modeloDeTV;

    public void setModeloDeTV(String modeloDeTV) {
        this.modeloDeTV = modeloDeTV;
    }

    public TVHD(ArrayList<Canal> a, String modeloDeTV, String id) {
        super(a);
        setiD(id);
        setModeloDeTV(modeloDeTV);
    }

    @Override
    public void cadastraCanal(){
        for (int i = 0; i <Televisão.canaisDisponiveis.size();i++){
            if(canaisDisponiveis.get(i).getHD()==true){
                canaisCadastrados.add(Televisão.canaisDisponiveis.get(i));
            }
        }
        setCanalAtual(canaisCadastrados.get(canaisCadastrados.size()-1));
    }
}
