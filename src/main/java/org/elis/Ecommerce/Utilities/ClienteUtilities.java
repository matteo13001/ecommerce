package org.elis.Ecommerce.Utilities;

import org.elis.Ecommerce.Exceptions.DatiNonValidiException;

public class ClienteUtilities {
		  /*
		    ^                 # start-of-string
		 ^(?=.*[0-9])$       # a digit must occur at least once
		 ^(?=.*[a-z])$       # a lower case letter must occur at least once
		 ^(?=.*[A-Z])$       # an upper case letter must occur at least once
		 ^(?=.*[@#$%^&+=])$  # a special character must occur at least once
		 ^(?=\S+$)$          # no whitespace allowed in the entire string
		 ^.{8,}$             # anything, at least eight places though
		 $ 
		   */

		  public static boolean controllaPassword(String stringaDaEsaminare,Object o) {
		   switch(0) {
		   case 0:
		    if (almenoUnNumero(stringaDaEsaminare)) {
		     //throw new UtilitiesException("Manca un numero");
		    	 throw new DatiNonValidiException( o,"Manca un numero") ;
		    }
		   case 1:
		    if (almenoUnCarattereMinuscolo(stringaDaEsaminare)) {
		     //throw new UtilitiesException("Manca un carattere minuscolo");
		    	throw new DatiNonValidiException( o,"Manca un carattere minuscolo") ;
		    }
		   case 2:
		    if (almenoUnCarattereMaiuscolo(stringaDaEsaminare)) {
		     //throw new UtilitiesException("Manca un carattere maiuscolo");
		    	throw new DatiNonValidiException( o,"Manca un carattere maiuscolo");
		    }
		   case 3:
		    if (almenoUnCarattereSpeciale(stringaDaEsaminare)) {
		     //throw new UtilitiesException("Manca un carattere speciale");
		    	throw new DatiNonValidiException( o,"Manca un carattere speciale");
		    }
		   case 4:
		    if (spaziVuotiNonPresenti(stringaDaEsaminare)) {
		     //throw new UtilitiesException("Sono presenti spazi vuoti");
		    	throw new DatiNonValidiException( o,"Sono presenti spazi vuoti");
		    }
		   case 5: 
		    if (!lungoAlmenoOtto(stringaDaEsaminare)) {
		     //throw new UtilitiesException("Non rispetta la lunghezza minima di 8");
		    	throw new DatiNonValidiException( o,"Non rispetta la lunghezza minima di 8");
		    }
		   default:
		    return true;
		   }
		  }

		  public static boolean controllaNomeECognome(String nome, String cognome,Object o) {
		   if (nome.matches("^[a-zA-Z]+(?:[\\s.]+[a-zA-Z]+)*$") && cognome.matches("^[a-zA-Z]+(?:[\\s.]+[a-zA-Z]+)*$")) {
		    return true;
		   }
		    //throw new UtilitiesException("Nome o Cognome non valido");
			  throw new DatiNonValidiException( o,"Nome o Cognome non valido");
			  }
		  //^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$
		  
		  public static boolean controlloUsername(String username,Object o) {
		   if(username.matches("^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$")) {
		    return true;
		   }else{
		    //throw new UtilitiesException("L'username non puo contenere spazi");
			   throw new DatiNonValidiException( o,"L'username non puo contenere spazi");
		   }
		  }
		  
		  public static boolean almenoUnNumero(String stringaDaEsaminare) {
		   return stringaDaEsaminare.matches("^(?=.*[0-9])$");
		  }

		  public static boolean almenoUnCarattereMinuscolo(String stringaDaEsaminare) {
		   return stringaDaEsaminare.matches("^(?=.*[a-z])$");
		  }

		  public static boolean almenoUnCarattereMaiuscolo(String stringaDaEsaminare) {
		   return stringaDaEsaminare.matches("^(?=.*[A-Z])$");
		  }

		  public static boolean almenoUnCarattereSpeciale(String stringaDaEsaminare) {
		   return stringaDaEsaminare.matches("^(?=.*[@!\"£/()#$%',._§°^&+=])$");
		  }

		  public static boolean spaziVuotiNonPresenti(String stringaDaEsaminare) {
		   return stringaDaEsaminare.matches("[^-\s]");
		  }

		  public static boolean lungoAlmenoOtto(String stringaDaEsaminare) {
		   return stringaDaEsaminare.matches("^.{8,}$");
		  }
		  
		  public static boolean categoriaControllo(String stringaDaEsaminare) {
		   return stringaDaEsaminare.matches("^[a-zA-Z0-9\\-]+$\r\n");
		  }
}