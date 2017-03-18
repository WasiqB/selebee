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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 14-Mar-2017 5:45:30 PM
 */
public class WebBlock extends Block {
	protected WebDriverWait wait;

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 5:51:52 PM
	 * @param session
	 */
	public WebBlock (final Session session) {
		this (session, 30);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 5:45:30 PM
	 * @param session
	 * @param time
	 */
	public WebBlock (final Session session, final long time) {
		super (session);
		this.wait = new WebDriverWait (session.driver (), time);
		this.tag = this.wait.until ((Function <WebDriver, WebElement>) d -> d.findElement (By.tagName ("body")));
	}
}