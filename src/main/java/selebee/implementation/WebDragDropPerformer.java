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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import selebee.interfaces.IPerformDragAndDrop;

/**
 * @author wasiq.bhamla
 * @since 12-Mar-2017 9:40:20 PM
 */
public class WebDragDropPerformer implements IPerformDragAndDrop {
	private final WebDriver driver;

	/**
	 * @author wasiq.bhamla
	 * @since 12-Mar-2017 9:40:37 PM
	 * @param driver
	 */
	public WebDragDropPerformer (final WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.IPerformDragAndDrop#dragAndDrop(org.openqa.selenium.WebElement, int,
	 * int)
	 */
	@Override
	public void dragAndDrop (final WebElement drag, final int x, final int y) {
		new Actions (this.driver).dragAndDropBy (drag, x, y)
			.build ()
			.perform ();
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.IPerformDragAndDrop#dragAndDrop(org.openqa.selenium.WebElement,
	 * org.openqa.selenium.WebElement)
	 */
	@Override
	public void dragAndDrop (final WebElement drag, final WebElement drop) {
		new Actions (this.driver).dragAndDrop (drag, drop)
			.build ()
			.perform ();
	}
}