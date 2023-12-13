package usarThreads.tela;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Criar uma tela com Swing que irá exibir a data e a hora do sistema
 * No Java, cada tela é criada utilizando uma classe
 *
 * @author Diego Mendes Rodrigues
 */
public class TelaComDataHora extends JDialog {
    /* Painel de Componentes */
    private JPanel jPanel = new JPanel(new GridBagLayout());

    /* Componentes utilizados na tela */
    private JLabel linhaBranca = new JLabel(" ");
    private JLabel linhaBranca2 = new JLabel(" ");
    private JLabel tituloData = new JLabel("Data");
    private JTextField exibirData = new JTextField();
    private JLabel tituloHora = new JLabel("Hora");
    private JTextField exibirHora = new JTextField();
    private JButton btnIniciar = new JButton("Iniciar");
    private JButton btnParar = new JButton("Parar");

    /* Threads que irão atualizar os campos de Data e Hora */
    Thread threadData;
    Thread threadHora;

    /**
     * Construtor que cria a tela, com os campos de data e hora, além de 2 botões que irão iniciar e parar
     * as threads que alteram os valores dos campos data e hora
     */
    public TelaComDataHora() {
        /* Tela */
        setTitle("Data e Hora Atuais");
        setSize(new Dimension(240, 240));

        /* Centralizar a tela */
        setLocationRelativeTo(null);

        /* Cancelar o redimensionamento a tela */
        setResizable(false);

        /* Colocar uma margem no JPanel */
        jPanel.setBorder(new EmptyBorder(0, 20, 10, 20));

        /* Controlador para o posicionamento dos componentes */
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        /* Adicionar os elementos na tela */
        tituloData.setPreferredSize(new Dimension(180, 25));
        jPanel.add(tituloData, gridBagConstraints);

        exibirData.setPreferredSize(new Dimension(180, 25));
        gridBagConstraints.gridy++;
        exibirData.setEditable(false);
        exibirData.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(exibirData, gridBagConstraints);

        linhaBranca.setPreferredSize(new Dimension(180, 15));
        gridBagConstraints.gridy++;
        jPanel.add(linhaBranca, gridBagConstraints);

        tituloHora.setPreferredSize(new Dimension(180, 25));
        gridBagConstraints.gridy++;
        jPanel.add(tituloHora, gridBagConstraints);

        exibirHora.setPreferredSize(new Dimension(180, 25));
        gridBagConstraints.gridy++;
        exibirHora.setEditable(false);
        exibirHora.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(exibirHora, gridBagConstraints);

        linhaBranca2.setPreferredSize(new Dimension(180, 25));
        gridBagConstraints.gridy++;
        jPanel.add(linhaBranca2, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;

        btnIniciar.setPreferredSize(new Dimension(89, 25));
        gridBagConstraints.gridy++;
        jPanel.add(btnIniciar, gridBagConstraints);

        btnParar.setPreferredSize(new Dimension(89, 25));
        btnParar.setEnabled(false);
        gridBagConstraints.gridx++;
        jPanel.add(btnParar, gridBagConstraints);

        /* Criar as ações dos botões Iniciar e Parar */
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threadData = new Thread(exibirDataAtual);
                threadHora = new Thread(exibirHoraAtual);
                threadData.start();
                threadHora.start();
                btnIniciar.setEnabled(false);
                btnParar.setEnabled(true);
            }
        });
        btnParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threadData.interrupt();
                threadHora.interrupt();
                btnIniciar.setEnabled(true);
                btnParar.setEnabled(false);
            }
        });

        /* Adicionar o Painel na tela */
        add(jPanel, BorderLayout.WEST);

        /* Exibir a tela */
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Atualizar o campo de data a cada 1 segundo utilizando uma Thread
     */
    public Runnable exibirDataAtual = new Runnable() {
        @Override
        public void run() {
            while (true) {
                Calendar saoPauloDate = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                exibirData.setText(new SimpleDateFormat("dd/MM/yyyy")
                        .format(saoPauloDate.getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    //throw new RuntimeException(e);
                }
            }
        }
    };

    /**
     * Atualizar o campo de hora a cada 1 segundo utilizando uma Thread
     */
    public Runnable exibirHoraAtual = new Runnable() {
        @Override
        public void run() {
            while (true) {
                Calendar saoPauloDate = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                exibirHora.setText(new SimpleDateFormat("HH:mm.ss")
                        .format(saoPauloDate.getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    //throw new RuntimeException(e);
                }
            }
        }
    };
}
