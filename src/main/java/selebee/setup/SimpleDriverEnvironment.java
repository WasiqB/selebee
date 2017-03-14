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

import org.openqa.selenium.WebDriver;

/**
 * @author wasiq.bhamla
 * @param <TDriver>
 * @since 13-Mar-2017 2:48:25 PM
 */
public abstract class SimpleDriverEnvironment <TDriver extends WebDriver> extends GenericFactory <TDriver>
		implements IDriverEnvironment {
	private final long		time;
	private final TimeUnit	timeUnit;

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 3:04:10 PM
	 */
	public SimpleDriverEnvironment () {
		this (TimeUnit.SECONDS, 10);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 3:04:40 PM
	 * @param timeUnit
	 * @param time
	 */
	public SimpleDriverEnvironment (final TimeUnit timeUnit, final long time) {
		this.timeUnit = timeUnit;
		this.time = time;
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.setup.IDriverEnvironment#createDriver()
	 */
	@Override
	public TDriver createDriver () {
		final TDriver driver = init ();
		driver.manage ()
			.timeouts ()
			.implicitlyWait (this.time, this.timeUnit);
		driver.manage ()
			.window ()
			.maximize ();
		return driver;
	}
}