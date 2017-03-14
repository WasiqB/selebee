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

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selebee.interfaces.IBlock;
import selebee.interfaces.IPerformDragAndDrop;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 05-Mar-2017 6:24:51 PM
 */
public abstract class Block implements IBlock {
	protected WebElement	tag;
	private final Session	session;

	/**
	 * @author wasiq.bhamla
	 * @param session
	 * @since 05-Mar-2017 6:24:51 PM
	 */
	public Block (final Session session) {
		this.session = session;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 05-Mar-2017 6:30:08 PM
	 * @param locator
	 * @return WebElement
	 */
	public WebElement findElement (final By locator) {
		if (this.tag == null) {
			throw new NullPointerException ("Tag needs to be initialized first.");
		}
		return this.tag.findElement (locator);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 05-Mar-2017 6:31:06 PM
	 * @param locator
	 * @return List of WebElements
	 */
	public List <WebElement> findElements (final By locator) {
		if (this.tag == null) {
			throw new NullPointerException ("Tag needs to be initialized first.");
		}
		return this.tag.findElements (locator);
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.IDraggable#getDragDropPerformer()
	 */
	@Override
	public IPerformDragAndDrop getDragDropPerformer () {
		return new WebDragDropPerformer (this.session.driver ());
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.IHasDriver#driver()
	 */
	@Override
	public Session session () {
		return this.session;
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.IHasBackingElement#tag()
	 */
	@Override
	public WebElement tag () {
		return this.tag;
	}
}