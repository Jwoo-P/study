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
	// 보낸 문자의 연락처가 저장된 연락처인지 확인하는 기능
	// 수신한 문자의 연락처가 저장된 연락처인지 확인하는 기능
	
	List<Message> getMessagesByName(String searchingName) {
		if (telephoneDirectory.searchPhoneNumberByName(searchingName).equals("전화번호음슴")) {
			return null; //null 인지 new ArrayList인지는 선택
		} else {
			Contact searchingContact = telephoneDirectory.searchContactByName(searchingName);
			List<Message> searchedMessages = new ArrayList();
			
			for(int i = 0; i < messages.size(); i++) {
				if(searchingContact.equals(messages.get(i).getContact())) {
					searchedMessages.add(messages.get(i));
				}
			}
			return searchedMessages;
			// Date 순으로 메세지를 보여주는 메소드 호출
			//showMessages(searchingContact, telephoneDirectory);
		}
	}
}
