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

import selebee.interfaces.IBlock;

/**
 * @author wasiq.bhamla
 * @param <TResult>
 * @since 16-Mar-2017 5:34:31 PM
 */
public interface ICheckbox <TResult extends IBlock> extends selebee.interfaces.ICheckbox {
	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 5:35:44 PM
	 * @return result
	 */
	TResult check ();

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 5:35:47 PM
	 * @return result
	 */
	TResult toggle ();

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 5:35:51 PM
	 * @return result
	 */
	TResult uncheck ();
}