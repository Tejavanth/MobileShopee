package com.client;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.bean.Mobile;
import com.exception.OutOfStockException;

public class De_Serialization {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/Java/examples/mobiledata.ser"));
		
		initializeMobileShoppeeDate(ois);
		
	}

	

public static void initializeMobileShoppeeDate(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		
		Mobile m = null;

		try {
			while(true) {
				m = (Mobile) ois.readObject();

				if(m.getQuantity() > 0) {
					
					System.out.println(m.getId() + " " + m.getCost() + " " + m.getOperatingSystems() + " " + 
									m.getBrand() + " " + m. getStyle() + " " + m .getTypeOfDisplay() +  " " + m.getQuantity());
				}else {
					try {
						throw new OutOfStockException("Mobile Out of Stock!!!!");
					} catch (OutOfStockException e) {
						System.out.println(e.getMessage());
						
					}
				}
			}
			
		} catch (EOFException e2) {
			System.out.println("Reached EOF");
		}

		ois.close();
		
	}	

}
