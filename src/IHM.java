import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class IHM extends JFrame {
    private Container pan = getContentPane();
    private JTextField text;
    private JButton bouton_validation;
    private JButton bouton_lieu;

    public IHM () {
        super();
        this.text = new JTextField("Ceci est la fenetre de gestion des alarmes");
        this.pan.add(this.text, BorderLayout.CENTER);
        this.bouton_validation = new JButton ("Bouton valisation de l'alarme");
        this.bouton_lieu = new JButton ("Choisir la salle");

        /*
        this.bouton_lieu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IHM MyIHM2 = new IHM();

            }
        });
        */

        this.bouton_validation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MoniteurA monoA = new MoniteurA("monoA");
                MoniteurB monoB = new MoniteurB("monoB");
                CaptIncendie newE = new CaptIncendie(2, "Alerte IHM", "IHM");
                newE.addListener(monoA);
                newE.addListener(monoB);
                newE.createEvent(LocalDate.of(2022, 5, 6), "IHM", 1);
                
            }

    
        });

        this.pan.add(this.bouton_validation, BorderLayout.SOUTH);
        this.pan.add(this.bouton_lieu, BorderLayout.CENTER);
        this.setVisible(true);
    }
}