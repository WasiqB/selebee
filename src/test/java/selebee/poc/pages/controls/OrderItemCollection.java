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

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import selebee.implementation.Clickable;
import selebee.interfaces.IBlock;

/**
 * @author wasiq.bhamla
 * @since 25-Mar-2017 7:31:42 PM
 */
public class OrderItemCollection extends Clickable {
	private final List <OrderItem> items;

	/**
	 * @author wasiq.bhamla
	 * @since 25-Mar-2017 7:31:42 PM
	 * @param parent
	 * @param locator
	 */
	public OrderItemCollection (final IBlock parent, final By locator) {
		super (parent, locator);
		this.items = findElements (By.cssSelector (".product-container")).stream ()
			.filter (e -> e.isDisplayed ())
			.map (e -> new OrderItem (session (), e))
			.collect (Collectors.toList ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Mar-2017 7:40:57 PM
	 * @param title
	 * @return item
	 */
	public OrderItem item (final String title) {
		return this.items.stream ()
			.filter (i -> i.title ()
				.text ()
				.equals (title))
			.findFirst ()
			.get ();
	}
}