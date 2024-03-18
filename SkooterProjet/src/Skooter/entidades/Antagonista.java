
package Skooter.entidades;

import Skooter.controle.Jogo;
import Skooter.graficos.Fase;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Antagonista extends EntidadeMovel{
     
    
    private int iDirecao;
    private boolean estaBatendo;
    //construtor
    public Antagonista(int x, int y, int width, int height, boolean transponivel, boolean letal, BufferedImage sprite) {
        super(x, y, width, height, transponivel, letal, sprite);  
        
        iDirecao = 0;     
    }
    //getters e setters
    public boolean isEstaBatendo() {
        return estaBatendo;
    }

    public void setEstaBatendo(boolean estaBatendo) {
        this.estaBatendo = estaBatendo;
    }
    //roda a logica de mov dos inimigos
    public void tick(){ 
        
        
        
        
        
        if(estaBatendo){
            Random rand = new Random();
            iDirecao = rand.nextInt(4);

        }
        if(this.getX()<335&&iDirecao == 0&& !estaColidindo(x+1,y,this)&& !estaColidindoFixo(x+1,y,this)){
            this.setX(getX()+1);
            estaBatendo = false;
        }else if(this.getX()>16 && iDirecao == 1 && !estaColidindo(x-1,y,this)&& !estaColidindoFixo(x-1,y,this)){
            this.setX(getX()-1);
            estaBatendo = false;
        }else if(this.getY()<335 && iDirecao == 2 && !estaColidindo(x,y+1,this)&& !estaColidindoFixo(x,y+1,this)){
            this.setY(getY()+1);
            estaBatendo = false;
        }else if(this.getY()>16 && iDirecao == 3 && !estaColidindo(x,y-1,this)&& !estaColidindoFixo(x,y-1,this)){
            this.setY(getY()-1);
            estaBatendo = false;
        }else{
            estaBatendo = true;
        }
                
            
            
        
        
   }


}
