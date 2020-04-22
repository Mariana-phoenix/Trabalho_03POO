package com.company;

public class Canal implements Comparable<Canal>{
    protected int numeroDoCanal;
    protected String nomeDoCanal;
    protected boolean esHD;

    public Canal(int nC, String noC, boolean esHD){
        this.numeroDoCanal = nC;
        this.nomeDoCanal = noC;
        this.esHD = esHD;
    }

    public Canal(){}

    public void setNomeDoCanal(String nomeDoCanal) {
        this.nomeDoCanal = nomeDoCanal;
    }

    public String getNomeDoCanal() {
        return nomeDoCanal;
    }

    public void setNumeroDoCanal(int numeroDoCanal) {
        this.numeroDoCanal = numeroDoCanal;
    }

    public int getNumeroDoCanal() {return this.numeroDoCanal; }

    public void setEsHD(boolean esHD) {
        this.esHD = esHD;
    }

    public boolean isEsHD() {
        return esHD;
    }

    public String toString(){
        return getNumeroDoCanal()+"  "+getNomeDoCanal()+"  "+ isEsHD();
    }

    @Override
    public int compareTo(Canal canal) {
       return this.getNumeroDoCanal() < canal.getNumeroDoCanal() ? -1 : this.getNumeroDoCanal() == canal.getNumeroDoCanal() ? 1 : 0;
    }

}