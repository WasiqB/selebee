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
package selebee.implementation.generic;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selebee.interfaces.IBlock;
import selebee.interfaces.generic.IClickable;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @param <TResult>
 * @since 13-Mar-2017 11:02:23 PM
 */
public class Clickable <TResult extends IBlock> extends selebee.implementation.Clickable
		implements IClickable <TResult> {
	private final Function <Session, TResult> target;

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 11:02:23 PM
	 * @param parent
	 * @param locator
	 * @param target
	 */
	public Clickable (final IBlock parent, final By locator, final Function <Session, TResult> target) {
		super (parent, locator);
		this.target = target;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 11:02:23 PM
	 * @param parent
	 * @param tag
	 * @param target
	 */
	public Clickable (final IBlock parent, final WebElement tag, final Function <Session, TResult> target) {
		super (parent, tag);
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.generic.IClickable#click()
	 */
	@Override
	public TResult click () {
		return click (this.target);
	}
}