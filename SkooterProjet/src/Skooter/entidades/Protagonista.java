
package Skooter.entidades;

import Skooter.controle.Jogo;
import java.awt.image.BufferedImage;
import java.io.Serializable;


public class Protagonista extends EntidadeMovel{
    
    private int vida;
    private int pontuacao;
    private int quantidadeDeColetaveis;
    private int faseAtual;
    private int contadorMovimento;
    
    //construtor
    public Protagonista(int x, int y, int width, int height, boolean transponivel, boolean letal, BufferedImage sprite) {
        super(x, y, width, height, transponivel, letal, sprite);
        vida = 4;
        pontuacao = 0;
        quantidadeDeColetaveis = 0;
        contadorMovimento = 0;
    }

    //getters e setters
    public int getFaseAtual() {
        return faseAtual;
    }

    public void setFaseAtual(int faseAtual) {
        this.faseAtual = faseAtual;
    }

    public int getQuantidadeDeColetaveis() {
        return quantidadeDeColetaveis;
    }

    public void setQuantidadeDeColetaveis(int quantidadeDeColetaveis) {
        this.quantidadeDeColetaveis = quantidadeDeColetaveis;
    }
            
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public int getContadorMovimento() {
        return contadorMovimento;
    }

    public void setContadorMovimento(int contadorMovimento) {
        this.contadorMovimento = contadorMovimento;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    //funcoes de movimentacao
    public void moveUp(){          
        if(this.getY()<16 || estaColidindo(x,y-2,Jogo.jogador)|| estaColidindoFixo(x,y-2,Jogo.jogador)){
          return;  
        }
        this.setY((this.getY()-2));
    }
    
    public void moveDown(){
        if(this.getY()>335 || estaColidindo(x,y+2,Jogo.jogador)|| estaColidindoFixo(x,y+2,Jogo.jogador)){
          return;  
        }
        this.setY((this.getY()+2));

    }
        
    public void moveRight(){
        if(this.getX()>335 || estaColidindo(x+2,y,Jogo.jogador)|| estaColidindoFixo(x+2,y,Jogo.jogador)){
          return;  
        }
        this.setX((this.getX()+2));
            
    }
        
    public void moveLeft(){
        if(this.getX()<16 || estaColidindo(x-2,y,Jogo.jogador)|| estaColidindoFixo(x-2,y,Jogo.jogador)){
          return;  
        }
        this.setX((this.getX()-2));

    }

    //define logica de tick do protagonista
    public void tick(){
        
        if(contadorMovimento>16){
            this.setObjetivo(0);
        }
        estaColidindo(this.getX(),this.getY(),this);
        estaColidindoFixo(this.getX(),this.getY(),this);

        if(cima){
            this.moveUp();
        }else if(baixo){
           this.moveDown();    
        }else if(direita){ 
            this.moveRight();     
        }else if(esquerda){
            this.moveLeft();
        }
        contadorMovimento++;
        
    }


    
    
}
