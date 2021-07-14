package Phone;

import java.util.ArrayList;
import java.util.List;

//클래스가 갖고 있는 필드만 조물딱조물딱 'ㅅ'

public class TelephoneDirectory {

	private List<Contact> contacts;

	// 본래 배열 크기보다 +1만큼짜리의 배열 생성?
	// 배열의 전부를 새로운 배열에 넣고
	// setContacts를 호출해서 새로만든 배열을 넣어부러

	// private Scanner scanner = new Scanner(System.in); // 입력 클래스에만 쓴다 ~
	// 실행클래스 == 메인 클래스?

	
	//is same number
	//is same name
	
	//클래스 이름 ㅋㅋㅋ

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

	// 외부에서 실행하는 메소드라 public
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
			return "전화번호음슴";
		
		return searchContactByName(name).getPhoneNumber();
	}

	String searchNameByPhoneNumber(String phoneNumber) {

		if (contacts == null)
			return phoneNumber;

		for (int i = 0; i < contacts.size(); i++) {
			if (phoneNumber.equals(contacts.get(i).getPhoneNumber()))
				return contacts.get(i).getName();
		}

		return phoneNumber; // 저장된 이름 없으면 그냥 폰번호 그대로 리턴 ㄱㄱ
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
