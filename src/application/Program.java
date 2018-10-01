package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Room;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("How many rooms will be rented?");
		int n = scan.nextInt();
		
		System.out.println();

		int room, auxRoom;
		String name, email, auxName, auxEmail;

		Room[] vect = new Room[n];

		for (int i = 0; i < vect.length; i++) {

			System.out.println("Rent #" + (i + 1));
			System.out.print("Enter name: ");
			scan.nextLine();
			name = scan.nextLine();
			
			System.out.print("Enter email: ");
			email = scan.nextLine();
			
			System.out.print("Enter room: ");
			room = scan.nextInt();
			System.out.println();

			vect[i] = new Room(name, email, room);
		}

		System.out.println();
		
		for (int i = 1; i < vect.length; i++) {
			for (int j = i - 1; j < vect.length; j++) {

				if (vect[i].getRoom() < vect[j].getRoom()) {

					auxRoom = vect[i].getRoom();
					auxName = vect[i].getName();
					auxEmail = vect[i].getEmail();

					vect[i].setRoom(vect[j].getRoom());
					vect[i].setName(vect[j].getName());
					vect[i].setEmail(vect[j].getEmail());

					vect[j].setRoom(auxRoom);
					vect[j].setName(auxName);
					vect[j].setEmail(auxEmail);
				}

			}
		}
		System.out.println("Busy rooms:");

		for (int i1 = 0; i1 < vect.length; i1++) {
			System.out.println(vect[i1].getRoom() + ": " + vect[i1].getName() + ", " + vect[i1].getEmail());
		}

		scan.close();
	}

}
