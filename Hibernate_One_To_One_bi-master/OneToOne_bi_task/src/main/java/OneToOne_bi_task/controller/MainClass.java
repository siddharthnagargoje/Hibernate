package OneToOne_bi_task.controller;

import java.util.List;
import java.util.Scanner;

import OneToOne_bi_task.dao.PersonDao;
import OneToOne_bi_task.dto.PanCard;
import OneToOne_bi_task.dto.Person;

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person person = new Person();
		PanCard panCard = new PanCard();
		PersonDao dao = new PersonDao();
		int choice;
		boolean key = true;
		do {
			System.out.println(
					"Enter the choice \n 1.Save Person \n 2.Update Person \n 3.Delete Person \n 4.Get Person By Id \n 5.Get All Person \n 6.Exit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the Person id");
				int id = scanner.nextInt();
				System.out.println("Enter the Person name");
				String name = scanner.next();
				System.out.println("Enter the Person address");
				String address = scanner.next();
				System.out.println("Enter the Person phone");
				long phone = scanner.nextLong();

				person.setId(id);
				person.setName(name);
				person.setAddress(address);
				person.setPhone(phone);

				System.out.println("Enter the Pancard id");
				int pid = scanner.nextInt();
				System.out.println("Enter the Pancard name");
				String pname = scanner.next();
				System.out.println("Enter the Pancard address");
				String paddress = scanner.next();

				panCard.setId(pid);
				panCard.setName(pname);
				panCard.setAddress(paddress);

				person.setPanCard(panCard);
				panCard.setPerson(person);

				dao.savePerson(person);
			}
				break;
			case 2: {
				System.out.println("Enter the Person id");
				int id = scanner.nextInt();
				System.out.println("Enter the Person name");
				String name = scanner.next();
				System.out.println("Enter the Person address");
				String address = scanner.next();
				System.out.println("Enter the Person phone");
				long phone = scanner.nextLong();

				person.setId(id);
				person.setName(name);
				person.setAddress(address);
				person.setPhone(phone);

				System.out.println("Enter the Pancard id");
				int pid = scanner.nextInt();
				System.out.println("Enter the Pancard name");
				String pname = scanner.next();
				System.out.println("Enter the Pancard address");
				String paddress = scanner.next();

				panCard.setId(pid);
				panCard.setName(pname);
				panCard.setAddress(paddress);

				person.setPanCard(panCard);
				panCard.setPerson(person);

				dao.updatePerson(id, person);
			}
				break;
			case 3: {
				System.out.println("Enter the Person id");
				int id = scanner.nextInt();

				dao.deletePerson(id);
			}
				break;
			case 4: {
				System.out.println("Enter the Person id");
				int id = scanner.nextInt();

				person = dao.getPersonById(id);
				System.out.println(person);

			}
				break;
			case 5: {
				List<Person> list = dao.getAllPerson();
				System.out.println(list);
			}
				break;
			default:
				key = false;
			}
		} while (key);

	}

}
