import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent; // Import the ActionEvent class

public class jogoDaVelha extends JFrame{

    private JButton[][] botoes;
    private int jogador = 1;
    private JButton botaoReiniciar;
   
    private int jogadas = 0;
    private boolean estadoDoJogo = true;

    public jogoDaVelha(){
        //JFrame frame = new JFrame();
        
        this.setSize(300, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar a janela
        //this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(3, 3));
        this.setTitle("Jogo da Velha");

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 3));
        

        botoes = new JButton[3][3]; // instanciando os botoes
        
        botaoReiniciar = new JButton("Reiniciar");
        botaoReiniciar.setPreferredSize(new Dimension(100, 50));
        JPanel controles = new JPanel();
        controles.setLayout(new FlowLayout());
        controles.setSize(300, 100);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){


                botoes[i][j] = new JButton();
                //botoes[i][j].setBounds(i * 150, j * 150, 100, 100); // ajustar a posição com base em i e j
                // ajusar o tamanho
                //botoes[i][j].setPreferredSize(new Dimension(100, 100));

                painelBotoes.add(botoes[i][j]);

                final int finalLinha = i;
                final int finalColuna = j;


                botoes[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                       jogar(finalLinha, finalColuna);
                    }
                });
            }
        }

        this.add(painelBotoes);
        this.setVisible(true); // mostrar a janela
        this.add(controles.add(this.getBotaoReiniciar()));
        this.getBotaoReiniciar().addActionListener( new ActionListener() {
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

    public int getJogadas(){
        return this.jogadas;
    }

    public void setJogadas(int jogadas){
        this.jogadas = jogadas;
    }

    public boolean getEstadoDoJogo(){
        return this.estadoDoJogo;
    }

    public void setEstadoDoJogo(boolean estadoDoJogo){
        this.estadoDoJogo = estadoDoJogo;
    }

    public JButton getBotaoReiniciar(){
        return this.botaoReiniciar;
    }

    public void setBotaoReiniciar(JButton botaoReiniciar){
        this.botaoReiniciar = botaoReiniciar;
    }



    public void jogar(int i, int j){

        while (this.getEstadoDoJogo() && jogadas < 9 && this.botoes[i][j].getText().equals("")){ // verificar tbm se os botoes estao "em branco"
            if (jogador == 1){
                // vez do jogador 1
                this.botoes[i][j].setText("X");
                jogador++;
            }

            else { // jogador 2
                this.botoes[i][j].setText("O");
                jogador--;

            }
            // funcao de verificar vitoria aq 
            verificarVitoria();
            incrementarPartida();
        }

    }


    //verifica Vitoria
    public void verificarVitoria(){

        // olhar empate
        
        

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

        // diagonal
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


        if (this.getJogadas() == 9){
            JOptionPane.showMessageDialog(null, "Empate!");
            estadoDoJogo = false;
        }
    }

    public void incrementarPartida(){
        jogadas++;
       // System.out.println(jogadas);
    }

    public void reiniciarJogo(){
        for (int i =0; i <3; i++){
            for (int j =0; j <3; j++){
                botoes[i][j].setText("");
            }
            
        }
        
        jogadas = 0;
        estadoDoJogo = true;
    }

}
