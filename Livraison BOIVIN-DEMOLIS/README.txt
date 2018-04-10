
Comment lancer l'application Java GestionFormations

Pré-requis:
	    - Installer le JDK 8 (ou superieur) sur la machine cible, 

		    (Téléchargé depuis: http://www.oracle.com/technetwork/java/javase/downloads/index.html).

	    - Machine cible dote d'un systeme d'exploitation Windows.

Execution :
	    - Copier le fichier .jar (ou le dossier contenant le .jar) en local sur la machine,
	    - Copier le path du répertoire parent contenant le fichier .jar,
            - Ouvrir un invite de commande,
	    - Taper "cd <path>" puis pressez entrée (avec <path> le path copié precedemment),
	      
			Ex: "cd C:\formationJava\livraison".

	    - Taper "java -jar ProxyBanque.jar" et presser entrée. 
	    - Lors de l'utilisation du programme, il est impératif de respecter le type de réponse demander par le programme (Il ne faut pas taper au clavier une lettre quand un chiffre est demandé)

Consulter la documentation: 
	- Les diagrammes UML se trouvent dans le dossier "Diagrammes UML"
	- Pour consulter le diagramme de classe : 
	- se rendre à l'adresse https://www.draw.io/
		à l'aide d'un navigateur internet et glisser le fichier dedans
	- spécifier le dossier contenant le diagramme à ouvrir
	- Pour consulter les autres diagrammes :
	- Installer un logiciel permettant d'ouvrir les fichiers .edg (UML Pacestar par exemple, pouvant être téléchargé depuis https://pacestar-uml-diagrammer.fr.softonic.com/).
	- Pour consulter la javadoc, il suffit de double-cliquer sur le fichier index.html se trouvant dans le repertoire "doc" livré avec le fichier jar.
	- Pour les tests, il se trouve dans le package tests du projet et test les méthodes débiter et créditer de la classe ServiceCompte.java
