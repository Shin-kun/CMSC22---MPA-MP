public class Account{
	private int accountNumber;
	private double balance;

	Account(){
		accountNumber = 0;
		balance = 0.0;
	}

	Account(int anum, double bal){
		accountNumber = anum;
		setBalance(bal);
	}

	Account(int anum){
		accountNumber = anum;
		balance = 0.0;
	}

	public int getAccountNumber(){
		return accountNumber;
	}

	public double getBalance(){
		return balance;
	}

	public void setBalance(double bal){
		if(bal < 0.0){
			throw new IllegalArgumentException("WONG!");

		}

		balance = bal;
	}

	public void credit(double amount){
		if(amount < 0.0){
			throw new IllegalArgumentException("WONG AGAIN!");
		}

		balance = balance + amount;
	}

	public void debit(double amount){
		if(amount < 0.0){
			throw new IllegalArgumentException("WONG AGAIN and sayup!");
		}

		if(balance >= amount){
			balance = balance - amount;

		}
		else{
			System.out.println("Amount Withdrawn exceeds the current balance!");

		}

	}

	public String toString(){
		String acc;
		acc = String.format("A/C no:%03d, Balance = $%.2f",accountNumber,balance);
		return acc;
	}

}