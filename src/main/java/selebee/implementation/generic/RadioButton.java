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
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @param <TResult>
 * @since 18-Mar-2017 12:15:30 PM
 */
public class RadioButton <TResult extends IBlock> extends Option <TResult> {
	/**
	 * @author wasiq.bhamla
	 * @since 18-Mar-2017 12:17:12 PM
	 * @param parent
	 * @param locator
	 * @param target
	 */
	public RadioButton (final IBlock parent, final By locator, final Function <Session, TResult> target) {
		super (parent, locator, target);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 18-Mar-2017 12:17:16 PM
	 * @param parent
	 * @param tag
	 * @param target
	 */
	public RadioButton (final IBlock parent, final WebElement tag, final Function <Session, TResult> target) {
		super (parent, tag, target);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.implementation.Element#text()
	 */
	@Override
	public String text () {
		final String locator = "label[for=\"" + tag ().getAttribute ("id") + "\"]";
		return parentBlock ().tag ()
			.findElement (By.cssSelector (locator))
			.getText ();
	}
}