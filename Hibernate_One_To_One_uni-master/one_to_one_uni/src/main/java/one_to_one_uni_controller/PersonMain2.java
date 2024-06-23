package one_to_one_uni_controller;

import java.util.List;
import java.util.Scanner;

import one_to_one_uni_dao.PersonDao;
import one_to_one_uni_dto.AadharCard;
import one_to_one_uni_dto.Person;

public class PersonMain2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean flag = true;

		AadharCard aadharCard = new AadharCard();

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

				System.out.println("Enter the aadhar id");
				int aid = scanner.nextInt();
				System.out.println("Enter the aadhar name");
				String aname = scanner.next();
				System.out.println("Enter the aadhar address");
				String aaddress = scanner.next();

				aadharCard.setAid(aid);
				aadharCard.setName(aname);
				aadharCard.setAddress(aaddress);

				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				person.setAadharCard(aadharCard);

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

				System.out.println("Enter the aadhar id");
				int aid = scanner.nextInt();
				System.out.println("Enter the aadhar name");
				String aname = scanner.next();
				System.out.println("Enter the aadhar address");
				String aaddress = scanner.next();

				aadharCard.setAid(aid);
				aadharCard.setName(aname);
				aadharCard.setAddress(aaddress);

				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				person.setAadharCard(aadharCard);

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

				Person person1 = dao.getPersonById(id);
				System.out.println(person1);
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
