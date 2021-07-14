package Phone;

import java.util.List;
import java.util.Scanner;

public class MessageController {
	Scanner scanner = new Scanner(System.in);
	MessageService messageService;

	MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	void showMassageFuncNum(TelephoneDirectory telephoneDirectory) {
		System.out.println("==========�޼���==========");
		System.out.println("1 �޼��� �߽� / 2 �޼��� ��ȸ");
		System.out.println("����� ����� �Է��Ͻÿ�");
		checkMessageFuncNum(telephoneDirectory);
	}

	void checkMessageFuncNum(TelephoneDirectory telephoneDirectory) {
		String answerNumber = scanner.nextLine();

		while (!isChoiceOneOrTwo(answerNumber)) {
			answerNumber = scanner.nextLine();
		}

		if (answerNumber.equals("1")) {
			askSendMessageWay(telephoneDirectory);// ���� �߽��� ���� �Է� �޼ҵ� ȣ��
		} else {
			askSearchingWayForShowMessage(telephoneDirectory);// ���� ���� ��ȸ�� ���� �Է� �޼ҵ� ȣ��
		}
	}

	void askSendMessageWay(TelephoneDirectory telephoneDirectory) {
		System.out.println("=====�޼��� �߽�=====");
		System.out.println("1. ��ȭ��ȣ�� �ٷ� �߽� / 2. ����ó �˻� �� �߽�");
		System.out.println("�߽� ��� ���� : ");
		askSendWay(telephoneDirectory);// �߽� ��� ���� �޼ҵ� ȣ��
	}

	void askSendWay(TelephoneDirectory telephoneDirectory) {

		String answerNumber = scanner.nextLine();
		while (!isChoiceOneOrTwo(answerNumber)) {
			answerNumber = scanner.nextLine();
		}

		if (answerNumber.equals("1")) {
			sendMessageByPhoneNumber(telephoneDirectory);// ���� �߽��� ���� �Է� �޼ҵ� ȣ��
		} else {
			sendMessageBySearchingContact(telephoneDirectory);// ���� ���� ��ȸ�� ���� �Է� �޼ҵ� ȣ��
		}
	}

	void sendMessageByPhoneNumber(TelephoneDirectory telephoneDirectory) {

		System.out.println("�߽��� ��ȭ��ȣ �Է� :");
		String phoneNumber = scanner.nextLine();
		System.out.println("�޼��� ���� �Է� : ");
		String messageContents = scanner.nextLine();

		// �߽Ÿ޼��� ���� �޼ҵ�
		messageService.sendMessage("send", phoneNumber, messageContents, telephoneDirectory);
		// MessageService �������� �����ִ´�?
	}

	void sendMessageBySearchingContact(TelephoneDirectory telephoneDirectory) {
		System.out.println("1. �̸����� �˻� / 2. ��ȣ�� �˻�");
		System.out.println("�˻��� ��� ����");
		searchContactForMessage(telephoneDirectory);// �˻���� �Է� �޼ҵ� ȣ��
	}

	void searchContactForMessage(TelephoneDirectory telephoneDirectory) {
		String answerNumber = scanner.nextLine();

		while (!isChoiceOneOrTwo(answerNumber)) {
			answerNumber = scanner.nextLine();
		}

		if (answerNumber.equals("1")) {
			askNameForSearchingContact(telephoneDirectory);// �̸����� �˻��ؼ� �߽��� ���� �Է� �޼ҵ� ȣ��
		} else {
			askPhoneNumberSearchingContact(telephoneDirectory);// ��ȣ�� �˻��ؼ� �߽��� ���� �Է� �޼ҵ� ȣ��
		}
	}

	void askNameForSearchingContact(TelephoneDirectory telephoneDirectory) {
		System.out.println("�˻��� ����ó�� �̸� : ");
		String searchingName = scanner.nextLine();

		if (telephoneDirectory.searchPhoneNumberByName(searchingName).equals("��ȭ��ȣ����")) {
			System.out.println("����� ����ó�� �����ϴ�.");
			askSendMessageWay(telephoneDirectory);
		} else {
			setTextMessageByName(searchingName, telephoneDirectory);
		}
	}

	void setTextMessageByName(String searchingName, TelephoneDirectory telephoneDirectory) {
		Contact searchedContact = telephoneDirectory.searchContactByName(searchingName);
		System.out.println("��ȸ�� ����ó : ");
		System.out.println("�̸� : " + searchedContact.getName());
		System.out.println("��ȭ��ȣ : " + searchedContact.getPhoneNumber());
		System.out.println("���� �޼��� �Է� :");
		String text = scanner.nextLine();
		messageService.sendMessage("send", searchedContact.getPhoneNumber(), text, telephoneDirectory);
	}

	void askPhoneNumberSearchingContact(TelephoneDirectory telephoneDirectory) {
		System.out.println("�˻��� ����ó�� ��ȭ��ȣ : ");
		String searchingPhoneNumber = scanner.nextLine();

		if (telephoneDirectory.searchNameByPhoneNumber(searchingPhoneNumber).equals(searchingPhoneNumber)) {
			System.out.println("����� ����ó�� �����ϴ�.");
			askSendMessageWay(telephoneDirectory);
		} else {
			sendTextMessageByPhoneNumber(searchingPhoneNumber, telephoneDirectory);
		}
	}

	Message sendTextMessageByPhoneNumber(String searchingPhoneNumber, TelephoneDirectory telephoneDirectory) {
		Contact searchedContact = telephoneDirectory.searchContactByPhoneNumber(searchingPhoneNumber);
		System.out.println("��ȸ�� ����ó : ");
		System.out.println("�̸� : " + searchedContact.getName());
		System.out.println("��ȭ��ȣ : " + searchedContact.getPhoneNumber());
		System.out.println("���� �޼��� �Է� :");
		String text = scanner.nextLine();
		return messageService.sendMessage("send", searchedContact, text, telephoneDirectory); // �̰� ���� view���� �޾ƿ�
	}

	void askSearchingWayForShowMessage(TelephoneDirectory telephoneDirectory) {
		System.out.println("=====�޼��� ��ȸ=====");
		System.out.println("1. �̸� �˻����� �޼��� ��ȸ / 2. ��ȭ��ȣ �˻����� �޼��� ��ȸ");
		askWayMessagesView(telephoneDirectory);
	}

	void askWayMessagesView(TelephoneDirectory telephoneDirectory) {
		String answerNumber = scanner.nextLine();

		while (!isChoiceOneOrTwo(answerNumber)) {
			answerNumber = scanner.nextLine();
		}

		if (answerNumber.equals("1")) {
			askNameForShowMessages(telephoneDirectory);
		} else {
			askPhoneNumberForShowMessages(telephoneDirectory);
		}
	}

	void askNameForShowMessages(TelephoneDirectory telephoneDirectory) {
		System.out.println("�˻��� ����ó�� �̸� : ");
		String searchingName = scanner.nextLine();

		List<Message> searchedMessages = getMessageByName(searchingName);
		showMessages(searchedMessages);
	}

	List<Message> getMessageByName(String searchingName) {
		return messageService.getMessagesByName(searchingName);
	}

	void askPhoneNumberForShowMessages(TelephoneDirectory telephoneDirectory) {
		System.out.println("�˻��� ����ó�� ��ȭ��ȣ : ");
		String searchingPhoneNumber = scanner.nextLine();

		if (telephoneDirectory.searchNameByPhoneNumber(searchingPhoneNumber).equals(searchingPhoneNumber)) {
			System.out.println("����� ����ó�� �����ϴ�.");
			askSendMessageWay(telephoneDirectory);
		} else {
			Contact searchingContact = telephoneDirectory.searchContactByPhoneNumber(searchingPhoneNumber);
			// Date ������ �޼����� �����ִ� �޼ҵ� ȣ��
			//showMessages(searchingContact, telephoneDirectory);
		}
	}

	void showMessages(List<Message> messages) {
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getMessageType().equals("send")) {
				System.out.print("�� : ");
			} else {
				System.out.print(messages.get(i).getContact().getName() + " : ");
			}
			System.out.println(messages.get(i).getText());
		}
	}

	boolean isChoiceOneOrTwo(String number) {
		if (number.equals("1") || number.equals("2")) {
			return true;
		}
		System.out.println("�߸� �Է��߽��ϴ�.");
		System.out.println("�ٽ� �Է��ϼ���.");
		return false;
	}
}