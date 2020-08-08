import application.*;
import java.util.*;
import java.io.File;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;



public class main {
	public static void main(String[] args) {
			Menu m1 = new Menu();
			m1.start();
			m1.startShow();
	}
}
/*
public void actionPerformed(ActionEvent evt) {
}

public void test() {

		final Utilisateur U1 = new Utilisateur();
		U1.CreationFichier("AlexandreNote");
		U1.Affichage();
		U1.AjoutAnime("Dragon ball");
		U1.AjoutAnime("Parasite");
		//List<Anime> anime = new ArrayList<Anime>( Arrays.asList(new Anime("Re:zero")) );
		//Utilisateur U3 = new Utilisateur("Alexandre", "U3", anime, 1);
		//U3.AjoutAnime("Kaguya-sama");
		U1.Note(0);
}
*/
class Menu extends JFrame implements ActionListener {
	
	static JPanel panel = new JPanel();
	JPanel panelFirst = new JPanel(new GridLayout(4,1));
	JPanel panelSecond = new JPanel(new GridLayout(4,1));
	JPanel panelTrois = new JPanel(new GridLayout(6,1));
	JPanel panelQuatre = new JPanel(new GridLayout(5,1));
	JPanel panelCinq = new JPanel(new GridLayout(5,1));
	JPanel panelSix = new JPanel(new GridLayout(6,1));
	JPanel panelSept = new JPanel(new GridLayout(5,1));
	JPanel panelHuit = new JPanel(new GridLayout(6,1));
	JPanel panelNeuf = new JPanel(new GridLayout(5,1));
	JPanel panelDix = new JPanel(new GridLayout(6,1));
	JPanel panelOnze = new JPanel(new GridLayout(5,1));
	static JPanel panelDouze = new JPanel(new GridLayout(2,1));
	JPanel panelTreize = new JPanel(new GridLayout(2,1));
	JPanel panelQuatorze = new JPanel(new GridLayout(2,1));

	static JFrame accueil = new JFrame("Notator");
	static CardLayout c1 = new CardLayout();
	JButton commencer = new JButton("Je souhaite noter une histoire");
	JButton validerNom = new JButton("Valider !");
	JButton bareme = new JButton("Créer son propre barème");
	JButton baremeUtiliser = new JButton("Choisir un fichier");
	JFileChooser choisirFichier = new JFileChooser(new File("./fichier"));
	static JTextField nomHistoire = new JTextField();
	JLabel attention = new JLabel("", SwingConstants.CENTER);

	public Menu() {
	}
	
	public void start() {
		setSize(1200,800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		panel.setLayout(c1);
		setContentPane(panel);

		commencer.addActionListener(this);
		bareme.addActionListener(this);
		baremeUtiliser.addActionListener(this);

		// Menu
		JLabel presentation = new JLabel("Bienvenue sur Notator, ici tu vas pouvoir noter tes oeuvres selon divers critères", SwingConstants.CENTER);
		panelFirst.add(presentation);
		panelFirst.add(commencer);
		panelFirst.add(bareme);
		panelFirst.add(baremeUtiliser);
		
		// Commencer
		JLabel presOeuvre = new JLabel("Veuillez sélectionner le nom de l'oeuvre que vous souhaitez noter", SwingConstants.CENTER);
		nomHistoire.setColumns(10);
		
		validerNom.addActionListener(this);
		panelSecond.add(presOeuvre);
		panelSecond.add(nomHistoire);
		panelSecond.add(validerNom);
		panelSecond.add(attention);
		
		panel.add(panelFirst,"1");
		panel.add(panelSecond,"2");
		panel.add(panelTrois,"3");
		panel.add(panelQuatre,"4");
		panel.add(panelCinq,"5");
		panel.add(panelSix,"6");
		panel.add(panelSept,"7");
		panel.add(panelHuit,"8");
		panel.add(panelNeuf,"9");
		panel.add(panelDix,"10");
		panel.add(panelOnze,"11");
		panel.add(panelDouze,"12");
		panel.add(panelTreize,"13");
		panel.add(panelQuatorze,"14");
		
		// Notation
		JLabel categorie1 = new JLabel("Opening", SwingConstants.CENTER);
		JLabel presOpening = new JLabel("Animation et lien avec l'oeuvre", SwingConstants.CENTER);
		panelTrois.add(categorie1);
		panelTrois.add(presOpening);
		TheBouton b1 = new TheBouton(4,"1:30 exploitée à son maximum qui nécessite maintes analyses pour déceler ses mystères, toute l'histoire y est racontée ; rend curieux.", panelTrois, c1, panel);
		TheBouton b2 = new TheBouton(3,"Enchaînement non répétitif et progressif qui montrent aussi bien les personnages que les enjeux ; attise la curiosité du spectateur.", panelTrois, c1, panel);
		TheBouton b3 = new TheBouton(1,"Présentation des personnages dénuée d'action et détachée des enjeux principaux.", panelTrois, c1, panel);
		TheBouton b4 = new TheBouton(0,"Reprise de scènes présentes dans l'anime qui ne correspondent pas à l'univers.", panelTrois, c1, panel);
		
		JLabel presMusique = new JLabel("Musique et parole", SwingConstants.CENTER);
		panelQuatre.add(presMusique);
		TheBouton b5 = new TheBouton(3,"Outre les nombreux mystères, la musique est profondément liée à l'opening et les paroles sont entièrement en accord avec le scénario.", panelQuatre, c1, panel);
		TheBouton b6 = new TheBouton(2,"Paroles peu ancrées dans l'histoire, mais transitions maîtrisées.", panelQuatre, c1, panel);
		TheBouton b7 = new TheBouton(1,"Actions en lien avec la musique mais les paroles sont délaissées, n'ont généralement aucun sens avec l'histoire.", panelQuatre, c1, panel);
		TheBouton b8 = new TheBouton(0,"Aucune construction autour de la musique et paroles sans lien avec ce qui est montré et/ou avec le scénario.", panelQuatre, c1, panel);
		
		JLabel presTypo = new JLabel("Typographie", SwingConstants.CENTER);
		panelCinq.add(presTypo);
		TheBouton b9 = new TheBouton(3,"Intégration totale à l'opening, souvent voire absolument dissimulé dans chaque scène.", panelCinq, c1, panel);
		TheBouton b10 = new TheBouton(2,"Intégration moyenne à l'opening, parfois cela est ancré dans l'animation.", panelCinq, c1, panel);
		TheBouton b11 = new TheBouton(1,"Positionnement de façon à ce que l'animation ne soit pas gênée.", panelCinq, c1, panel);
		TheBouton b12 = new TheBouton(0,"Ce qui est écrit gêne grandement ce qui est animé, est très mal placé.", panelCinq, c1, panel);
		
		
		JLabel categorie2 = new JLabel("Animation", SwingConstants.CENTER);
		JLabel presDetail = new JLabel("Détails de conception", SwingConstants.CENTER);
		panelSix.add(categorie2);
		panelSix.add(presDetail);
		TheBouton b13 = new TheBouton(7,"L'animation s'allie parfaitement au scénario, on nous montre la représentation précise de l'histoire.", panelSix, c1, panel);
		TheBouton b14 = new TheBouton(5,"Nombreux détails, paysage accentué, les plans fixes sont moins présents, et remplacés par des moments d'action.", panelSix, c1, panel);
		TheBouton b15 = new TheBouton(3,"Accentuations prononcées de quelques actions marquantes, mais de nombreux plans fixes sont présents.", panelSix, c1, panel);
		TheBouton b16 = new TheBouton(0,"Aucun effort sur l'animation, aucun sentiment ne s'y dégage, l'action est mal transmise, le spectateur ne peut s'y projeter.", panelSix, c1, panel);
		
		JLabel pres3D = new JLabel("Utilisation de la 3D", SwingConstants.CENTER);
		panelSept.add(pres3D);
		TheBouton b17 = new TheBouton(4,"3D souvent ou totalement présente, ce choix plutôt risqué est considéré et l'animation ne pèse pas du tout sur la compréhension.", panelSept, c1, panel);
		TheBouton b18 = new TheBouton(3,"La 3D est utilisée pour animer les objets, ce qui rend l'animation plus crédible, la 2D sert aux paysages, aux visages et ne gêne pas la fluidité.", panelSept, c1, panel);
		TheBouton b19 = new TheBouton(2,"Mélange de 3D et de 2D mal enchaîné, l'animation s'en retrouve gêné.", panelSept, c1, panel);
		TheBouton b20 = new TheBouton(0,"3D présente pour cacher un manque de temps évident, la 2D est essentielle mais trop peu présente.", panelSept, c1, panel);
		
		
		JLabel categorie3 = new JLabel("Scénario", SwingConstants.CENTER);
		JLabel presOriginal = new JLabel("Cohérence & Originalité", SwingConstants.CENTER);
		panelHuit.add(categorie3);
		panelHuit.add(presOriginal);
		TheBouton b21 = new TheBouton(7,"Création d'un univers solide avec explication cohérente et détaillée de son fonctionnement, peut se montrer très original.", panelHuit, c1, panel);
		TheBouton b22 = new TheBouton(5,"Univers inspiré d'autres, mais qui n'arrive pas à justifier ses événements, en outre, il ne peut se montrer original.", panelHuit, c1, panel);
		TheBouton b23 = new TheBouton(3,"Le scénario est dépourvu de clarté scénaristique, il se repose trop sur des facilités, peut être difficilement original.", panelHuit, c1, panel);
		TheBouton b24 = new TheBouton(0,"Apparition de nouveaux événements sans éléments logiques, peut s'avérer original.", panelHuit, c1, panel);
		
		JLabel presEnjeux = new JLabel("Renouvellement continu des enjeux principaux & Changement des règles de l'univers", SwingConstants.CENTER);
		panelNeuf.add(presEnjeux);
		TheBouton b25 = new TheBouton(5,"Renouvellement complet des enjeux principaux, change constamment de direction.", panelNeuf, c1, panel);
		TheBouton b26 = new TheBouton(3,"Évolution incomplète des règles du récit et mal gérée, malgré les efforts, l'histoire est prise dans un cycle.", panelNeuf, c1, panel);
		TheBouton b27 = new TheBouton(2,"Les règles fixées ne sont pas respectées, d'autres semblants de règles apparaissent mais au fil du temps, ils sont omis par l'auteur.", panelNeuf, c1, panel);
		TheBouton b28 = new TheBouton(0,"Renouvellement partiel, incomplet, inexpliqué, dénué de logique.", panelNeuf, c1, panel);
		
		
		JLabel categorie4 = new JLabel("OST", SwingConstants.CENTER);
		JLabel presIdentite = new JLabel("Identité particulière et originalité", SwingConstants.CENTER);
		panelDix.add(categorie4);
		panelDix.add(presIdentite);
		TheBouton b29 = new TheBouton(3,"Identité forte des musiques de l'anime, elles sont facilement reconnaissables à la simple écoute.", panelDix, c1, panel);
		TheBouton b30 = new TheBouton(2,"Utilisation partielle d'instruments originaux qui créent une musique originale et propre à l'anime.", panelDix, c1, panel);
		TheBouton b31 = new TheBouton(0,"Les musiques ne sont pas reconnaissables, les instruments utilisés sont dans les classiques.", panelDix, c1, panel);
		TheBouton b32 = new TheBouton(0,"Présence d'instruments non originaux, qui paraissent inexistants, qui ne se retiennent pas.", panelDix, c1, panel);
		
		JLabel presLien = new JLabel("Lien avec l'action", SwingConstants.CENTER);
		panelOnze.add(presLien);
		TheBouton b33 = new TheBouton(4,"Très bonne maîtrise des éléments musicaux, utilisés à des moments précis de l'histoire, certains sont même créés à un événement.", panelOnze, c1, panel);
		TheBouton b34 = new TheBouton(3,"Les musiques sont souvent en accord avec l'action décrite mais la pauvreté des possibilités rendent l'expérience audio linéaire.", panelOnze, c1, panel);
		TheBouton b35 = new TheBouton(2,"Les musiques n'ont pas d'utilité précise, mais s'accordent bien avec l'ambiance générale de l'histoire.", panelOnze, c1, panel);
		TheBouton b36 = new TheBouton(0,"Utilisation de musique à des moments aléatoires, qui ne correspondent en aucun cas avec l'action décrite.", panelOnze, c1, panel);
		
		
		
		Note n1 = new Note();

	}
	
	public void startShow () {
		c1.show(panel,"1");
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		
		if(src.equals(commencer)) {
			c1.show(panel,"2");
		}
		else if (src.equals(validerNom)) {
			
			if (nomHistoire.getText().equals("")) {
				attention.setText("Veuillez remplir le nom de l'oeuvre !");
				attention.setForeground(Color.red);
			}
			else {
				c1.show(panel,"3");
		
			}
		}
		else if (src.equals(bareme)){
			c1.show(panel,"13");
			// Réalisation du barème puis save

		}
		
		else if (src.equals(baremeUtiliser)) {
			int retour = choisirFichier.showOpenDialog(null);
			
			choisirFichier.setMultiSelectionEnabled(false);
			choisirFichier.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter leFiltre = new FileNameExtensionFilter("Fichier de type barème", "txt");
			choisirFichier.addChoosableFileFilter(leFiltre);
			panelQuatorze.add(choisirFichier);
			c1.show(panel,"14");
            if (retour == JFileChooser.APPROVE_OPTION) {
				File selectedFile = choisirFichier.getSelectedFile();
				// Création du barème enregistrer
			}
		}
		            
	}
	
	public void afficheNoteMenu() {
		Note n1 = new Note();
		n1.afficheNote(panelDouze, panel, "12", c1, nomHistoire.getText());

	}
}

class TheBouton implements ActionListener {
	int noteBouton = 0;
	String nomBouton = "Bouton";
	CardLayout c1;
	JPanel global;
	JPanel page;
	
	public TheBouton (int note, String nom, JPanel pageActuel, CardLayout cardLayout, JPanel panelGlobal) {
		JButton bouton = new JButton(nom);
		bouton.addActionListener(this);
		pageActuel.add(bouton);
		c1 = cardLayout;
		global = panelGlobal;
		page = pageActuel;
		noteBouton = note;
		nomBouton = nom;
	}
	
	public void actionPerformed(ActionEvent e) {
		Note n1 = new Note();
		Menu m1 = new Menu();
		
		if (n1.nbNote < 8 ) {
			
			n1.ajoutNote(noteBouton);
			n1.getNote();
			c1.show(global,Integer.toString(n1.nbNote+3));
		
		}
		else {

			m1.afficheNoteMenu();
			
		}
	}
}

class Note {
	
	static int noteTotal = 0;
	static int nbNote = 0;
	
	public Note() {
	}
	
	public void afficheNote(JPanel pageActuel, JPanel panelGlobal, String page, CardLayout cardLayout, String nomAnime) {
		JLabel presNoteOeuvre = new JLabel(("Votre note pour l'oeuvre " + nomAnime), SwingConstants.CENTER);
		presNoteOeuvre.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
		JLabel note = new JLabel(Integer.toString(moyenneNote()) + "/20", SwingConstants.CENTER);
		note.setForeground(Color.RED);
		note.setFont(new Font("Helvetica Neue", Font.PLAIN, 32));
		pageActuel.add(presNoteOeuvre);
		pageActuel.add(note);
		cardLayout.show(panelGlobal,page);
	}
	
	public int getNote() {
		System.out.println(noteTotal);
		return noteTotal;
	}
	
	public void setNote(int note) {
		noteTotal = note;
	}
	
	public void ajoutNote (int note) {
		nbNote = nbNote + 1;
		noteTotal = note + noteTotal;
	}
	
	public int moyenneNote() {
		int moyenne = noteTotal/2;
		return moyenne;
	}
}
