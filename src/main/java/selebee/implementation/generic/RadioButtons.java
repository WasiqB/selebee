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

import selebee.interfaces.IBlock;
import selebee.interfaces.generic.IOption;
import selebee.interfaces.generic.IRadioButton;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @param <TResult>
 * @since 18-Mar-2017 12:36:35 PM
 */
public class RadioButtons <TResult extends IBlock> extends Clickable <TResult> implements IRadioButton <TResult> {
	/**
	 * @author wasiq.bhamla
	 * @since 18-Mar-2017 12:38:54 PM
	 * @param parent
	 * @param locator
	 * @param target
	 */
	public RadioButtons (final IBlock parent, final By locator, final Function <Session, TResult> target) {
		super (parent, locator, target);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.generic.IRadioButton#options()
	 */
	@Override
	public List <IOption <TResult>> options () {
		return findElements (By.tagName ("option")).stream ()
			.filter (e -> e.isDisplayed ())
			.map (e -> new RadioButton <> (this, e, this.target))
			.collect (Collectors.toList ());
	}
}