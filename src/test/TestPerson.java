package test;

import org.junit.Assert;
import org.junit.Test;

import main.Person;

public class TestPerson {
	
	String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
	
	@Test	
	public void testContructorPerson(){		
		 Person person = new Person(strContact0); 
		 Assert.assertEquals("Pedro", person.getName()); 
		 Assert.assertEquals("Picapiedra", person.getSurname());
		 Assert.assertEquals("003412415789", person.getPhone()); 
		 Assert.assertEquals("pedro@pica.com", person.getEmail()); 
		 Assert.assertEquals("Marmol 45", person.getAddress());
	}
			
}
