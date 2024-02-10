import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;

import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent; // Import the ActionEvent class

public class jogoDaVelha extends JFrame{

    JButton[][] botoes;
    private int partidas = 0; // contador de partidas
    private int situacaoAtual = 1;
    private int turnoDojogador = 1;
    JLabel contador;
    JLabel vitoria;
    JButton resetar; // botao para resetar o jogo


    public jogoDaVelha(){
        super("Jogo da Velha");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        contador = new JLabel();
        vitoria = new JLabel();
        setLayout(new GridLayout(4, 3));
        resetar = new JButton();

        
        
        botoes = new JButton[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                botoes[i][j] = new JButton(); // criando o botao
                botoes[i][j].setBounds(i * 100, j * 100, 100, 100); // ajustar a posição com base em i e j

                final int finalI = i;
                final int finalJ = j;

                this.add(botoes[i][j]);

                botoes[i][j].addActionListener(new ActionListener() { // funcao dentro de funcao
                    public void actionPerformed(ActionEvent e) {
                        jogar(finalI, finalJ);
                        contadorDePartida();
                        verificarVitoria();
                    }
                    
                });
            }
        }

        resetar.setText("Resetar");
        resetar.setFont(new Font("Roboto", Font.PLAIN, 20));
        resetar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                for (int i =0; i < 3; i ++){
                    for (int j = 0; j < 3; j++){
                        botoes[i][j].setText("");
                        partidas = 0;
                        situacaoAtual = 1;
                        turnoDojogador = 1;
                    }
                
                }
            }
        });
        contador.setText("Partidas: " + String.valueOf(partidas));
        contador.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(contador);
        this.add(resetar);
    
    }

    public void jogar(int i, int j){
        // verificar se o jogador é X ou O
        // verificar se a posição está vazia
        // se estiver vazia, colocar o X ou O
        // se não estiver vazia, não fazer nada

        while (partidas < 9 && situacaoAtual == 1 && botoes[i][j].getText().equals("")){
            
            if (turnoDojogador == 1){
                //etiqueta.setText("Vez do jogador 1");
                botoes[i][j].setText("X");
                botoes[i][j].setFont(new Font("Roboto", Font.PLAIN, 60));
                turnoDojogador = 2;
            } else {
                //etiqueta.setText("Vez do jogador 2");
                botoes[i][j].setText("O");
                botoes[i][j].setFont(new Font("Roboto", Font.PLAIN, 60));
                turnoDojogador = 1;
            }
            partidas++;
        }
    }

    public void verificarVitoria(){
        // verificar se o jogador 1 ganhou
        // verificar se o jogador 2 ganhou
        // verificar se deu velha

        if (partidas == 9 && situacaoAtual == 1){
            //etiqueta.setText("Deu velha");
            
            situacaoAtual = 0;
        }
    }

    public void incrementaPartida(){
        partidas++;
        contadorDePartida();
    }

    public void contadorDePartida(){
        this.contador.setText("Partidas: " + partidas );
    }






}
