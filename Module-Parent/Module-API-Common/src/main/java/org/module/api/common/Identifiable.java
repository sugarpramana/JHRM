package org.module.api.common;

import java.io.Serializable;

/**
*
* @author formulateko@admin.com
*/
public interface Identifiable<T extends Serializable> {
	T getId();
}