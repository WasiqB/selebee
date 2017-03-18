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
package selebee.implementation;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selebee.interfaces.IBlock;
import selebee.interfaces.INumericField;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 17-Mar-2017 10:00:08 PM
 */
public class NumericField extends TextField implements INumericField {
	/**
	 * @author wasiq.bhamla
	 * @since 17-Mar-2017 10:00:08 PM
	 * @param parent
	 * @param locator
	 */
	public NumericField (final IBlock parent, final By locator) {
		super (parent, locator);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Mar-2017 10:00:08 PM
	 * @param parent
	 * @param tag
	 */
	public NumericField (final IBlock parent, final WebElement tag) {
		super (parent, tag);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.INumericField#enterNumber(double, java.util.function.Function)
	 */
	@Override
	public <TResult extends IBlock> TResult enterNumber (final double value, final Function <Session, TResult> target) {
		return enterText (Double.toString (value), target);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.INumericField#value()
	 */
	@Override
	public double value () {
		return Double.parseDouble (text ());
	}
}