/**
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package selebee.setup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

import org.openqa.selenium.InvalidArgumentException;

/**
 * @author wasiq.bhamla
 * @param <T>
 * @since 13-Mar-2017 2:55:08 PM
 */
public abstract class GenericFactory <T> {
	private static <TResult> TResult initialize (final Class <TResult> cls, final Class <?> [] argTypes,
			final Object [] args) {
		try {
			final Constructor <TResult> ctor = cls.getDeclaredConstructor (argTypes);
			if (ctor == null) {
				throw new InvalidArgumentException ("Constructor not found.");
			}
			return ctor.newInstance (args);
		}
		catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace ();
		}
		return null;
	}

	protected <E> T init (final E... args) {
		try {
			final ParameterizedType pt = (ParameterizedType) getClass ().getGenericSuperclass ();
			final String parameterClassName = pt.getActualTypeArguments () [0].toString ()
				.split ("\\s") [1];
			final Class <T> cls = (Class <T>) Class.forName (parameterClassName);
			final Class <?> [] argTypes = new Class <?> [args.length];
			for (int i = 0; i < args.length; i++) {
				argTypes [i] = args [i].getClass ();
			}
			return initialize (cls, argTypes, args);
		}
		catch (final ClassNotFoundException e) {
			e.printStackTrace ();
		}
		return null;
	}
}