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
 * @since 16-Mar-2017 5:53:51 PM
 */
public interface INumericField <TResult extends IBlock> extends selebee.interfaces.INumericField {
	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 5:54:46 PM
	 * @param value
	 * @return result
	 */
	TResult enterNumber (double value);
}