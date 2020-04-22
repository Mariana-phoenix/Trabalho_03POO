package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Canal canalAtual1 = new Canal(16,"Cultura",false);
        Canal canalAtual2 = new Canal(152,"Megapix", true);
        Canal canal = new Canal(25,"Aparecida",false);
        Canal canal1 = new Canal(30,"Curta!", false);
        Canal canal2 = new Canal(661,"Telecine", true);
        Canal canal3 = new Canal(671,"HBO", true);
        ArrayList<Canal> canals = new ArrayList<>();
        canals.add(canal);
        canals.add(canal1);
        ArrayList<Canal> canals1 = new ArrayList<>();
        canals1.add(canal2);
        canals1.add(canal3);
        ArrayList<SwartTV> swartTVS = new ArrayList<>();
        ArrayList<TVHD> tvhds = new ArrayList<>();
        SwartTV swartTV1 = new SwartTV("Samsung", 5, canals, 32, canalAtual1);
        SwartTV swartTV2 = new SwartTV("tvnova", 5, canals, 16, canalAtual1);
        TVHD tvhd1 = new TVHD("LG32", "LED", 5, canals1, canalAtual2);
        TVHD tvhd2 = new TVHD("LG", "Plasma", 5, canals1, canalAtual2);
        swartTVS.add(swartTV1);
        swartTVS.add(swartTV2);
        tvhds.add(tvhd1);
        tvhds.add(tvhd2);
        System.out.println("Programa Televisao");
        ControleRemoto controleRemoto = new ControleRemoto(swartTVS,tvhds);
        controleRemoto.execucao();
        System.out.println("Fim de Programa");

    }

}
