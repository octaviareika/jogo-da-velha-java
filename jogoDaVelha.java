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
    private int situacaoAtual = 1; // situacao do jogo
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

            verificarVitoria();
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

        // olhar as diagonais, as linhas e colunas
        // linhas primeiro
        for (int i = 0; i < 3; i++){
            if (this.botoes[i][0].equals(this.botoes[i][1]) && this.botoes[i][1].equals(this.botoes[i][2])){
                if (this.botoes[i][0].getText().equals("X")){
                    //etiqueta.setText("Jogador 1 ganhou");
                    situacaoAtual = 0;
                } else if (this.botoes[i][0].getText().equals("O")){
                    //etiqueta.setText("Jogador 2 ganhou");
                    situacaoAtual = 0;
                }
            }
        }

        ///colunas
        for (int j = 0; j < 3; j++){
            if (this.botoes[0][j].getText().equals(this.botoes[1][j].getText()) && this.botoes[1][j].getText().equals(this.botoes[2][j].getText())){
                if (this.botoes[0][j].getText().equals("X")){
                    //etiqueta.setText("Jogador 1 ganhou");
                    situacaoAtual = 0;
                } else if (this.botoes[0][j].getText().equals("O")){
                    //etiqueta.setText("Jogador 2 ganhou");
                    situacaoAtual = 0;
                }

            }
        }


        if (this.botoes[0][0].getText().equals(this.botoes[1][1].getText()) && this.botoes[1][1].getText().equals(this.botoes[2][2].getText())){
            if (this.botoes[0][0].getText().equals("X")){
                //etiqueta.setText("Jogador 1 ganhou");
                situacaoAtual = 0;
            } else if (this.botoes[0][0].getText().equals("O")){
                //etiqueta.setText("Jogador 2 ganhou");
                situacaoAtual = 0;
            }
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
