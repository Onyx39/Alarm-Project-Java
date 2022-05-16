import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class IHMGenerationAlarme extends JFrame{

    public ArrayList<Batiment> list_bat;
    public ArrayList<ListenerA> liste_ecouteursA_IHM;
    public ArrayList<ListenerB> liste_ecouteursB_IHM;
    public ArrayList<CaptIncendie> liste_capteurs_feu_IHM;
    public ArrayList<CaptGaz> liste_capteurs_gaz_IHM;
    public ArrayList<CaptRadiation> liste_capteurs_radiation_IHM;

    public IHMGenerationAlarme(ArrayList<ListenerA> uneMonoListeA, ArrayList<ListenerB> uneMonoListeB, ArrayList<CaptIncendie> uneFeuListe, ArrayList<CaptGaz> uneGazListe, ArrayList<CaptRadiation> uneRadiationListe, ArrayList<Batiment> uneBatListe) {
        list_bat = uneBatListe;
        liste_ecouteursA_IHM = uneMonoListeA;
        liste_ecouteursB_IHM = uneMonoListeB;
        liste_capteurs_feu_IHM = uneFeuListe;
        liste_capteurs_gaz_IHM = uneGazListe;
        liste_capteurs_radiation_IHM = uneRadiationListe;


    //Création de la liste de choix des alarmes
        final JFrame f =  new JFrame();
        f.setLayout(null); 
        f.setSize(1050,250);  
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(20, 20, 250, 250); 
        f.setTitle("Fenêtre de déclaration des alarmes");
        final JLabel question_alerte = new JLabel("Quelle alerte voulez vous déclarer ?");
        question_alerte.setBounds(0, 0, 250, 25); 
        final JButton b = new JButton("Entrer");
        b.setBounds(115, 76, 100, 20);  
        final JButton fin_de_programme = new JButton("Terminer le programme");
        fin_de_programme.setBounds(20, 150, 200, 30);
        final DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement(" Alerte gaz ");  
        l1.addElement(" Alerte feu ");  
        l1.addElement(" Alerte radiation ");   
        final JList<String> list1 = new JList<>(l1);  
        list1.setBounds(0,42, 100,54);  

    //Ajout de tous les ecouteurs
        for (int i = 0; i < liste_capteurs_feu_IHM.size(); i++) {
            for (int j = 0; j < liste_ecouteursA_IHM.size(); j++) {
                liste_capteurs_feu_IHM.get(i).addListenerA(liste_ecouteursA_IHM.get(j));
            }
        }

        for (int i = 0; i < liste_capteurs_gaz_IHM.size(); i++) {
            for (int j = 0; j < liste_ecouteursA_IHM.size(); j++) {
                liste_capteurs_gaz_IHM.get(i).addListenerA(liste_ecouteursA_IHM.get(j));
            }
        }

        for (int i = 0; i < liste_capteurs_gaz_IHM.size(); i++) {
            for (int j = 0; j < liste_ecouteursB_IHM.size(); j++) {
                liste_capteurs_gaz_IHM.get(i).addListenerB(liste_ecouteursB_IHM.get(j));
            }
        }

        for (int i = 0; i < liste_capteurs_radiation_IHM.size(); i++) {
            for (int j = 0; j < liste_ecouteursB_IHM.size(); j++) {
                liste_capteurs_radiation_IHM.get(i).addListenerB(liste_ecouteursB_IHM.get(j));
            }
        }

        panel1.add(question_alerte);
        panel1.add(list1); 
        panel1.add(b);
        f.add(fin_de_programme);
        f.add(panel1);
        panel1.setVisible(true); 
        f.setVisible(true); 

        b.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                String reponse_alerte = "";                       
                reponse_alerte = list1.getSelectedValue();    
                if (reponse_alerte == " Alerte gaz ") {
                    new PanelGaz(f, liste_capteurs_gaz_IHM, list_bat);
                }

                else { if (reponse_alerte == " Alerte feu ") {
                    new PanelIncendie(f, liste_capteurs_feu_IHM, list_bat);
                }

                else { if (reponse_alerte == " Alerte radiation ") {
                    new PanelRadiation(f, liste_capteurs_radiation_IHM, list_bat);
                }}}
            }
        });      

        //Bonton pour fermer la fenêtre et terminer le programme
        fin_de_programme.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });   

    };
        
}
