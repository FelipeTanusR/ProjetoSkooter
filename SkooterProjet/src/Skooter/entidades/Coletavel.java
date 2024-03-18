/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Skooter.entidades;

import Skooter.controle.Jogo;
import static Skooter.controle.Jogo.HEIGHT;
import static Skooter.controle.Jogo.SCALE;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author fe_ta
 */
public class Coletavel extends EntidadeFixa{
    
    private int valor;
    

    
    //construtor
    public Coletavel(int x, int y, int width, int height, boolean transponivel, boolean letal, BufferedImage sprite, int valor) {
        super(x, y, width, height, transponivel, letal, sprite);
        this.valor = valor;
        this.setOrdem(0);
    }
    
    //getters e setters
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    //roda a logica de renderizacao dos coletaveis
    public void renderizar(Graphics g){
       
        g.drawImage(sprite,this.x*Jogo.SCALE,this.y*Jogo.SCALE, 32*Jogo.SCALE,32*Jogo.SCALE,null);
        if(this.getOrdem()==1){
            
            if(valor == 100){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x1",HEIGHT*SCALE + 40*SCALE , 250*SCALE);
            }else if(valor == 150){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x1",HEIGHT*SCALE + 40*SCALE , 285*SCALE);
            }else if(valor == 200){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x1",HEIGHT*SCALE + 40*SCALE , 320*SCALE);
            }else if(valor == 250){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x1",HEIGHT*SCALE + 40*SCALE , 355*SCALE);
            }
        }else if(this.getOrdem()==2){
            
            if(valor == 100){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x2",HEIGHT*SCALE + 40*SCALE , 250*SCALE);
            }else if(valor == 150){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x2",HEIGHT*SCALE + 40*SCALE , 285*SCALE);
            }else if(valor == 200){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x2",HEIGHT*SCALE + 40*SCALE , 320*SCALE);
            }else if(valor == 250){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x2",HEIGHT*SCALE + 40*SCALE , 355*SCALE);
            }
        }else if(this.getOrdem()==3){
            
            if(valor == 100){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x3",HEIGHT*SCALE + 40*SCALE , 250*SCALE);
            }else if(valor == 150){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x3",HEIGHT*SCALE + 40*SCALE , 285*SCALE);
            }else if(valor == 200){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x3",HEIGHT*SCALE + 40*SCALE , 320*SCALE);
            }else if(valor == 250){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x3",HEIGHT*SCALE + 40*SCALE , 355*SCALE);
            }
        }else if(this.getOrdem()==4){
            
            if(valor == 100){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x4",HEIGHT*SCALE + 40*SCALE , 250*SCALE);
            }else if(valor == 150){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x4",HEIGHT*SCALE + 40*SCALE , 285*SCALE);
            }else if(valor == 200){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x4",HEIGHT*SCALE + 40*SCALE , 320*SCALE);
            }else if(valor == 250){
                g.setFont(new Font ("Arial",Font.BOLD,15*SCALE));
                g.setColor(Color.red);
                g.drawString("x4",HEIGHT*SCALE + 40*SCALE , 355*SCALE);
            }
        }
    }
    

    
    
    
}
