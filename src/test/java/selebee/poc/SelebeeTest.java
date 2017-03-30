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
package selebee.poc;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import selebee.poc.pages.MyStorePage;
import selebee.poc.pages.OrderItemPage;
import selebee.poc.pages.SignInPage;
import selebee.setup.Chrome;
import selebee.setup.ThreadedSession;

/**
 * @author wasiq.bhamla
 * @since 14-Mar-2017 5:43:01 PM
 */
public class SelebeeTest {
	private static final String	url	= "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	private MyStorePage			storePage;

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 8:43:09 PM
	 */
	@AfterSuite
	public void teardown () {
		ThreadedSession.end ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 8:12:36 PM
	 */
	@Test
	public void test1 () {
		this.storePage = ThreadedSession.with (e -> new Chrome ())
			.navigateTo (url, e -> new SignInPage (e))
			.email ()
			.enterText ("wasbhamla2005@gmail.com")
			.password ()
			.enterText ("Wasiq@786")
			.signIn ()
			.click (e -> new MyStorePage (e));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Mar-2017 7:06:40 PM
	 */
	@Test
	public void test2 () {
		this.storePage = this.storePage.option ("DRESSES")
			.click ()
			.option ("CASUAL DRESSES")
			.click ()
			.items ()
			.item ("Printed Dress")
			.title ()
			.click (e -> new OrderItemPage (e))
			.addToCart ()
			.click (e -> new MyStorePage (e));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Mar-2017 7:18:56 PM
	 */
	@Test
	public void test3 () {
		this.storePage.signOut ()
			.click ();
	}
}