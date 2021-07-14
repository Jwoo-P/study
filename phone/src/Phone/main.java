package Phone;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws InterruptedException {

		String inputNumber;
		Scanner scanner = new Scanner(System.in);

		List<Contact> testContacts = new ArrayList();

		testContacts.add(new Contact("하이", "123"));

		TelephoneDirectory testDirectory = new TelephoneDirectory(testContacts);
		TelephoneDirectoryController testDirectoryController = new TelephoneDirectoryController();

		 //Message 명시해줌
		// Service는 Controller에서 호출
	
		MessageController testMessageController = new MessageController(new MessageService(new ArrayList<Message>(), testDirectory));

		while (true) {
			testDirectoryController.excuteUsingFunction(testDirectory);
			testMessageController.showMassageFuncNum(testDirectory);
		}

		// 전화번호부에서 문자 보내기 'ㅅ'!
		// 기능 두어개 더 만들어보기그기긔기

		// Call aaaaCall = new Call();
//		aaaaCall.startCall("01011234456", aaaaDirectory);
//		
//		Thread.sleep(1000);
//		
//		aaaaCall.endCalling();
//		

	}
}
