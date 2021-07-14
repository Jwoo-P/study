package Phone;

import java.util.Scanner;

public class TelephoneDirectoryController {
	Scanner scanner = new Scanner(System.in);

	// ����ó ��� �����ϱ�
	void excuteUsingFunction(TelephoneDirectory telephoneDirectory) {
		System.out.println("==========��ȭ��ȣ�� ���==========");
		System.out.println("1 ����ó ��ȸ / 2 ����ó ���� / 3 ����ó ���� / 4 ����ó ����");
		System.out.println("����� ����� �Է��Ͻÿ�");
		choiceQuetionForUseFunction(telephoneDirectory);

	}

	void choiceQuetionForUseFunction(TelephoneDirectory telephoneDirectory) {
		String choiceNum = scanner.nextLine();

		while (Integer.parseInt(choiceNum) > 4 || Integer.parseInt(choiceNum) < 1) {
			System.out.println("�ٽ� �Է��Ͻÿ�");
			choiceNum = scanner.nextLine();
		}

		switch (Integer.parseInt(choiceNum)) {
		case 1:
			choiceQuestionForSearchContact(telephoneDirectory);
			break;
		case 2:
			askContactInfo(telephoneDirectory);
			break;
		case 3:
			choiceQuestionForChangeContactInfo(telephoneDirectory);
			break;
		case 4:
			choiceQuestionForDeleteContactInfo(telephoneDirectory);
			break;
		}
	}

	// 1 ��ȸ�� ����ó ���� �����ϱ�
	void choiceQuestionForSearchContact(TelephoneDirectory telephoneDirectory) {
		System.out.println("��ȸ�� ����ó�� �˻��� ����� �����Ͻÿ�");
		System.out.println("1 �̸����� �˻� / 2 ��ȣ�� �˻�");

		setChoiceNumberForSearch(telephoneDirectory);

	}

	void setChoiceNumberForSearch(TelephoneDirectory telephoneDirectory) {
		String choiceNum = scanner.nextLine();

		while (Integer.parseInt(choiceNum) != 1 && Integer.parseInt(choiceNum) != 2) {
			System.out.println("�ٽ� �Է��Ͻÿ�");
			choiceNum = scanner.nextLine();
		}

		if (Integer.parseInt(choiceNum) == 1) {
			askContactNameForSearchPhoneNumber(telephoneDirectory);
		} else {
			askContactPhoneNumberForSearchName(telephoneDirectory);
		}
	}

	// �̸����� ����ó ��ȣ ã��
	void askContactNameForSearchPhoneNumber(TelephoneDirectory telephoneDirectory) {
		System.out.println("��ȸ�� ����ó �̸�: ");
		String inputName = scanner.nextLine();
		System.out.println("��ȭ��ȣ : " + telephoneDirectory.searchPhoneNumberByName(inputName));
	}

	// ��ȣ�� ����ó �̸� ã��
	void askContactPhoneNumberForSearchName(TelephoneDirectory telephoneDirectory) {
		System.out.println("��ȸ�� ����ó ��ȣ: ");
		String inputPhoneNumber = scanner.nextLine();
		System.out.println("�̸� : " + telephoneDirectory.searchNameByPhoneNumber(inputPhoneNumber));
	}

	// 2 ������ ����ó ���� �����ϱ�
	void askContactInfo(TelephoneDirectory telephoneDirectory) {
		System.out.println("������ ����ó �̸� : ");
		String inputName = scanner.nextLine();

		System.out.println("������ ����ó ��ȣ : ");
		String inputPhoneNumber = scanner.nextLine();

		telephoneDirectory.addContact(inputName, inputPhoneNumber);

		System.out.println("�����Ͽ����ϴ�.");

	}

	// 3 ������ ����ó �����ϱ�
	void choiceQuestionForChangeContactInfo(TelephoneDirectory telephoneDirectory) {
		System.out.println("������ ����ó�� �˻��� ����� �����Ͻÿ�");
		System.out.println("1 �̸����� �˻� / 2 ��ȣ�� �˻�");

		setChoiceNumberForChangeInfo(telephoneDirectory);

	}

	void setChoiceNumberForChangeInfo(TelephoneDirectory telephoneDirectory) {
		String choiceNum = scanner.nextLine();

		while (Integer.parseInt(choiceNum) != 1 && Integer.parseInt(choiceNum) != 2) {
			System.out.println("�ٽ� �Է��Ͻÿ�");
			choiceNum = scanner.nextLine();
		}

		if (Integer.parseInt(choiceNum) == 1) {
			askContactNameForChangePhoneNumber(telephoneDirectory);
		} else {
			askContactPhoneNumberForChangeName(telephoneDirectory);
		}
	}

	void askContactNameForChangePhoneNumber(TelephoneDirectory telephoneDirectory) {
		System.out.println("��ȸ�� ����ó �̸�: ");
		String inputName = scanner.nextLine();
		System.out.println("������ ��ȣ :");
		String inputPhoneNumber = scanner.nextLine();
		telephoneDirectory.changePhoneNumberByName(inputName, inputPhoneNumber);
	}

	void askContactPhoneNumberForChangeName(TelephoneDirectory telephoneDirectory) {
		System.out.println("��ȸ�� ����ó ��ȣ: ");
		String inputPhoneNumber = scanner.nextLine();
		System.out.println("������ �̸�: ");
		String inputName = scanner.nextLine();
		telephoneDirectory.changeNameByPhoneNumber(inputName, inputPhoneNumber);
	}

	// 4 ������ ����ó �����ϱ�
	void choiceQuestionForDeleteContactInfo(TelephoneDirectory telephoneDirectory) {
		System.out.println("������ ����ó�� �˻��� ����� �����Ͻÿ�");
		System.out.println("1 �̸����� �˻� / 2 ��ȣ�� �˻�");

		setChoiceNumberForDeleteInfo(telephoneDirectory);

	}

	void setChoiceNumberForDeleteInfo(TelephoneDirectory telephoneDirectory) {
		String choiceNum = scanner.nextLine();

		while (Integer.parseInt(choiceNum) != 1 && Integer.parseInt(choiceNum) != 2) {
			System.out.println("�ٽ� �Է��Ͻÿ�");
			choiceNum = scanner.nextLine();
		}

		if (Integer.parseInt(choiceNum) == 1) {
			askNameForDeleteInfo(telephoneDirectory);
		} else {
			askPhoneNumberForDeleteInfo(telephoneDirectory);
		}
	}

	void askNameForDeleteInfo(TelephoneDirectory telephoneDirectory) {
		System.out.println("������ ����ó �̸� :");
		String inputName = scanner.nextLine();
		Contact deleteContact = telephoneDirectory.deleteByName(inputName);
		isNullDeleteContact(deleteContact);
	}

	void askPhoneNumberForDeleteInfo(TelephoneDirectory telephoneDirectory) {
		System.out.println("������ ����ó ��ȣ :");
		String inputPhoneNumber = scanner.nextLine();
		Contact deleteContact = telephoneDirectory.deleteByPhoneNumber(inputPhoneNumber);
		isNullDeleteContact(deleteContact);
	}

	void isNullDeleteContact(Contact contact) {
		if (contact == null) {
			System.out.println("����� ����ó�� �����ϴ�.");
		} else {
			System.out.println("������ ����ó");
			System.out.println("�̸� : " + contact.getName());
			System.out.println("��ȣ : " + contact.getPhoneNumber());
		}
	}
}
