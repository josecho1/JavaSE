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
package dao.example1.structure;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
	
	List<Person> persons;
	
	public PersonDaoImpl(){
		persons = new ArrayList<Person>();
		Person person1 = new Person("Ana",0);
		Person person2 = new Person("Peter",1);
		persons.add(person1);
		persons.add(person2);
	}

	@Override
	public List<Person> getAllPersons() {
		return persons;
	}

	@Override
	public Person getPerson(int id) {
		return persons.get(id);
	}

	@Override
	public void updatePerson(Person person) {
		persons.get(person.getId()).setName(person.getName());
		System.out.println("Person: Id NO "+ person.getId()
				+", updated in the database");

	}

	@Override
	public void deletePerson(Person person) {
		persons.remove(person.getId());
		System.out.println("Person: Id No "+ person.getId()
				+", deleted from database");
	}

	
}
