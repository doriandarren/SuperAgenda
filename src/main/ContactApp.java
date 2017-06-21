package main;

import util.FileHelper;
import util.Input;

public class ContactApp {

	private static final String PATH_DB = "file.txt";

	public static void main(String[] args) {
		
		String[] strContacts = FileHelper.readFile(PATH_DB);		
		ListPerson listContacts = new ListPerson(strContacts);		
		boolean exit=false;
		
		do{			
			
			String opc = UserInterface.menuScreem();
			
			switch (opc) {
			case "1":
				UserInterface.clearScreen();
				String strInput = UserInterface.inputNewRegister(); 
				Person contact = new Person(strInput);
				listContacts.add(contact);				
				FileHelper.writeFile(listContacts.toFileFormat(), PATH_DB);				
				break;
			case "2":
				UserInterface.clearScreen();
				UserInterface.printListContacts(listContacts.getPersons());
				break;
			case "3":
				UserInterface.clearScreen();
				UserInterface.printListContacts(listContacts.sort());
				break;
			case "4":
				UserInterface.clearScreen();
				String strInputName = Input.scanLineSecure("Escriba el nombre: ", 1, false);	
				UserInterface.printListContacts(listContacts.findByName(strInputName));
				break;
			case "5":
				UserInterface.clearScreen();
				String strInputEmail = Input.scanLineSecure("Escriba el email: ", 3, false);	
				UserInterface.printListContacts(listContacts.findByEmail(strInputEmail));
				break;	
				
			case "6":
				UserInterface.clearScreen();
				UserInterface.printListContacts(listContacts.getPersons());
				String opcEdit = Input.scanLineSecure("Número a Editar: ", 4, false);
				int index = Integer.valueOf(opcEdit);
				UserInterface.printContact(listContacts.getPersons(), index);
				String strEdit = UserInterface.inputEditRegister(listContacts.getPersons(), index);
				//guardar registro
				
				
				break;
				
			case "9":
				UserInterface.clearScreen();
				exit=true;
				break;	
			default:
				opc="1";
				System.out.print("Por favor ingrese una opción válida!");
				break;
			}			
			
		}while(exit!=true);

	}

}
