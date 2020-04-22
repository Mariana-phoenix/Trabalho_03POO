package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class TVHD extends Televisao{
    ArrayList<Canal> novocanal = super.novoCanal;
    String modelodeTV;

    public TVHD(String id, String modelodeTV,int volume, ArrayList<Canal> canalCadastradosCanal, Canal canalAtual) {
        super(id, volume, canalCadastradosCanal, canalAtual);
        this.modelodeTV = modelodeTV;
        novocanal.removeIf(canal -> !canal.isEsHD());
        novocanal.add(canalAtual);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public void setCanalAtual(Canal canalAtual) {
        super.setCanalAtual(canalAtual);
    }

    @Override
    public void setNomeDoCanal(String nomeDoCanal) {
        super.setNomeDoCanal(nomeDoCanal);
    }

    @Override
    public String getNomeDoCanal() {
        return super.getNomeDoCanal();
    }

    @Override
    public void setNumeroDoCanal(int numeroDoCanal) {
        super.setNumeroDoCanal(numeroDoCanal);
    }

    @Override
    public int getNumeroDoCanal() {
        return super.getNumeroDoCanal();
    }

    @Override
    public void setEsHD(boolean esHD) {
        super.setEsHD(esHD);
    }

    @Override
    public boolean isEsHD() {
        return super.isEsHD();
    }

    public void setModelodeTV(String modelodeTV) {
        this.modelodeTV = modelodeTV;
    }

    public String getModelodeTV() {
        return this.modelodeTV;
    }

    @Override
    public void canalDisponivel(){
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
        if(!canalExiste(canalnovo)){
            if(canalnovo.isEsHD()) {
                novoCanal.add(canalnovo);
                return true;
            }
        }
        return false;
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
        int k = novocanal.size();
        if(novocanal.get(k-1) != canalAtual){
            novocanal.remove(canalAtual);
            novocanal.set(k-1,canalAtual);
        }
    }

    public void informacao() {
        int i = 0;
        while(i == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informacao da TV: ");
            System.out.println("ID: " + getId());
            System.out.println("Polegadas: " + getModelodeTV());
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
                    String modelodeTV = scanner.next();
                    this.setModelodeTV(modelodeTV);
                }
                System.out.println("Deseja rever?\n0-Sim\n1-Nao\n>>> ");
                i = scanner.nextInt();
            }
        }
    }

}


