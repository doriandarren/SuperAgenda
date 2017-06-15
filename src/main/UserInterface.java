package main;

import util.Input;

public class UserInterface {
	
	
	
	public static String menuScreem(){
		final String menuDescripcion[] = {"[1] Agregar", "[2] Listar Todos", "[3] Ordenar Nombre", "[4] Buscar nombre",
				"[5] Buscar Email","[6] Editar", "[7] Eliminar","(9) Exit"};		
		
		System.out.println("\n///////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\n\t\t\t\t ***  Men� de Selecci�n  ***");
		for(int i=0; i<menuDescripcion.length;i++){
			System.out.print(menuDescripcion[i]+"  ");
		}
		System.out.println("\n\n///////////////////////////////////////////////////////////////////////////////////////////////////////");
		String opc = Input.scanLineSecure("Escriba su opci�n: ", 4);		
		return opc;
	}
	
	
	public static String inputNewRegister() {			
		System.out.println("Formulario de Registro ");
		String newStr = formatterInput(Input.scanLineSecure("Escriba Nombre y Apellido: ",1));
		newStr += formatterInput(Input.scanLineSecure("Tel�fono: ", 5));
		newStr += formatterInput(Input.scanLineSecure("Email: ", 3));
		newStr += Input.scanLineSecure("Direcci�n: ", 2);
		return newStr;
	}
	
	
	public static void printListContacts(Person[] person) {
		System.out.println("Listar Todos");
		System.out.println("#\t NOMBRE \t APELLIDO \t\t TEL�FONO \t\t EMAIL \t\t DIRECCI�N");
		for(int i=0; i<person.length;i++){
			System.out.println("["+ (i+1) +"]" + "\t" + person[i].getName()+ 
					"\t" + person[i].getSurname() + "\t\t" + person[i].getPhone()+ 
					"\t" + person[i].getEmail()+ "\t" + person[i].getAddress());
		}
		
	}	
	
	
	
	
	
		
	


	public static String formatterInput(String pal) {
		String str = pal + ";";
		return str;
	}
	
	public static void clearScreen(){		
		for(int i=0; i<50;i++){
			System.out.println();
		}
	}	
}
