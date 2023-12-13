package usarTelas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Criar interfaces gráficas com a biblioteca Java Swing
 * Informações adicionais: <a href="http://www.java2s.com/Tutorials/Java/Java_Swing/index.htm">Java Swing</a>
 *
 * @author Diego Mendes Rodrigues
 */
public class Sistema {
    public static void main(String[] args) {
        /*
         * Executar um exemplo de tela por vez
         */
        usarJDialog();

//        usarJLabelTexto();
    }

    /**
     * JDialog: Exibir uma caixa de diálogo na tela
     * Existem 4 tipos de diálogos:
     * + Message Dialog
     * + Confirmation Dialog
     * + Input Dialog
     * + Option Dialog
     * Informações adicionais:
     * <a href="http://www.java2s.com/Tutorials/Java/Java_Swing/1320__Java_Swing_JDialog.htm">JDialog</a>
     */
    public static void usarJDialog() {
        /**
         * showMessageDialog()
         */
        JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!",
                "Login", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Dados inválidos!",
                "Login", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Você lembra sua senha?",
                "Login", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Faz tempo que você não entra!",
                "Login", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "Troque sua senha em até 7 dias!",
                "Login", JOptionPane.PLAIN_MESSAGE);

        /**
         * showConfirmDialog()
         */
        int response = JOptionPane.showConfirmDialog(null,
                "Salvar o arquivo?",
                "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        response = JOptionPane.showConfirmDialog(null,
                "Salvar o arquivo?",
                "Confirmação", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        switch (response) {
            case JOptionPane.YES_OPTION:
                System.out.println("yes");
                break;
            case JOptionPane.NO_OPTION:
                System.out.println("no");
                break;
            case JOptionPane.CANCEL_OPTION:
                System.out.println("cancel");
                break;
            case JOptionPane.CLOSED_OPTION:
                System.out.println("closed.");
                break;
            default:
                System.out.println("something else");
        }

        /**
         * showInputDialog()
         */
        String responseInput = JOptionPane.showInputDialog("Nome Completo");
        if (responseInput == null) {
            System.out.println("cancelled.");
        } else {
            System.out.println("Nome: " + responseInput);
        }

        responseInput = JOptionPane.showInputDialog("Nome Completo", "Bruna Mendes");

        Object message = "Curso de Interesse";
        String title = "Informações para a Matrícula";
//        int messageType = JOptionPane.INFORMATION_MESSAGE;
//        int messageType = JOptionPane.QUESTION_MESSAGE;
        int messageType = JOptionPane.PLAIN_MESSAGE;
        Icon icon = null;
        Object[] selectionValues = new String[]{"Java", "Python", "C#"};
        Object initialSelectionValue = selectionValues[1];
        Object response2 = JOptionPane.showInputDialog(null, message,
                title, messageType, icon, selectionValues, initialSelectionValue);

        /**
         * showOptionDialog()
         */
        JComponent parentComponent = null;
        Object message2 = "Qual sua satisfação com o nosso curso?";
        String title2 = "Avalie nosso curso";
        int messageType2 = JOptionPane.INFORMATION_MESSAGE;
        Icon icon2 = null;
        Object[] options2 = new String[]{"1", "2", "3", "4", "5"};
        Object initialOption2 = options2[4];
        int response3 = JOptionPane.showOptionDialog(null, message2, title2,
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon2,
                options2, initialOption2);
    }

    /**
     * JLabel: Exibir textos na tela, ou resultados de um processo
     * Podemos formatar o texto com HTML
     * -
     * Métodos comuns:
     * + setText() - Insere um valor de texto para exibir um resultado neste componente
     * + setFont() - Define o tipo, tamanho e o estilo da fonte (negrito e/ou itálico) da fonte
     * + setIcon() - Permite que um ícone ou imagem seja usado e exibido na tela
     * -
     * Informações adicionais:
     * <a href="http://www.java2s.com/Tutorials/Java/Java_Swing/0720__Java_Swing_JLabel.htm">JLabel</a>
     * <a href="http://www.java2s.com/Tutorials/Java/Java_Swing/1520__Java_Swing_Font.htm">Font</a>
     * <a href="https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html">GridBag</a>
     */
    public static void usarJLabelTexto() {
        /* Criar a Tela */
        JFrame jFrame = new JFrame("Usar o JLabel");
        jFrame.setSize(new Dimension(400, 240));
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        JPanel jPanel = new JPanel();
        jPanel.setSize(new Dimension(400, 240));
        jPanel.setBorder(new EmptyBorder(30, 0, 0, 0));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        /* Usar o JLabel */
        JLabel texto = new JLabel();
        texto.setText("Bruna Mendes Rodrigues");
//        texto.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
//        texto.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
//        texto.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        texto.setDisplayedMnemonic('B');
        jPanel.add(texto, gridBagConstraints);

        JLabel texto2 = new JLabel();
        texto2.setText("<html><h1>Diego <i>Mendes</i> Rodrigues</h1></html>");
        texto2.setSize(new Dimension(400, 40));
        gridBagConstraints.gridy++;
        jPanel.add(texto2, gridBagConstraints);

        JLabel texto3 = new JLabel();
        texto3.setText("Regina Marcia Ruiz");
        texto3.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
        texto3.setEnabled(false);
        gridBagConstraints.gridy++;
        jPanel.add(texto3, gridBagConstraints);

        /* Deixar a tela visível */
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}
