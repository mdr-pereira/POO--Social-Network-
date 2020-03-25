import java.util.Scanner;

import Network.FriendsClass;
import Network.FriendsIterator;
import Network.SocialNetworkClass;
import Network.UserClass;
import Network.UserIteratorClass;

public class Main {

	//	Static command strings
	private final static String REGISTER = "REGISTA";
	private final static String VERIFY_USER = "CONSULTAPESSOA";
	private final static String FRIEND_EXISTS = "CONSULTAAMIZADE";
	private final static String ADD_FRIENDSHIP = "AMIGOS";
	private final static String LIST_FRIENDS = "CONSULTAAMIGOS";
	private final static String EDIT_STATUS = "NOVOESTADO";
	private final static String GET_STATUS = "CONSULTAESTADO";
	private final static String LIST = "PESSOAS";
	private final static String EXIT = "SAIR"; 

	//	Static success and error messages

	//Success/Error
	private final static String EXISTS = "Pessoa registada.";	
	private final static String FRIENDSHIP_EXISTS = "Amizade existente."; 
	//Success
	private final static String REGISTERED = "Pessoa registada com sucesso.";
	private final static String FRIENDSHIP_SET = "Amizade criada.";
	private final static String STATUS_SET = "Estado alterado.";

	private final static String EXIT_MSG = "Adeus."; 
	//Error
	private final static String NO_REG = "Sem registo.";
	private final static String ERR_EMPTY = "Rede Social vazia.";
	private final static String FRIENDSHIP_NOT_EXIST = "Amizade inexistente.";
	private final static String FRIENDSHIP_INVALID = "Amizade invalida.";
	private final static String NO_FRIENDS = "Nao tem amigos registados.";
	private final static String INV_INPUT = "Input invalido.";

	//	Auxiliary messages 
	private final static String LIST_MSG = "Lista de pessoas registadas:";
	private final static String FRIEND_LIST_MSG = "Lista de amigos:";
	private final static String SEMICOLON = "; ";
	//	Main

	public static void main(String[] args) {
		SocialNetworkClass ua = new SocialNetworkClass(); 
		Scanner in = new Scanner(System.in);

		String select = readCommand(in);

		while (!select.equals(EXIT)) {
			processCommand(in, ua, select); 
			select = readCommand(in);
		}

		System.out.println(EXIT_MSG);	
		in.close();
	}

	/*
	 * Input reading and interpretation 
	 */

	private static String readCommand (Scanner input) {
		return input.next().toUpperCase();
	}

	private static void processCommand (Scanner input, SocialNetworkClass ua, String cmd) {
		switch (cmd) {

		case REGISTER:
			register(input, ua);
			break;

		case VERIFY_USER:
			verifyUser(input, ua);
			break;

		case FRIEND_EXISTS:
			friendExists(input, ua);
			break;

		case ADD_FRIENDSHIP:
			addFriendship(input,ua);
			break;

		case LIST_FRIENDS:
			listFriends(input, ua);
			break;

		case EDIT_STATUS:
			editStatus(input, ua);
			break;

		case GET_STATUS:
			getStatus(input, ua);
			break;

		case LIST:
			listUsers(input, ua);
			break;

		default:
			System.out.println(INV_INPUT);
			break; 
		}
	}

	private static void register(Scanner input, SocialNetworkClass ua) {
		input.nextLine();
		String name = input.nextLine();
		String email = input.nextLine();
		String initStatus = input.nextLine();

		if(ua.userExists(name)) {
			System.out.println(EXISTS); 
		}
		else {
			ua.register(name, email, initStatus);
			System.out.println(REGISTERED);
		}
	}

	private static void verifyUser(Scanner input, SocialNetworkClass ua) {
		input.nextLine();
		String name = input.nextLine();

		if(!ua.userExists(name)) {
			System.out.println(NO_REG);
		}
		else {
			System.out.println(EXISTS);
		}
	}

	private static void friendExists(Scanner input, SocialNetworkClass ua) {
		input.nextLine();
		String user1 = input.nextLine();
		String user2 = input.nextLine();

		if(!ua.friendExists(user1, user2)) {
			System.out.println(FRIENDSHIP_NOT_EXIST);
		}
		else {
			System.out.println(FRIENDSHIP_EXISTS);
		}
	}

	private static void addFriendship(Scanner input, SocialNetworkClass ua) {
		input.nextLine();
		String user1 = input.nextLine();
		String user2 = input.nextLine();

		if(!ua.userExists(user1) || !ua.userExists(user2)) {
			System.out.println(NO_REG);
		}

		else if (ua.friendExists(user1, user2)) {
			System.out.println(FRIENDSHIP_EXISTS);
		}
		else if (user1.equals(user2)) {
			System.out.println(FRIENDSHIP_INVALID);
		}
		else {
			ua.addFriendship(user1, user2);
			System.out.println(FRIENDSHIP_SET);	
		}
	}

	private static void listFriends (Scanner input, SocialNetworkClass ua) {
		input.nextLine();
		String name = input.nextLine();

		FriendsIterator fit = ua.getIterator(name);

		if(!ua.hasFriends(name)) {
			System.out.println(NO_FRIENDS);

		} else {
			System.out.println(FRIEND_LIST_MSG);

			while (fit.hasNext()) {
				FriendsClass fc = fit.next();
				System.out.println(fc.getName() + "; " + ua.getEmail(fc.getName()));
			}
		}
	}

	private static void editStatus(Scanner input, SocialNetworkClass ua) {
		input.nextLine();
		String name = input.nextLine();
		String status = input.nextLine();

		if(!ua.userExists(name)) {
			System.out.println(NO_REG);
		}
		else {
			ua.editStatus(name, status);
			System.out.println(STATUS_SET);
		}
	}

	private static void getStatus(Scanner input, SocialNetworkClass ua) {
		input.nextLine();
		String name = input.nextLine();

		if(!ua.userExists(name)) {
			System.out.println(NO_REG);
		}
		else {
			System.out.println(ua.getStatus(name));
		}
	}

	private static void listUsers(Scanner input, SocialNetworkClass ua) {
		UserIteratorClass it = ua.iterator();

		if(ua.isEmpty()) {
			System.out.println(ERR_EMPTY);
		}
		else {
			System.out.println(LIST_MSG);

			while(it.hasNext()) {
				UserClass uc = it.next();
				System.out.println( uc.getName() + SEMICOLON + uc.getEmail());
			}
		}	
	}
}
