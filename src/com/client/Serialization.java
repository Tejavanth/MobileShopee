package com.client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.bean.Brand;
import com.bean.Mobile;
import com.bean.OperatingSystems;
import com.bean.Style;
import com.bean.TypeOfDisplay;
import com.exception.DuplicateIdException;

public class Serialization {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Mobile m1 = new Mobile(1, 35000, OperatingSystems.valueOf("IOS"), Brand.valueOf("Apple"), Style.valueOf("Bar"),
									TypeOfDisplay.valueOf("Touch_Screen"), 5);
		Mobile m2 = new Mobile(2, 30000, OperatingSystems.valueOf("Android"), Brand.valueOf("Samsung"), Style.valueOf("Bar"),
									TypeOfDisplay.valueOf("Touch_Screen"), 2);
		Mobile m3 = new Mobile(3, 32000, OperatingSystems.valueOf("Windows"), Brand.valueOf("HTC"), Style.valueOf("Bar"),
									TypeOfDisplay.valueOf("Touch_Screen"), 3);
		Mobile m4 = new Mobile(4, 12000, OperatingSystems.valueOf("Windows"), Brand.valueOf("HTC"), Style.valueOf("Flip_Up"),
									TypeOfDisplay.valueOf("NoTouch_Screen"), 1);
		Mobile m5 = new Mobile(5, 14000, OperatingSystems.valueOf("Windows"), Brand.valueOf("HTC"), Style.valueOf("Slide"),
									TypeOfDisplay.valueOf("NoTouch_Screen"), 3);
		Mobile m6 = new Mobile(6, 24000, OperatingSystems.valueOf("Android"), Brand.valueOf("LG"), Style.valueOf("Bar"),
									TypeOfDisplay.valueOf("Touch_Screen"), 3);
		Mobile m7 = new Mobile(7, 14000, OperatingSystems.valueOf("Android"), Brand.valueOf("Samsung"), Style.valueOf("Slide"),
									TypeOfDisplay.valueOf("Touch_Screen"), 4);
		Mobile m8 = new Mobile(8, 28000, OperatingSystems.valueOf("Android"), Brand.valueOf("HTC"), Style.valueOf("Bar"),
									TypeOfDisplay.valueOf("Touch_Screen"), 3);
		Mobile m9 = new Mobile(8, 28000, OperatingSystems.valueOf("Windows"), Brand.valueOf("Samsung"), Style.valueOf("Bar"),
									TypeOfDisplay.valueOf("Touch_Screen"), 3);
		Mobile m10 = new Mobile(2, 18000, OperatingSystems.valueOf("Android"), Brand.valueOf("HTC"), Style.valueOf("Slide"),
									TypeOfDisplay.valueOf("Touch_Screen"), 3);
		
		Mobile[] arr = {m1, m2, m3, m4, m5, m6, m7, m8, m9, m10};
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i].getId() == arr[j].getId()) {
					arr[j].setId(0);
				}
			}
		}
		
		saveData(arr);

	}

	private static void saveData(Mobile[] arr) throws FileNotFoundException, IOException {
		
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/Java/examples/mobiledata.ser"));	
		int count = 0;
		for(Mobile m : arr) {
			count++;
			 if(m.getId() != 0) {
				 oos.writeObject(m);
			 }else {
				 try {
					throw new DuplicateIdException("ID already exists");
				} catch (DuplicateIdException e) {
					System.out.println(e.getMessage() + " at line " + count);
				}
			 }
			
	}
	
		oos.close();
	}
}
