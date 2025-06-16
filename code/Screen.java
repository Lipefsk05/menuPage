import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       


public class Screen extends JFrame{

    private Font font;

    public Screen(){

//  ===================================================================================================================================================================================

//  LOAD FONTS

        ComicFont();

//  ===================================================================================================================================================================================

//  PAGE MODEL

        int fWidth = 250, fHeight = 800;
        
        setTitle("Menu Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(fWidth, fHeight);
        setLocationRelativeTo(null);
        setLayout(null);
        // setIconImage(getIconImage());
        getContentPane().setBackground(Color.darkGray);        
        
//  ===================================================================================================================================================================================

//  BUTTONS

//      --------------------------------------
//      Projects
        JButton jButtonPro = creatButton("Projects", 50, fWidth, fHeight);
        jButtonPro.addActionListener(e -> openFolder("/home/lipe/projetos"));
        jButtonPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // animateButtonFont(jButtonPro, 35f);
                jButtonPro.setBackground(new Color(40, 40, 40));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // animateButtonFont(jButtonPro, 25f);
                jButtonPro.setBackground(Color.darkGray);
            }
        });
//      --------------------------------------
//      Github
        JButton jButtonGitH = creatButton("Github", 110, fWidth, fHeight);
        jButtonGitH.addActionListener(e -> openLink("https://github.com/Lipefsk05"));

        jButtonGitH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // animateButtonFont(jButtonGitH, 35f);
                jButtonGitH.setBackground(new Color(40, 40, 40));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // animateButtonFont(jButtonGitH, 25f);
                jButtonGitH.setBackground(Color.darkGray);
            }
        });
//      --------------------------------------
//      TPs
        JButton jButtonTps = creatButton("Tps", 170, fWidth, fHeight);
        jButtonTps.addActionListener(e -> openFolder("/home/lipe/facul/cc-puc/cc-2-periodo/tps"));

        jButtonTps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // animateButtonFont(jButtonTps, 35f);
                jButtonTps.setBackground(new Color(40, 40, 40));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // animateButtonFont(jButtonTps, 25f);
                jButtonTps.setBackground(Color.darkGray);
            }
        });
//      --------------------------------------
//      Terminal
        JButton jButtonTerm = creatButton("Terminal", 230, fWidth, fHeight);
        jButtonTerm.addActionListener(e -> openTerminal());

        jButtonTerm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // animateButtonFont(jButtonTerm, 35f);
                jButtonTerm.setBackground(new Color(40, 40, 40));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // animateButtonFont(jButtonTerm, 25f);
                jButtonTerm.setBackground(Color.darkGray);
            }
        });
//      --------------------------------------
//      TPs
        JButton jButtonBeecrowd = creatButton("Beecrowd", 290, fWidth, fHeight);
        jButtonBeecrowd.addActionListener(e -> openFolder("/home/lipe/facul/code-lab/beecrowd"));

        jButtonBeecrowd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // animateButtonFont(jButtonBeecrowd, 35f);
                jButtonBeecrowd.setBackground(new Color(40, 40, 40));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // animateButtonFont(jButtonBeecrowd, 25f);
                jButtonBeecrowd.setBackground(Color.darkGray);
            }
        });
//      --------------------------------------
//      Add
        add(jButtonPro);
        add(jButtonGitH);
        add(jButtonTps);
        add(jButtonTerm);
        add(jButtonBeecrowd);

//  ===================================================================================================================================================================================
        setVisible(true);
    }



//  ===================================================================================================================================================================================
    
//      LOAD FONT COMIC

    private void ComicFont() {
    try {
        font = Font.createFont(Font.TRUETYPE_FONT, new File("/home/lipe/projetos/menuPage/fonts/Roboto.ttf")).deriveFont(25f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
    } catch (IOException | FontFormatException e) {
        e.printStackTrace();
        System.out.println("Erro ao carregar a fonte.");
        font = new Font("Arial", Font.PLAIN, 25);
    }
    }

//  ===================================================================================================================================================================================

//      ANIMATE BUTTON FONT

    private void animateButtonFont(JButton button, float targetSize) {
        Timer timer = new Timer(5, null);
        float initialSize = button.getFont().getSize2D();
        final float[] size = { initialSize };

        timer.addActionListener(e -> {
            if ((initialSize < targetSize && size[0] >= targetSize) || 
                (initialSize > targetSize && size[0] <= targetSize)) {
                timer.stop();
                return;
            }
            size[0] += (targetSize - initialSize) / 10;
            button.setFont(button.getFont().deriveFont(size[0]));
        });

        timer.start();
    }

//  ===================================================================================================================================================================================

//      OPEN FOLDER

    private void openFolder(String path) {
        try {
            new ProcessBuilder("/bin/sh", "-c", "cd " + path + " && code .").start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar abrir o VS Code: " + ex.getMessage());
        }
    }

//  ===================================================================================================================================================================================

//      OPEN LINK

    private void openLink(String link) {
        try {
            String command;
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                command = "cmd /c start " + link;
            } else {
                command = "xdg-open " + link;
            }
            Runtime.getRuntime().exec(command);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar abrir o link: " + ex.getMessage());
        }
    }

//  ===================================================================================================================================================================================

//      OPEN TERMINAL

    private void openTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;

            if (os.contains("win")) {
                processBuilder = new ProcessBuilder("cmd.exe", "/c", "start cmd");
            } else {
                processBuilder = new ProcessBuilder("/bin/sh", "-c", "kitty"); // Para GNOME
                // Se usar outra interface, pode tentar "konsole" (KDE) ou "x-terminal-emulator"
            }

            processBuilder.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o terminal: " + e.getMessage());
        }
    }


//  ===================================================================================================================================================================================

//      CREAT BUTTON

    private JButton creatButton(String text, int posH, int fWidth, int fHeight){
        
        
        JButton button = new JButton(text);
        button.setBounds((fWidth - 300)/2, posH, 300, 50);
        button.setForeground(Color.white);
        button.setBackground(Color.darkGray);
        // button.setBackground(Color.black);
        button.setFont(font);
        button.setBorder(null);
        button.setFocusPainted(false);
        
        return button;
    }
}
