import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class IHM2 extends JFrame{

    public String reponse_alerte;
    public ArrayList<Listener> liste_ecouteurs_IHM;
    public ArrayList<CaptIncendie> liste_capteurs_feu_IHM;
    public ArrayList<CaptGaz> liste_capteurs_gaz_IHM;
    public ArrayList<CaptRadiation> liste_capteurs_radiation_IHM;

    public IHM2(ArrayList<Listener> uneMonoListe, ArrayList<CaptIncendie> uneFeuListe, ArrayList<CaptGaz> uneGazListe, ArrayList<CaptRadiation> uneRadiationListe) {
    liste_ecouteurs_IHM = uneMonoListe;
    liste_capteurs_feu_IHM = uneFeuListe;
    liste_capteurs_gaz_IHM = uneGazListe;
    liste_capteurs_radiation_IHM = uneRadiationListe;
    final JFrame f =  new JFrame();  
    f.setTitle("Fenêtre de déclaration des alarmes");
    final JLabel question_alerte = new JLabel("Quelle alerte voulez vous déclarer ?");
    question_alerte.setBounds(100, 75, 250, 25); 
    final JButton b = new JButton("Entrer");
    b.setBounds(100, 160, 100, 20);  
    final JButton fin_de_programme = new JButton("Terminer le programme");
    fin_de_programme.setBounds(100, 300, 200, 20);
    final DefaultListModel<String> l1 = new DefaultListModel<>();  
    l1.addElement("Alerte gaz");  
    l1.addElement("Alerte feu");  
    l1.addElement("Alerte radiation");   
    final JList<String> list1 = new JList<>(l1);  
    list1.setBounds(100,100, 100,55);  

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

    f.add(question_alerte);
    f.add(list1); 
    f.add(b);
    f.add(fin_de_programme);
    f.setSize(450,450);  
    f.setLayout(null);  
    f.setVisible(true);  
    b.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {   
            String data = "";                       
            data = list1.getSelectedValue();   
            reponse_alerte = data; 
            if (reponse_alerte == "Alerte gaz") {
                liste_capteurs_gaz_IHM.get(0).createEvent(LocalDate.of(2022, 5, 6), "IHM", 1, "C02");
            }
            if (reponse_alerte == "Alerte feu") {
                liste_capteurs_feu_IHM.get(0).createEvent(LocalDate.of(2022, 5, 6), "IHM", 1);
            }
            if (reponse_alerte == "Alerte radiation") {
                liste_capteurs_radiation_IHM.get(0).createEvent(LocalDate.of(2022, 5, 6), "IHM", 1, 98);
            }
            }
        });

    fin_de_programme.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });   
}
}
