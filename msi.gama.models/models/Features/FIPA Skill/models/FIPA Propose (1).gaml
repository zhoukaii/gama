/**
 * This model demontrates a usecase of the FIPA Propose interaction protocol.
 * (Please see http://www.fipa.org/specs/fipa00036/SC00036H.html for the detail description of this protocol).
 * 
 * 
 * The Initiator agent begins the conversation/interaction protocol by sending a 'propose'
 * message to the Participant agent with 'Go swimming?' as content.
 * 
 * On receiving the 'propose' message, the participant agent replies with an 'accept_proposal' message
 * indicating that it agrees to go swimming.
 * 
 * After the Initiator agent reads the 'accept_proposal' message, the conversation ends.
 */
model fipa_propose_1

global {
	Participant p;
	
	init {
		create Initiator;
		create Participant returns: ps;
		
		set p <- ps at 0;
		
		write 'Step the simulation to observe the outcome in the console';
	}
}

species Initiator skills: [communicating] {
	reflex send_propose_message when: (time = 1) {
		write name + ' sends a propose message';
		do start_conversation with: [ receivers :: [p], protocol :: 'fipa-propose', performative :: 'propose', content :: ['Go swimming?'] ];
	}
	
	reflex read_accept_proposals when: !(empty(accept_proposals)) {
		write name + ' receives accept_proposal messages';
		loop i over: accept_proposals {
			write 'accept_proposal message with content: ' + (string(i.content));
		}
	}
	
}

species Participant skills: [communicating] {
	reflex accept_proposal when: !(empty(proposes)) {
		let proposalFromInitiator type: message <- proposes at 0;
		
		do accept_proposal with: [ message :: proposalFromInitiator, content :: ['OK! It \'s hot today!'] ];
	}
}

experiment test_propose_interaction_protocol type: gui {}