package main;

import util.Input;

public class UserInterface {
	
	public static String menuScreem(){
		final String menuDescripcion[] = {"[1] Agregar", "[2] Listar Todos", "[3] Ordenar Nombre", "[4] Buscar nombre",
				"[5] Buscar Email","[6] Editar", "[7] Eliminar","(9) Exit"};		
		
		System.out.println("\n****************************************************");
		System.out.println("\n\t\t\t\t ***  Menú de Selección  ***");
		for(int i=0; i<menuDescripcion.length;i++){
			System.out.print(menuDescripcion[i]+"  ");
		}
		System.out.println("\n\n****************************************************");
		String opc = Input.scanLineSecure("Escriba su opción: ", 4,false);		
		return opc;
	}
	
	//Añadir nuevo registro
	public static String inputNewRegister() {			
		System.out.println("Formulario de Registro ");
		String newStr = formatterInput(Input.scanLineSecure("Escriba Nombre y Apellido: ",1,false));
		newStr += formatterInput(Input.scanLineSecure("Teléfono: ", 5,false));
		newStr += formatterInput(Input.scanLineSecure("Email: ", 3,false));
		newStr += Input.scanLineSecure("Dirección: ", 2,false);
		return newStr;
	}
	
	//Editar
	public static String inputEditRegister(Person[] person, int index) {
		System.out.println("Editar Registro");
		String newStr = "";
		
		String retornStr = Input.scanLineSecure("Escriba Nombre y Apellido: ",1,true);
		if(retornStr.isEmpty() || person[index].getFullName().equals(retornStr)){
			newStr += formatterInput(retornStr);
		}else{
			newStr += retornStr.toString();
		}
		
		
		retornStr = Input.scanLineSecure("Teléfono: ", 5,true);
		if(retornStr.isEmpty() || person[index].getPhone().equals(retornStr)){
			newStr += formatterInput(retornStr);
		}else{
			newStr += retornStr.toString();
		}		
		
		retornStr += Input.scanLineSecure("Email: ", 3,true);
		if(retornStr.isEmpty() || person[index].getEmail().equals(retornStr)){
			newStr += formatterInput(retornStr);
		}else{
			newStr += retornStr.toString();
		}
		
		
		retornStr += Input.scanLineSecure("Dirección: ", 2,true);
		if(retornStr.isEmpty() || person[index].getAddress().equals(retornStr)){
			newStr += retornStr;
		}else{
			newStr += retornStr.toString();
		}
		
		return newStr;
	}
	
	//Imprimir lista de registros
	public static void printListContacts(Person[] person) {
		//Controlar cuando no exista el Objeto Person
		System.out.println("Listar Todos");
		System.out.println("#\t NOMBRE \t APELLIDO \t\t TELEFONO \t\t EMAIL \t\t DIRECCIÓN");
		for (int i = 0; i < person.length; i++) {
			System.out.println("[" + (i + 1) + "]" + "\t" + person[i].getName() + "\t" + person[i].getSurname() + "\t"
					+ person[i].getPhone() + "\t" + person[i].getEmail() + "\t" + person[i].getAddress());
		}

	}
	
	//Imprimir un solo registro
	public static void printContact(Person[] person, int index){
		int i=index-1;
		System.out.println("Contaco Detalle: ");
		System.out.println("#\t NOMBRE \t APELLIDO \t\t TELEFONO \t\t EMAIL \t\t DIRECCIÓN");
		System.out.println("["+ (i+1) +"]" + "\t" + person[i].getName()+ 
				"\t" + person[i].getSurname() + "\t\t" + person[i].getPhone()+ 
				"\t\t" + person[i].getEmail()+ "\t" + person[i].getAddress());
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
