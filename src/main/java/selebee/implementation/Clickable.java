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
package selebee.implementation;

import java.util.Objects;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selebee.interfaces.IBlock;
import selebee.interfaces.IClickable;
import selebee.interfaces.IElement;

/**
 * @author wasiq.bhamla
 * @since 13-Mar-2017 10:58:32 PM
 */
public class Clickable extends Element implements IClickable {
	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 10:58:32 PM
	 * @param parent
	 * @param locator
	 */
	public Clickable (final IBlock parent, final By locator) {
		super (parent, locator);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 10:58:32 PM
	 * @param parent
	 * @param tag
	 */
	public Clickable (final IBlock parent, final WebElement tag) {
		super (parent, tag);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.IClickable#click(java.util.function.Function)
	 */
	@Override
	public <TResult extends IBlock, T extends IElement> TResult click (final Function <T, TResult> target) {
		Objects.requireNonNull (target);
		tag ().click ();
		return target.apply ((T) this);
	}
}