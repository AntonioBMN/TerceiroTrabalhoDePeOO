package Trab3;


import java.util.ArrayList;

public class SmarTV extends Televisão {
    int quantidadeDePolegadas;

    public void setQuantidadeDePolegadas(int quantidadeDePolegadas) {
        this.quantidadeDePolegadas = quantidadeDePolegadas;
    }

    public SmarTV(ArrayList<Canal> a, int quantidadeDePolegadas, String id) {
        super(a);
        setiD(id);
        setQuantidadeDePolegadas(quantidadeDePolegadas);
        }

        @Override
        public void cadastraCanal() {
            for (int i = 0; i <Televisão.canaisDisponiveis.size();i++){
                getCanaisCadastrados().add( Televisão.canaisDisponiveis.get(i));
            }
            setCanalAtual(canaisCadastrados.get(0));
        }

    }