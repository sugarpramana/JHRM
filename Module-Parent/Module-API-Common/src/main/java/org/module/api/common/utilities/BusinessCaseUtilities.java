package org.module.api.common.utilities;

/**
*
* @author formulateko@admin.com
*/
public final class BusinessCaseUtilities {
	/**
	 * Fungsi untuk menggabungkan FIRST NAME, MIDDLE NAME, LAST NAME.
	 *  
	 * @param firstName Berisikan nilai FIRST NAME dengan tipe {@link java.lang.String}
	 * @param middleName Berisikan nilai FIRST NAME dengan tipe {@link java.lang.String}
	 * @param lastName Berisikan nilai FIRST NAME dengan tipe {@link java.lang.String}
	 * @return Bentuk gabungan (FULL NAME) dengan tipe {@link java.lang.String}
	 */
	public static String composeFullName(String firstName, String middleName, String lastName) {
		String fullName = "";
		
		if (firstName != null) {
			if (!firstName.isEmpty()) {
				fullName += firstName + " ";
			}
		} else {
			fullName += "";
		}
		
		if (middleName != null) {
			if (!middleName.isEmpty()) {
				fullName += middleName + " ";
			}
		} else {
			fullName += "";
		}
		
		if (lastName != null) {
			if (!lastName.isEmpty()) {
				fullName += lastName;
			}
		} else {
			fullName += "";
		}
		
		return fullName;
	}
}