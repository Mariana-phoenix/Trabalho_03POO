package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SwartTV extends Televisao{
    public int polegadas;
    ArrayList<Canal> novocanal = super.novoCanal;

    public SwartTV(String id, int volume,  ArrayList<Canal> canalCadastradosCanal, int polegadas, Canal canalAtual) {
        super(id,volume,canalCadastradosCanal,canalAtual);
        this.polegadas = polegadas;
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setVolume(int volume) {
        super.setVolume(volume);
    }

    @Override
    public int getVolume() {
        return super.getVolume();
    }

    protected int getPolegadas() {
        return this.polegadas;
    }

    protected void setPolegadas(int polegadas){
        this.polegadas = polegadas;
    }

    @Override
    public void canalDisponivel() {
        super.canalDisponivel();
    }

    @Override
    public Canal getCanalAtual() {
        return super.getCanalAtual();
    }

    @Override
    public boolean alterarVolume(String upORdown) {
        return super.alterarVolume(upORdown);
    }

    @Override
    public boolean cadastrarCanais(Canal canalnovo) {
        if (novocanal.contains(canalnovo)) {
            return false;
        }
        for(Canal canal:novocanal){
            if(canal.getNumeroDoCanal() == canalnovo.getNumeroDoCanal()){
                return false;
            }
        }
        novocanal.add(canalnovo);
        return true;
    }

    @Override
    public boolean canalExiste(Canal canalExiste) {
        return super.canalExiste(canalExiste);
    }

    @Override
    public boolean alterarCanal(String canalNumero) {
        getNovocanal();
        return super.alterarCanal(canalNumero);
    }

    @Override
    public boolean sintonizar(int canalNumero) {
        return super.sintonizar(canalNumero);
    }

    @Override
    public void informarDados() {
        super.informarDados();
    }

    @Override
    public void mostrarGrade(){
        getNovocanal();
        super.mostrarGrade();
    }


    public void getNovocanal() {
        novoCanal.sort((canal1, canal2) -> {
            if(canal1.getNumeroDoCanal()> canal2.getNumeroDoCanal()){
                return 1;
            }
            if(canal1.getNumeroDoCanal() < canal2.getNumeroDoCanal()){
                return -1;
            }
            return 0;
        });
        if(novocanal.get(0) != canalAtual){
            novocanal.remove(canalAtual);
            novocanal.set(0,canalAtual);
        }
    }

    public void informacao() {
        int i = 0;
        while(i == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informacao da TV: ");
            System.out.println("ID: " + getId());
            System.out.println("Polegadas: " + getPolegadas());
            System.out.print("Alterar Informacoes?\n0-Sim\n1-Nao\n>>> ");
            i = scanner.nextInt();
            if (i == 0) {
                System.out.println("O que deseja alterar\n0-ID\n1-Polegadas\n2-Sair\n>>> ");
                int j = scanner.nextInt();
                if (j == 0) {
                    System.out.print("Digite ID novo da TV: ");
                    String idnovo = scanner.next();
                    this.setId(idnovo);
                }
                if (j == 1) {
                    System.out.print("Digite polegadas nova da TV: ");
                    int polegadas = scanner.nextInt();
                    this.setPolegadas(polegadas);
                }
            }
            System.out.println("Deseja rever?\n0-Sim\n1-Nao\n>>> ");
            i = scanner.nextInt();
        }
    }
}
