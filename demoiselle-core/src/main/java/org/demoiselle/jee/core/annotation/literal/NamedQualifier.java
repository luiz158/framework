/*
 * Demoiselle Framework
 *
 * License: GNU Lesser General Public License (LGPL), version 3 or later.
 * See the lgpl.txt file in the root directory or <https://www.gnu.org/licenses/lgpl.html>.
 */
package org.demoiselle.jee.core.annotation.literal;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Named;
import java.lang.annotation.Annotation;

/**
 * Annotation litteral that allows to create instances of the {@link Named} literal.
 * Those instances can then be used to call
 * {@link javax.enterprise.inject.spi.CDI#select(Class subtype, Annotation... qualifiers)}
 *  
 * @see javax.enterprise.inject.spi.CDI
 * @see Named
 * 
 * @author SERPRO
 */
@SuppressWarnings("all")
public class NamedQualifier extends AnnotationLiteral<Named> implements Named {

	private static final long serialVersionUID = 6790759427086052113L;

	private String namedValue;

	public NamedQualifier(String value) {
		namedValue = value;
	}

	public String value() {
		return namedValue;
	}
}
