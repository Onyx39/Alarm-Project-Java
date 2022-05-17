package ihm;

import alarm.EmissionGaz;
import alarm.Incendie;
import alarm.ListenerA;

import java.awt.event.*;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class IHMMoniteurA extends JFrame implements ListenerA {

    String nom;
    ArrayList<Incendie> liste_alarme_feu;
    ArrayList<EmissionGaz> liste_alarme_gaz;
    JFrame f = new JFrame("Interface moniteur type A");
  
    final DefaultListModel<String> l1 = new DefaultListModel<>();
    JList<String> list1 = new JList<>(l1);

    JButton details = new JButton("Détails");
    

    public IHMMoniteurA (String unNom) {
    nom = unNom;
    liste_alarme_feu = new ArrayList<Incendie>();
    liste_alarme_gaz = new ArrayList<EmissionGaz>();
    JLabel titre = new JLabel("Bienvenue sur le moniteur '" + nom + "' de type A");
    titre.setBounds(20, 20, 420, 30);
    f.setBounds(600, 300, 350, 320);
    f.setLayout(null);
    f.add(titre);
    f.add(details);
    list1.setBounds(50, 50, 100, 150);
    details.setBounds(45, 230, 100, 30);
    f.add(list1);
    f.setVisible(true);

    details.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent e){
            JFrame p = new JFrame ("Détails de l'alarme");
            p.setLayout(null);
            p.setBounds(0, 310, 500, 180);
            int index = list1.getSelectedIndex();
            if (list1.getSelectedValue() == "Alerte feu") {
                Incendie alerte_presente = liste_alarme_feu.get(index);
                JLabel importance = new JLabel("L'importance de l'alerte est " + alerte_presente.getImportance());
                importance.setBounds(20, 20, 300, 25);
                JLabel lieu = new JLabel("L'incendie s'est déclaré dans le bâtiment " + alerte_presente.getLieu().getNom());
                lieu.setBounds(20, 45, 350, 25);
                JLabel adresse = new JLabel("Adresse : " + alerte_presente.getLieu().getAdresse());
                adresse.setBounds(20, 70, 500, 25);
                p.add(adresse);
                p.add(importance);
                p.add(lieu);
            }
            else {
                EmissionGaz alerte_presente = liste_alarme_gaz.get(index);
                JLabel importance = new JLabel("L'importance de l'alerte est " + alerte_presente.getImportance());
                importance.setBounds(20, 20, 300, 25);
                JLabel lieu = new JLabel("L'incident s'est déclaré dans le bâtiment " + alerte_presente.getLieu().getNom());
                lieu.setBounds(20, 45, 350, 25);
                JLabel adresse = new JLabel("Adresse : " + alerte_presente.getLieu().getAdresse());
                adresse.setBounds(20, 70, 500, 25);
                JLabel gaz = new JLabel("Gaz impliqué : " + alerte_presente.getType());
                gaz.setBounds(20, 95, 150, 25);
                p.add(gaz);
                p.add(adresse);
                p.add(importance);
                p.add(lieu);

            }
            p.setVisible(true);

        }    
    });

    }

    @Override
    public void onEvent(EmissionGaz e) {
        l1.addElement("Alerte gaz");
        liste_alarme_gaz.add(e);
        liste_alarme_feu.add(null);
        f.setVisible(true);
        SwingUtilities.updateComponentTreeUI(f);
        
    }

    @Override
    public void onEvent(Incendie e) {
        l1.addElement("Alerte feu");
        liste_alarme_feu.add(e);
        liste_alarme_gaz.add(null);
        f.setVisible(true);
        SwingUtilities.updateComponentTreeUI(f);
    }
    

    
}

    