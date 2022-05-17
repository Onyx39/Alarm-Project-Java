package ihm;

import alarm.EmissionGaz;
import alarm.EmissionRadiation;
import alarm.ListenerB;

import java.awt.event.*;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class IHMMoniteurB extends JFrame implements ListenerB {

    String nom;
    ArrayList<EmissionGaz> liste_alarme_gaz;
    ArrayList<EmissionRadiation> liste_alarme_radiation;

    JFrame f = new JFrame("Interface moniteur type B");
  
    final DefaultListModel<String> l1 = new DefaultListModel<>();
    JList<String> list1 = new JList<>(l1);

    JButton details = new JButton("Détails");
    

    public IHMMoniteurB (String unNom) {
        nom = unNom;
        liste_alarme_radiation = new ArrayList<EmissionRadiation>();
        liste_alarme_gaz = new ArrayList<EmissionGaz>();
        JLabel titre = new JLabel("Bienvenue sur le moniteur '" + nom + "' de type B");
        titre.setBounds(20, 20, 420, 30);
        f.setBounds(900, 300, 400, 320);
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
                p.setBounds(0, 500, 400, 180);
                int index = list1.getSelectedIndex();
                if (list1.getSelectedValue() == "Alerte radiation") {
                    EmissionRadiation alerte_presente = liste_alarme_radiation.get(index);
                    JLabel importance = new JLabel("L'importance de l'alerte est " + alerte_presente.getImportance());
                    importance.setBounds(20, 20, 300, 25);
                    JLabel lieu = new JLabel("L'incident s'est déclaré dans le bâtiment " + alerte_presente.getLieu().getNom());
                    lieu.setBounds(20, 45, 350, 25);
                    JLabel adresse = new JLabel("Adresse : " + alerte_presente.getLieu().getAdresse());
                    adresse.setBounds(20, 70, 500, 25);
                    JLabel rad = new JLabel("Niveau des radiations : " + alerte_presente.getNiveau_radiation());
                    rad.setBounds(20, 95, 150, 25);
                    p.add(rad);
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
        liste_alarme_radiation.add(null);
        f.setVisible(true);
        SwingUtilities.updateComponentTreeUI(f);
        
    }

    @Override
    public void onEvent(EmissionRadiation e) {
        l1.addElement("Alerte radiation");
        liste_alarme_gaz.add(null);
        liste_alarme_radiation.add(e);
        f.setVisible(true);
        SwingUtilities.updateComponentTreeUI(f);
    }
    

    
}

    