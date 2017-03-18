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
package selebee.implementation;

import org.openqa.selenium.WebElement;

import selebee.interfaces.ISpecificBlock;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 12-Mar-2017 9:44:56 PM
 */
public abstract class SpecificBlock extends Block implements ISpecificBlock {
	/**
	 * @author wasiq.bhamla
	 * @since 12-Mar-2017 9:44:56 PM
	 * @param session
	 * @param tag
	 */
	public SpecificBlock (final Session session, final WebElement tag) {
		super (session);
		this.tag = tag;
	}
}