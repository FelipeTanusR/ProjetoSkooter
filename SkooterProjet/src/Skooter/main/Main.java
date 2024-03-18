
package Skooter.main;

import Skooter.controle.Jogo;

//instancia um objeto jogo e inicia o ciclo de ticks e renders
public class Main {
    public static void main(String args[]){
        Jogo jogo = new Jogo();
        jogo.start();
        
    }
    
}
