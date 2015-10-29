/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.test.Verifies;

/**
 * This class tests all methods that are not getter or setters in the {@link org.openmrs.OrderType}
 * java object this test class for {@link org.openmrs.OrderType}
 * 
 * @see org.openmrs.OrderType
 */
public class OrderTypeTest {
	
	/**
	 * @see org.openmrs.OrderType#getJavaClass()
	 */
	@Test
	@Verifies(value = "should get java class String as class", method = "getJavaClassObject()")
	public void setJavaClass_shouldGetJavaClassObject() throws Exception {
		//Create a new OrderType
		OrderType orderType = new OrderType();
		
		//Test with Integer class
		Class clazz = Integer.class;
		
		orderType.setJavaClassName(clazz.getName());
		Assert.assertEquals(clazz, orderType.getJavaClass());
	}
	
	/**
	 * @verifies add the specified concept class
	 * @see OrderType#addConceptClass(ConceptClass)
	 */
	@Test
	public void addConceptClass_shouldAddTheSpecifiedConceptClass() throws Exception {
		OrderType ot = new OrderType();
		ConceptClass cc = new ConceptClass();
		ot.addConceptClass(cc);
		assertTrue(ot.getConceptClasses().contains(cc));
	}
	
	/**
	 * Ensures that if the collection implementation gets changed from a set, that duplicates are
	 * not added
	 * 
	 * @verifies not add a duplicate concept class
	 * @see OrderType#addConceptClass(ConceptClass)
	 */
	@Test
	public void addConceptClass_shouldNotAddADuplicateConceptClass() throws Exception {
		OrderType ot = new OrderType();
		ConceptClass cc1 = new ConceptClass();
		ot.addConceptClass(cc1);
		ot.addConceptClass(cc1);
		assertTrue(ot.getConceptClasses().contains(cc1));
		assertEquals(1, ot.getConceptClasses().size());
	}
}
