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

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selebee.interfaces.IBlock;
import selebee.interfaces.IOption;
import selebee.interfaces.ISelectBox;

/**
 * @author wasiq.bhamla
 * @since 16-Mar-2017 9:55:02 PM
 */
public class SelectBox extends Element implements ISelectBox {
	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 9:55:03 PM
	 * @param parent
	 * @param locator
	 */
	public SelectBox (final IBlock parent, final By locator) {
		super (parent, locator);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 9:55:03 PM
	 * @param parent
	 * @param tag
	 */
	public SelectBox (final IBlock parent, final WebElement tag) {
		super (parent, tag);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.ISelectBox#options()
	 */
	@Override
	public List <IOption> options () {
		return findElements (By.tagName ("option")).stream ()
			.filter (e -> e.isDisplayed ())
			.map (e -> new Option (this, e))
			.collect (Collectors.toList ());
	}
}