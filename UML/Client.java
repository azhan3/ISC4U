package UML;

import java.util.ArrayList;
import java.util.List;

class Client {
    private String name;
    private Contact contactInfo;
    private int ID;
    private int cardNumber;
    private List<Account> accounts;

    public Client(String name, Contact contactInfo, int ID, int cardNumber) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.ID = ID;
        this.cardNumber = cardNumber;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void changeInfo(Contact newContactInfo) {
        contactInfo = newContactInfo;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Contact contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

	public static void main(String[] args) {
		Client testClient = new Client("John", new Contact("613-111-1111", "John@gmail.com"), 1, 1111111111);
		testClient.addAccount(new Checking(1, 1000, 100));
		testClient.getAccounts().get(0).deposit(30);
		testClient.getAccounts().get(0).withdraw(600);
		for (Transaction i : testClient.getAccounts().get(0).getTransactions()) {
			i.PrintInfo();
			System.out.println();
		}
		testClient.getAccounts().get(0).displayAccountInfo();
	}
}
