package Phone;

import java.util.ArrayList;
import java.util.List;

//Ŭ������ ���� �ִ� �ʵ常 ������������ '��'

public class TelephoneDirectory {

	private List<Contact> contacts;

	// ���� �迭 ũ�⺸�� +1��ŭ¥���� �迭 ����?
	// �迭�� ���θ� ���ο� �迭�� �ְ�
	// setContacts�� ȣ���ؼ� ���θ��� �迭�� �־�η�

	// private Scanner scanner = new Scanner(System.in); // �Է� Ŭ�������� ���� ~
	// ����Ŭ���� == ���� Ŭ����?

	
	//is same number
	//is same name
	
	//Ŭ���� �̸� ������

	public TelephoneDirectory(List<Contact> contacts) {
		if( contacts == null )
			this.contacts = new ArrayList();
		else
			this.contacts = contacts;
	}

	void addContact(String name, String phoneNumber){
		contacts.add(new Contact(name, phoneNumber));
	}

	public void deleteContactByName(String name) {
		for (int i = 0; i < contacts.size(); i++) {
			if (name.equals(contacts.get(i).getName()))
				contacts.remove(contacts.get(i));
		}
	}

	public void deleteContactByPhoneNumber(String phoneNumber) {
		for (int i = 0; i < contacts.size(); i++) {
			if (phoneNumber.equals(contacts.get(i).getPhoneNumber()))
				contacts.remove(contacts.indexOf(i));
		}
	}

	// �ܺο��� �����ϴ� �޼ҵ�� public
	public Contact searchContactByName(String name) {
		for (int i = 0; i < contacts.size(); i++) {
			if (name.equals(contacts.get(i).getName()))
				return contacts.get(i);
		}		
		return new Contact();
	}
	
	public Contact searchContactByPhoneNumber(String phoneNumber) {
		for (int i = 0; i < contacts.size(); i++) {
			if (phoneNumber.equals(contacts.get(i).getPhoneNumber()))
				return contacts.get(i);
		}		
		return new Contact();
	}

	String searchPhoneNumberByName(String name) {
		if (searchContactByName(name).isEmpty())
			return "��ȭ��ȣ����";
		
		return searchContactByName(name).getPhoneNumber();
	}

	String searchNameByPhoneNumber(String phoneNumber) {

		if (contacts == null)
			return phoneNumber;

		for (int i = 0; i < contacts.size(); i++) {
			if (phoneNumber.equals(contacts.get(i).getPhoneNumber()))
				return contacts.get(i).getName();
		}

		return phoneNumber; // ����� �̸� ������ �׳� ����ȣ �״�� ���� ����
	}
	
	void changePhoneNumberByName(String name,String phoneNumber) {
		for (int i = 0; i < contacts.size(); i++) {
			if (name.equals(contacts.get(i).getName()))
				contacts.get(i).setPhoneNumber(phoneNumber);
		}	
	}
	void changeNameByPhoneNumber(String name,String phoneNumber) {
		for (int i = 0; i < contacts.size(); i++) {
			if (phoneNumber.equals(contacts.get(i).getPhoneNumber()))
				contacts.get(i).setName(name);
		}
	}
	
	Contact deleteByName(String name) {
		Contact deleteContact = null;
		for (int i = 0; i < contacts.size(); i++) {
			if (name.equals(contacts.get(i).getName()))
				deleteContact = contacts.get(i);
				contacts.remove(i);
				return deleteContact;
		}
		return deleteContact;
	}
	
	Contact deleteByPhoneNumber(String phoneNumber) {
		Contact deleteContact = null;
		for (int i = 0; i < contacts.size(); i++) {
			if (phoneNumber.equals(contacts.get(i).getPhoneNumber()))
				deleteContact = contacts.get(i);
				contacts.remove(i);
				return deleteContact;
		}
		return deleteContact;
	}
}
