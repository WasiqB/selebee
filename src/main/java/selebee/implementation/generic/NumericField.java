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
package selebee.implementation.generic;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selebee.interfaces.IBlock;
import selebee.interfaces.generic.INumericField;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @param <TResult>
 * @since 17-Mar-2017 10:05:39 PM
 */
public class NumericField <TResult extends IBlock> extends selebee.implementation.NumericField
		implements INumericField <TResult> {
	private final Function <Session, TResult> target;

	/**
	 * @author wasiq.bhamla
	 * @since 17-Mar-2017 10:08:35 PM
	 * @param parent
	 * @param locator
	 * @param target
	 */
	public NumericField (final IBlock parent, final By locator, final Function <Session, TResult> target) {
		super (parent, locator);
		this.target = target;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Mar-2017 10:08:52 PM
	 * @param parent
	 * @param tag
	 * @param target
	 */
	public NumericField (final IBlock parent, final WebElement tag, final Function <Session, TResult> target) {
		super (parent, tag);
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.generic.INumericField#enterNumber(double)
	 */
	@Override
	public TResult enterNumber (final double value) {
		return enterNumber (value, this.target);
	}
}