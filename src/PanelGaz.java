import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PanelGaz {

    public PanelGaz (JFrame f, ArrayList<CaptGaz> liste_capteurs_gaz_IHM, ArrayList<Batiment> list_bat) {

        JPanel selectLieu = new JPanel();
        selectLieu.setLayout(null);
        selectLieu.setBounds(290, 20, 200, 250);
        JLabel question_batiment = new JLabel ("Dans quel bâtiment ?");
        question_batiment.setBounds(0, 0, 200, 25);
        final DefaultListModel<String> l3 = new DefaultListModel<>();  
        for (int k = 0; k < liste_capteurs_gaz_IHM.size(); k++) {
            Batiment bat_nom = liste_capteurs_gaz_IHM.get(k).getLieu();
            l3.add(k, " "+bat_nom.getNom()+" ");
        }
        final JList<String> list3 = new JList<>(l3);  
        list3.setBounds(0, 42, 60,54); 
        JButton validLieu = new JButton("Entrer");
        validLieu.setBounds(75, 76, 100, 20);
        selectLieu.add(question_batiment);
        selectLieu.add(validLieu);
        selectLieu.add(list3);
        f.add(selectLieu);
        selectLieu.setVisible(true);
        SwingUtilities.updateComponentTreeUI(f);

        validLieu.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                String lieu = "";
                lieu = list3.getSelectedValue();
                final String lieu_incendie = lieu;
                JPanel selectImportance = new JPanel ();
                JLabel question_importance = new JLabel("Quel est le niveau d'importance de l'alerte ?");
                selectImportance.setLayout(null);
                question_importance.setBounds(0, 0, 250, 20);
                selectImportance.setBounds(510, 20, 250, 250);
                final DefaultListModel<String> l2 = new DefaultListModel<>();  
                l2.addElement(" 1 ");  
                l2.addElement(" 2 ");  
                l2.addElement(" 3 ");  
                final JList<String> list2 = new JList<>(l2);  
                list2.setBounds(0,42, 15,54); 
                JButton validImportance = new JButton("Entrer");
                validImportance.setBounds(30, 76, 100, 20);
                selectImportance.add(question_importance);
                selectImportance.add(list2);
                selectImportance.add(validImportance);
                f.add(selectImportance);
                selectImportance.setVisible(true);
                SwingUtilities.updateComponentTreeUI(f);

                        validImportance.addActionListener(new ActionListener()  {
                            public void actionPerformed(ActionEvent e) {
                                list2.getSelectedValue();
                                final String importance = String.valueOf(list2.getSelectedValue().charAt(1));
                                JPanel selectGaz = new JPanel();
                                selectGaz.setLayout(null);
                                JLabel question_gaz = new JLabel("Quel est le type de gaz ?");
                                question_gaz.setBounds(0, 0, 250, 20);
                                selectGaz.setBounds(780, 20, 250, 250);
                                JTextField gaz = new JTextField();
                                gaz.setBounds(0, 42, 50, 20);;
                                JButton validGaz = new JButton("Entrer");
                                validGaz.setBounds(0, 77, 100, 20);
                                selectGaz.add(question_gaz);
                                selectGaz.add(gaz);
                                selectGaz.add(validGaz);
                                f.add(selectGaz);
                                selectGaz.setVisible(true);
                                SwingUtilities.updateComponentTreeUI(f);

                                validGaz.addActionListener(new ActionListener () {
                                    public void actionPerformed (ActionEvent e) {
                                        String type_gaz = gaz.getText();
                                        liste_capteurs_gaz_IHM.get(0).createEvent(LocalDate.now(), lieu_incendie, Integer.parseInt(importance), type_gaz);
                                        selectGaz.removeAll();
                                        selectImportance.removeAll();
                                        selectLieu.removeAll();
                                        SwingUtilities.updateComponentTreeUI(f);
                                    }
                                });
                            }
                        }); 
                    }
                }); 
            }

    }