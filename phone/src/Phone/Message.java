package Phone;

import java.util.Date;

public class Message {
	private String messageType;
	private Contact contact;
	private String text;
	private Date textDate;

	Message() {

	}

	Message(String messageType, Contact contact, String text, Date textDate) {
		this.messageType = messageType;
		this.contact = contact;
		this.text = text;
		this.textDate = textDate;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTextDate() {
		return textDate;
	}

	public void setgetTextDate(Date textDate) {
		this.textDate = textDate;
	}

	void setSendTypeMessage(String phoneNumber, String text, TelephoneDirectory telephoneDirectory) {
		// ����ó�� ����� ��� �̸��� ���� �������ִ� �޼ҵ�
		this.contact = new Contact();
		this.contact.setName(telephoneDirectory.searchNameByPhoneNumber(phoneNumber));

		this.contact.setPhoneNumber(phoneNumber);
		this.text = text;
		this.messageType = "send";
		this.textDate = new Date();
	}
	
	void sendMessage() {
		System.out.println("�޼����� �����ϴ�.");//�α�ó�� ����
	}
}
