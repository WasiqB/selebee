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

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selebee.implementation.Element;
import selebee.interfaces.IBlock;
import selebee.interfaces.generic.IOption;
import selebee.interfaces.generic.ISelectBox;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @param <TResult>
 * @since 16-Mar-2017 9:59:35 PM
 */
public class SelectBox <TResult extends IBlock> extends Element implements ISelectBox <TResult> {
	private final Function <Session, TResult> target;

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 10:07:52 PM
	 * @param parent
	 * @param locator
	 * @param target
	 */
	public SelectBox (final IBlock parent, final By locator, final Function <Session, TResult> target) {
		super (parent, locator);
		this.target = target;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 10:07:47 PM
	 * @param parent
	 * @param tag
	 * @param target
	 */
	public SelectBox (final IBlock parent, final WebElement tag, final Function <Session, TResult> target) {
		super (parent, tag);
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.implementation.SelectBox#options()
	 */
	@Override
	public List <IOption <TResult>> options () {
		return findElements (By.tagName ("option")).stream ()
			.filter (e -> e.isDisplayed ())
			.map (e -> new Option <> (this, e, this.target))
			.collect (Collectors.toList ());
	}
}