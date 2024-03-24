package src;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent; 

public class controleJogo extends JFrame{

    private JButton[][] botoes;
    private int jogador = 1;

    Contador jogadas;
    private boolean estadoDoJogo = true;
    private reiniciarJogo reiniciarJogo;
    JLabel jogadorAtual;

    public controleJogo(){
        
        this.setSize(300, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar a janela
        this.setResizable(false); // nao permitir redimensionar
        this.setLocationRelativeTo(null); // centralizar a janela
        this.setTitle("Jogo da Velha");
 

        // instanciando os botoes
        botoes = new JButton[3][3]; 

        // instanciando o contador
        jogadas = new Contador();

        // instanciando o botao reiniciar
        reiniciarJogo = new reiniciarJogo();

        // mostrar qual jogador começa
        jogadorAtual = new JLabel("Jogador 1");
        jogadorAtual.setBounds(110, 300, 100, 50);
        // ajustar o tamanho do texto
        jogadorAtual.setFont(jogadorAtual.getFont().deriveFont(19.0f));
        

        
        // criar um painel para os botoes
        JPanel controles = new JPanel();
        controles.setLayout(null);
        controles.setSize(100, 50);
        controles.add(jogadorAtual);
        controles.add(reiniciarJogo.getBotaoReiniciar());


        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){


                botoes[i][j] = new JButton();
                botoes[i][j].setBounds(i * 100, j * 100, 100, 100); // ajustar a posição com base em i e j
                controles.add(botoes[i][j]);
                

                final int finalLinha = i;
                final int finalColuna = j;


                botoes[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                       jogar(finalLinha, finalColuna);
                    }
                });
            }
        }

        this.setVisible(true); // mostrar a janela

        this.add(controles); // adicionar os botoes na janela

        reiniciarJogo.getBotaoReiniciar().addActionListener(new ActionListener() { // adicionar ação ao botao reiniciar
          public void actionPerformed(ActionEvent e){
              reiniciarJogo();
          }
      });

    }

    // getter e setter
    public JButton[][] getBotoes(){
        return this.botoes;
    }

    public void setBotoes(JButton[][] botoes){
        this.botoes = botoes;
    }

    public int getJogador(){
        return this.jogador;
    }

    public void setJogador(int jogador){
        this.jogador = jogador;
    }

    public Contador getJogadas(){
        return this.jogadas;
    }

    public void setJogadas(Contador jogadas){
        this.jogadas = jogadas;
    }

    public boolean getEstadoDoJogo(){
        return this.estadoDoJogo;
    }

    public void setEstadoDoJogo(boolean estadoDoJogo){
        this.estadoDoJogo = estadoDoJogo;
    }


    public JLabel getJogadorAtual(){
        return this.jogadorAtual;
    }

    public void setJogadorAtual(JLabel jogadorAtual){
        this.jogadorAtual = jogadorAtual;
    }


    public void jogar(int i, int j){

        while (this.getEstadoDoJogo() && jogadas.getContador() < 9 && this.botoes[i][j].getText().equals("")){ // verificar tbm se os botoes estao "em branco"
            if (jogador == 1){
                // vez do jogador 1
                this.botoes[i][j].setText("X");
                this.botoes[i][j].setFont(new Font("Roboto", Font.PLAIN, 30));
                this.getJogadorAtual().setText("Jogador 2");
                jogador++;
            }

            else { // jogador 2
                this.botoes[i][j].setText("O");
                this.botoes[i][j].setFont(new Font("Roboto", Font.PLAIN, 30));
                this.getJogadorAtual().setText("Jogador 1");

                jogador--;

            }
           
            jogadas.incrementarPartida();

            verificarVitoria();
        }

    }


    //verifica Vitoria
    public void verificarVitoria(){

        for (int i =0; i < 3; i++){
            if (botoes[i][0].getText().equals("X") && botoes[i][0].getText().equals(botoes[i][1].getText()) && botoes[i][0].getText().equals(botoes[i][2].getText()) && !botoes[i][0].getText().equals("")){
                estadoDoJogo = false;
                JOptionPane.showMessageDialog(null, "Jogador 1 venceu!"); // mensagem de vitoria
                estadoDoJogo = false;
            }

            if (botoes[i][0].getText().equals("O") && botoes[i][0].getText().equals(botoes[i][1].getText()) && botoes[i][0].getText().equals(botoes[i][2].getText()) && !botoes[i][0].getText().equals("")){
                estadoDoJogo = false;
                JOptionPane.showMessageDialog(null, "Jogador 2 venceu!"); // mensagem de vitoria
            }
        }

        for (int j =0; j < 3; j++){
            if (botoes[0][j].getText().equals("X") && botoes[0][j].getText().equals(botoes[1][j].getText()) && botoes[0][j].getText().equals(botoes[2][j].getText()) && !botoes[0][j].getText().equals("")){
                estadoDoJogo = false;
                JOptionPane.showMessageDialog(null, "Jogador 1 venceu!"); // mensagem de vitoria
                estadoDoJogo = false;
            }

            if (botoes[0][j].getText().equals("O") && botoes[0][j].getText().equals(botoes[1][j].getText()) && botoes[0][j].getText().equals(botoes[2][j].getText()) && !botoes[0][j].getText().equals("")){

                estadoDoJogo = false;
                JOptionPane.showMessageDialog(null, "Jogador 2 venceu!"); // mensagem de vitoria
                
            }
        }

        // diagonal principal
        if (botoes[0][0].getText().equals("X") && botoes[0][0].getText().equals(botoes[1][1].getText()) && botoes[0][0].getText().equals(botoes[2][2].getText()) && !botoes[0][0].getText().equals("")){
            estadoDoJogo = false;
            JOptionPane.showMessageDialog(null, "Jogador 1 venceu!"); // mensagem de vitoria
            estadoDoJogo = false;
        }

        else if (botoes[0][0].getText().equals("O") && botoes[0][0].getText().equals(botoes[1][1].getText()) && botoes[0][0].getText().equals(botoes[2][2].getText()) && !botoes[0][0].getText().equals("")){
            estadoDoJogo = false;
            JOptionPane.showMessageDialog(null, "Jogador 2 venceu!"); // mensagem de vitoria
            estadoDoJogo = false;
        }


        // diagonal secundária
        if (botoes[0][2].getText().equals("X") && botoes[0][2].getText().equals(botoes[1][1].getText()) && botoes[0][2].getText().equals(botoes[2][0].getText()) && !botoes[0][2].getText().equals("")){
            estadoDoJogo = false;
            JOptionPane.showMessageDialog(null, "Jogador 1 venceu!"); // mensagem de vitoria
        }
        else if (botoes[0][2].getText().equals("O") && botoes[0][2].getText().equals(botoes[1][1].getText()) && botoes[0][2].getText().equals(botoes[2][0].getText()) && !botoes[0][2].getText().equals("")){
            estadoDoJogo = false;
            JOptionPane.showMessageDialog(null, "Jogador 2 venceu!"); // mensagem de vitoria
        }


        if (jogadas.getContador() >= 9){
            if (estadoDoJogo){
                JOptionPane.showMessageDialog(null, "Empate!");
                estadoDoJogo = false;
            }
           
        }
    }


    public void reiniciarJogo(){
        for (int i =0; i <3; i++){
            for (int j =0; j <3; j++){
                botoes[i][j].setText("");
            }
            
        }
        
        this.jogadas.setContador(0);
        estadoDoJogo = true;
    }

}
