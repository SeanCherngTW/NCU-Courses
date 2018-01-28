// Fig. 17.16: AccountRecordSerializable.java
// AccountRecordSerializable class for serializable objects.
package com.deitel.ch17;

import java.io.Serializable;

public class AccountRecordSerializable implements Serializable {

	private static final long serialVersionUID = 7062416958718983473L;
	private String Name;
	private double score1;
	private double score2;

	// no-argument constructor calls other constructor with default values
	public AccountRecordSerializable() {
		this("", 0.0, 0.0);
	} // end no-argument AccountRecordSerializable constructor

	// four-argument constructor initializes a record
	public AccountRecordSerializable(
			String name, double sc1, double sc2) {

		setName(name);
		setScore1(sc1);
		setScore2(sc2);
	} // end four-argument AccountRecordSerializable constructor

	// set account number   

	public void setName(String name) {
		Name = name;
	} // end method setFirstName

	// get first name   
	public String getName() {
		return Name;
	} // end method getFirstName

	// set last name   
	public void setScore1(double sc1) {
		score1 = sc1;
	} // end method setLastName

	// get last name   
	public double getScore1() {
		return score1;
	} // end method getLastName

	// set balance  
	public void setScore2(double sr2) {
		score2 = sr2;
	} // end method setBalance

	// get balance   
	public double getScore2() {
		return score2;
	} // end method getBalance
} // end class AccountRecordSerializable

/*************************************************************************
* (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/