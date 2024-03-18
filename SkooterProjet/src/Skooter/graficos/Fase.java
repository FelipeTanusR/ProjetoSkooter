
package Skooter.graficos;

import Skooter.controle.Jogo;
import Skooter.entidades.Antagonista;
import Skooter.entidades.Coletavel;
import Skooter.entidades.EntidadeFixa;
import Skooter.entidades.EntidadeMovel;
import Skooter.entidades.Protagonista;
import Skooter.entidades.SetasDeMovimentacao;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.text.html.HTML.Tag.EM;


public class Fase {


    protected SpriteSheet sheet;
    protected SpriteSheet TelasEspeciais;
    protected int Level;
    public List<EntidadeMovel> entidadesMoveis;
    public List<EntidadeFixa> entidadesFixas;
    public Protagonista jogador;

    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    
   //inicia array lists e chama a func de escolher fase 
    public Fase(int i){
        entidadesMoveis = new ArrayList<EntidadeMovel>();
        entidadesFixas = new ArrayList<EntidadeFixa>();
        this.setLevel(i);
        TelasEspeciais = new SpriteSheet("/res/TelasEspeciais.png");
        sheet = new SpriteSheet("/res/Spritesheet.png");
        addEntMov(Level); 
    }
    
    //chama as func baseado em qual level esta
    public void addEntMov(int Level){
        
        switch(Level){
            case 0:
                telaDeInicio();
                break;
            case 1:
                Level1();
                break;
            case 2:
                Level2();
                break;
            case 3:
                Level3();
                break;
            case 4:
                Level4();
                break;
            case 5:
                Level5();
                break;
            case 6:
                Conclusao();
                break;
            case 7:
                GameOver();
                break;
        }      
    }   
    
    //retorna ArrayList de EntidadesMoveis
    public List<EntidadeMovel> entidadesMoveis(){
        
        return entidadesMoveis;     
    }
    
    //retorna ArrayList de EnitadesFixas
    public List<EntidadeFixa> entidadesFixas(){
        
        return entidadesFixas;     
    }
    
    public void telaDeInicio(){
        EntidadeFixa tela = new EntidadeFixa(0,0,Jogo.WIDTH*Jogo.SCALE,Jogo.HEIGHT*Jogo.SCALE,false,false,
                TelasEspeciais.getSprite(0,0,Jogo.WIDTH,Jogo.HEIGHT));
        jogador = new Protagonista(16+(16*4)*Jogo.SCALE,16+(16*4)*Jogo.SCALE,16*Jogo.SCALE,16*Jogo.SCALE,true,false,sheet.getSprite(0,0,32,32));
        entidadesMoveis.add(jogador);
        entidadesFixas.add(tela);
    }
    
    public void GameOver(){
        EntidadeFixa tela = new EntidadeFixa(0,0,Jogo.WIDTH*Jogo.SCALE,Jogo.HEIGHT*Jogo.SCALE,false,false,
                TelasEspeciais.getSprite(0,384,Jogo.WIDTH,Jogo.HEIGHT));
        jogador = new Protagonista(16+(16*4)*Jogo.SCALE,16+(16*4)*Jogo.SCALE,16*Jogo.SCALE,16*Jogo.SCALE,true,false,sheet.getSprite(0,0,32,32));
        entidadesMoveis.add(jogador);
        entidadesFixas.add(tela);
    }
    
    public void Conclusao(){
        EntidadeFixa tela = new EntidadeFixa(0,0,Jogo.WIDTH*Jogo.SCALE,Jogo.HEIGHT*Jogo.SCALE,false,false,
                TelasEspeciais.getSprite(0,768,Jogo.WIDTH,Jogo.HEIGHT));
        jogador = new Protagonista(16+(16*4)*Jogo.SCALE,16+(16*4)*Jogo.SCALE,16*Jogo.SCALE,16*Jogo.SCALE,true,false,sheet.getSprite(0,0,32,32));
        entidadesMoveis.add(jogador);
        entidadesFixas.add(tela);
    }
    
    public void Level1(){
        jogador = new Protagonista(16+(16*4)*Jogo.SCALE,16+(16*4)*Jogo.SCALE,16*Jogo.SCALE,16*Jogo.SCALE,true,false,sheet.getSprite(0,0,32,32));
        entidadesMoveis.add(jogador);
        
        EntidadeFixa[] blocoVerm = new EntidadeFixa[25];
        blocoVerm[0] = new EntidadeFixa(16+(32*1),16+(32*1),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[1] = new EntidadeFixa(16+(32*1),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[2] = new EntidadeFixa(16+(32*1),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[3] = new EntidadeFixa(16+(32*1),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[4] = new EntidadeFixa(16+(32*1),16+(32*9),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[5] = new EntidadeFixa(16+(32*3),16+(32*1),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[6] = new EntidadeFixa(16+(32*3),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[7] = new EntidadeFixa(16+(32*3),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[8] = new EntidadeFixa(16+(32*3),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[9] = new EntidadeFixa(16+(32*3),16+(32*9),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[10] = new EntidadeFixa(16+(32*5),16+(32*1),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[11] = new EntidadeFixa(16+(32*5),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[12] = new EntidadeFixa(16+(32*5),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[13] = new EntidadeFixa(16+(32*5),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[14] = new EntidadeFixa(16+(32*5),16+(32*9),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[15] = new EntidadeFixa(16+(32*7),16+(32*1),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[16] = new EntidadeFixa(16+(32*7),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[17] = new EntidadeFixa(16+(32*7),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[18] = new EntidadeFixa(16+(32*7),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[19] = new EntidadeFixa(16+(32*7),16+(32*9),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[20] = new EntidadeFixa(16+(32*9),16+(32*1),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[21] = new EntidadeFixa(16+(32*9),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[22] = new EntidadeFixa(16+(32*9),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[23] = new EntidadeFixa(16+(32*9),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32)); 
        blocoVerm[24] = new EntidadeFixa(16+(32*9),16+(32*9),32,32,false,false,sheet.getSprite(128,32,32,32));
        
        EntidadeFixa[] colecionavel = new EntidadeFixa[8];
        //coletaveis no mapa
        //morango
        colecionavel[0] = new Coletavel(16+(32*0),16+(32*10),32,32,true,false,sheet.getSprite(0, 32, 32, 32),100);
        //uva
        colecionavel[1] = new Coletavel(16+(32*0),16+(32*0),32,32,true,false,sheet.getSprite(32, 32, 32, 32),250);
        //limao
        colecionavel[2] = new Coletavel(16+(32*10),16+(32*0),32,32,true,false,sheet.getSprite(64, 32, 32, 32),150);
        //cereja
        colecionavel[3] = new Coletavel(16+(32*10),16+(32*10),32,32,true,false,sheet.getSprite(96, 32, 32, 32),200);
        //tela de consumiveis
        colecionavel[4] = new Coletavel(440,220,32,32,true,false,sheet.getSprite(0, 32, 32, 32),100);
        colecionavel[5] = new Coletavel(440,328,32,32,true,false,sheet.getSprite(32, 32, 32, 32),250);
        colecionavel[6] = new Coletavel(440,256,32,32,true,false,sheet.getSprite(64, 32, 32, 32),150);
        colecionavel[7] = new Coletavel(440,292,32,32,true,false,sheet.getSprite(96, 32, 32, 32),200);

        EntidadeMovel[] blocoVerd = new EntidadeMovel[24];
        blocoVerd[0] = new EntidadeMovel(16+(32*1),16+(32*0),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[1] = new EntidadeMovel(16+(32*5),16+(32*0),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[2] = new EntidadeMovel(16+(32*2),16+(32*1),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[3] = new EntidadeMovel(16+(32*8),16+(32*1),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[4] = new EntidadeMovel(16+(32*10),16+(32*1),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[5] = new EntidadeMovel(16+(32*1),16+(32*2),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[6] = new EntidadeMovel(16+(32*5),16+(32*2),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[7] = new EntidadeMovel(16+(32*0),16+(32*3),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[8] = new EntidadeMovel(16+(32*8),16+(32*3),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[9] = new EntidadeMovel(16+(32*1),16+(32*4),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[10] = new EntidadeMovel(16+(32*9),16+(32*4),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[11] = new EntidadeMovel(16+(32*2),16+(32*5),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[12] = new EntidadeMovel(16+(32*6),16+(32*5),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[13] = new EntidadeMovel(16+(32*5),16+(32*6),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[14] = new EntidadeMovel(16+(32*7),16+(32*6),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[15] = new EntidadeMovel(16+(32*8),16+(32*7),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[16] = new EntidadeMovel(16+(32*10),16+(32*7),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[17] = new EntidadeMovel(16+(32*3),16+(32*8),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[18] = new EntidadeMovel(16+(32*9),16+(32*8),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[19] = new EntidadeMovel(16+(32*0),16+(32*9),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[20] = new EntidadeMovel(16+(32*2),16+(32*9),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[21] = new EntidadeMovel(16+(32*6),16+(32*9),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[22] = new EntidadeMovel(16+(32*8),16+(32*9),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        blocoVerd[23] = new EntidadeMovel(16+(32*7),16+(32*10),32,32,false,false,sheet.getSprite(64,64,32,32)); 
        
        Antagonista[] antagonista = new Antagonista[4];
        //amarelo
        antagonista[0] = new Antagonista(16+(32*0),16+(32*2),32,32,true,true,sheet.getSprite(32,0,32,32));
        //verde
        antagonista[1] = new Antagonista(16+(32*9),16+(32*10),32,32,true,true,sheet.getSprite(64,0,32,32));
        //rosa
        antagonista[2] = new Antagonista(16+(32*9),16+(32*0),32,32,true,true,sheet.getSprite(96,0,32,32));
        //azul
        antagonista[3] = new Antagonista(16+(32*1),16+(32*10),32,32,true,true,sheet.getSprite(128,0,32,32));

        for(int i = 0; i<25; i++){
            entidadesFixas.add(blocoVerm[i]);
        }
        for(int i = 0; i<8; i++){
            entidadesFixas.add(colecionavel[i]);
        }
        for(int i = 0; i<24; i++){
            entidadesMoveis.add(blocoVerd[i]);
        }
        for(int i = 0; i<4; i++){
            entidadesMoveis.add(antagonista[i]);
        } 
        
    }

    public void Level2() {
        
        Jogo.jogador.setX(16+(32*5));
        Jogo.jogador.setY(16+(32*5));
        entidadesMoveis.add(Jogo.jogador);
        
        
        SetasDeMovimentacao[] seta = new SetasDeMovimentacao[33];
        //seta Direita 9
        seta[0] = new SetasDeMovimentacao(16+(32*3), 16+(32*0),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[1] = new SetasDeMovimentacao(16+(32*3), 16+(32*2),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[2] = new SetasDeMovimentacao(16+(32*3), 16+(32*4),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[3] = new SetasDeMovimentacao(16+(32*3), 16+(32*6),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[4] = new SetasDeMovimentacao(16+(32*3), 16+(32*8),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[5] = new SetasDeMovimentacao(16+(32*7), 16+(32*0),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[6] = new SetasDeMovimentacao(16+(32*7), 16+(32*10),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[7] = new SetasDeMovimentacao(16+(32*7), 16+(32*4),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[8] = new SetasDeMovimentacao(16+(32*7), 16+(32*8),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        
        //seta Baixo 6
        seta[9] = new SetasDeMovimentacao(16+(32*2), 16+(32*3),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[10] = new SetasDeMovimentacao(16+(32*2), 16+(32*7),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[11] = new SetasDeMovimentacao(16+(32*4), 16+(32*2),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[12] = new SetasDeMovimentacao(16+(32*4), 16+(32*3),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[13] = new SetasDeMovimentacao(16+(32*4), 16+(32*7),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[32] = new SetasDeMovimentacao(16+(32*10), 16+(32*3),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        
        //Seta Cima 11
        seta[14] = new SetasDeMovimentacao(16+(32*0), 16+(32*3),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[15] = new SetasDeMovimentacao(16+(32*0), 16+(32*4),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[16] = new SetasDeMovimentacao(16+(32*0), 16+(32*5),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[17] = new SetasDeMovimentacao(16+(32*0), 16+(32*6),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[18] = new SetasDeMovimentacao(16+(32*0), 16+(32*7),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[19] = new SetasDeMovimentacao(16+(32*6), 16+(32*3),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[20] = new SetasDeMovimentacao(16+(32*6), 16+(32*7),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[21] = new SetasDeMovimentacao(16+(32*8), 16+(32*3),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[22] = new SetasDeMovimentacao(16+(32*8), 16+(32*4),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[23] = new SetasDeMovimentacao(16+(32*8), 16+(32*7),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[24] = new SetasDeMovimentacao(16+(32*10), 16+(32*7),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        
        //Seta Esquerda 7
        seta[25] = new SetasDeMovimentacao(16+(32*3), 16+(32*10),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[26] = new SetasDeMovimentacao(16+(32*5), 16+(32*2),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[27] = new SetasDeMovimentacao(16+(32*6), 16+(32*2),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[28] = new SetasDeMovimentacao(16+(32*7), 16+(32*2),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[29] = new SetasDeMovimentacao(16+(32*7), 16+(32*6),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[30] = new SetasDeMovimentacao(16+(32*9), 16+(32*4),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[31] = new SetasDeMovimentacao(16+(32*10), 16+(32*4),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        

        EntidadeFixa[] blocoVerm = new EntidadeFixa[16];
        blocoVerm[0] = new EntidadeFixa(16+(32*1),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[1] = new EntidadeFixa(16+(32*1),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[2] = new EntidadeFixa(16+(32*3),16+(32*1),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[3] = new EntidadeFixa(16+(32*3),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[4] = new EntidadeFixa(16+(32*3),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[5] = new EntidadeFixa(16+(32*3),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[6] = new EntidadeFixa(16+(32*3),16+(32*9),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[7] = new EntidadeFixa(16+(32*5),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[8] = new EntidadeFixa(16+(32*5),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[9] = new EntidadeFixa(16+(32*7),16+(32*1),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[10] = new EntidadeFixa(16+(32*7),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[11] = new EntidadeFixa(16+(32*7),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[12] = new EntidadeFixa(16+(32*7),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[13] = new EntidadeFixa(16+(32*7),16+(32*9),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[14] = new EntidadeFixa(16+(32*9),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVerm[15] = new EntidadeFixa(16+(32*9),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32));
        
        
        
        EntidadeFixa[] colecionavel = new EntidadeFixa[8];
        //coletaveis no mapa
        //morango
        colecionavel[0] = new Coletavel(16+(32*9),16+(32*5),32,32,true,false,sheet.getSprite(0, 32, 32, 32),100);
        //uva
        colecionavel[1] = new Coletavel(16+(32*5),16+(32*1),32,32,true,false,sheet.getSprite(32, 32, 32, 32),250);
        //limao
        colecionavel[2] = new Coletavel(16+(32*1),16+(32*5),32,32,true,false,sheet.getSprite(64, 32, 32, 32),150);
        //cereja
        colecionavel[3] = new Coletavel(16+(32*5),16+(32*9),32,32,true,false,sheet.getSprite(96, 32, 32, 32),200);
        //tela de consumiveis
        colecionavel[4] = new Coletavel(440,220,32,32,true,false,sheet.getSprite(0, 32, 32, 32),100);
        colecionavel[5] = new Coletavel(440,328,32,32,true,false,sheet.getSprite(32, 32, 32, 32),250);
        colecionavel[6] = new Coletavel(440,256,32,32,true,false,sheet.getSprite(64, 32, 32, 32),150);
        colecionavel[7] = new Coletavel(440,292,32,32,true,false,sheet.getSprite(96, 32, 32, 32),200);
        
        
        Antagonista[] antagonista = new Antagonista[4];
        //amarelo
        antagonista[0] = new Antagonista(16+(32*1),16+(32*1),32,32,true,true,sheet.getSprite(32,0,32,32));
        //verde
        antagonista[1] = new Antagonista(16+(32*9),16+(32*1),32,32,true,true,sheet.getSprite(64,0,32,32));
        //rosa
        antagonista[2] = new Antagonista(16+(32*1),16+(32*9),32,32,true,true,sheet.getSprite(96,0,32,32));
        //azul
        antagonista[3] = new Antagonista(16+(32*9),16+(32*9),32,32,true,true,sheet.getSprite(128,0,32,32));
     
        for(int i = 0; i<4; i++){
            entidadesMoveis.add(antagonista[i]);
        }
        for(int i = 0; i<33; i++){
            entidadesFixas.add(seta[i]);
        }
        for(int i = 0; i<16; i++){
            entidadesFixas.add(blocoVerm[i]);
        }
        for(int i = 0; i<8; i++){
            entidadesFixas.add(colecionavel[i]);
        }
 
    }
    
    public void Level3(){
        Jogo.jogador.setX(16+(32*5));
        Jogo.jogador.setY(16+(32*5));
        entidadesMoveis.add(Jogo.jogador);
        
        EntidadeMovel[] blocoVermPret = new EntidadeMovel [48];
        blocoVermPret[0] = new EntidadeMovel(16+(32*1), 16+(32*1),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[1] = new EntidadeMovel(16+(32*1), 16+(32*2),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[2] = new EntidadeMovel(16+(32*1), 16+(32*3),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[3] = new EntidadeMovel(16+(32*1), 16+(32*4),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[4] = new EntidadeMovel(16+(32*1), 16+(32*5),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[5] = new EntidadeMovel(16+(32*1), 16+(32*6),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[6] = new EntidadeMovel(16+(32*1), 16+(32*7),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[7] = new EntidadeMovel(16+(32*1), 16+(32*8),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[8] = new EntidadeMovel(16+(32*1), 16+(32*9),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[9] = new EntidadeMovel(16+(32*9), 16+(32*1),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[10] = new EntidadeMovel(16+(32*9), 16+(32*2),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[11] = new EntidadeMovel(16+(32*9), 16+(32*3),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[12] = new EntidadeMovel(16+(32*9), 16+(32*4),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[13] = new EntidadeMovel(16+(32*9), 16+(32*5),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[14] = new EntidadeMovel(16+(32*9), 16+(32*6),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[15] = new EntidadeMovel(16+(32*9), 16+(32*7),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[16] = new EntidadeMovel(16+(32*9), 16+(32*8),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[17] = new EntidadeMovel(16+(32*9), 16+(32*9),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[18] = new EntidadeMovel(16+(32*2), 16+(32*1),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[19] = new EntidadeMovel(16+(32*3), 16+(32*1),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[20] = new EntidadeMovel(16+(32*4), 16+(32*1),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[21] = new EntidadeMovel(16+(32*5), 16+(32*1),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[22] = new EntidadeMovel(16+(32*6), 16+(32*1),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[23] = new EntidadeMovel(16+(32*7), 16+(32*1),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[24] = new EntidadeMovel(16+(32*8), 16+(32*1),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[25] = new EntidadeMovel(16+(32*2), 16+(32*9),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[26] = new EntidadeMovel(16+(32*3), 16+(32*9),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[27] = new EntidadeMovel(16+(32*4), 16+(32*9),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[28] = new EntidadeMovel(16+(32*5), 16+(32*9),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[29] = new EntidadeMovel(16+(32*6), 16+(32*9),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[30] = new EntidadeMovel(16+(32*7), 16+(32*9),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[31] = new EntidadeMovel(16+(32*8), 16+(32*9),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        //quadrado interior
        blocoVermPret[32] = new EntidadeMovel(16+(32*3), 16+(32*3),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[33] = new EntidadeMovel(16+(32*3), 16+(32*4),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[34] = new EntidadeMovel(16+(32*3), 16+(32*5),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[35] = new EntidadeMovel(16+(32*3), 16+(32*6),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[36] = new EntidadeMovel(16+(32*3), 16+(32*7),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[37] = new EntidadeMovel(16+(32*7), 16+(32*3),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[38] = new EntidadeMovel(16+(32*7), 16+(32*4),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[39] = new EntidadeMovel(16+(32*7), 16+(32*5),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[40] = new EntidadeMovel(16+(32*7), 16+(32*6),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[41] = new EntidadeMovel(16+(32*7), 16+(32*7),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[42] = new EntidadeMovel(16+(32*4), 16+(32*3),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[43] = new EntidadeMovel(16+(32*5), 16+(32*3),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[44] = new EntidadeMovel(16+(32*6), 16+(32*3),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[45] = new EntidadeMovel(16+(32*4), 16+(32*7),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[46] = new EntidadeMovel(16+(32*5), 16+(32*7),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[47] = new EntidadeMovel(16+(32*6), 16+(32*7),32,32,true,true,sheet.getSprite(32, 64, 32, 32));
        
        
        EntidadeFixa[] colecionavel = new EntidadeFixa[8];
        //coletaveis no mapa
        //morango
        colecionavel[0] = new Coletavel(16+(32*2),16+(32*5),32,32,true,false,sheet.getSprite(0, 32, 32, 32),100);
        //uva
        colecionavel[1] = new Coletavel(16+(32*0),16+(32*5),32,32,true,false,sheet.getSprite(32, 32, 32, 32),250);
        //limao
        colecionavel[2] = new Coletavel(16+(32*8),16+(32*5),32,32,true,false,sheet.getSprite(64, 32, 32, 32),150);
        //cereja
        colecionavel[3] = new Coletavel(16+(32*10),16+(32*5),32,32,true,false,sheet.getSprite(96, 32, 32, 32),200);
        //tela de consumiveis
        colecionavel[4] = new Coletavel(440,220,32,32,true,false,sheet.getSprite(0, 32, 32, 32),100);
        colecionavel[5] = new Coletavel(440,328,32,32,true,false,sheet.getSprite(32, 32, 32, 32),250);
        colecionavel[6] = new Coletavel(440,256,32,32,true,false,sheet.getSprite(64, 32, 32, 32),150);
        colecionavel[7] = new Coletavel(440,292,32,32,true,false,sheet.getSprite(96, 32, 32, 32),200);
        
        Antagonista[] antagonista = new Antagonista[4];
        //amarelo
        antagonista[0] = new Antagonista(16+(32*5),16+(32*0),32,32,true,true,sheet.getSprite(32,0,32,32));
        //verde
        antagonista[1] = new Antagonista(16+(32*5),16+(32*10),32,32,true,true,sheet.getSprite(64,0,32,32));
        //rosa
        antagonista[2] = new Antagonista(16+(32*5),16+(32*2),32,32,true,true,sheet.getSprite(96,0,32,32));
        //azul
        antagonista[3] = new Antagonista(16+(32*5),16+(32*8),32,32,true,true,sheet.getSprite(128,0,32,32));
        
        for(int i = 0; i<48;i++){
            blocoVermPret[i].setPodeQuebrar(false);
            blocoVermPret[i].setLetal(false);            
            entidadesMoveis.add(blocoVermPret[i]);
        }
        for(int i = 0; i<4;i++){            
            entidadesMoveis.add(antagonista[i]);
        }
        for(int i = 0; i<8;i++){            
            entidadesFixas.add(colecionavel[i]);
        }
    }
    
    public void Level4(){
        Jogo.jogador.setX(16+(32*5));
        Jogo.jogador.setY(16+(32*4));
        entidadesMoveis.add(Jogo.jogador);
        
        EntidadeFixa[] blocoVerdSem = new EntidadeFixa[41];
        blocoVerdSem[0] = new EntidadeFixa(16 + (32*1), 16 + (32*1),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[1] = new EntidadeFixa(16 + (32*1), 16 + (32*3),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[2] = new EntidadeFixa(16 + (32*1), 16 + (32*5),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[3] = new EntidadeFixa(16 + (32*1), 16 + (32*7),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[4] = new EntidadeFixa(16 + (32*1), 16 + (32*9),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[5] = new EntidadeFixa(16 + (32*2), 16 + (32*2),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[6] = new EntidadeFixa(16 + (32*2), 16 + (32*4),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[7] = new EntidadeFixa(16 + (32*2), 16 + (32*6),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[8] = new EntidadeFixa(16 + (32*2), 16 + (32*8),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[9] = new EntidadeFixa(16 + (32*3), 16 + (32*1),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[10] = new EntidadeFixa(16 + (32*3), 16 + (32*3),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[11] = new EntidadeFixa(16 + (32*3), 16 + (32*5),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[12] = new EntidadeFixa(16 + (32*3), 16 + (32*7),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[13] = new EntidadeFixa(16 + (32*3), 16 + (32*9),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[14] = new EntidadeFixa(16 + (32*4), 16 + (32*2),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[15] = new EntidadeFixa(16 + (32*4), 16 + (32*4),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[16] = new EntidadeFixa(16 + (32*4), 16 + (32*6),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[17] = new EntidadeFixa(16 + (32*4), 16 + (32*8),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[18] = new EntidadeFixa(16 + (32*5), 16 + (32*1),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[19] = new EntidadeFixa(16 + (32*5), 16 + (32*3),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[20] = new EntidadeFixa(16 + (32*5), 16 + (32*5),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[21] = new EntidadeFixa(16 + (32*5), 16 + (32*7),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[22] = new EntidadeFixa(16 + (32*5), 16 + (32*9),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[23] = new EntidadeFixa(16 + (32*6), 16 + (32*2),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[24] = new EntidadeFixa(16 + (32*6), 16 + (32*4),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[25] = new EntidadeFixa(16 + (32*6), 16 + (32*6),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[26] = new EntidadeFixa(16 + (32*6), 16 + (32*8),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[27] = new EntidadeFixa(16 + (32*7), 16 + (32*1),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[28] = new EntidadeFixa(16 + (32*7), 16 + (32*3),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[29] = new EntidadeFixa(16 + (32*7), 16 + (32*5),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[30] = new EntidadeFixa(16 + (32*7), 16 + (32*7),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[31] = new EntidadeFixa(16 + (32*7), 16 + (32*9),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[32] = new EntidadeFixa(16 + (32*8), 16 + (32*2),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[33] = new EntidadeFixa(16 + (32*8), 16 + (32*4),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[34] = new EntidadeFixa(16 + (32*8), 16 + (32*6),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[35] = new EntidadeFixa(16 + (32*8), 16 + (32*8),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[36] = new EntidadeFixa(16 + (32*9), 16 + (32*1),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[37] = new EntidadeFixa(16 + (32*9), 16 + (32*3),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[38] = new EntidadeFixa(16 + (32*9), 16 + (32*5),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[39] = new EntidadeFixa(16 + (32*9), 16 + (32*7),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[40] = new EntidadeFixa(16 + (32*9), 16 + (32*9),32,32, false, false, sheet.getSprite(0, 64, 32, 32));
        
        EntidadeFixa[] blocoVermSem = new EntidadeFixa[15];
        blocoVermSem[0] = new EntidadeFixa(16+(32*0),16+(32*1),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[1] = new EntidadeFixa(16+(32*0),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[2] = new EntidadeFixa(16+(32*1),16+(32*8),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[3] = new EntidadeFixa(16+(32*1),16+(32*10),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[4] = new EntidadeFixa(16+(32*2),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[5] = new EntidadeFixa(16+(32*2),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[6] = new EntidadeFixa(16+(32*3),16+(32*0),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[7] = new EntidadeFixa(16+(32*3),16+(32*6),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[8] = new EntidadeFixa(16+(32*5),16+(32*2),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[9] = new EntidadeFixa(16+(32*7),16+(32*0),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[10] = new EntidadeFixa(16+(32*7),16+(32*8),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[11] = new EntidadeFixa(16+(32*8),16+(32*1),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[12] = new EntidadeFixa(16+(32*8),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[13] = new EntidadeFixa(16+(32*10),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[14] = new EntidadeFixa(16+(32*10),16+(32*8),32,32,false,false,sheet.getSprite(128,32,32,32));
        
        
        EntidadeFixa[] colecionavel = new EntidadeFixa[8];
        //coletaveis no mapa
        //morango
        colecionavel[0] = new Coletavel(16+(32*0),16+(32*10),32,32,true,false,sheet.getSprite(0, 32, 32, 32),100);
        //uva
        colecionavel[1] = new Coletavel(16+(32*0),16+(32*0),32,32,true,false,sheet.getSprite(32, 32, 32, 32),250);
        //limao
        colecionavel[2] = new Coletavel(16+(32*10),16+(32*0),32,32,true,false,sheet.getSprite(64, 32, 32, 32),150);
        //cereja
        colecionavel[3] = new Coletavel(16+(32*10),16+(32*10),32,32,true,false,sheet.getSprite(96, 32, 32, 32),200);
        //tela de consumiveis
        colecionavel[4] = new Coletavel(440,220,32,32,true,false,sheet.getSprite(0, 32, 32, 32),100);
        colecionavel[5] = new Coletavel(440,328,32,32,true,false,sheet.getSprite(32, 32, 32, 32),250);
        colecionavel[6] = new Coletavel(440,256,32,32,true,false,sheet.getSprite(64, 32, 32, 32),150);
        colecionavel[7] = new Coletavel(440,292,32,32,true,false,sheet.getSprite(96, 32, 32, 32),200);
        
        Antagonista[] antagonista = new Antagonista[4];
        //amarelo
        antagonista[0] = new Antagonista(16+(32*5),16+(32*0),32,32,true,true,sheet.getSprite(32,0,32,32));
        //verde
        antagonista[1] = new Antagonista(16+(32*0),16+(32*5),32,32,true,true,sheet.getSprite(64,0,32,32));
        //rosa
        antagonista[2] = new Antagonista(16+(32*5),16+(32*10),32,32,true,true,sheet.getSprite(96,0,32,32));
        //azul
        antagonista[3] = new Antagonista(16+(32*10),16+(32*5),32,32,true,true,sheet.getSprite(128,0,32,32));
        
        
        for(int i =0; i<41;i++){
            blocoVerdSem[i].setPodeQuebrar(true);
            entidadesFixas.add(blocoVerdSem[i]);
        }
        for(int i =0; i<15;i++){
            blocoVermSem[i].setPodeQuebrar(false);
            entidadesFixas.add(blocoVermSem[i]);
        }
        for(int i =0; i<8;i++){
            entidadesFixas.add(colecionavel[i]);
        }
        for(int i =0; i<4;i++){
            entidadesMoveis.add(antagonista[i]);
        }
        
                
    }
    
    public void Level5(){
        Jogo.jogador.setX(16+(32*8));
        Jogo.jogador.setY(16+(32*2));
        entidadesMoveis.add(Jogo.jogador);
        
        Antagonista[] antagonista = new Antagonista[4];
        //amarelo
        antagonista[0] = new Antagonista(16+(32*0),16+(32*0),32,32,true,true,sheet.getSprite(32,0,32,32));
        //verde
        antagonista[1] = new Antagonista(16+(32*1),16+(32*1),32,32,true,true,sheet.getSprite(64,0,32,32));
        //rosa
        antagonista[2] = new Antagonista(16+(32*0),16+(32*1),32,32,true,true,sheet.getSprite(96,0,32,32));
        //azul
        antagonista[3] = new Antagonista(16+(32*1),16+(32*0),32,32,true,true,sheet.getSprite(128,0,32,32));
        
        EntidadeFixa[] blocoVermSem = new EntidadeFixa[17];
        blocoVermSem[0] = new EntidadeFixa(16+(32*0),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[1] = new EntidadeFixa(16+(32*1),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[2] = new EntidadeFixa(16+(32*2),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[3] = new EntidadeFixa(16+(32*5),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[4] = new EntidadeFixa(16+(32*8),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[5] = new EntidadeFixa(16+(32*9),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[6] = new EntidadeFixa(16+(32*10),16+(32*5),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[7] = new EntidadeFixa(16+(32*5),16+(32*0),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[8] = new EntidadeFixa(16+(32*5),16+(32*1),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[9] = new EntidadeFixa(16+(32*5),16+(32*2),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[10] = new EntidadeFixa(16+(32*5),16+(32*8),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[11] = new EntidadeFixa(16+(32*5),16+(32*9),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[12] = new EntidadeFixa(16+(32*5),16+(32*10),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[13] = new EntidadeFixa(16+(32*3),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[14] = new EntidadeFixa(16+(32*3),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[15] = new EntidadeFixa(16+(32*7),16+(32*3),32,32,false,false,sheet.getSprite(128,32,32,32));
        blocoVermSem[16] = new EntidadeFixa(16+(32*7),16+(32*7),32,32,false,false,sheet.getSprite(128,32,32,32));
        
        
        EntidadeMovel[] blocoVerdSem = new EntidadeMovel[8];
        blocoVerdSem[0] = new EntidadeMovel(16 + (32*3), 16 + (32*4),32,32, false, true, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[1] = new EntidadeMovel(16 + (32*4), 16 + (32*5),32,32, false, true, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[2] = new EntidadeMovel(16 + (32*4), 16 + (32*6),32,32, false, true, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[3] = new EntidadeMovel(16 + (32*4), 16 + (32*7),32,32, false, true, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[4] = new EntidadeMovel(16 + (32*6), 16 + (32*6),32,32, false, true, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[5] = new EntidadeMovel(16 + (32*6), 16 + (32*4),32,32, false, true, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[6] = new EntidadeMovel(16 + (32*6), 16 + (32*3),32,32, false, true, sheet.getSprite(0, 64, 32, 32));
        blocoVerdSem[7] = new EntidadeMovel(16 + (32*7), 16 + (32*5),32,32, false, true, sheet.getSprite(0, 64, 32, 32));
        
        
        
         SetasDeMovimentacao[] seta = new SetasDeMovimentacao[24];
        //seta Direita 3
        seta[0] = new SetasDeMovimentacao(16+(32*5), 16+(32*4),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[1] = new SetasDeMovimentacao(16+(32*6), 16+(32*5),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[16] = new SetasDeMovimentacao(16+(32*4), 16+(32*7),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        seta[22] = new SetasDeMovimentacao(16+(32*3), 16+(32*4),32,32,true,false,sheet.getSprite(32, 96, 32, 32), 1);
        //seta Baixo 9
        seta[2] = new SetasDeMovimentacao(16+(32*0), 16+(32*7),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[3] = new SetasDeMovimentacao(16+(32*1), 16+(32*6),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[4] = new SetasDeMovimentacao(16+(32*4), 16+(32*4),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[5] = new SetasDeMovimentacao(16+(32*5), 16+(32*3),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[6] = new SetasDeMovimentacao(16+(32*6), 16+(32*1),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[7] = new SetasDeMovimentacao(16+(32*7), 16+(32*0),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[17] = new SetasDeMovimentacao(16+(32*4), 16+(32*6),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
        seta[18] = new SetasDeMovimentacao(16+(32*7), 16+(32*5),32,32,true,false,sheet.getSprite(0, 96, 32, 32), 3);
       
        //Seta Cima 6
        seta[8] = new SetasDeMovimentacao(16+(32*3), 16+(32*5),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[9] = new SetasDeMovimentacao(16+(32*5), 16+(32*7),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[10] = new SetasDeMovimentacao(16+(32*9), 16+(32*4),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[20] = new SetasDeMovimentacao(16+(32*6), 16+(32*6),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[21] = new SetasDeMovimentacao(16+(32*6), 16+(32*4),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        seta[19] = new SetasDeMovimentacao(16+(32*10), 16+(32*3),32,32,true,false,sheet.getSprite(96, 64, 32, 32), 4);
        //Seta Esquerda 6
        seta[11] = new SetasDeMovimentacao(16+(32*3), 16+(32*10),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[12] = new SetasDeMovimentacao(16+(32*4), 16+(32*9),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[13] = new SetasDeMovimentacao(16+(32*5), 16+(32*6),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[14] = new SetasDeMovimentacao(16+(32*7), 16+(32*6),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[15] = new SetasDeMovimentacao(16+(32*6), 16+(32*3),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        seta[23] = new SetasDeMovimentacao(16+(32*4), 16+(32*5),32,32,true,false,sheet.getSprite(128, 64, 32, 32), 2);
        
        EntidadeMovel[] blocoVermPret = new EntidadeMovel [3];
        blocoVermPret[0] = new EntidadeMovel(16+(32*9), 16+(32*7),32,32,true,false,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[1] = new EntidadeMovel(16+(32*9), 16+(32*9),32,32,true,false,sheet.getSprite(32, 64, 32, 32));
        blocoVermPret[2] = new EntidadeMovel(16+(32*7), 16+(32*9),32,32,true,false,sheet.getSprite(32, 64, 32, 32));
        
        
        EntidadeFixa[] colecionavel = new EntidadeFixa[8];
        //coletaveis no mapa
        //morango
        colecionavel[0] = new Coletavel(16+(32*4),16+(32*10),32,32,true,false,sheet.getSprite(0, 32, 32, 32),150);
        //uva
        colecionavel[1] = new Coletavel(16+(32*6),16+(32*0),32,32,true,false,sheet.getSprite(32, 32, 32, 32),300);
        //limao
        colecionavel[2] = new Coletavel(16+(32*0),16+(32*6),32,32,true,false,sheet.getSprite(64, 32, 32, 32),200);
        //cereja
        colecionavel[3] = new Coletavel(16+(32*10),16+(32*4),32,32,true,false,sheet.getSprite(96, 32, 32, 32),250);
        //tela de consumiveis
        colecionavel[4] = new Coletavel(440,220,32,32,true,false,sheet.getSprite(0, 32, 32, 32),150);
        colecionavel[5] = new Coletavel(440,328,32,32,true,false,sheet.getSprite(32, 32, 32, 32),300);
        colecionavel[6] = new Coletavel(440,256,32,32,true,false,sheet.getSprite(64, 32, 32, 32),200);
        colecionavel[7] = new Coletavel(440,292,32,32,true,false,sheet.getSprite(96, 32, 32, 32),250);
        
        for(int i =0; i<17;i++){
            entidadesFixas.add(blocoVermSem[i]);
        }
               
        for(int i =0; i<4;i++){
            entidadesMoveis.add(antagonista[i]);
        }
        for(int i = 0; i<24; i++){
            entidadesFixas.add(seta[i]);
        }
        for(int i = 0; i<8; i++){
            entidadesFixas.add(colecionavel[i]);
        }
        for(int i =0; i<3;i++){
            blocoVermPret[i].setPodeQuebrar(false);
            entidadesMoveis.add(blocoVermPret[i]);
        }
        for(int i =0; i<8;i++){
            blocoVerdSem[i].setPodeMover(true);
            entidadesMoveis.add(blocoVerdSem[i]);
        }
    }
}
