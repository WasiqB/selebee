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

import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 04-Mar-2017 9:16:28 PM
 */
public interface IHasSession {
	/**
	 * @author wasiq.bhamla
	 * @since 04-Mar-2017 10:21:19 PM
	 * @return session
	 */
	Session session ();
}