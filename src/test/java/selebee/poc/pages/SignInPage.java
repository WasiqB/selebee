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
package selebee.poc.pages;

import org.openqa.selenium.By;

import selebee.implementation.Clickable;
import selebee.implementation.generic.TextField;
import selebee.interfaces.IClickable;
import selebee.interfaces.generic.ITextField;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 14-Mar-2017 7:47:33 PM
 */
public class SignInPage extends MainPage {
	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 7:47:33 PM
	 * @param session
	 */
	public SignInPage (final Session session) {
		super (session);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 7:51:36 PM
	 * @return email
	 */
	public ITextField <SignInPage> email () {
		return new TextField <> (this, By.id ("email"), e -> new SignInPage (session ()));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 7:52:12 PM
	 * @return password
	 */
	public ITextField <SignInPage> password () {
		return new TextField <> (this, By.id ("passwd"), e -> new SignInPage (session ()));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 7:53:34 PM
	 * @return signIn
	 */
	public IClickable signIn () {
		return new Clickable (this, By.id ("SubmitLogin"));
	}
}