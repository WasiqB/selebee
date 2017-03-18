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
package selebee.setup;

import java.util.function.Function;

/**
 * @author wasiq.bhamla
 * @since 14-Mar-2017 4:55:59 PM
 */
public class ThreadedSession {
	private static final ThreadLocal <Session> session = new ThreadLocal <> ();

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 5:04:41 PM
	 */
	public static void end () {
		if (current () != null) {
			current ().end ();
			current (null);
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 14-Mar-2017 5:03:50 PM
	 * @param env
	 * @return session
	 */
	public static <TDriver extends IDriverEnvironment> Session with (final Function <ThreadedSession, TDriver> env) {
		end ();
		current (new Session (env.apply (new ThreadedSession ())));
		return current ();
	}

	private static Session current () {
		return session.get ();
	}

	private static void current (final Session instance) {
		session.set (instance);
	}
}