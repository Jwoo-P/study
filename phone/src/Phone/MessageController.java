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
		System.out.println("==========메세지==========");
		System.out.println("1 메세지 발신 / 2 메세지 조회");
		System.out.println("사용할 기능을 입력하시오");
		checkMessageFuncNum(telephoneDirectory);
	}

	void checkMessageFuncNum(TelephoneDirectory telephoneDirectory) {
		String answerNumber = scanner.nextLine();

		while (!isChoiceOneOrTwo(answerNumber)) {
			answerNumber = scanner.nextLine();
		}

		if (answerNumber.equals("1")) {
			askSendMessageWay(telephoneDirectory);// 문자 발신을 위한 입력 메소드 호출
		} else {
			askSearchingWayForShowMessage(telephoneDirectory);// 수신 문자 조회를 위한 입력 메소드 호출
		}
	}

	void askSendMessageWay(TelephoneDirectory telephoneDirectory) {
		System.out.println("=====메세지 발신=====");
		System.out.println("1. 전화번호로 바로 발신 / 2. 연락처 검색 후 발신");
		System.out.println("발신 방법 선택 : ");
		askSendWay(telephoneDirectory);// 발신 방법 선택 메소드 호출
	}

	void askSendWay(TelephoneDirectory telephoneDirectory) {

		String answerNumber = scanner.nextLine();
		while (!isChoiceOneOrTwo(answerNumber)) {
			answerNumber = scanner.nextLine();
		}

		if (answerNumber.equals("1")) {
			sendMessageByPhoneNumber(telephoneDirectory);// 문자 발신을 위한 입력 메소드 호출
		} else {
			sendMessageBySearchingContact(telephoneDirectory);// 수신 문자 조회를 위한 입력 메소드 호출
		}
	}

	void sendMessageByPhoneNumber(TelephoneDirectory telephoneDirectory) {

		System.out.println("발신할 전화번호 입력 :");
		String phoneNumber = scanner.nextLine();
		System.out.println("메세지 내용 입력 : ");
		String messageContents = scanner.nextLine();

		// 발신메세지 저장 메소드
		messageService.sendMessage("send", phoneNumber, messageContents, telephoneDirectory);
		// MessageService 전역으로 갖고있는다?
	}

	void sendMessageBySearchingContact(TelephoneDirectory telephoneDirectory) {
		System.out.println("1. 이름으로 검색 / 2. 번호로 검색");
		System.out.println("검색할 방식 선택");
		searchContactForMessage(telephoneDirectory);// 검색방식 입력 메소드 호출
	}

	void searchContactForMessage(TelephoneDirectory telephoneDirectory) {
		String answerNumber = scanner.nextLine();

		while (!isChoiceOneOrTwo(answerNumber)) {
			answerNumber = scanner.nextLine();
		}

		if (answerNumber.equals("1")) {
			askNameForSearchingContact(telephoneDirectory);// 이름으로 검색해서 발신을 위한 입력 메소드 호출
		} else {
			askPhoneNumberSearchingContact(telephoneDirectory);// 번호로 검색해서 발신을 위한 입력 메소드 호출
		}
	}

	void askNameForSearchingContact(TelephoneDirectory telephoneDirectory) {
		System.out.println("검색할 연락처의 이름 : ");
		String searchingName = scanner.nextLine();

		if (telephoneDirectory.searchPhoneNumberByName(searchingName).equals("전화번호음슴")) {
			System.out.println("저장된 연락처가 없습니다.");
			askSendMessageWay(telephoneDirectory);
		} else {
			setTextMessageByName(searchingName, telephoneDirectory);
		}
	}

	void setTextMessageByName(String searchingName, TelephoneDirectory telephoneDirectory) {
		Contact searchedContact = telephoneDirectory.searchContactByName(searchingName);
		System.out.println("조회된 연락처 : ");
		System.out.println("이름 : " + searchedContact.getName());
		System.out.println("전화번호 : " + searchedContact.getPhoneNumber());
		System.out.println("보낼 메세지 입력 :");
		String text = scanner.nextLine();
		messageService.sendMessage("send", searchedContact.getPhoneNumber(), text, telephoneDirectory);
	}

	void askPhoneNumberSearchingContact(TelephoneDirectory telephoneDirectory) {
		System.out.println("검색할 연락처의 전화번호 : ");
		String searchingPhoneNumber = scanner.nextLine();

		if (telephoneDirectory.searchNameByPhoneNumber(searchingPhoneNumber).equals(searchingPhoneNumber)) {
			System.out.println("저장된 연락처가 없습니다.");
			askSendMessageWay(telephoneDirectory);
		} else {
			sendTextMessageByPhoneNumber(searchingPhoneNumber, telephoneDirectory);
		}
	}

	Message sendTextMessageByPhoneNumber(String searchingPhoneNumber, TelephoneDirectory telephoneDirectory) {
		Contact searchedContact = telephoneDirectory.searchContactByPhoneNumber(searchingPhoneNumber);
		System.out.println("조회된 연락처 : ");
		System.out.println("이름 : " + searchedContact.getName());
		System.out.println("전화번호 : " + searchedContact.getPhoneNumber());
		System.out.println("보낼 메세지 입력 :");
		String text = scanner.nextLine();
		return messageService.sendMessage("send", searchedContact, text, telephoneDirectory); // 이건 원래 view에서 받아옴
	}

	void askSearchingWayForShowMessage(TelephoneDirectory telephoneDirectory) {
		System.out.println("=====메세지 조회=====");
		System.out.println("1. 이름 검색으로 메세지 조회 / 2. 전화번호 검색으로 메세지 조회");
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
		System.out.println("검색할 연락처의 이름 : ");
		String searchingName = scanner.nextLine();

		List<Message> searchedMessages = getMessageByName(searchingName);
		showMessages(searchedMessages);
	}

	List<Message> getMessageByName(String searchingName) {
		return messageService.getMessagesByName(searchingName);
	}

	void askPhoneNumberForShowMessages(TelephoneDirectory telephoneDirectory) {
		System.out.println("검색할 연락처의 전화번호 : ");
		String searchingPhoneNumber = scanner.nextLine();

		if (telephoneDirectory.searchNameByPhoneNumber(searchingPhoneNumber).equals(searchingPhoneNumber)) {
			System.out.println("저장된 연락처가 없습니다.");
			askSendMessageWay(telephoneDirectory);
		} else {
			Contact searchingContact = telephoneDirectory.searchContactByPhoneNumber(searchingPhoneNumber);
			// Date 순으로 메세지를 보여주는 메소드 호출
			//showMessages(searchingContact, telephoneDirectory);
		}
	}

	void showMessages(List<Message> messages) {
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getMessageType().equals("send")) {
				System.out.print("나 : ");
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
		System.out.println("잘못 입력했습니다.");
		System.out.println("다시 입력하세요.");
		return false;
	}
}