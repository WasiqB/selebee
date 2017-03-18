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
package selebee.interfaces;

import java.util.Date;
import java.util.function.Function;

import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 16-Mar-2017 5:56:13 PM
 */
public interface IDateField extends ITextField {
	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 5:58:25 PM
	 * @param date
	 * @param target
	 * @return result
	 */
	<TResult extends IBlock> TResult enterDate (Date date, Function <Session, TResult> target);

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 5:57:44 PM
	 * @param date
	 * @param format
	 * @param target
	 * @return result
	 */
	<TResult extends IBlock> TResult enterDate (Date date, String format, Function <Session, TResult> target);

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 5:57:55 PM
	 * @return value
	 */
	Date value ();
}