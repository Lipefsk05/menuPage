import java.awt.*;
import java.awt.event.*;
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

        Color STR_DARK_GRAY = new Color(40, 40, 40);

        int fWidth = 350, fHeight = 800;
        
        setTitle("Menu Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(fWidth, fHeight);
        setLocationRelativeTo(null);
        setLayout(null);
        // setIconImage(getIconImage());
        getContentPane().setBackground(Color.DARK_GRAY);        
        
//  ===================================================================================================================================================================================

//  BUTTONS

//      --------------------------------------
//      Projects
        JButton jButtonPro = creatButton("Projects", 50, fWidth, fHeight);
        jButtonPro.addActionListener(e -> openFolder("/home/lipe/projetos"));

        jButtonPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                animateButtonFont(jButtonPro, 55f);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                animateButtonFont(jButtonPro, 45f);
            }
        });
//      --------------------------------------
//      Github
        JButton jButtonGitH = creatButton("Github", 200, fWidth, fHeight);
        jButtonGitH.addActionListener(e -> openLink("https://github.com/Lipefsk05"));

        jButtonGitH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                animateButtonFont(jButtonGitH, 55f);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                animateButtonFont(jButtonGitH, 45f);
            }
        });
//      --------------------------------------
//      TPs
        JButton jButtonTps = creatButton("Tps", 350, fWidth, fHeight);
        jButtonTps.addActionListener(e -> openFolder("/home/lipe/facul/cc-puc/cc-2-periodo/tps"));

        jButtonTps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                animateButtonFont(jButtonTps, 55f);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                animateButtonFont(jButtonTps, 45f);
            }
        });
//      --------------------------------------
//      Add
        add(jButtonPro);
        add(jButtonGitH);
        add(jButtonTps);

//  ===================================================================================================================================================================================
        setVisible(true);
    }



//  ===================================================================================================================================================================================
    
//      LOAD FONT COMIC

    private void ComicFont() {
    try {
        font = Font.createFont(Font.TRUETYPE_FONT, new File("/home/lipe/projetos/menuPage/fonts/Comico.ttf")).deriveFont(40f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
    } catch (IOException | FontFormatException e) {
        e.printStackTrace();
        System.out.println("Erro ao carregar a fonte.");
        font = new Font("Arial", Font.PLAIN, 45); // Fonte alternativa se der erro
    }
    }

//  ===================================================================================================================================================================================

//      ANIMATE BUTTON FONT

    private void animateButtonFont(JButton button, float targetSize) {
        Timer timer = new Timer(10, null);
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




//  ===================================================================================================================================================================================

//      CREAT BUTTON

    private JButton creatButton(String text, int posH, int fWidth, int fHeight){
        
        
        JButton button = new JButton(text);
        button.setBounds((fWidth - 300)/2, posH, 300, 100);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.setFont(font);
        button.setBorder(null);
        button.setFocusPainted(false);
        
        return button;
    }
}
