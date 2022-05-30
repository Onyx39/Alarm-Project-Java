package ihm;

import alarm.EmissionGaz;
import alarm.EmissionRadiation;
import alarm.ListenerB;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class IHMMoniteurB extends JFrame implements ListenerB {

    String nom;
    ArrayList<EmissionGaz> liste_alarme_gaz;
    ArrayList<EmissionRadiation> liste_alarme_radiation;
    ArrayList<String> alarmes_deja_visualisees;

    JFrame f = new JFrame("Interface moniteur type B");
    JLabel nonTraitees = new JLabel("Non traitées");

    final DefaultListModel<String> l1 = new DefaultListModel<>();
    JList<String> list1 = new JList<>(l1);

    JButton details = new JButton("Détails");
    JButton traitee = new JButton("Traitée");

    public IHMMoniteurB (String unNom) {
        nom = unNom;
        liste_alarme_radiation = new ArrayList<EmissionRadiation>();
        liste_alarme_gaz = new ArrayList<EmissionGaz>();
        alarmes_deja_visualisees = new ArrayList<String>();
        JLabel titre = new JLabel("Bienvenue sur le moniteur '" + nom + "' de type B");
        titre.setBounds(20, 20, 420, 30);
        f.setBounds(900, 300, 400, 320);
        f.setLayout(null);
        f.add(titre);
        f.add(details);
        f.add(nonTraitees);
        nonTraitees.setBounds(50, 50, 100, 25);
        list1.setBounds(50, 75, 100, 150);
        details.setBounds(50, 245, 100, 30);
        traitee.setBounds(170, 245, 100, 30);
        f.add(traitee);
        f.add(list1);
        f.setVisible(true);
    
        details.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                JFrame p = new JFrame ("Détails de l'alarme (" + nom +')');
                p.setLayout(null);
                p.setBounds(0, 500, 400, 180);
                int index = list1.getSelectedIndex();
                alarmes_deja_visualisees.set(index, "1");
                if (list1.getSelectedValue() == "Alerte gaz") {
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
                    JButton fermer = new JButton ("Fermer");
                    fermer.setBounds(297, 110, 80, 25);
                    p.add(fermer);
                    p.add(adresse);
                    p.add(importance);
                    p.add(lieu);
                    p.setVisible(true);
                    traitee.addActionListener(new ActionListener() {
                        public void actionPerformed (ActionEvent e){
                            int index = list1.getSelectedIndex();
                            String test = alarmes_deja_visualisees.get(index);
                            if (test == "1") {
                                p.dispose();
                                liste_alarme_radiation.remove(index);
                                liste_alarme_gaz.remove(index);
                                alarmes_deja_visualisees.remove(index);
                                l1.remove(index);
                
                                f.revalidate();
                                SwingUtilities.updateComponentTreeUI(f);
                            }
                            else {
                                JFrame non = new JFrame ("Message d'erreur");
                                JLabel erreur = new JLabel ("Vous n'avez pas traité l'erreur !", SwingConstants.CENTER);
                                non.setSize(300, 300);
                                non.setLocationRelativeTo(null);
                                non.add(erreur);
                                non.setVisible(true);
                                f.revalidate();
                                SwingUtilities.updateComponentTreeUI(f);
                            }
                        }
                    });
                    fermer.addActionListener(new ActionListener() {
                        public void actionPerformed (ActionEvent h) {
                            p.dispose();
                            f.revalidate();
                        }
                    });
                }
                else {
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
                    JButton fermer = new JButton ("Fermer");
                    fermer.setBounds(297, 110, 80, 25);
                    p.add(fermer);
                    p.add(adresse);
                    p.add(importance);
                    p.add(lieu);
                    p.setVisible(true);
                    traitee.addActionListener(new ActionListener() {
                        public void actionPerformed (ActionEvent e){
                            int index = list1.getSelectedIndex();
                            String test = alarmes_deja_visualisees.get(index);
                            if (test == "1") {
                                p.dispose();
                                liste_alarme_radiation.remove(index);
                                liste_alarme_gaz.remove(index);
                                alarmes_deja_visualisees.remove(index);
                                l1.remove(index);
                
                                f.revalidate();
                                SwingUtilities.updateComponentTreeUI(f);
                            }
                            else {
                                JFrame non = new JFrame ("Message d'erreur");
                                JLabel erreur = new JLabel ("Vous n'avez pas traité l'erreur !", SwingConstants.CENTER);
                                non.setSize(300, 300);
                                non.setLocationRelativeTo(null);
                                non.add(erreur);
                                non.setVisible(true);
                                f.revalidate();
                                SwingUtilities.updateComponentTreeUI(f);
                            }
                        }
                    });
                    fermer.addActionListener(new ActionListener() {
                        public void actionPerformed (ActionEvent h) {
                            p.dispose();
                            f.revalidate();
                        }
                    });
                }
    
            }    
        });
    
        }

        @Override
        public void onEvent(EmissionGaz e) {
            JFrame message = new JFrame ("Nouvelle alerte");
            message.setLayout(null);
            JLabel message_alerte1 = new JLabel("Nouvelle alerte gaz !", SwingConstants.CENTER);
            JLabel message_alerte2 = new JLabel("'" + nom + "'", SwingConstants.CENTER);
    
            message_alerte1.setForeground(Color.RED);
            message_alerte1.setBackground(Color.white);
            message_alerte1.setOpaque(true);
            message_alerte1.setFont(new Font("Serif", Font.BOLD, 38));
            message_alerte2.setForeground(Color.RED);
            message_alerte2.setBackground(Color.white);
            message_alerte2.setOpaque(true);
            message_alerte2.setFont(new Font("Serif", Font.BOLD, 38));
            JButton ok = new JButton ("OK");
            ok.setBounds(500, 600, 400, 60);
            message.setSize(1350, 730);
            message.setLocationRelativeTo(null);
            message_alerte1.setBounds(400, 300, 600, 200);
            message_alerte2.setBounds(400, 100, 600, 200);
            message.getContentPane().setBackground(Color.BLUE);
            message.add(message_alerte1);
            message.add(message_alerte2);
            message.add(ok);
            message.setVisible(true);
            ok.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent actionevent) {
                    message.removeAll();
                    f.revalidate();
                    message.setVisible(false);
                    f.revalidate();
                    l1.addElement("Alerte gaz");
                    liste_alarme_gaz.add(e);
                    liste_alarme_radiation.add(null);
                    alarmes_deja_visualisees.add("0");
                    f.setVisible(true);
                    SwingUtilities.updateComponentTreeUI(f);
                }
            });
            
        }

    @Override
    public void onEvent(EmissionRadiation e) {
        JFrame message = new JFrame ("Nouvelle alerte");
            message.setLayout(null);
            JLabel message_alerte1 = new JLabel("Nouvelle alerte radiation !", SwingConstants.CENTER);
            JLabel message_alerte2 = new JLabel("'" + nom + "'", SwingConstants.CENTER);
    
            message_alerte1.setForeground(Color.RED);
            message_alerte1.setBackground(Color.white);
            message_alerte1.setOpaque(true);
            message_alerte1.setFont(new Font("Serif", Font.BOLD, 38));
            message_alerte2.setForeground(Color.RED);
            message_alerte2.setBackground(Color.white);
            message_alerte2.setOpaque(true);
            message_alerte2.setFont(new Font("Serif", Font.BOLD, 38));
            JButton ok = new JButton ("OK");
            ok.setBounds(500, 600, 400, 60);
            message.setSize(1350, 730);
            message.setLocationRelativeTo(null);
            message_alerte1.setBounds(400, 300, 600, 200);
            message_alerte2.setBounds(400, 100, 600, 200);
            message.getContentPane().setBackground(Color.BLUE);
            message.add(message_alerte1);
            message.add(message_alerte2);
            message.add(ok);
            message.setVisible(true);
            ok.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent actionevent) {
                    message.removeAll();
                    f.revalidate();
                    message.setVisible(false);
                    f.revalidate();
                    l1.addElement("Alerte radiation");
                    liste_alarme_gaz.add(null);
                    liste_alarme_radiation.add(e);
                    alarmes_deja_visualisees.add("0");
                    f.setVisible(true);
                    SwingUtilities.updateComponentTreeUI(f);
                }
            });
    }
    

    
}

    