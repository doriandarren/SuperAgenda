package test;

import org.junit.Assert;
import org.junit.Test;

import main.ListPerson;
import main.Person;

public class TestListPerson {

	@Test	
	public void testContructorList(){
		
	
		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol; 003412415700; pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1}; 
		
	    ListPerson list = new ListPerson(strContacts ); 
	     
		 Assert.assertEquals(strContacts.length,list.size());
		 Person person = list.get(0);  
		 Assert.assertEquals("Pedro", person.getName()); 
		 Assert.assertEquals("Picapiedra", person.getSurname());
		 Assert.assertEquals("003412415789", person.getPhone()); 
		 Assert.assertEquals("pedro@pica.com", person.getEmail()); 
		 Assert.assertEquals("Marmol 45", person.getAddress()); 
		
	}
	
	
	@Test	
	public void testAddList(){
		
		String strContactAdd= "Pablo Marmol; 0034123456789; pedro@pica.com;Marmol 47";
		
		String[] strNewList= new String[] 
				{"Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"};
		
		ListPerson list = new ListPerson(strNewList);	
		Person newPerson = new Person(strContactAdd);
		list.add(newPerson);
		Assert.assertEquals(2, list.size());
		Assert.assertEquals("Pablo", list.get(1).getName());
		Assert.assertEquals("Marmol", list.get(1).getSurname());
		
	}
	
	
	@Test	
	public void testRemoveList(){		

		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol;003412415700;pablo@pica.com;Marmol 46";
		String strContact2= "Betty Zapata;003555555500;bettyzapata@pica.com;Gran via  les cort 1025";
		String[] strContacts= 
				new String[]{strContact0,strContact1,strContact2}; 
		
		//se instancia el objeto
		ListPerson list = new ListPerson(strContacts);				
		Assert.assertEquals(3, list.size());
				
		list.remove(1);
		
		Assert.assertEquals(2, list.size());
		
		//Assert.assertEquals("Pablo", list.get(0).getName());
		//Assert.assertEquals("Marmol", list.get(0).getSurname());
		
		Assert.assertEquals("Pedro", list.get(0).getName());
		Assert.assertEquals("Picapiedra", list.get(0).getSurname());
		
		Assert.assertEquals("Betty", list.get(1).getName());
		Assert.assertEquals("Zapata", list.get(1).getSurname());
	}
	
		
	@Test
	public void testSort(){		
		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol;003412415700;pablo@pica.com;Marmol 46";
		String strContact2= "Betty Zapata;003555555500;bettyzapata@pica.com;Gran via  les cort 1025";
		String strContact3= "Ana Gutierrez;0037528966630;ana@gmail.com;Horta 205";
		
		String[] strContacts = new String[]{strContact0,strContact1,strContact2, strContact3};
		
		ListPerson list = new ListPerson(strContacts);
		
		Person[] persons = list.sort();		
		
		Assert.assertEquals("Ana", persons[0].getName());
		Assert.assertEquals("Gutierrez", persons[0].getSurname());	
	}
	
		
	@Test
	public void testFindByName(){
		
		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol;003412415700;pablo@pica.com;Marmol 46";
		String strContact2= "Betty Zapata;003555555500;bettyzapata@pica.com;Gran via  les cort 1025";
		
		String[] strContacts = new String[]{strContact0,strContact1,strContact2};
		
		
		ListPerson list = new ListPerson(strContacts);
		
	}
	
	
}
