import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PanelRadiation {

    public PanelRadiation (JFrame f, ArrayList<CaptRadiation> liste_capteurs_radiation_IHM) {

        JPanel selectLieu = new JPanel();
                selectLieu.setBounds(300, 20, 250, 300);
                JLabel question_batiment = new JLabel ("Dans quel bâtiment ?");
                question_batiment.setBounds(0, 0, 150, 20);
                final DefaultListModel<String> l3 = new DefaultListModel<>();  
                l3.addElement("Polytech");  
                l3.addElement("Mairie");  
                l3.addElement("Maison");   
                final JList<String> list3 = new JList<>(l3);  
                list3.setBounds(20,20, 100,55); 
                JButton validLieu = new JButton("Entrer");
                validLieu.setBounds(20, 160, 100, 20);
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
                        JLabel question_importance = new JLabel("Quel est le niveau d'importance ?");
                        question_importance.setBounds(0, 0, 300, 20);
                        selectImportance.setBounds(550, 20, 250, 300);
                        final DefaultListModel<String> l2 = new DefaultListModel<>();  
                        l2.addElement("1");  
                        l2.addElement("2");  
                        l2.addElement("3");   
                        final JList<String> list2 = new JList<>(l2);  
                        list2.setBounds(600,100, 100,55); 
                        JButton validImportance = new JButton("Entrer");
                        validImportance.setBounds(600, 160, 100, 20);
                        selectImportance.add(question_importance);
                        selectImportance.add(list2);
                        selectImportance.add(validImportance);
                        f.add(selectImportance);
                        selectImportance.setVisible(true);
                        SwingUtilities.updateComponentTreeUI(f);

                        validImportance.addActionListener(new ActionListener()  {
                            public void actionPerformed(ActionEvent e) {
                                final String importance = list2.getSelectedValue();
                                JPanel selectRad = new JPanel();
                                JLabel question_rad = new JLabel("Quelle est le niveau des radiations ?");
                                question_rad.setBounds(0, 0, 150, 20);
                                selectRad.setBounds(600, 150, 300, 300);
                                JTextField rad = new JTextField("Entrer le niveau [0, 100] : ");
                                JButton validRad = new JButton("Entrer");
                                validRad.setBounds(20, 60, 100, 20);
                                selectRad.add(question_rad);
                                selectRad.add(rad);
                                selectRad.add(validRad);
                                f.add(selectRad);
                                selectRad.setVisible(true);
                                SwingUtilities.updateComponentTreeUI(f);

                                validRad.addActionListener(new ActionListener () {
                                    public void actionPerformed (ActionEvent e) {
                                        Integer niveau_radiation = Integer.parseInt(rad.getText());
                                        liste_capteurs_radiation_IHM.get(0).createEvent(LocalDate.now(), lieu_incendie, Integer.parseInt(importance), niveau_radiation);
                                    }
                                });
                            }
                        }); 
                    }
                }); 
            }
    }