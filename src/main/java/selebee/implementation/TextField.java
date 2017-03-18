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

import java.util.Objects;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import selebee.interfaces.IBlock;
import selebee.interfaces.ITextField;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 13-Mar-2017 9:27:37 PM
 */
public class TextField extends Element implements ITextField {
	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 9:27:38 PM
	 * @param parent
	 * @param locator
	 */
	public TextField (final IBlock parent, final By locator) {
		super (parent, locator);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 9:27:38 PM
	 * @param parent
	 * @param tag
	 */
	public TextField (final IBlock parent, final WebElement tag) {
		super (parent, tag);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.ITextField#appendText(java.lang.String, java.util.function.Function)
	 */
	@Override
	public <TResult extends IBlock> TResult appendText (final String text, final Function <Session, TResult> target) {
		Objects.requireNonNull (target);
		for (final char c : text.toCharArray ()) {
			tag ().sendKeys (Character.toString (c));
		}
		return target.apply (session ());
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.ITextField#enterText(java.lang.String, java.util.function.Function)
	 */
	@Override
	public <TResult extends IBlock> TResult enterText (final String text, final Function <Session, TResult> target) {
		tag ().clear ();
		return appendText (text, target);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.ITextField#press(org.openqa.selenium.Keys,
	 * java.util.function.Function)
	 */
	@Override
	public <TResult extends IBlock> TResult press (final Keys key, final Function <Session, TResult> target) {
		Objects.requireNonNull (target);
		tag ().sendKeys (key);
		return target.apply (session ());
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.implementation.Element#text()
	 */
	@Override
	public String text () {
		return tag ().getAttribute ("value");
	}
}