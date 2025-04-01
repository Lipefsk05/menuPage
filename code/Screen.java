import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       


public class Screen extends JFrame{

    private Font font;

    public Screen(){
    
//  FONT LOAD ============
        ComicFont();
//  ======================

//  COLORS  =============================================
        Color STR_DARK_GRAY = new Color(40, 40, 40);
        
        setTitle("Menu Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        // setIconImage(getIconImage());
        getContentPane().setBackground(Color.DARK_GRAY);
//  ====================================================
        
        
//  BUTTONS =================================================================
        
//      Github
        JButton jButtonLink = new JButton("Github");
        jButtonLink.setBounds(300, 200, 200, 100);
        jButtonLink.setForeground(Color.WHITE);
        jButtonLink.setBackground(STR_DARK_GRAY);
        jButtonLink.setBorder(null);
        jButtonLink.setFont(font);

        jButtonLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLink.setBackground(Color.WHITE);
                jButtonLink.setForeground(STR_DARK_GRAY);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLink.setBackground(STR_DARK_GRAY);
                jButtonLink.setForeground(Color.WHITE);
            }
        });

        jButtonLink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String link = "https://github.com/Lipefsk05";
                    
                    String[] browsers = {
                        "xdg-open", // Linux
                        "gnome-open", // Para GNOME
                        "open", // macOS
                        "start" // Windows
                    };
        
                    String os = System.getProperty("os.name").toLowerCase();
                    String browserCommand = null;
                    if (os.contains("win")) {
                        browserCommand = "cmd /c start " + link;
                    } else if (os.contains("mac")) {
                        browserCommand = "open " + link;
                    } else {
                        browserCommand = "xdg-open " + link;
                    }
        
                    Runtime.getRuntime().exec(browserCommand);
        
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Screen.this, "Erro ao tentar abrir o link: " + ex.getMessage());
                }
            }
        });
//      --------------------------------------
        
//      TPs
        JButton jButtonTps = new JButton("Tps");
        jButtonTps.setBounds(300, 350, 200, 100);
        jButtonTps.setForeground(Color.WHITE);
        jButtonTps.setBackground(STR_DARK_GRAY);
        jButtonTps.setFont(font);
        jButtonTps.setBorder(null);

        jButtonTps.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String os = System.getProperty("os.name").toLowerCase();
                    ProcessBuilder processBuilder;
                    
                    if (os.contains("win")) {
                        processBuilder = new ProcessBuilder("cmd", "/c", "start", "code", "C:\\Users\\lipe\\facul\\cc-puc\\cc-2-periodo\\tps");
                    } else {
                        processBuilder = new ProcessBuilder("/bin/sh", "-c", "cd /home/lipe/facul/cc-puc/cc-2-periodo/tps && code .");
                    }
                    
                    processBuilder.inheritIO();  // Permite visualizar a saída no terminal
                    Process process = processBuilder.start();
                    process.waitFor();
        
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Screen.this, "Erro ao tentar abrir o VS Code: " + ex.getMessage());
                    ex.printStackTrace();  // Exibe erro no console
                }
            }
        });
//      --------------------------------------

//      Projects
        JButton jButtonPro = new JButton("Projects");
        jButtonPro.setBounds(300, 50, 200, 100);
        jButtonPro.setForeground(Color.WHITE);
        jButtonPro.setBackground(STR_DARK_GRAY);
        jButtonPro.setFont(font);
        jButtonPro.setBorder(null);
        
        jButtonPro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String os = System.getProperty("os.name").toLowerCase();
                    ProcessBuilder processBuilder;
                    
                    if (os.contains("win")) {
                        processBuilder = new ProcessBuilder("cmd", "/c", "start", "code", "C:\\Users\\lipe\\projetos");
                    } else {
                        processBuilder = new ProcessBuilder("/bin/sh", "-c", "cd /home/lipe/projetos && code .");
                    }
                    
                    processBuilder.inheritIO();  // Permite visualizar a saída no terminal
                    Process process = processBuilder.start();
                    process.waitFor();
        
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Screen.this, "Erro ao tentar abrir o VS Code: " + ex.getMessage());
                    ex.printStackTrace();  // Exibe erro no console
                }
            }
        });
//      --------------------------------------

//  ========================================================================

//  ADD-BUTTONS ======================================================================================
        add(jButtonLink);
        add(jButtonTps);
        add(jButtonPro);
//  ==================================================================================================

        setVisible(true);
    }



//  LOAD FONT COMIC ==============================================================================
    private void ComicFont() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("/home/lipe/projetos/menuPage/fonts/Comico.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a fonte.");
            font = new Font("Arial", Font.PLAIN, 40); // Fonte alternativa se der erro
        }
        
    }
//  ==============================================================================================
}
