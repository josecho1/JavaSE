/*DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2013 José Luis Villaverde Balsa.

This file is part of PatternsMeu.

    PatternsMeu is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    PatternsMeu is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
*/
package dao.example2.execute;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.example2.structure.Person;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "daojpa";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // Read the existing entries and write to console
	    Query q = em.createQuery("select p from Person p");
	    List<Person> personList = q.getResultList();
	    for (Person person : personList) {
	      System.out.println(person);
	    }
	    System.out.println("Size: " + personList.size());
	
	    // Create new person
	    em.getTransaction().begin();
	    Person person = new Person();
	    person.setName("pepe");
	    em.persist(person);
	    em.getTransaction().commit();
	
	    em.close();
	}
}


