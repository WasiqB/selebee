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
package selebee.poc.pages.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selebee.implementation.Clickable;
import selebee.implementation.SpecificBlock;
import selebee.interfaces.IClickable;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 25-Mar-2017 7:25:37 PM
 */
public class OrderItem extends SpecificBlock {
	/**
	 * @author wasiq.bhamla
	 * @since 25-Mar-2017 7:25:37 PM
	 * @param session
	 * @param tag
	 */
	public OrderItem (final Session session, final WebElement tag) {
		super (session, tag);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Mar-2017 8:04:24 PM
	 * @return button
	 */
	public IClickable addToCart () {
		return new Clickable (this, By.cssSelector (".button-container a[title='Add to cart']"));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Mar-2017 7:40:23 PM
	 * @return title
	 */
	public IClickable title () {
		return new Clickable (this, By.className ("product-name"));
	}
}