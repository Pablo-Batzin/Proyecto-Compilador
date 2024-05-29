
import JFlex.SilentExit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pablo G
 */
public class LexicoPrincipal {
    public static void main(String omega[]){
        String lexerFile = System.getProperty("user.dir")+"/src/Lexico.Flex",
                lexerColor = System.getProperty("user.dir")+"/src/LexicoColor.Flex";
        
        try {
            JFlex.Main.generate(new String[]{lexerFile, lexerColor});
        } catch (SilentExit ex) {
            Logger.getLogger(LexicoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
