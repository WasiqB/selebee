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
package selebee.poc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

import selebee.implementation.WebBlock;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 14-Mar-2017 6:11:22 PM
 */
public class MainPage extends WebBlock {
	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 6:11:22 PM
	 * @param session
	 */
	public MainPage (final Session session) {
		super (session);
		this.tag = this.wait.until ((Function <WebDriver, WebElement>) d -> this.tag.findElement (By.id ("page")));
	}
}