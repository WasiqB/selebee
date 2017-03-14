/**
 *    Copyright 2017 Wasiq Amjad Bhamla
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package selebee.setup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selebee.interfaces.IBlock;
import selebee.interfaces.ISpecificBlock;

/**
 * @author wasiq.bhamla
 * @since 12-Mar-2017 10:23:02 PM
 */
@Deprecated
public class GenericBlock {
	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 12:55:44 PM
	 * @param driver
	 * @param cls
	 * @return currentBlock
	 */
	public static <TBlock extends IBlock> TBlock current (final WebDriver driver, final Class <TBlock> cls) {
		return current (driver, null, cls);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 12:53:25 PM
	 * @param driver
	 * @param tag
	 * @param cls
	 * @return currentBlock
	 */
	public static <TBlock extends IBlock> TBlock current (final WebDriver driver, final WebElement tag,
			final Class <TBlock> cls) {
		final List <Class <?>> parameterTypes = new ArrayList <> ();
		parameterTypes.add (WebDriver.class);
		final List <Object> parameters = new ArrayList <> ();
		parameters.add (driver);

		if (cls == ISpecificBlock.class) {
			parameterTypes.add (WebElement.class);
			parameters.add (tag);
		}

		final Class <?> [] argSig = new Class <?> [parameterTypes.size ()];
		parameterTypes.toArray (argSig);
		final Object [] args = new Object [parameters.size ()];
		parameters.toArray (args);

		return initialize (cls, argSig, args);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 2:47:02 PM
	 * @param cls
	 * @param argTypes
	 * @param args
	 * @return result
	 */
	public static <TResult> TResult initialize (final Class <TResult> cls, final Class <?> [] argTypes,
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
}