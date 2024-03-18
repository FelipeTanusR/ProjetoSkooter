
package Skooter.entidades;

import Skooter.controle.Jogo;
import Skooter.graficos.SpriteSheet;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;


public abstract class Entidade {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean transponivel; // pode passar por cima?
    protected boolean letal; // se encostar morre?
    protected BufferedImage sprite;
    protected SpriteSheet sheet;
    protected boolean colidindo;
    
    //2 opc de construtores 
    public Entidade(){
        
    }
    
    public Entidade(int x, int y, int width, int height, boolean transponivel, boolean letal, BufferedImage sprite){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.transponivel = transponivel;
        this.letal = letal;
        this.sprite = sprite;
    }
   
    //metodo de renderizacao
    abstract public void renderizar(Graphics g);
    
    //metode de realizar acao
    public void tick(){
        
    }
    //metodod verificar colisao
    public boolean estaColidindo(int x, int y){
        return colidindo;
    }
    
    //getters e setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public boolean isTransponivel() {
        return transponivel;
    }

    public void setTransponivel(boolean transponivel) {
        this.transponivel = transponivel;
    }

    public boolean isLetal() {
        return letal;
    }

    public void setLetal(boolean letal) {
        this.letal = letal;
    }
    

    
}
