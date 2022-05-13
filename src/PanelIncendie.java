import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PanelIncendie {

    JPanel selectLieu = new JPanel();
    JPanel selectImportance = new JPanel();

    public PanelIncendie (JFrame f, ArrayList<CaptIncendie> liste_capteurs_feu_IHM, ArrayList<Batiment> list_bat) {
    
        selectLieu.setBounds(250, 20, 175, 300);
        JLabel question_batiment = new JLabel (" Dans quel bâtiment ?  ");
        question_batiment.setBounds(0, 0, 250, 25);
        final DefaultListModel<String> l3 = new DefaultListModel<>();  
        for (int k = 0; k < liste_capteurs_feu_IHM.size(); k++) {
            Batiment bat_nom = liste_capteurs_feu_IHM.get(k).getLieu();
            l3.add(k, " "+bat_nom.getNom()+" ");
        }
        final JList<String> list3 = new JList<>(l3);  
        list3.setBounds(0, 25, 50,100); 
        JButton validLieu = new JButton("Entrer");
        validLieu.setBounds(90, 50, 100, 20);
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
                JLabel question_importance = new JLabel("    Quel est le niveau d'importance ?   ");
                question_importance.setBounds(0, 0, 225, 20);
                selectImportance.setBounds(415, 20, 225, 300);
                final DefaultListModel<String> l2 = new DefaultListModel<>();  
                l2.addElement(" 1 ");  
                l2.addElement(" 2 ");  
                l2.addElement(" 3 ");  
                final JList<String> list2 = new JList<>(l2);  
                list2.setBounds(0,20, 30,100); 
                JButton validImportance = new JButton("Entrer");
                validImportance.setBounds(50, 50, 100, 20);
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
                        liste_capteurs_feu_IHM.get(0).createEvent(LocalDate.now(), lieu_incendie, Integer.parseInt(importance));
                        selectImportance.removeAll();
                        selectLieu.removeAll();
                        SwingUtilities.updateComponentTreeUI(f);
                    }
                }); 
            }
        }); 
    }
}
