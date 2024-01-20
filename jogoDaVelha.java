import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;

import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent; // Import the ActionEvent class

public class jogoDaVelha extends JFrame{

    JLabel etiqueta = new JLabel();
    JButton[][] botoes;

    public jogoDaVelha(){
        super("Jogo da Velha");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new GridLayout(3, 3));

        // adicionar botao

       // botao = new JButton("Botao");
        //botao.setBounds(100, 100, 100, 100);

        // criar uma matriz de botoes
        
        botoes = new JButton[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                botoes[i][j] = new JButton();
                botoes[i][j].setBounds(i * 100, j * 100, 100, 100); // ajustar a posição com base em i e j

                final int finalI = i;
                final int finalJ = j;

                this.add(botoes[i][j]);

                botoes[i][j].addActionListener(new ActionListener() { // funcao dentro de funcao
                    public void actionPerformed(ActionEvent e) {
                        botoes[finalI][finalJ].setText("X"); // definir o texto do botão como "X"
                        //jogar(i, j, getName());
                    }
                    
                });
            }
        }

    
    }

    // criar um metodo que quando a pessoa clica no botao vai aparecer um X ou O





}
