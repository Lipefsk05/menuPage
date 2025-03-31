import java.awt.*;
import java.awt.event.*;
import javax.swing.*;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       


public class Screen extends JFrame{
    public Screen(){
    
        JButton jButtonLink = new JButton("Github");
        JButton jButtonTps = new JButton("Tps");

        Font font = new Font("Arial", Font.BOLD, 40);
        Color white = new Color(0, 0, 0);
        Color black = new Color(255, 255, 255);

        setTitle("Menu Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        
        
        // setIconImage(getIconImage());

        jButtonLink.setBounds(300, 200, 200, 100);
        jButtonLink.setForeground(black);
        jButtonLink.setBackground(white);
        jButtonLink.setFont(font);
        
        jButtonTps.setBounds(300, 350, 200, 100);
        jButtonTps.setForeground(black);
        jButtonTps.setBackground(white);
        jButtonTps.setFont(font);

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
        
        jButtonTps.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
        
                    String os = System.getProperty("os.name").toLowerCase();
                    String command = null;
                    if (os.contains("win")) {
                        command = "";
                    } else if (os.contains("mac")) {
                        // command = "open ";
                    } else {
                        command = "cd /home/lipe/facul/cc-puc/cc-2-periodo/tps/ ; code .";
                    }
        
                    Runtime.getRuntime().exec(command);
        
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Screen.this, "Erro ao tentar abrir o link: " + ex.getMessage());
                }
            }
        });
        

        add(jButtonLink);
        add(jButtonTps);

        setVisible(true);
    }
}