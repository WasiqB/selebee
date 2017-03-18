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
import selebee.interfaces.generic.ICheckbox;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @param <TResult>
 * @since 16-Mar-2017 9:40:31 PM
 */
public class Checkbox <TResult extends IBlock> extends selebee.implementation.Checkbox implements ICheckbox <TResult> {
	private final Function <Session, TResult> target;

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 9:40:31 PM
	 * @param parent
	 * @param locator
	 * @param target
	 */
	public Checkbox (final IBlock parent, final By locator, final Function <Session, TResult> target) {
		super (parent, locator);
		this.target = target;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 9:40:31 PM
	 * @param parent
	 * @param tag
	 * @param target
	 */
	public Checkbox (final IBlock parent, final WebElement tag, final Function <Session, TResult> target) {
		super (parent, tag);
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.generic.ICheckbox#check()
	 */
	@Override
	public TResult check () {
		return check (this.target);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.generic.ICheckbox#toggle()
	 */
	@Override
	public TResult toggle () {
		return toggle (this.target);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.generic.ICheckbox#uncheck()
	 */
	@Override
	public TResult uncheck () {
		return uncheck (this.target);
	}
}