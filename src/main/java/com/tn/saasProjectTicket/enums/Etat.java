package com.tn.saasProjectTicket.enums;

public enum Etat {
	PENDING,
	REJECTED_CLIENT,
	REJECTED_MANAGER,
	ACCEPTED_CLIENT,
	ACCEPTED_MANAGER,
	AFFECTED,
	TO_DO,
	IN_PROGRESS,
	SUSPENDED,
	DONE,
	DELIVERED	
}
/*
 *client create ticket INITIE (posibilite REJECTED)
 *manager AcceptedManager (estimation cout)
 		**manager RejectedManager(add comment no obl) Proces terminé
 *client AcceptedClient
 		**client RejectedClient(add comment)Proces terminé
 *manager affectation ticket to ressource Afected
 *ressource TO_DO,IN_PROGRESS,SUSPENDED,DONE
 * manager DELIVRED
 * 
 * 
 * */
 

/*
 * TICKET REJECTEDCLIENT (si etat initie ou si etat AcceptedManager)
 * TICKET REJECTEDMANAGER (si etat INITIE)
 * 
 * CLIENT lors de creation de ticket les etat possible sont (INITIE)
 * Mananger si l'etat de ticket INITIE les etats possible (ACCEPTEDMANAGER, REJECTEDMANAGER)
 * CLIENT si l'etat ACCEPTEDMANAGER les etats possible (ACCEPTEDCLIENT, REJECTEDCLIENT)
 * CLIENT si l'etat REJECTEDMANAGER les etats possible (--)
 * 
 * Apres l'acceptation de ticket de la part de client et manager la modification de detail cette ticket sera impossible
 * 
 * Mananger si l'etat de ticket ACCEPTEDCLIENT les etats possible (AFFECTED)
 * Mananger si l'etat de ticket REJECTEDCLIENT les etats possible (--)
 * ressource la ticket sera affichier au ressource si etat (AFFECTED) les etats possible (TO_DO,IN_PROGRESS,SUSPENDED,DONE)
 * Mananger si l'etat de ticket DONE les etats possible (DELIVRED)
 * 
 * */
 