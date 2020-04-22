package com.company;
import java.util.Collections;
import java.util.*;


public abstract class Televisao extends Canal{
    protected String id;
    protected int volume;
    protected Canal canalAtual;
    protected ArrayList<Canal> novoCanal;
    protected static String UP = "up";
    protected static String DOWN = "down";

    public Televisao(String id, int volume, ArrayList<Canal> canalCadastrados, Canal canalAtual) {
        super();
        this.volume = volume;
        this.novoCanal = canalCadastrados;
        this.id = id;
        this.canalAtual = canalAtual;
        canalDisponivel();
    }

    public void canalDisponivel() {
        Canal CanalRecord = new Canal(8, "Record", false);
        Canal CanalGlobo = new Canal(10, "Globo", false);
        Canal CanalBand = new Canal(12, "Band", false);
        novoCanal.add(CanalRecord);
        novoCanal.add(CanalGlobo);
        novoCanal.add(CanalBand);
        novoCanal.sort(Comparator.comparing(Canal::getNumeroDoCanal));
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCanalAtual(Canal canalAtual) {
        this.canalAtual = canalAtual;
    }

    public Canal getCanalAtual() {
        return canalAtual;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public boolean alterarVolume(String upORdown) {
        if (upORdown.equals("incrementa")) {
            if ((volume + 1) > 10) {
                System.out.println("Volume ultrapassou do maximo");
                return false;
            } else {
                volume += 1;
                return true;
            }
        } else if (upORdown.equals("descrementa")) {
            if ((volume - 1) < 0) {
                System.out.println("Volume ultrapassou do minimo");
                return false;
            } else {
                volume -= 1;
                return true;
            }
        }
        return false;
    }

    public abstract boolean cadastrarCanais(Canal canalnovo);

    public boolean canalExiste(Canal canalExiste) {
        for (Canal canal : novoCanal) {
            if (canal.equals(canalExiste)) {
                return false;
            }
        }
        novoCanal.add(canalExiste);
        return true;
    }

    public boolean sintonizar(int canalNumero) {
        try {
            for (Canal canalinterno : novoCanal) {
                if (canalinterno.getNumeroDoCanal() == canalNumero) {
                    canalAtual = canalinterno;
                    return true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Canal inexistente");
            return false;
        }
        return false;
    }

    public boolean alterarCanal(String canalNumero) {
        try {
            if (canalNumero.equals(UP)) {
                for (Canal canalinterno : Collections.unmodifiableList(novoCanal)) {
                    if (canalinterno.equals(canalAtual)) {
                        int i = novoCanal.indexOf(canalinterno);
                        canalAtual = novoCanal.get(i + 1);
                        return true;
                    }
                }
            }
        }catch (IndexOutOfBoundsException e){
                canalAtual = novoCanal.get(0);
        }
        try {
            if (canalNumero.equals(DOWN)) {
                for (Canal canalinterno : novoCanal) {
                    if (canalinterno.equals(canalAtual)) {
                        int i = novoCanal.indexOf(canalinterno);
                        canalAtual = novoCanal.get(i - 1);
                        return true;
                    }
                }
            }
        }catch (IndexOutOfBoundsException e){
            canalAtual = novoCanal.get(novoCanal.size()-1);
        }
    return false;
    }

    public void informarDados() {
        System.out.println("Nome do Canal = " + canalAtual.getNomeDoCanal());
        System.out.println("Numero do Canal = " + canalAtual.getNumeroDoCanal());
        System.out.println("Canal é HD = " + canalAtual.isEsHD());
        System.out.println("O volume atual é: " + getVolume());
    }

    public void mostrarGrade() {
        for (Canal canal : novoCanal) {
            System.out.println(canal.toString());
            System.out.println("_______________________________________________________");
        }
    }

}

