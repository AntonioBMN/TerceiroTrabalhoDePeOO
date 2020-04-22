package Trab3;

import java.util.Collections;
import java.util.Scanner;



public class main {
    public static void novosCanais() {
        Canal RedeTV = new Canal(2, "RedeTV", false);
        Televisão.canaisDisponiveis.add(RedeTV);
        Canal TvCultura = new Canal(5, "TvCultura", false);
        Televisão.canaisDisponiveis.add(TvCultura);
        Canal Record = new Canal(8, "Record", false);
        Televisão.canaisDisponiveis.add(Record);
        Canal RecordHD = new Canal(9, "Record HD", true);
        Televisão.canaisDisponiveis.add(RecordHD);
        Canal Globo = new Canal(10, "Globo", false);
        Televisão.canaisDisponiveis.add(Globo);
        Canal GloboHD = new Canal(11, "GloboHD", true);
        Televisão.canaisDisponiveis.add(GloboHD);
        Canal Band = new Canal(12, "Band", false);
        Televisão.canaisDisponiveis.add(Band);
        Canal BandHD = new Canal(13, "BandHD", true);
        Televisão.canaisDisponiveis.add(BandHD);

    }
    public static void menu() {
        System.out.println("Digite 0 para fechar as televisões");
        System.out.println("Digite 1 para aumentar o volume");
        System.out.println("Digite 2 para diminuir o volume.");
        System.out.println("Digite 3 para sintonizar um canal.");
        System.out.println("Digite 4 para próximo canal");
        System.out.println("Digite 5 para canal anterior");
        System.out.println("Digite 6 exibir informações sobre o canal atual.");
        System.out.println("Digite 7 exibir grade de canais.");
    }
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        novosCanais();

        ControleRemoto c1 = new ControleRemoto();
        SmarTV s1 = new SmarTV(SmarTV.canaisDisponiveis,32,"LG195");
        TVHD t1 = new TVHD(TVHD.canaisDisponiveis,"LED","LG696");
        s1.cadastraCanal();
        t1.cadastraCanal();

        System.out.println("Digite 1 para: " +
                "Tv 1: Smartv: "+ s1.getiD()+", 2 para Tv 2: TVHD: "+t1.getiD()
        +" ou 3 para: controlar as duas.");
        int z = 0;
        z=s.nextInt();
        switch (z){
            case 1:
                c1.adicionaTV(s1);
                break;
            case 2:
                c1.adicionaTV(t1);
                break;
            case 3:
                c1.adicionaTV(s1);
                c1.adicionaTV(t1);
                break;
        }
        int a= -1;
        while (a!=0){
            menu();
            a = s.nextInt();

            switch (a) {
                case 1:
                    System.out.println("Escolha a televisão que deseja aumentar o volume " +
                            "\nTVs Disponíveis: ");
                    for (int i = 0; i < c1.televisões.size(); i++) {
                        System.out.print(i+1 +": "+ c1.televisões.get(i).getiD());
                        System.out.print(" ");
                    }
                    int d = s.nextInt();
                    c1.televisões.get(d-1).getVolumeAtual();
                    c1.mudarVolume(c1.televisões.get(d-1).getiD(), "Aumentar");
                    break;
                case 2:
                    System.out.println("Escolha a televisão que deseja diminuir o volume " +
                            "\nTVs Disponíveis: ");
                    for (int i = 0; i < c1.televisões.size(); i++) {
                        System.out.print(i+1 +": "+ c1.televisões.get(i).getiD());
                        System.out.print(" ");
                    }
                    d = s.nextInt();
                    c1.televisões.get(d-1).getVolumeAtual();
                    c1.mudarVolume(c1.televisões.get(d-1).getiD(), "Diminuir");
                    break;
                case 3:
                    int aaa = 0;
                    int bbb = 0;
                    boolean zzz= false;
                    do {
                        try{
                            System.out.println("Escolha a televisão que deseja sintonizar o canal" +
                                    "TVs Disponíveis: ");
                            for (int i = 0; i < c1.televisões.size(); i++) {
                                System.out.print(i + 1 + ": " + c1.televisões.get(i).getiD());
                                System.out.print(" ");
                            }
                            System.out.println();
                            bbb = s.nextInt();
                            System.out.println("Agora digite qual canal deseja sintonizar");
                            aaa = s.nextInt();
                            c1.sintonizar(c1.televisões.get(bbb- 1).getiD(), aaa);
                            System.out.println();
                            for (int i = 0;i<c1.televisões.get(bbb-1).getCanaisCadastrados().size();i++){
                                if (c1.televisões.get(bbb-1).getCanaisCadastrados().get(i).getNumero()==aaa){
                                    zzz=true;
                                }
                            }
                        } catch (Exception e){
                            System.out.println("Este canal não existe, por favor digite outro.");
                        }
                    }
                        while(!zzz);
                    break;
                case 4:
                    System.out.println("Escolha a televisão que deseja alterar canal" +
                            "\nTVs Disponíveis: ");
                    for (int i = 0; i < c1.televisões.size(); i++) {
                        System.out.print(i+1 +": "+ c1.televisões.get(i).getiD());
                        System.out.print(" ");
                    }
                    System.out.println();
                    d = s.nextInt();
                    c1.mudarCanal(c1.televisões.get(d-1).getiD(),"Proximo");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Escolha a televisão que deseja alterar canal" +
                            "\nTVs Disponíveis: ");
                    for (int i = 0; i < c1.televisões.size(); i++) {
                        System.out.print(i+1 +": "+ c1.televisões.get(i).getiD());
                        System.out.print(" ");
                    }
                    System.out.println();
                    d = s.nextInt();
                    c1.mudarCanal(c1.televisões.get(d-1).getiD(),"Anterior");
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Escolha a televisão que deseja exibir informações" +
                            "\nTVs Disponíveis: ");
                    for (int i = 0; i < c1.televisões.size(); i++) {
                        System.out.print(i+1 +": "+ c1.televisões.get(i).getiD());
                        System.out.print(" ");
                    }
                    System.out.println();
                    d = s.nextInt();
                    c1.informarDados(c1.televisões.get(d-1).getiD());
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Escolha a televisão que deseja exibir a grade de canais " +
                            "\nTVs Disponíveis: ");
                    for (int i = 0; i < c1.televisões.size(); i++) {
                        System.out.print(i+1 +": "+ c1.televisões.get(i).getiD());
                        System.out.print(" ");
                    }
                    System.out.println();
                    d = s.nextInt();
                    c1.mostrarDados(c1.televisões.get(d-1).getiD());
                    System.out.println();
                    break;
            }
        }
    }
}