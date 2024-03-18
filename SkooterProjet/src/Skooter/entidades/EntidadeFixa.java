
package Skooter.entidades;

import Skooter.controle.Jogo;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;


public class EntidadeFixa extends Entidade implements Serializable{

    
    private int tipo;
    private int objetivo;
    private int movimentoAtual;
    private boolean PodeMover;
    
    //construtor
    public EntidadeFixa(int x, int y, int width, int height, boolean transponivel, boolean letal, BufferedImage sprite) {
        super(x, y, width, height, transponivel, letal, sprite);
        this.podeQuebrar = false;
    }
    
    //getters e setters
    public boolean isPodeMover() {
        return PodeMover;
    }

    public void setPodeMover(boolean PodeMover) {
        this.PodeMover = PodeMover;
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }

    public int getMovimentoAtual() {
        return movimentoAtual;
    }

    public void setMovimentoAtual(int movimentoAtual) {
        this.movimentoAtual = movimentoAtual;
    }

    public boolean isPodeQuebrar() {
        return podeQuebrar;
    }

    public void setPodeQuebrar(boolean podeQuebrar) {
        this.podeQuebrar = podeQuebrar;
    }
    private boolean podeQuebrar;
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    private int ordem;
     
    public BufferedImage getSprite(){
        return sprite;
    }
    
    int getValor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setOrdem(int quantidadeDeColetaveis) {
        this.ordem = quantidadeDeColetaveis;
    }
    public int getOrdem(){
        return this.ordem;
    }
    
    
    //renderiza na tela
    @Override
    public void renderizar(Graphics g){
        g.drawImage(sprite,this.x*Jogo.SCALE,this.y*Jogo.SCALE, 32*Jogo.SCALE,32*Jogo.SCALE,null);

    }
    
    //verifica se esta colidindo
    public boolean estaColidindo(int xnext, int ynext, EntidadeFixa objeto){
        Rectangle atual = new Rectangle(xnext,ynext,29,29);
        for(int i = 0; i < Jogo.entidadesMoveis.size(); i++){
            EntidadeMovel e = Jogo.entidadesMoveis.get(i);



            Rectangle alvo = new Rectangle(e.getX(),e.getY(),29,29);


            if(atual.intersects(alvo)){


                return true;
            }
        }
        for(int i = 0; i < Jogo.entidadesFixas.size(); i++){
            
            EntidadeFixa ef = Jogo.entidadesFixas.get(i);
            
            
            
            Rectangle alvof = new Rectangle(ef.getX(),ef.getY(),29,29);

            if(atual.intersects(alvof)){
                if(ef == objeto){
                    continue;
                }
                if(ef.getClass() == EntidadeFixa.class && objeto.getClass() == EntidadeFixa.class){
                    return true;
                }
                if(ef.getClass() == SetasDeMovimentacao.class && objeto.getClass() == EntidadeFixa.class){
                    return false;
                }
                if(ef.getClass()==EntidadeFixa.class){
                    return true;
                }
                if(ef.getClass() == SetasDeMovimentacao.class){
                    objeto.setPodeQuebrar(true);
                }
                
                
                return true;
            }
        } 
        return false;
    }
    
    //verifica se esta colidindo com objetos moveis especificamentes
    public boolean estaColidindoMovel(int xnext, int ynext, EntidadeFixa objeto){
                Rectangle atual = new Rectangle(xnext,ynext,29,29);
        for(int i = 0; i < Jogo.entidadesMoveis.size(); i++){
            EntidadeMovel e = Jogo.entidadesMoveis.get(i);
            
            
             
            Rectangle alvo = new Rectangle(e.getX(),e.getY(),29,29);
            

            if(atual.intersects(alvo)){
                
                
                return true;
            }
        }
        return false;
    }
    




    

    

}
