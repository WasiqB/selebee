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
package selebee.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author wasiq.bhamla
 * @since 13-Mar-2017 3:08:13 PM
 */
public class Chrome extends SimpleDriverEnvironment <ChromeDriver> {
	static {
		final String dir = System.getProperty ("user.dir");
		final String path = dir + "/src/test/resources/chromedriver.exe";
		System.setProperty ("webdriver.chrome.driver", path);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 3:08:59 PM
	 */
	public Chrome () {
		super ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 3:08:52 PM
	 * @param timeUnit
	 * @param time
	 */
	public Chrome (final TimeUnit timeUnit, final long time) {
		super (timeUnit, time);
	}
}