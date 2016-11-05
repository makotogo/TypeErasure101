package com.makotogo.learn.erasure;

/*
 * Copyright 2016 Makoto Consulting Group, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

  private static final Logger log = Logger.getLogger(AppTest.class.getName());

  private App classUnderTest;

  private Person person1;
  private Person person2;
  private Guest guest1;
  private Guest guest2;
  private Employee employee1;
  private Employee employee2;

  @Before
  public void setUp() throws Exception {
    classUnderTest = new App();

    person1 = new Person("Joe", 20, EyeColor.BLACK, Gender.MALE);
    person2 = new Person("Jane", 22, EyeColor.BLUE, Gender.FEMALE);

    guest1 = new Guest("Joe", 20, EyeColor.BLACK, Gender.MALE);
    guest2 = new Guest("Jane", 22, EyeColor.BLUE, Gender.FEMALE);

    employee1 = new Employee("Joe", 20, EyeColor.BLACK, Gender.MALE, "123-45-6789", "EMP000200");
    employee2 = new Employee("Jane", 22, EyeColor.BLUE, Gender.FEMALE, "987-65-4321", "EMP000201");

  }

  @After
  public void tearDown() throws Exception {
    person1 = person2 = null;
    guest1 = guest2 = null;
    employee1 = employee2 = null;
  }

  @Test
  public void testProcessListOfPerson() {
    log.info("BEGIN - testProcessListOfPerson()");

    List<Person> people = new ArrayList<>();
    people.add(person1);
    people.add(person2);

    log.info("Invoking generic method...");
    classUnderTest.process(people);

    log.info("Invoking specific method...");
    classUnderTest.processPeople(people);

    log.info("END - testProcessListOfPerson()");
  }

  @Test
  public void testProcessListOfGuest() {
    log.info("BEGIN - testProcessListOfGuest()");

    List<Guest> guests = new ArrayList<>();
    guests.add(guest1);
    guests.add(guest2);

    log.info("Invoking generic method...");
    classUnderTest.process(guests);

    log.info("Invoking specific method...");
    classUnderTest.processGuests(guests);

    log.info("END - testProcessListOfGuest()");
  }

  @Test
  public void testProcessListOfEmployee() {
    log.info("BEGIN - testProcessListOfEmployee()");

    List<Employee> employees = new ArrayList<>();
    employees.add(employee1);
    employees.add(employee2);

    classUnderTest.process(employees);

    log.info("END - testProcessListOfEmployee()");
  }

  @Test
  public void testProcessPersonArray() {
    log.info("BEGIN - testProcessPersonArray()");

    Person[] people = {
        person1,
        person2
    };

    classUnderTest.process(people);

    log.info("END - testProcessPersonArray()");
  }

  @Test
  public void testProcessGuestArray() {
    log.info("BEGIN - testProcessGuestArray()");

    Guest[] guests = {
        guest1,
        guest2
    };

    classUnderTest.process(guests);

    log.info("END - testProcessGuestArray()");
  }

  @Test
  public void testProcessEmployeeArray() {
    log.info("BEGIN - testProcessEmployeeArray()");

    Employee[] employees = {
        employee1,
        employee2
    };

    classUnderTest.process(employees);

    log.info("END - testProcessEmployeeArray()");
  }

  @Test
  public void testProcessFooArray() {
    log.info("BEGIN - testProcessFooArray()");

    Foo foo = new Foo();
    Foo foo2 = new Foo();
    Foo[] foos = {
        foo,
        foo2
    };

    classUnderTest.process(foos);

    log.info("BEGIN - testProcessFooArray()");
  }

}
