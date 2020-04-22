package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleRemoto {
    Scanner scanner = new Scanner(System.in);
    ArrayList <SwartTV> swartTVS;
    ArrayList <TVHD> tvHD;

    public ControleRemoto(ArrayList<SwartTV> swartTVS,ArrayList<TVHD> tvHD){
        this.swartTVS =swartTVS;
        this.tvHD = tvHD;
    }

    public void adicionarTV(){
        try {
            System.out.print("Deseja adicionar TV?\n0-Sim\n1-Nao\n>>> ");
            int adicionarTV = scanner.nextInt();
            while (adicionarTV == 0) {
                System.out.print("ID da TV: ");
                String tvnova = scanner.next();
                System.out.print("TV é HD?\n0-Sim\n1-Nao\n>>>");
                int eshd = scanner.nextInt();
                System.out.println("Cadastre seu primeiro canal");
                System.out.print("Nome do Canal: ");
                String nomeDoCanal = scanner.next();
                System.out.print("Numero do Canal: ");
                int numeroDoCanal = scanner.nextInt();
                System.out.print("Canal es HD:\n0-Sim\n1-Nao\n>>> ");
                int eshD = scanner.nextInt();
                boolean hD = false;
                if (eshD == 0) {
                    hD = true;
                }
                Canal canalAtual = new Canal(numeroDoCanal, nomeDoCanal, hD);
                ArrayList<Canal> canalCadastrados = new ArrayList<>();
                System.out.print("Cadastrar mais Canais?\n0-Sim\n1-Nao\n>>> ");
                int cadastrarCanais = scanner.nextInt();
                while (cadastrarCanais == 0) {
                    System.out.print("Nome do Canal: ");
                    String nomeDoCanal1 = scanner.next();
                    System.out.print("Numero do Canal: ");
                    int numeroDoCanal1 = scanner.nextInt();
                    System.out.print("Canal es HD:\n0-Sim\n1-Nao\n>>> ");
                    int eShd = scanner.nextInt();
                    boolean hd = false;
                    if (eShd == 0) {
                        hd = true;
                    }
                    Canal canalnovo = new Canal(numeroDoCanal1, nomeDoCanal1, hd);
                    canalCadastrados.add(canalnovo);
                    System.out.print("Cadastrar mais Canais?\n0-Sim\n1-Nao\n>>> ");
                    cadastrarCanais = scanner.nextInt();
                }
                if (eshd == 0) {
                    System.out.print("Qual seu modelo de TV?\n>>> ");
                    String modelodeTV = scanner.next();
                    TVHD tvhd = new TVHD(tvnova, modelodeTV, 5, canalCadastrados, canalAtual);
                    tvHD.add(tvhd);
                }
                if (eshd == 1) {
                    System.out.println("Quantas polegadas tem sua TV?");
                    int polegadas = scanner.nextInt();
                    SwartTV swartTV = new SwartTV(tvnova, 5, canalCadastrados, polegadas, canalAtual);
                    swartTVS.add(swartTV);
                }
                System.out.print("Deseja adicionar TV?\n0-Sim\n1-Nao\n>>> ");
                adicionarTV = scanner.nextInt();
            }
        }catch (Exception e){
            System.out.println("TV já cadastrada");
        }
    }

    public void execucao() {
         adicionarTV();
         int fazeroperacao = 0;
         while (fazeroperacao == 0){
             System.out.print("Digite o primeiro numero e clique [ENTER]  e pos o proximo numero da TV escolhida\n");
             System.out.print("OBS: PRIMEIRA COLUNA -> primeiro numero\n SEGUNDA COLUNA -> segundo numero");
             System.out.println("Escolha a sua TV:");
             int i = 0;
             for(SwartTV swartTv: swartTVS){
                 System.out.println("0  " + i +"   "+ swartTv.getId());
                 i +=1;
             }
             for(TVHD tvHd: tvHD ){
                 System.out.println("1  "+ i +"   "+ tvHd.getId());
                 i +=1;
             }
             System.out.print("Digite o primeiro numero e pressione [ENTER]: ");
             int tv = scanner.nextInt();
             System.out.print("Digite o segundo numero: ");
             int numero = scanner.nextInt();
             if(tv == 0){
                 SwartTV swartTV = swartTVS.get(numero);
                 int opcao;
                 do {
                     System.out.print("O que deseja fazer?\n1-AlterarVolume\n2-Cadastrar novo Canal\n3-Verificar se canal existe\n");
                     System.out.print("4-Sintonizar\n5-Alterar Canal\n6-Informar dados atuais\n7-Mostrar Grade\n8-Informacoes de TV\n9-Sair\n>>>  ");
                     opcao = scanner.nextInt();
                     if (opcao == 1) {
                         System.out.println("Deseja aumentar ou diminuir\n0-Aumentar\n1-Diminuir\n>>>");
                         int upORdown = scanner.nextInt();
                         if (upORdown == 0) {
                             System.out.println(swartTV.alterarVolume("incrementa"));
                         }else{
                             System.out.println(swartTV.alterarVolume("descrementa"));
                         }
                         System.out.println("*********************************************************************");
                     }
                     else if(opcao == 2){
                         System.out.print("Nome do Canal: ");
                         String nomeDoCanal = scanner.next();
                         System.out.print("Numero do Canal: ");
                         int numeroDoCanal = scanner.nextInt();
                         System.out.print("Canal es HD:\n0-Sim\n1-Nao\n>>>");
                         int eshd = scanner.nextInt();
                         boolean hd = false;
                         if (eshd == 0){ hd = true;}
                         Canal novocanal = new Canal(numeroDoCanal,nomeDoCanal,hd);
                         System.out.println(swartTV.cadastrarCanais(novocanal));
                         System.out.println("*********************************************************************");
                     }
                     else if(opcao == 3){
                         System.out.print("Nome do Canal: ");
                         String nomeDoCanal = scanner.next();
                         System.out.print("Numero do Canal: ");
                         int numeroDoCanal = scanner.nextInt();
                         System.out.print("Canal es HD:\n0-Sim\n1-Nao\n>>>");
                         int eshd = scanner.nextInt();
                         boolean hd = false;
                         if (eshd == 0){ hd = true;}
                         Canal novocanal = new Canal(numeroDoCanal,nomeDoCanal,hd);
                         System.out.println(swartTV.canalExiste(novocanal));
                         System.out.println("*********************************************************************");
                     }
                     else if (opcao == 4){
                         System.out.print("Digite o numero do Canal: ");
                         int numeroDoCanal = scanner.nextInt();
                         System.out.println(swartTV.sintonizar(numeroDoCanal));
                         System.out.println("*********************************************************************");
                     }
                     else if (opcao == 5){
                         System.out.print("Digite "+"up"+" para subir e "+"down"+" para descer: ");
                         String upORdown = scanner.next();
                         swartTV.alterarCanal(upORdown);
                         System.out.println("*********************************************************************");
                     }
                     else if (opcao == 6){
                        swartTV.informarDados();
                         System.out.println("*********************************************************************");
                     }
                     else if(opcao == 7){
                         swartTV.mostrarGrade();
                         System.out.println("*********************************************************************");
                     }
                     else if(opcao == 8){
                         swartTV.informacao();
                         System.out.println("*********************************************************************");
                     }
                     else if (opcao > 9 || opcao < 1){
                         System.out.println("Opcao inexistente");
                         System.out.println("*********************************************************************");
                     }
                 }while (opcao != 9);

             }else{
                 TVHD tvhd = tvHD.get(numero);
                 int opcao;
                 do {
                     System.out.print("O que deseja fazer?\n1-AlterarVolume\n2-Cadastrar novo Canal\n3-Verificar se canal existe\n");
                     System.out.print("4-Sintonizar\n5-Alterar Canal\n6-Informar dados atuais\n7-Mostrar Grade\n8-Sair\n9-Informacoes de TV\n>>>  ");
                     opcao = scanner.nextInt();
                     if (opcao == 1) {
                         System.out.println("Deseja aumentar ou diminuir\n0-Aumentar\n1-Diminuir\n>>>");
                         int upORdown = scanner.nextInt();
                         if (upORdown == 0) {
                             System.out.println(tvhd.alterarVolume("incrementa"));
                         }else{
                             System.out.println(tvhd.alterarVolume("descrementa"));
                         }
                         System.out.println("*********************************************************************");
                     }
                     else if(opcao == 2){
                         System.out.print("Nome do Canal: ");
                         String nomeDoCanal = scanner.next();
                         System.out.print("Numero do Canal: ");
                         int numeroDoCanal = scanner.nextInt();
                         System.out.print("Canal es HD:\n0-Sim\n1-Nao\n>>> ");
                         int eshd = scanner.nextInt();
                         boolean hd = false;
                         if(eshd == 0){hd = true;}
                         Canal novocanal = new Canal(numeroDoCanal,nomeDoCanal,hd);
                         System.out.println(tvhd.cadastrarCanais(novocanal));
                         System.out.println("*********************************************************************");
                     }
                     else if(opcao == 3){
                         System.out.print("Nome do Canal: ");
                         String nomeDoCanal = scanner.next();
                         System.out.print("Numero do Canal: ");
                         int numeroDoCanal = scanner.nextInt();
                         System.out.print("Canal es HD:\n0-Sim\n1-Nao\n>>>");
                         int eshd = scanner.nextInt();
                         boolean hd = false;
                         if (eshd == 0){ hd = true;}
                         Canal novocanal = new Canal(numeroDoCanal,nomeDoCanal,hd);
                         System.out.println(tvhd.canalExiste(novocanal));
                         System.out.println("*********************************************************************");
                     }
                     else if (opcao == 4){
                         System.out.print("Digite o numero do Canal: ");
                         int numeroDoCanal = scanner.nextInt();
                         System.out.println(tvhd.sintonizar(numeroDoCanal));
                         System.out.println("*********************************************************************");
                     }
                     else if (opcao == 5){
                         System.out.print("Digite "+"up"+" para subir e "+"down"+" para descer: ");
                         String upORdown = scanner.next();
                         tvhd.alterarCanal(upORdown);
                         System.out.println("*********************************************************************");
                     }
                     else if (opcao == 6){
                         tvhd.informarDados();
                         System.out.println("*********************************************************************");
                     }
                     else if(opcao == 7){
                         tvhd.mostrarGrade();
                         System.out.println("*********************************************************************");
                     }
                     else if(opcao == 8){
                         tvhd.informacao();
                         System.out.println("*********************************************************************");
                     }
                     else if (opcao > 9 || opcao < 1){
                         System.out.println("Opcao inexistente");
                         System.out.println("*********************************************************************");
                     }
                 }while (opcao != 9);

             }
             System.out.print("Deseja fazer outra operacao?\n0-Sim\n1-Nao\n>>> ");
             fazeroperacao = scanner.nextInt();
         }
     }
}
