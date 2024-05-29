
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Pablo G
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory Directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setText("Guardar como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jtpCode);

        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEjecutar)
                .addContainerGap())
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rootPanelLayout.createSequentialGroup()
                        .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (Directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (Directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (Directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (Directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "No se puede ejecutar el Código ya que se encontró uno o mas errores");
            }
        } else {

        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void init() {
        title = "Proyecto Compiladores";
        setLocationRelativeTo(null);
        setTitle(title);
        Directorio = new Directory(this, jtpCode, title, ".compilador");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Directorio.Exit();
                System.exit(0);
            }
        });

        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{"Void", "int", "if", "return", "numero", "ifelse", "menor", "parametro", "ingresado", "hola"}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    private void colorAnalysis() {
        textsColor.clear();
        LexicoColor lexer;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF-8"));
            lexer = new LexicoColor(entrada);
            while (true) {
                TextColor textColor = lexer.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }

        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    private void compile() {
        clearFields();
        AnalizadorLexico();
        TablaTokens();
        AnalizadorSintactico();
        AnalizadorSemantico();
        ImprimirenConsole();
        codeHasBeenCompiled = true;

    }

    private void AnalizadorLexico() {
        Lexico lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF-8"));
            lexer = new Lexico(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void TablaTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(),
                "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });

    }

    private void AnalizadorSintactico() {
        Grammar gramatica = new Grammar(tokens, errors);
        /*Eliminacion de Errores*/
        gramatica.delete(new String[]{"ERROR"}, 1);
        /*Agrupacion*/
        gramatica.group("VALOR", "NUMERO | IDENTIFICADOR");
        gramatica.group("CONDICION", "(VALOR OP_COMPARACION VALOR)+");
        gramatica.group("CONDICION2", "(CONDICION OP_LOGICO CONDICION)+");
        //gramatica.group("IDENT", "(IDENTIFICADOR)");
       // gramatica.group("RESERV", "(PALABRA_RESERVADA)+");
        //gramatica.group("SENTENCIA", "(PALABRA_RESERVADA)*");
        gramatica.group("INTE", "(PALABRA_RESERVADA VALOR OP_ASIGNACION VALOR OP_FIN_DE_LINEA)+ | (VALOR)+");
        gramatica.group("INTER", "(INTE PALABRA_RESERVADA PARENT_IZQUIERDO)+ | (INTE)+");
        gramatica.group("INTERM", "(INTER CONDICION)+ | (INTER CONDICION2)+ | (INTER)+");
        gramatica.group("INTERME", "(INTERM PARENT_DERECHO)+ | (INTERM)+");
        gramatica.group("INTERMED", "(INTERME LLAVE_ABRE)+ | (INTERME)+");
        gramatica.group("INTERMEDI", "([INTERMED VALOR OP_COMPARACION(OP_COMPARACION)* COMILLAS (VALOR)* COMILLAS])+ | (INTERMED OP_COMPARACION(OP_COMPARACION)* COMILLAS (VALOR)* COMILLAS)+ | ([INTERMED VALOR OP_COMPARACION(OP_COMPARACION)* COMILLAS (VALOR)* COMILLAS SIMB_SUMA VALOR])+");
        gramatica.group("INTERMEDIO", "(INTERMEDI OP_FIN_DE_LINEA LLAVE_CIERRA)+");
        gramatica.group("INTERMEDIOS", "(INTERMEDIO PALABRA_RESERVADA LLAVE_ABRE)+");
        gramatica.group("SOLU", "(INTERMEDIOS INTERMEDIO)+");
        gramatica.group("SOLUCION", "(SOLU LLAVE_CIERRA)+ | (INTERMEDIO)+");
       // gramatica.group("ESTRUCTURA", "(INTERMEDIO)+");
       // gramatica.group("INTERM", "VALOR OP_COMPARACION VALOR OP_FIN_DE_LINEA PARENT_DERECHO");
       //gramatica.group("INTERME", "(PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_IZQUIERDO PARENT_DERECHO LLAVE_ABRE INTE INTER INTERM)");
        /*Declaracion de Variable*/
        gramatica.group("SINTACTICO", "PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_IZQUIERDO PARENT_DERECHO LLAVE_ABRE SOLUCION | PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_IZQUIERDO PARENT_DERECHO LLAVE_ABRE SOLUCION", true);
        gramatica.group("SINTACTICO", "PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_IZQUIERDO PARENT_DERECHO LLAVE_ABRE", true, 2,
               "Error Sintactico {}: Falta La Solucion en la Declaracion [#,%]");
        gramatica.group("SINTACTICO", "PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_DERECHO LLAVE_ABRE SOLUCION", 3,
                "Error Sintactico {}: Falta Parentesistes de APertura en la Declaracion [#,%]");
        gramatica.group("SINTACTICO", "PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_IZQUIERDO PARENT_DERECHO SOLUCION", 4,
                "Error Sintactico {}: Falta Llave que abren en la declaracion [#,%]");
        gramatica.group("SINTACTICO", "PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_IZQUIERDO LLAVE_ABRE SOLUCION", 5, 
                "Error Sintactico {}: Falta Parentesis Derecho en la Declaracion [#,%]");
        //gramatica.group("ES", "(INTERMEDI)+");
        //gramatica.group("EST", "(ES LLAVE_CIERRA)+");
       // gramatica.group("ESTRUCTURA", "(INTERMEDIO)+");
       // gramatica.group("SINTA", "PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_IZQUIERDO PARENT_DERECHO LLAVE_ABRE ESTRUCTURA", true);
     //gramatica.group("VARIABLE", "PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_IZQUIERDO PARENT_DERECHO", true,
             //   2,"Error Sintactico {}: Falta Llave que Abre en la declaracion [#, %]");
                //gramatica.finalLineColumn();
       // gramatica.group("VARIABLE", "PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_IZQUIERDO LLAVE_ABRE", 3,
       //         "Error Sintactico {}: Falta Parentesis derecho en la declaracion [#, %]");
       // gramatica.group("VARIABLE", "PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_DERECHO LLAVE_ABRE", 4,
       //         "Error Sintactico {}: Falta Parentesis Izquierdo en la declaracion [#, %]");
      //  gramatica.group("VARIABLE", "PALABRA_RESERVADA (PALABRA_RESERVADA)* PARENT_IZQUIERDO PARENT_DERECHO LLAVE_ABRE", 5,
        //        "Eror Sintactico {}: Falta una Palabra Reservada en la Declaracion [#, %]");
        //gramatica.initialLineColumn();
        /*Eliminacion de Palabra Reservada y LLave_Abre*/
        //gramatica.delete("PALABRA_RESERVADA", 6, "Error Sintactico {}: La palabra Reservada no esta en la declaracion [#, %]");
       // gramatica.delete("LLAVE_ABRE", 7, "Error Sintactico {}: La Llave que abre no esta en la declaracion [#, %]");
       
        /* Agrupar Indentificadores y definicion de Parametros */
        //gramatica.group("PARAMETRO", "PALABRA RESERVADA",true);
       // gramatica.group("FUNCION", "(PARAMETRO VALOR | PARAMETRO VALOR OP_ASIGNACION)*");
        
        
        /*Agrupacion de Funciones*/
        //gramatica.group("FUNCION", "(PALBRA_RESERVADA | IDENTIFICADOR | NUMERO | OP_FIN_DE_LINEA | OP_COMPARACION | OPERADOR | OP_RELACIONAL | OP_LOGICO | OP_ASIGNACION)", true);
        //gramatica.group("FUNCION_COMP", "VARIABLE FUNCION", true);
        //gramatica.finalLineColumn();
       // gramatica.group("FUNCION_COMP", "(VALOR | PARAMETROS)", true, 
         //       8, "Erro Sintactico {}: Falta La Variable en la Declaracion [#,%]");
       // gramatica.initialLineColumn();
        
        /*Eliminacion de Funciones Completas */
        //gramatica.delete("FUNCION", 8, "Error Sintactico {}: La funcion no esta declarado correctamente en mi lenguaje");
        
        
        gramatica.show();
    }

    private void AnalizadorSemantico() {

    }

    private void ImprimirenConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilacion Terminada...\n"
                    + strErrors + "\nLa Compilacion termino con Errores");
        } else {
            jtaOutputConsole.setText("Compilacion Terminada... ");
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());

                new Compilador().setVisible(true);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
