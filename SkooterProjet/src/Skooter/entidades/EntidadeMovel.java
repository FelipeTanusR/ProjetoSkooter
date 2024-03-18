
package Skooter.entidades;

import Skooter.controle.Jogo;
import static Skooter.controle.Jogo.HEIGHT;
import static Skooter.controle.Jogo.SCALE;
import static Skooter.controle.Jogo.WIDTH;
import Skooter.graficos.SpriteSheet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EntidadeMovel extends Entidade implements Serializable {
    
 
    protected boolean cima,baixo,direita,esquerda;
    protected boolean podeMover;
    protected boolean podeQuebrar;
    private int objetivo;
    private int movimentoAtual;

    
    
    //construtor
    public EntidadeMovel(int x, int y, int width, int height, boolean transponivel, boolean letal, BufferedImage sprite) {
        super(x, y, width, height, transponivel, letal, sprite);
        this.podeQuebrar = false;
    }
    
    //getters e setters
    public int getMovimentoAtual() {
        return movimentoAtual;
    }

    public void setMovimentoAtual(int movimentoAtual) {
        this.movimentoAtual = movimentoAtual;
    }
    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }


    public boolean isPodeQuebrar() {
        return podeQuebrar;
    }

    public void setPodeQuebrar(boolean podeQuebrar) {
        this.podeQuebrar = podeQuebrar;
    }
    public boolean isPodeMover() {
        return podeMover;
    }

    public void setPodeMover(boolean podeMover) {
        this.podeMover = podeMover;
    }
    
    public boolean isCima() {
        return cima;
    }

    public void setCima(boolean cima) {
        this.cima = cima;
    }

    public boolean isBaixo() {
        return baixo;
    }

    public void setBaixo(boolean baixo) {
        this.baixo = baixo;
    }

    public boolean isDireita() {
        return direita;
    }

    public void setDireita(boolean direita) {
        this.direita = direita;
    }

    public boolean isEsquerda() {
        return esquerda;
    }

    public void setEsquerda(boolean esquerda) {
        this.esquerda = esquerda;
    }
    
    
    //roda logica de colisao das entidades
    public void tick(){
        estaColidindo(this.getX(),this.getY(),this);
        estaColidindoFixo(this.getX(),this.getY(),this);
    }
    
    
    //renderiza na tela

    @Override
    public void renderizar(Graphics g) {
        g.drawImage(sprite,this.x*Jogo.SCALE,this.y*Jogo.SCALE, 32*Jogo.SCALE,32*Jogo.SCALE,null);
    }
    
    //funcoes de mov 
    public void moveUp(){          
        if(this.getY()<16 || estaColidindo(x,y-2,this)){
          return;  
        }
        this.setY((this.getY()-2));
    }
    
    public void moveDown(){
        if(this.getY()>335 || estaColidindo(x,y+2,this)){
          return;  
        }
        this.setY((this.getY()+2));

    }
        
    public void moveRight(){
        if(this.getX()>335 || estaColidindo(x+2,y,this)){
          return;  
        }
        this.setX((this.getX()+2));
            
    }
        
    public void moveLeft(){
        if(this.getX()<16 || estaColidindo(x-2,y,this)){
          return;  
        }
        this.setX((this.getX()-2));

    }
    
    //retorna qual entidade movel esta colidindo
    public EntidadeMovel comQuemEstaColidindoMovel(int xnext, int ynext, EntidadeMovel objeto){
        Rectangle atual = new Rectangle(xnext,ynext,32,32);
        for(int i = 0; i < Jogo.entidadesMoveis.size(); i++){
            EntidadeMovel e = Jogo.entidadesMoveis.get(i);
            
            
            
            Rectangle alvo = new Rectangle(e.getX(),e.getY(),32,32);
            

            if(atual.intersects(alvo)){
                
                if(e == objeto){
                    continue;
                }
                
                return e;          
            }
        }
        return null;    
    }
    
    //retorna qual entidade fixa esta colidindo
    public EntidadeFixa comQuemEstaColidindoFixo(int xnext, int ynext, EntidadeMovel objeto){
        Rectangle atual = new Rectangle(xnext,ynext,32,32);
        for(int i = 0; i < Jogo.entidadesFixas.size(); i++){
            EntidadeFixa e = Jogo.entidadesFixas.get(i);
            
            
            Rectangle alvo = new Rectangle(e.getX(),e.getY(),32,32);
            

            if(atual.intersects(alvo)){
                    
                if(e.getClass() == SetasDeMovimentacao.class){
                    continue;
                }
                
                return e;          
            }
        }
        return null;    
    }
    
    
    //verifica se esta colidindo com entidadeMovel
    public boolean estaColidindo(int xnext, int ynext, EntidadeMovel objeto){
        Rectangle atual = new Rectangle(xnext,ynext,28,28);
        if(objeto.getClass()==Antagonista.class){
            atual.setSize(32,32);
        }
        for(int i = 0; i < Jogo.entidadesMoveis.size(); i++){
            EntidadeMovel e = Jogo.entidadesMoveis.get(i);
            
            
            if (e == this){
                continue; 
            }
            Rectangle alvo = new Rectangle(e.getX(),e.getY(),28,28);
            

            if(atual.intersects(alvo)){
                
                if(e == objeto){
                    continue;
                }
                
                if(e.getClass()==EntidadeMovel.class && objeto.getClass() == Protagonista.class && !e.isLetal()){
                    
                    
                    
                
                    
                
                    if(xnext>objeto.getX()){
                        empurrar(e,1);
                    }else if(xnext<objeto.getX()){
                        empurrar(e,2);
                    }else if(ynext>objeto.getY()){
                        empurrar(e,3);
                    }else if(ynext<objeto.getY()){
                        empurrar(e,4);
                    }
                }
                
                
                if(e.getClass()== Protagonista.class && objeto.getClass() == Antagonista.class||e.getClass()==
                        Antagonista.class && objeto.getClass() == Protagonista.class){
                    Jogo.jogador.setVida(Jogo.jogador.getVida()-1);
                    if(Jogo.jogador.getVida()>0){
                        Jogo.restartFase();
                    }
                    return true;
                }
                return true;
            }
        }
        
        
        
        return false;
    }
    
    //verifica se esta colidindo com entidade Fixa
    public boolean estaColidindoFixo(int xnext, int ynext, EntidadeMovel objeto){
        
        Rectangle atual = new Rectangle(xnext,ynext,28,28);
        if(objeto.getClass()==Antagonista.class){
            atual.setSize(32,32);
        }
        for(int i = 0; i < Jogo.entidadesFixas.size(); i++){
            
            EntidadeFixa ef = Jogo.entidadesFixas.get(i);
            Rectangle alvof = new Rectangle(ef.getX(),ef.getY(),28,28);
            

            if(atual.intersects(alvof)){
                
                if(ef.getClass() == SetasDeMovimentacao.class && objeto.getClass() != Antagonista.class){
                    continue;
                }
                
                
                
                if(ef.getClass() == Coletavel.class && objeto.getClass()==Protagonista.class){
                    Jogo.jogador.setPontuacao(Jogo.jogador.getPontuacao()+ef.getValor()* (Jogo.jogador.getQuantidadeDeColetaveis()+1));
                    Jogo.jogador.setQuantidadeDeColetaveis(Jogo.jogador.getQuantidadeDeColetaveis()+1);
                    int ordem = Jogo.jogador.getQuantidadeDeColetaveis();
                    ef.setOrdem(ordem);
                    
                    ef.setX(10000);
                    ef.setY(10000);

                    
                    
                }
                
                return true;
            }
        }
        return false;
    }
    
    //empurra objeto movel
    public void empurrar(EntidadeMovel empurrado, int direção ){
       empurrado.setPodeMover(true);
       if(direção == 1 &&empurrado.getX()<335&& !estaColidindo(empurrado.getX()+5,empurrado.getY(),empurrado)
               && !estaColidindoFixo(empurrado.getX()+5,empurrado.getY(),empurrado)){
           if(!empurrado.isLetal()){
            empurrado.setPodeQuebrar(false);
           }
            empurrado.setX(empurrado.getX()+2);
       }
       else if(direção == 2 &&empurrado.getX()>16&& !estaColidindo(empurrado.getX()-5,empurrado.getY(),empurrado)
               && !estaColidindoFixo(empurrado.getX()-5,empurrado.getY(),empurrado)){
            if(!empurrado.isLetal()){
             empurrado.setPodeQuebrar(false);
            }
            empurrado.setX(empurrado.getX()-2);
       }
       else if(direção == 3 &&empurrado.getY()<335&& !estaColidindo(empurrado.getX(),empurrado.getY()+5,empurrado)
               && !estaColidindoFixo(empurrado.getX(),empurrado.getY()+5,empurrado)){
            if(!empurrado.isLetal()){
             empurrado.setPodeQuebrar(false);
            }
            empurrado.setY(empurrado.getY()+2);
       }
       else if(direção == 4 &&empurrado.getY()>16&& !estaColidindo(empurrado.getX(),empurrado.getY()-5,empurrado)
               && !estaColidindoFixo(empurrado.getX(),empurrado.getY()-5,empurrado)){
            if(!empurrado.isLetal()){
             empurrado.setPodeQuebrar(false);
            }         
            empurrado.setY(empurrado.getY()-2);
       }else{
           if(!empurrado.isTransponivel()){
              empurrado.setPodeQuebrar(true); 
           }
            
       }
    }

    
    


}

