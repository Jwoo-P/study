package Phone;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageService {

	private List<Message> messages;
	private TelephoneDirectory telephoneDirectory;

	public MessageService(List<Message> messages, TelephoneDirectory telephoneDirectory) {
		this.telephoneDirectory = telephoneDirectory;
		if (messages == null) {
			this.messages = new ArrayList();
		}
		else {
			this.messages = messages;
		}
	}

	void sendMessage(String messageType, String phoneNumber, String text, TelephoneDirectory telephoneDirectory) {
		Date messageDate = new Date();
		messages.add(new Message(messageType, telephoneDirectory.searchContactByPhoneNumber(phoneNumber), text,
				messageDate));
	}

	Message sendMessage(String messageType, Contact contact, String text, TelephoneDirectory telephoneDirectory) {
		Date messageDate = new Date();
		Message message = new Message(messageType, contact, text, messageDate);
		message.sendMessage();
		messages.add(message);
		return message;
	}

	void sendMessageAfterSearchByName(Message message, TelephoneDirectory telephoneDirectory) {

	}

	void sendMessageAfterSearchByPhoneNumber(Message message) {

	}
	// ���� ������ ����ó�� ����� ����ó���� Ȯ���ϴ� ���
	// ������ ������ ����ó�� ����� ����ó���� Ȯ���ϴ� ���
	
	List<Message> getMessagesByName(String searchingName) {
		if (telephoneDirectory.searchPhoneNumberByName(searchingName).equals("��ȭ��ȣ����")) {
			return null; //null ���� new ArrayList������ ����
		} else {
			Contact searchingContact = telephoneDirectory.searchContactByName(searchingName);
			List<Message> searchedMessages = new ArrayList();
			
			for(int i = 0; i < messages.size(); i++) {
				if(searchingContact.equals(messages.get(i).getContact())) {
					searchedMessages.add(messages.get(i));
				}
			}
			return searchedMessages;
			// Date ������ �޼����� �����ִ� �޼ҵ� ȣ��
			//showMessages(searchingContact, telephoneDirectory);
		}
	}
}
