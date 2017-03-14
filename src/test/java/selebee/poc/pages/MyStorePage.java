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

import com.google.common.base.Predicate;

import selebee.implementation.generic.Clickable;
import selebee.interfaces.generic.IClickable;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 14-Mar-2017 7:55:38 PM
 */
public class MyStorePage extends MainPage {
	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 7:55:38 PM
	 * @param session
	 */
	public MyStorePage (final Session session) {
		super (session);
		this.wait.until ((Predicate <WebDriver>) d -> d.getTitle ()
			.endsWith ("My Store"));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 8:01:07 PM
	 * @return signOut
	 */
	public IClickable <SignInPage> signOut () {
		return new Clickable <> (this, By.className ("logout"), e -> new SignInPage (session ()));
	}
}