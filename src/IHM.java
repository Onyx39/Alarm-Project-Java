import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class IHM extends JFrame {
    private Container pan = getContentPane();
    //private JTextField text;
    private JButton bouton_validation_feu;
    private JButton bouton_validation_gaz;
    private JButton bouton_validation_radiation;
    public ArrayList<Listener> liste_ecouteurs_IHM;
    public ArrayList<CaptIncendie> liste_capteurs_feu_IHM;
    public ArrayList<CaptGaz> liste_capteurs_gaz_IHM;
    public ArrayList<CaptRadiation> liste_capteurs_radiation_IHM;

    public IHM (ArrayList<Listener> uneMonoListe, ArrayList<CaptIncendie> uneFeuListe, ArrayList<CaptGaz> uneGazListe, ArrayList<CaptRadiation> uneRadiationListe) {
        liste_ecouteurs_IHM = uneMonoListe;
        liste_capteurs_feu_IHM = uneFeuListe;
        liste_capteurs_gaz_IHM = uneGazListe;
        liste_capteurs_radiation_IHM = uneRadiationListe;
        //this.text = new JTextField("Ceci est la fenetre de gestion des alarmes");
        //this.pan.add(this.text, BorderLayout.CENTER);
        this.setTitle("Appliction de gestion des alarmes");
        this.bouton_validation_feu = new JButton ("Bouton validation de l'alarme feu");
        this.bouton_validation_gaz = new JButton ("Bouton validation de l'alarme gaz");
        this.bouton_validation_radiation = new JButton ("Bouton validation de l'alarme radiation");

        for (int i = 0; i < liste_capteurs_feu_IHM.size(); i++) {
            for (int j = 0; j < liste_ecouteurs_IHM.size(); j++) {
                liste_capteurs_feu_IHM.get(i).addListener(liste_ecouteurs_IHM.get(j));
            }
        }

        for (int i = 0; i < liste_capteurs_gaz_IHM.size(); i++) {
            for (int j = 0; j < liste_ecouteurs_IHM.size(); j++) {
                liste_capteurs_gaz_IHM.get(i).addListener(liste_ecouteurs_IHM.get(j));
            }
        }

        for (int i = 0; i < liste_capteurs_radiation_IHM.size(); i++) {
            for (int j = 0; j < liste_ecouteurs_IHM.size(); j++) {
                liste_capteurs_radiation_IHM.get(i).addListener(liste_ecouteurs_IHM.get(j));
            }
        }

        /*
        this.bouton_lieu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IHM MyIHM2 = new IHM();

            }
        });
        */

        this.bouton_validation_feu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liste_capteurs_feu_IHM.get(0).createEvent(LocalDate.of(2022, 5, 6), "IHM", 1);
            }
        });

        this.bouton_validation_gaz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liste_capteurs_gaz_IHM.get(0).createEvent(LocalDate.of(2022, 5, 6), "IHM", 1, "C02");
            }
        });

        this.bouton_validation_radiation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liste_capteurs_radiation_IHM.get(0).createEvent(LocalDate.of(2022, 5, 6), "IHM", 1, 98);
            }


    
        });

        this.pan.add(this.bouton_validation_feu, BorderLayout.EAST);
        this.pan.add(this.bouton_validation_gaz, BorderLayout.WEST);
        this.pan.add(this.bouton_validation_radiation, BorderLayout.CENTER);
        this.setVisible(true);
    }
}