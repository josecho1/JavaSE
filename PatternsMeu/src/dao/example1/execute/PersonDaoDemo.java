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
package dao.example1.execute;

import dao.example1.structure.Person;
import dao.example1.structure.PersonDao;
import dao.example1.structure.PersonDaoImpl;

public class PersonDaoDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PersonDao personDao = new PersonDaoImpl();

	      //print all persons
	      for (Person person : personDao.getAllPersons()) {
	         System.out.println("Person: [Id : "
	            +person.getId()+", Name : "+person.getName()+" ]");
	      }


	      //update person
	      Person person =personDao.getAllPersons().get(0);
	      person.setName("Rosa");
	      personDao.updatePerson(person);

	      //get the person
	      personDao.getPerson(0);
	      System.out.println("Person: [Id : "
	         +person.getId()+", Name : "+person.getName()+" ]");		
	   }

	}


