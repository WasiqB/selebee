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
import selebee.interfaces.IOption;

/**
 * @author wasiq.bhamla
 * @since 16-Mar-2017 9:46:23 PM
 */
public class Option extends Clickable implements IOption {
	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 9:46:24 PM
	 * @param parent
	 * @param locator
	 */
	public Option (final IBlock parent, final By locator) {
		super (parent, locator);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 9:46:24 PM
	 * @param parent
	 * @param tag
	 */
	public Option (final IBlock parent, final WebElement tag) {
		super (parent, tag);
	}
}