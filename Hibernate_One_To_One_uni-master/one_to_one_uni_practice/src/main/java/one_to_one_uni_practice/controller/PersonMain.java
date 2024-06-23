package one_to_one_uni_practice.controller;

import java.util.List;
import java.util.Scanner;

import one_to_one_uni_practice.dao.PersonDao;
import one_to_one_uni_practice.dto.PanCard;
import one_to_one_uni_practice.dto.Person;

public class PersonMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean flag = true;

		PanCard panCard = new PanCard();

		Person person = new Person();

		PersonDao dao = new PersonDao();

		do {
			System.out.println(
					"Enter the choice \n 1.Save Person \n 2.Update Person \n 3.Delete Person \n 4.Get Person by id \n 5.Get All Person \n 6.Exit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the person id");
				int id = scanner.nextInt();
				System.out.println("Enter the person name");
				String name = scanner.next();
				System.out.println("Enter the person phone");
				long phone = scanner.nextLong();
				System.out.println("Enter the person address");
				String address = scanner.next();

				System.out.println("Enter the pancard id");
				int pid = scanner.nextInt();
				System.out.println("Enter the pancard name");
				String pname = scanner.next();
				System.out.println("Enter the pancard address");
				String paddress = scanner.next();

				panCard.setPid(pid);
				panCard.setName(pname);
				panCard.setAddress(paddress);

				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				person.setPanCard(panCard);

				dao.savePerson(person);
			}
				break;

			case 2: {
				System.out.println("Enter the person id");
				int id = scanner.nextInt();
				System.out.println("Enter the person name");
				String name = scanner.next();
				System.out.println("Enter the person phone");
				long phone = scanner.nextLong();
				System.out.println("Enter the person address");
				String address = scanner.next();

				System.out.println("Enter the pancard id");
				int pid = scanner.nextInt();
				System.out.println("Enter the pancard name");
				String pname = scanner.next();
				System.out.println("Enter the pancard address");
				String paddress = scanner.next();

				panCard.setPid(pid);
				panCard.setName(pname);
				panCard.setAddress(paddress);

				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				person.setPanCard(panCard);

				dao.updatePerson(person);
			}
				break;

			case 3: {
				System.out.println("Enter the person id");
				int id = scanner.nextInt();

				dao.deletePerson(id);
			}
				break;

			case 4: {
				System.out.println("Enter the person id");
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
				flag = false;
			}
		} while (flag);

	}

}
