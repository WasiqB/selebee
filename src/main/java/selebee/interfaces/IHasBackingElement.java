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

import org.openqa.selenium.WebElement;

/**
 * @author wasiq.bhamla
 * @since 05-Mar-2017 6:02:33 PM
 */
public interface IHasBackingElement {
	/**
	 * @author wasiq.bhamla
	 * @since 05-Mar-2017 6:03:38 PM
	 * @return WebElement
	 */
	WebElement tag ();
}