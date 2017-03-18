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
package selebee.interfaces.generic;

import org.openqa.selenium.Keys;

import selebee.interfaces.IBlock;

/**
 * @author wasiq.bhamla
 * @param <TResult>
 *            result
 * @since 05-Mar-2017 6:19:35 PM
 */
public interface ITextField <TResult extends IBlock> extends selebee.interfaces.ITextField {
	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 10:01:04 PM
	 * @param text
	 * @return result
	 */
	TResult appendText (String text);

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 10:01:08 PM
	 * @param text
	 * @return result
	 */
	TResult enterText (String text);

	/**
	 * @author wasiq.bhamla
	 * @since 13-Mar-2017 10:01:11 PM
	 * @param key
	 * @return result
	 */
	TResult press (Keys key);
}