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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selebee.interfaces.IBlock;

/**
 * @author wasiq.bhamla
 * @since 12-Mar-2017 9:46:54 PM
 */
public abstract class Element extends SpecificBlock {
	private final IBlock parentBlock;

	/**
	 * @author wasiq.bhamla
	 * @param parent
	 * @param locator
	 * @since 12-Mar-2017 9:46:54 PM
	 */
	public Element (final IBlock parent, final By locator) {
		super (parent.session (), parent.tag ()
			.findElement (locator));
		this.parentBlock = parent;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Mar-2017 10:18:18 PM
	 * @param parent
	 * @param tag
	 */
	public Element (final IBlock parent, final WebElement tag) {
		super (parent.session (), tag);
		this.parentBlock = parent;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Mar-2017 10:18:41 PM
	 * @return the parentBlock
	 */
	public IBlock parentBlock () {
		return this.parentBlock;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Mar-2017 10:20:37 PM
	 * @return selected
	 */
	public boolean selected () {
		return tag ().isSelected ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Mar-2017 10:20:04 PM
	 * @return text
	 */
	public String text () {
		return tag ().getText ();
	}
}