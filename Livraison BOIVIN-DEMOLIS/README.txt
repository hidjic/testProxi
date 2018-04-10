
Comment lancer l'application Java GestionFormations

Pr�-requis:
	    - Installer le JDK 8 (ou superieur) sur la machine cible, 

		    (T�l�charg� depuis: http://www.oracle.com/technetwork/java/javase/downloads/index.html).

	    - Machine cible dote d'un systeme d'exploitation Windows.

Execution :
	    - Copier le fichier .jar (ou le dossier contenant le .jar) en local sur la machine,
	    - Copier le path du r�pertoire parent contenant le fichier .jar,
            - Ouvrir un invite de commande,
	    - Taper "cd <path>" puis pressez entr�e (avec <path> le path copi� precedemment),
	      
			Ex: "cd C:\formationJava\livraison".

	    - Taper "java -jar ProxyBanque.jar" et presser entr�e. 
	    - Lors de l'utilisation du programme, il est imp�ratif de respecter le type de r�ponse demander par le programme (Il ne faut pas taper au clavier une lettre quand un chiffre est demand�)

Consulter la documentation: 
	- Les diagrammes UML se trouvent dans le dossier "Diagrammes UML"
	- Pour consulter le diagramme de classe : 
	- se rendre � l'adresse https://www.draw.io/
		� l'aide d'un navigateur internet et glisser le fichier dedans
	- sp�cifier le dossier contenant le diagramme � ouvrir
	- Pour consulter les autres diagrammes :
	- Installer un logiciel permettant d'ouvrir les fichiers .edg (UML Pacestar par exemple, pouvant �tre t�l�charg� depuis https://pacestar-uml-diagrammer.fr.softonic.com/).
	- Pour consulter la javadoc, il suffit de double-cliquer sur le fichier index.html se trouvant dans le repertoire "doc" livr� avec le fichier jar.
	- Pour les tests, il se trouve dans le package tests du projet et test les m�thodes d�biter et cr�diter de la classe ServiceCompte.java
