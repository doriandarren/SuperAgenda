package main;

import util.Input;

public class UserInterface {
	
	public static String formatterInput(String pal) {
		String str = pal + ";";
		return str;
	}
	
	public static void clearScreen(){		
		for(int i=0; i<50;i++){
			System.out.println();
		}
	}	
	
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
	public static Person inputEditRegister(Person person) {
		System.out.println("Editar Registro");
		String newName = "";
		String newPhone = "";
		String newEmail = "";
		String newAddress = "";		
		
		String retornStr = Input.scanLineSecure("Escriba Nombre y Apellido: ",1,true);		
		if(retornStr.isEmpty() || person.getFullName().equals(retornStr)){
			newName = person.getName() +" "+ person.getSurname();  
		}else{
			newName = retornStr; 
		}
				
		retornStr = Input.scanLineSecure("Teléfono: ", 5,true);
		if(retornStr.isEmpty() || person.getPhone().equals(retornStr)){
			newPhone = person.getPhone();
		}else{
			newPhone = retornStr;
		}		
		
		retornStr = Input.scanLineSecure("Email: ", 3,true);
		if(retornStr.isEmpty() || person.getEmail().equals(retornStr)){
			newEmail = person.getEmail();
		}else{
			newEmail = retornStr;
		}
				
		retornStr = Input.scanLineSecure("Dirección: ", 2,true);
		if(retornStr.isEmpty() || person.getAddress().equals(retornStr)){
			newAddress = person.getAddress();
		}else{
			newAddress = retornStr;
		}
		
		//Se crea un registro nuevo y se retorna
		Person newPerson = new Person(); 
		
		//Formatear el nombre y el apellido
		String fullName[] = newName.split(" "); 
		String nombre = fullName.length==2 ? fullName[0] : newName;
		String apellido  = fullName.length==2 ? fullName [1] : "";
		
		//Cargan / Seteo el nuevo objeto
		newPerson.setName(nombre);
		newPerson.setSurname(apellido);
		newPerson.setPhone(newPhone);
		newPerson.setEmail(newEmail);
		newPerson.setAddress(newAddress);
		return newPerson;
	}
	
	//Eliminar
	public static boolean hasCorfirmDelete(){		
		String opcSeguro;
		do{
			opcSeguro = Input.scanLineSecure("Seguro de eliminar? [s/n]: ", 1, false);
			if(opcSeguro.equals("n")){
				return false;
			}
		}while(!opcSeguro.equals("s"));
		
		if(opcSeguro.equals("s")){
			return true;
		}		
		return false;
	}
	
	
	
	//Imprimir lista de registros
	public static void printListContacts(Person[] person) {		
		if(!person.equals(null)){
			//Controlar cuando no exista el Objeto Person
			System.out.println("Listar Todos");
			System.out.println("#\t NOMBRE \t APELLIDO \t\t TELEFONO \t\t EMAIL \t\t DIRECCIÓN");
			for (int i = 0; i < person.length; i++) {
				System.out.println("[" + (i + 1) + "]" + "\t" + person[i].getName() + "\t" + person[i].getSurname() + "\t"
						+ person[i].getPhone() + "\t" + person[i].getEmail() + "\t" + person[i].getAddress());
			}
		}
	}
	
	//Imprimir un solo registro
	public static void printContact(Person person){
		System.out.println("Contaco Detalle: ");
		System.out.println("#\t NOMBRE \t APELLIDO \t\t TELEFONO \t\t EMAIL \t\t DIRECCIÓN");
		System.out.println("\t" + person.getName()+ 
				"\t" + person.getSurname() + "\t\t" + person.getPhone()+ 
				"\t\t" + person.getEmail()+ "\t" + person.getAddress());
	}
	
		
	
}
