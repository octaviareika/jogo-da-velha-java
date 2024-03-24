package src;
//interface java.Swing


// adicionar JFrame
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Main {

    public static void main(String args[]){

         try {
            // Tenta aplicar o tema Nimbus
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { 
                // Se encontrar o tema Nimbus
                if ("Nimbus".equals(info.getName())) { 
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao inserir tema");
        }

        
        controleJogo jogo = new controleJogo();

        

    }


    // função para adicionar Icone
    public static ImageIcon createImageIcon(String path, String description) {

        java.net.URL imgURL = Main.class.getResource(path);

        int largura = 50;
        int altura = 50;

        Image image = new ImageIcon(imgURL).getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        if (imgURL != null) {

            return new ImageIcon(image, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}