package Phone;

import java.util.Date;

public class Call {
	private String receiverNumber;
	private String receiverName;
	private String senderNumber;
	private String senderName;
	//private String callingTime;//이거 어케 계산하즤?? > 없애버려 ㅋㅋㅋ
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
		System.out.println("발신자 이름 : "+ TelephoneDirectory.searchNameByPhoneNumber(phoneNumber));
	}
	
	void receiveCall(String phoneNumber, TelephoneDirectory telephoneDirectory) {
		
		this.senderName = telephoneDirectory.searchNameByPhoneNumber(phoneNumber);
		this.senderNumber = phoneNumber;
		
		this.callStartTime = new Date();
	}
	
	//통화끝나면 통화기록 보여주기

	
	void startCall(String phoneNumber, TelephoneDirectory TelephoneDirectory) {
		this.receiverName = TelephoneDirectory.searchNameByPhoneNumber(phoneNumber);
		this.receiverNumber = phoneNumber;
		this.callStartTime = new Date();
	}
	
	void endCalling() {
		this.callEndTime = new Date();
		
		System.out.println("통화시작시간 : "+ this.callStartTime);
		System.out.println("통화종료시간 : "+ this.callEndTime);
		
		if(this.receiverName == null)
			System.out.println("통화 상대 : " + this.senderName);
		if(this.senderName == null)
			System.out.println("통화 상대 : " + this.receiverName);
	}
}
