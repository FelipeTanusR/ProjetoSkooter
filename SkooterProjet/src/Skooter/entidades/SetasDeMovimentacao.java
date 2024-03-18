/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Skooter.entidades;

import Skooter.controle.Jogo;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author fe_ta
 */
public class SetasDeMovimentacao extends EntidadeFixa {
    
    //1 = direita, 2 = esquerda, 3 = baixo, 4 = cima,;
    private int tipo;
    private boolean podeMover;
    private int contador;
    
    //construtor
    public SetasDeMovimentacao(int x, int y, int width, int height, boolean transponivel, boolean letal, BufferedImage sprite, int tipo) {
        super(x, y, width, height, transponivel, letal, sprite);
        this.tipo = tipo;
        this.podeMover = true;
        this.contador = 0;
    }
    
    //getter e setter
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    //chama a funcao de verificacao de empurrar a cada tick/frame
    public void tick(){
        DevoEmpurrar(this.x,this.y,this);
       
    }

    //verifica se existe necessidade de empurrar e chama, caso precise
    public void DevoEmpurrar(int xnext,int ynext, EntidadeFixa objeto){
               Rectangle atual = new Rectangle(xnext,ynext,28,28);
        
        for(int i = 0; i < Jogo.entidadesMoveis.size(); i++){
            
            EntidadeMovel ef = Jogo.entidadesMoveis.get(i);
            Rectangle alvof = new Rectangle(ef.getX(),ef.getY(),28,28);
            

            if(atual.intersects(alvof)){
                
                
                    
                if(ef.getClass() != Antagonista.class ){
                    
                    if(ef.podeMover){
                        if(ef.getObjetivo()==0){
                            if(ef.getClass()==Protagonista.class){
                                Jogo.jogador.setContadorMovimento(0);
                            }
                            if(objeto.getTipo()==1){
                                ef.setObjetivo(objeto.getX()+32);
                            } else if(objeto.getTipo()==2){
                                ef.setObjetivo(objeto.getX()-32);
                            }else if(objeto.getTipo()==3){
                                ef.setObjetivo(objeto.getY()+32);
                            }else if(objeto.getTipo()==4){
                                ef.setObjetivo(objeto.getY()-32);
                            }
                            
                            mover(ef,objeto.getTipo());
                            
                        }else{
                            mover(ef,ef.getMovimentoAtual());
                        }
                        
                        
                    }
                    

                }  
                continue;
            }  
        }
        for(int i = 0; i < Jogo.entidadesFixas.size(); i++){
            
            EntidadeFixa ef = Jogo.entidadesFixas.get(i);
            Rectangle alvof = new Rectangle(ef.getX(),ef.getY(),28,28);
            

            if(atual.intersects(alvof)){
                
                if(ef == objeto){
                    continue;
                }
                    
                
                    
                
                if(ef.getObjetivo()==0){
                   
                    if(objeto.getTipo()==1){
                        ef.setObjetivo(objeto.getX()+32);
                    } else if(objeto.getTipo()==2){
                        ef.setObjetivo(objeto.getX()-32);
                    }else if(objeto.getTipo()==3){
                        ef.setObjetivo(objeto.getY()+32);
                    }else if(objeto.getTipo()==4){
                        ef.setObjetivo(objeto.getY()-32);
                    }

                    moverFixo(ef,objeto.getTipo());

                }else{
                    moverFixo(ef,ef.getMovimentoAtual());
                }


                
                    

                  
                continue;
            }  
        }
        
    }
    
    //move os objetos moveis
    public void mover(EntidadeMovel empurrado, int tipo){
        empurrado.setMovimentoAtual(tipo);
        if(tipo == 1){
            if(empurrado.getX()<empurrado.getObjetivo() && !empurrado.estaColidindo(empurrado.getX()+1,empurrado.getY(),empurrado) 
                    && !empurrado.estaColidindoFixo(empurrado.getX()+1,empurrado.getY(),empurrado)){
                empurrado.setX(empurrado.getX()+2);
            }else if(empurrado.getX()>= empurrado.getObjetivo()){
                empurrado.setObjetivo(0);
                empurrado.setMovimentoAtual(0);
            }
        }else if(tipo == 2){
            if(empurrado.getX()>empurrado.getObjetivo() && !empurrado.estaColidindo(empurrado.getX()-1,empurrado.getY(),empurrado)
                    && !empurrado.estaColidindoFixo(empurrado.getX()+1,empurrado.getY(),empurrado)){
                empurrado.setX(empurrado.getX()-2);
            }else if(empurrado.getX()<= empurrado.getObjetivo()){
                empurrado.setObjetivo(0);
                empurrado.setMovimentoAtual(0);
            }
        }else if(tipo == 3){
            if(empurrado.getY()<empurrado.getObjetivo() && !empurrado.estaColidindo(empurrado.getX(),empurrado.getY()+1,empurrado)
                    && !empurrado.estaColidindoFixo(empurrado.getX()+1,empurrado.getY(),empurrado)){
                empurrado.setY(empurrado.getY()+2);
            }else if(empurrado.getY()>= empurrado.getObjetivo()){
                empurrado.setObjetivo(0);
                empurrado.setMovimentoAtual(0);
            }
        }else if(tipo == 4){
            if(empurrado.getY()>empurrado.getObjetivo() && !empurrado.estaColidindo(empurrado.getX(),empurrado.getY()-1,empurrado)
                    && !empurrado.estaColidindoFixo(empurrado.getX()+1,empurrado.getY(),empurrado)){
                empurrado.setY(empurrado.getY()-2);
            }else if(empurrado.getY()<= empurrado.getObjetivo()){
                empurrado.setObjetivo(0);
                empurrado.setMovimentoAtual(0);
            }
        }
        
        
    }
    
    //move os objetos fixos
    //sim, eu compreendo que a definicao de entidadeFixa implica que ele nao pode ser movido, contudo na fase 5
    //do jogo original eh possivel ver q as setas sao capazes de fazer isso, por isso defini essa func soh aqui
    public void moverFixo(EntidadeFixa empurrado, int tipo){
        empurrado.setPodeQuebrar(true);
        empurrado.setMovimentoAtual(tipo);
        if(tipo == 1){
            if(empurrado.getX()<empurrado.getObjetivo() && !empurrado.estaColidindo(empurrado.getX()+2,empurrado.getY(),empurrado)
                    && !empurrado.estaColidindoMovel(empurrado.getX()+2,empurrado.getY(),empurrado)){
                empurrado.setX(empurrado.getX()+2);
                
            }else if(empurrado.getX()>= empurrado.getObjetivo()){
                empurrado.setObjetivo(0);
                empurrado.setMovimentoAtual(0);
            }
        }else if(tipo == 2){
            if(empurrado.getX()>empurrado.getObjetivo() && !empurrado.estaColidindo(empurrado.getX()-2,empurrado.getY(),empurrado)
                    && !empurrado.estaColidindoMovel(empurrado.getX()+2,empurrado.getY(),empurrado)){
                empurrado.setX(empurrado.getX()-2);
            }else if(empurrado.getX()<= empurrado.getObjetivo()){
                empurrado.setObjetivo(0);
                empurrado.setMovimentoAtual(0);
            }
        }else if(tipo == 3){
            if(empurrado.getY()<empurrado.getObjetivo() && !empurrado.estaColidindo(empurrado.getX(),empurrado.getY()+2,empurrado)
                    && !empurrado.estaColidindoMovel(empurrado.getX()+2,empurrado.getY(),empurrado)){
                empurrado.setY(empurrado.getY()+2);
            }else if(empurrado.getY()>= empurrado.getObjetivo()){
                empurrado.setObjetivo(0);
                empurrado.setMovimentoAtual(0);
            }
        }else if(tipo == 4){
            if(empurrado.getY()>empurrado.getObjetivo() && !empurrado.estaColidindo(empurrado.getX(),empurrado.getY()-2,empurrado)
                    && !empurrado.estaColidindoMovel(empurrado.getX()+2,empurrado.getY(),empurrado)){
                empurrado.setY(empurrado.getY()-2);
            }else if(empurrado.getY()<= empurrado.getObjetivo()){
                empurrado.setObjetivo(0);
                empurrado.setMovimentoAtual(0);
            }
        }
        
        
    }
    
}
