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
package selebee.setup;

import java.util.Objects;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import selebee.interfaces.IBlock;

/**
 * @author wasiq.bhamla
 * @since 13-Mar-2017 3:11:59 PM
 */
public class Session {
	private WebDriver driver;

	/**
	 * @author wasiq.bhamla
	 * @param environment
	 * @since 13-Mar-2017 3:11:59 PM
	 */
	public Session (final IDriverEnvironment environment) {
		Objects.requireNonNull (environment, "Env cannot be null");
		this.driver = environment.createDriver ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 5:39:11 PM
	 * @return the driver
	 */
	public WebDriver driver () {
		return this.driver;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 11:39:56 PM
	 */
	public void end () {
		if (this.driver != null) {
			this.driver.quit ();
			this.driver = null;
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 11:41:59 PM
	 * @param script
	 * @param args
	 * @return result
	 */
	public <T> T executeJavaScript (final String script, final Object... args) {
		return (T) ((JavascriptExecutor) this.driver).executeScript (script, args);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 11:39:03 PM
	 * @param url
	 * @param target
	 * @return block
	 */
	public <TBlock extends IBlock> TBlock navigateTo (final String url, final Function <Session, TBlock> target) {
		this.driver.navigate ()
			.to (url);
		return target.apply (this);
	}
}