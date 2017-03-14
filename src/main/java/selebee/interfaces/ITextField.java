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
package selebee.interfaces;

import java.util.function.Function;

import org.openqa.selenium.Keys;

/**
 * @author wasiq.bhamla
 * @since 05-Mar-2017 6:16:57 PM
 */
public interface ITextField extends IElement, IHasText {
	/**
	 * @author wasiq.bhamla
	 * @since 05-Mar-2017 6:18:35 PM
	 * @param text
	 * @param target
	 * @return result
	 */
	<TResult extends IBlock, T extends IElement> TResult appendText (String text, Function <T, TResult> target);

	/**
	 * @author wasiq.bhamla
	 * @since 05-Mar-2017 6:18:39 PM
	 * @param text
	 * @param target
	 * @return result
	 */
	<TResult extends IBlock, T extends IElement> TResult enterText (String text, Function <T, TResult> target);

	/**
	 * @author wasiq.bhamla
	 * @since 05-Mar-2017 6:18:42 PM
	 * @param key
	 * @param target
	 * @return result
	 */
	<TResult extends IBlock, T extends IElement> TResult press (Keys key, Function <T, TResult> target);
}