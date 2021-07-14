package Phone;

import java.util.Scanner;

public class TelephoneDirectoryController {
	Scanner scanner = new Scanner(System.in);

	// 연락처 기능 질문하기
	void excuteUsingFunction(TelephoneDirectory telephoneDirectory) {
		System.out.println("==========전화번호부 기능==========");
		System.out.println("1 연락처 조회 / 2 연락처 저장 / 3 연락처 수정 / 4 연락처 삭제");
		System.out.println("사용할 기능을 입력하시오");
		choiceQuetionForUseFunction(telephoneDirectory);

	}

	void choiceQuetionForUseFunction(TelephoneDirectory telephoneDirectory) {
		String choiceNum = scanner.nextLine();

		while (Integer.parseInt(choiceNum) > 4 || Integer.parseInt(choiceNum) < 1) {
			System.out.println("다시 입력하시오");
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

	// 1 조회할 연락처 정보 질문하기
	void choiceQuestionForSearchContact(TelephoneDirectory telephoneDirectory) {
		System.out.println("조회할 연락처를 검색할 방식을 선택하시오");
		System.out.println("1 이름으로 검색 / 2 번호로 검색");

		setChoiceNumberForSearch(telephoneDirectory);

	}

	void setChoiceNumberForSearch(TelephoneDirectory telephoneDirectory) {
		String choiceNum = scanner.nextLine();

		while (Integer.parseInt(choiceNum) != 1 && Integer.parseInt(choiceNum) != 2) {
			System.out.println("다시 입력하시오");
			choiceNum = scanner.nextLine();
		}

		if (Integer.parseInt(choiceNum) == 1) {
			askContactNameForSearchPhoneNumber(telephoneDirectory);
		} else {
			askContactPhoneNumberForSearchName(telephoneDirectory);
		}
	}

	// 이름으로 연락처 번호 찾기
	void askContactNameForSearchPhoneNumber(TelephoneDirectory telephoneDirectory) {
		System.out.println("조회할 연락처 이름: ");
		String inputName = scanner.nextLine();
		System.out.println("전화번호 : " + telephoneDirectory.searchPhoneNumberByName(inputName));
	}

	// 번호로 연락처 이름 찾기
	void askContactPhoneNumberForSearchName(TelephoneDirectory telephoneDirectory) {
		System.out.println("조회할 연락처 번호: ");
		String inputPhoneNumber = scanner.nextLine();
		System.out.println("이름 : " + telephoneDirectory.searchNameByPhoneNumber(inputPhoneNumber));
	}

	// 2 저정할 연락처 정보 질문하기
	void askContactInfo(TelephoneDirectory telephoneDirectory) {
		System.out.println("저장할 연락처 이름 : ");
		String inputName = scanner.nextLine();

		System.out.println("저장할 연락처 번호 : ");
		String inputPhoneNumber = scanner.nextLine();

		telephoneDirectory.addContact(inputName, inputPhoneNumber);

		System.out.println("저장하였습니다.");

	}

	// 3 수정할 연락처 질문하기
	void choiceQuestionForChangeContactInfo(TelephoneDirectory telephoneDirectory) {
		System.out.println("수정할 연락처를 검색할 방식을 선택하시오");
		System.out.println("1 이름으로 검색 / 2 번호로 검색");

		setChoiceNumberForChangeInfo(telephoneDirectory);

	}

	void setChoiceNumberForChangeInfo(TelephoneDirectory telephoneDirectory) {
		String choiceNum = scanner.nextLine();

		while (Integer.parseInt(choiceNum) != 1 && Integer.parseInt(choiceNum) != 2) {
			System.out.println("다시 입력하시오");
			choiceNum = scanner.nextLine();
		}

		if (Integer.parseInt(choiceNum) == 1) {
			askContactNameForChangePhoneNumber(telephoneDirectory);
		} else {
			askContactPhoneNumberForChangeName(telephoneDirectory);
		}
	}

	void askContactNameForChangePhoneNumber(TelephoneDirectory telephoneDirectory) {
		System.out.println("조회할 연락처 이름: ");
		String inputName = scanner.nextLine();
		System.out.println("변경할 번호 :");
		String inputPhoneNumber = scanner.nextLine();
		telephoneDirectory.changePhoneNumberByName(inputName, inputPhoneNumber);
	}

	void askContactPhoneNumberForChangeName(TelephoneDirectory telephoneDirectory) {
		System.out.println("조회할 연락처 번호: ");
		String inputPhoneNumber = scanner.nextLine();
		System.out.println("변경할 이름: ");
		String inputName = scanner.nextLine();
		telephoneDirectory.changeNameByPhoneNumber(inputName, inputPhoneNumber);
	}

	// 4 삭제할 연락처 질문하기
	void choiceQuestionForDeleteContactInfo(TelephoneDirectory telephoneDirectory) {
		System.out.println("삭제할 연락처를 검색할 방식을 선택하시오");
		System.out.println("1 이름으로 검색 / 2 번호로 검색");

		setChoiceNumberForDeleteInfo(telephoneDirectory);

	}

	void setChoiceNumberForDeleteInfo(TelephoneDirectory telephoneDirectory) {
		String choiceNum = scanner.nextLine();

		while (Integer.parseInt(choiceNum) != 1 && Integer.parseInt(choiceNum) != 2) {
			System.out.println("다시 입력하시오");
			choiceNum = scanner.nextLine();
		}

		if (Integer.parseInt(choiceNum) == 1) {
			askNameForDeleteInfo(telephoneDirectory);
		} else {
			askPhoneNumberForDeleteInfo(telephoneDirectory);
		}
	}

	void askNameForDeleteInfo(TelephoneDirectory telephoneDirectory) {
		System.out.println("삭제할 연락처 이름 :");
		String inputName = scanner.nextLine();
		Contact deleteContact = telephoneDirectory.deleteByName(inputName);
		isNullDeleteContact(deleteContact);
	}

	void askPhoneNumberForDeleteInfo(TelephoneDirectory telephoneDirectory) {
		System.out.println("삭제할 연락처 번호 :");
		String inputPhoneNumber = scanner.nextLine();
		Contact deleteContact = telephoneDirectory.deleteByPhoneNumber(inputPhoneNumber);
		isNullDeleteContact(deleteContact);
	}

	void isNullDeleteContact(Contact contact) {
		if (contact == null) {
			System.out.println("저장된 연락처가 없습니다.");
		} else {
			System.out.println("삭제한 연락처");
			System.out.println("이름 : " + contact.getName());
			System.out.println("번호 : " + contact.getPhoneNumber());
		}
	}
}
