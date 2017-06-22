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
				//Añadir
				UserInterface.clearScreen();
				String strInput = UserInterface.inputNewRegister(); 
				Person contact = new Person(strInput);
				listContacts.add(contact);				
				FileHelper.writeFile(listContacts.toFileFormat(), PATH_DB);				
				break;
			case "2":
				//Listar Todos
				UserInterface.clearScreen();
				UserInterface.printListContacts(listContacts.getPersons());
				break;
			case "3":
				//Ordenar Nombre
				UserInterface.clearScreen();
				UserInterface.printListContacts(listContacts.sort());
				break;
			case "4":
				//Buscar Nombre
				UserInterface.clearScreen();
				String strInputName = Input.scanLineSecure("Escriba el nombre: ", 1, false);
				UserInterface.printListContacts(listContacts.findByName(strInputName));
				break;
			case "5":
				//Buscar Email
				UserInterface.clearScreen();
				String strInputEmail = Input.scanLineSecure("Escriba el email: ", 3, false);	
				UserInterface.printListContacts(listContacts.findByEmail(strInputEmail));
				break;	
				
			case "6":
				//Editar
				UserInterface.clearScreen();
				//Listo los contactos
				UserInterface.printListContacts(listContacts.getPersons());
				String opcEdit = Input.scanLineSecure("Número a Editar: ", 4, false);
				//Formateo el index
				int index = Integer.valueOf(opcEdit);
				index = index - 1;
				//Imprime solo el contacto
				Person contacEdit = listContacts.get(index);				
				UserInterface.printContact(contacEdit);
				//Edita el contacto
				Person editedContact = UserInterface.inputEditRegister(contacEdit);				
				listContacts.set(editedContact, index);		
				//Sincroniza con el archivo txt	
				FileHelper.writeFile(listContacts.toFileFormat(), PATH_DB);	
				break;
				
			case "7":
				//Eliminar
				UserInterface.clearScreen();
				//Listo los contactos
				UserInterface.printListContacts(listContacts.getPersons());
				String opcDelete = Input.scanLineSecure("Número a Eliminar: ", 4, false);
				//Formateo el index
				int indexDelete = Integer.valueOf(opcDelete);
				indexDelete = indexDelete - 1;
				//Imprime solo el contacto
				Person contacDelete = listContacts.get(indexDelete);				
				UserInterface.printContact(contacDelete);
				//Confirma eliminacion
				boolean confirm = UserInterface.hasCorfirmDelete();				
				if(confirm){
					//Elimina el contacto
					listContacts.remove(indexDelete);
				}
				//Sincroniza con el archivo txt			
				FileHelper.writeFile(listContacts.toFileFormat(), PATH_DB);
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
