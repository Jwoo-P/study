package Phone;

import java.util.Date;

public class Call {
	private String receiverNumber;
	private String receiverName;
	private String senderNumber;
	private String senderName;
	//private String callingTime;//�̰� ���� ����ϣp?? > ���ֹ��� ������
	private Date callStartTime;
	private Date callEndTime;
	
	
	public String getReceiverNumber() {
		return receiverNumber;
	}
	public void setReceiverNumber(String receiverNumber) {
		this.receiverNumber = receiverNumber;
	}
	public String getSenderNumber() {
		return senderNumber;
	}
	public void setSenderNumber(String senderNumber) {
		this.senderNumber = senderNumber;
	}
	

	
	void showSenderName(String phoneNumber, TelephoneDirectory TelephoneDirectory) {
		System.out.println("�߽��� �̸� : "+ TelephoneDirectory.searchNameByPhoneNumber(phoneNumber));
	}
	
	void receiveCall(String phoneNumber, TelephoneDirectory telephoneDirectory) {
		
		this.senderName = telephoneDirectory.searchNameByPhoneNumber(phoneNumber);
		this.senderNumber = phoneNumber;
		
		this.callStartTime = new Date();
	}
	
	//��ȭ������ ��ȭ��� �����ֱ�

	
	void startCall(String phoneNumber, TelephoneDirectory TelephoneDirectory) {
		this.receiverName = TelephoneDirectory.searchNameByPhoneNumber(phoneNumber);
		this.receiverNumber = phoneNumber;
		this.callStartTime = new Date();
	}
	
	void endCalling() {
		this.callEndTime = new Date();
		
		System.out.println("��ȭ���۽ð� : "+ this.callStartTime);
		System.out.println("��ȭ����ð� : "+ this.callEndTime);
		
		if(this.receiverName == null)
			System.out.println("��ȭ ��� : " + this.senderName);
		if(this.senderName == null)
			System.out.println("��ȭ ��� : " + this.receiverName);
	}
}
