package src;
import javax.swing.JButton;

public class reiniciarJogo  extends JButton{
        private JButton botaoReiniciar;

        public reiniciarJogo(){
            botaoReiniciar = new JButton("Reiniciar");
            botaoReiniciar.setBounds(100, 350, 100, 50); // ajustar a posição do botao reiniciar


        }

        public JButton getBotaoReiniciar(){
            return this.botaoReiniciar;
        }

        public void setBotaoReiniciar(JButton botaoReiniciar){
            this.botaoReiniciar = botaoReiniciar;
        }

    
}
