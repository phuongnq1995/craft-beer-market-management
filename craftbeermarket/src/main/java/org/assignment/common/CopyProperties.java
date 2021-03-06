package org.assignment.common;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

/**
 * @author Phuongnq
 * CopyProperties
 */
public abstract class CopyProperties {

	private static final String[] ignoreProperties = new String[] 
		{ "createdAt", "createdBy", "updatedAt", "updatedBy"};

	/**
	 * copyProperties
	 * @param source
	 * @param target
	 * @throws BeansException
	 */
	public static void copyProperties(Object source, Object target) throws BeansException {
		BeanUtils.copyProperties(source, target, ignoreProperties);
	}
}
