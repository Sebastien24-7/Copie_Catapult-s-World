import java.awt.event.*;
import java.util.Iterator;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.html.parser.Element;

public class Panneau extends JPanel implements ActionListener, MouseMotionListener {

	private Terrain ter = new Terrain();
	private final double GRAVITY = 2.0 ;
	private static Projectile proj;
	private Cercle c1;
	private APoint p = new APoint (50,50);

<<<<<<< Upstream, based on branch 'master' of https://github.com/timwinner/catapult.git
	private static double limite_sol=0.2; // Pas cpmpris
	private double dist ; // Pas compris , quelle distance?
=======
	private static double limite_sol=0.310;
	private double dist ;
>>>>>>> 4123009 Try to correct Tim's bounce+ Redefinition of all the comments in English (need to add better computation of friction for the bounce depending on the objects, need to correct gravity so that everything always fall) I also modify the ground is set to 660 and did a function to get it because the limite_sol wasn't so fitting..
	private double angle = 30.0;
	private long temps;


	public Panneau(){

		proj = new Projectile(p,5.0, 5.0, 30.0 ,Color.black );
<<<<<<< Upstream, based on branch 'master' of https://github.com/timwinner/catapult.git
		proj.setPosition(300, 400);
		proj.setSpeed(10, 45);
=======
		proj.setPosition(100, 400);
		proj.setSpeed(10, 40);
>>>>>>> 4123009 Try to correct Tim's bounce+ Redefinition of all the comments in English (need to add better computation of friction for the bounce depending on the objects, need to correct gravity so that everything always fall) I also modify the ground is set to 660 and did a function to get it because the limite_sol wasn't so fitting..
		c1 = new Cercle(new APoint(600,600),15.0,Color.red);

		this.setLayout(null);
		addMouseMotionListener(this);
	}

	public static Projectile getProj() {
		return proj;
	}
	public static double getGround() {
		return 660;
	}

	public void paintComponent(Graphics g){

		Image fond = Toolkit.getDefaultToolkit().getImage("./images/image_fond_nuage.png");
					g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);
		//Image bottom = Toolkit.getDefaultToolkit().getImage("./images/terre2.png");
		//g.drawImage(bottom, 0, 750, this.getWidth(),this.getHeight(), this);

		g.setColor(Color.green);
		g.fillRect(0,(int)Panneau.getGround(),this.getWidth(),this.getHeight());

		/*===================== Objects Display*/

		proj.dessiner(g);
		c1.dessine(g);
		System.out.println((1-this.limite_sol)*this.getHeight() + "valeur du sol");

		for (int i = 0; i < Terrain.listEnnemies.size(); i++) {
			Ennemy perso1 = Terrain.listEnnemies.get(i); //local variable to avoid to much code
			g.drawImage(perso1.img, (int)perso1.x, (int)perso1.y,this); //affichage alien
			perso1.gravityAction(17);
			perso1.death();

		}
<<<<<<< Upstream, based on branch 'master' of https://github.com/timwinner/catapult.git

		//=================================
		//affichage des matériaux et leurs textures en parcourant la liste
=======
	
		//=============Material Blocks Display====================
>>>>>>> 4123009 Try to correct Tim's bounce+ Redefinition of all the comments in English (need to add better computation of friction for the bounce depending on the objects, need to correct gravity so that everything always fall) I also modify the ground is set to 660 and did a function to get it because the limite_sol wasn't so fitting..

		for (int i = 0; i < Terrain.listMateriaux.size(); i++) {

			g.drawImage(Terrain.listMateriaux.get(i).img, (int)Terrain.listMateriaux.get(i).x,(int)Terrain.listMateriaux.get(i).y, this);

			//=============gravity
			Terrain.listMateriaux.get(i).gravityAction(17);
			//System.out.println(Terrain.listMateriaux.get(i).y + " my position ");
			//System.out.println((double)(this.getHeight()*(1-limite_sol)));
			Terrain.listMateriaux.get(i).destruction();
			//System.out.println("My position en y" + Terrain.listMateriaux.get(i).y + "Mon centre x et y " + Terrain.listMateriaux.get(i).centreX +"||"+ Terrain.listMateriaux.get(i).centreY);

		}
<<<<<<< Upstream, based on branch 'master' of https://github.com/timwinner/catapult.git

		//============CALCUL COLLISION===========
		//this.collisionDetect(); // Replaced by bounce in the projectile class
=======
		
		//============ Collision Computation Call===========
		//this.collisionDetect();
>>>>>>> 4123009 Try to correct Tim's bounce+ Redefinition of all the comments in English (need to add better computation of friction for the bounce depending on the objects, need to correct gravity so that everything always fall) I also modify the ground is set to 660 and did a function to get it because the limite_sol wasn't so fitting..
		//===============
		Toolkit.getDefaultToolkit().sync();

		}



	//============CALCUL COLLISION=========== (juste changement de couleur pour l'instant et disparition case)
<<<<<<< Upstream, based on branch 'master' of https://github.com/timwinner/catapult.git
	public void collisionDetect() { // Bouncer from Seb, Disabled by Tim (no offence xD)
=======
	 // Bouncer from Seb, Disabled by Tim (no offence xD)
	public void collisionDetect() {
>>>>>>> 4123009 Try to correct Tim's bounce+ Redefinition of all the comments in English (need to add better computation of friction for the bounce depending on the objects, need to correct gravity so that everything always fall) I also modify the ground is set to 660 and did a function to get it because the limite_sol wasn't so fitting..

		dist = proj.getDistance(c1.centre.x, c1.centre.y);
		//System.out.println(dist + " la distance entre les 2 cercles ");

		//juste pour checker et s'amuser avec le drag
		if(dist <= c1.rayon + proj.getRayon()) {
			proj.couleur = c1.maCouleur ;
		}

		//========Limite de la fenêtre
		if(proj.x - proj.getRayon() <= 0 || proj.x + proj.getRayon() >= this.getWidth() ) {
			proj.dx = - proj.dx ;
		}
		if(proj.y - proj.getRayon() <= 0 || proj.y + proj.getRayon() >= (this.getHeight()-Panneau.limite_sol*this.getHeight()) ) {
			proj.dy = - proj.dy ;
		}

	}

	public void actionPerformed(ActionEvent e){

	}

	//To drag the red cercle
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		c1 = new Cercle(new APoint(e.getX(),e.getY()),15,Color.red);

	}

	//Detect collision between the mouse and the projectile
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(proj.getDistance(e.getX(), e.getY()) <= 15.0) {
			System.out.println("The mouse has collided");
			proj.couleur = new Color(50, 50, 50);
		}

	}


	}
