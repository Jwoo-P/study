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

		testContacts.add(new Contact("����", "123"));

		TelephoneDirectory testDirectory = new TelephoneDirectory(testContacts);
		TelephoneDirectoryController testDirectoryController = new TelephoneDirectoryController();

		 //Message �������
		// Service�� Controller���� ȣ��
	
		MessageController testMessageController = new MessageController(new MessageService(new ArrayList<Message>(), testDirectory));

		while (true) {
			testDirectoryController.excuteUsingFunction(testDirectory);
			testMessageController.showMassageFuncNum(testDirectory);
		}

		// ��ȭ��ȣ�ο��� ���� ������ '��'!
		// ��� �ξ �� ������ױ���

		// Call aaaaCall = new Call();
//		aaaaCall.startCall("01011234456", aaaaDirectory);
//		
//		Thread.sleep(1000);
//		
//		aaaaCall.endCalling();
//		

	}
}
