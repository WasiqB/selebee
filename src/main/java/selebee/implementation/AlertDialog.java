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

import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import selebee.interfaces.IAlertDialog;
import selebee.interfaces.IBlock;
import selebee.setup.Session;

/**
 * @author wasiq.bhamla
 * @since 16-Mar-2017 9:10:25 PM
 */
public class AlertDialog extends Block implements IAlertDialog {
	private final Alert alert;

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 9:11:32 PM
	 * @param session
	 */
	public AlertDialog (final Session session) {
		super (session);
		this.alert = waitForAlert ();
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.IAlertDialog#accept(java.util.function.Function)
	 */
	@Override
	public <TResult extends IBlock> TResult accept (final Function <Session, TResult> target) {
		this.alert.accept ();
		return target.apply (session ());
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.IAlertDialog#dismiss(java.util.function.Function)
	 */
	@Override
	public <TResult extends IBlock> TResult dismiss (final Function <Session, TResult> target) {
		this.alert.dismiss ();
		return target.apply (session ());
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.IAlertDialog#enterText(java.lang.String)
	 */
	@Override
	public IAlertDialog enterText (final String text) {
		for (final char c : text.toCharArray ()) {
			this.alert.sendKeys (Character.toString (c));
		}
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see selebee.interfaces.IHasText#text()
	 */
	@Override
	public String text () {
		return this.alert.getText ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 16-Mar-2017 9:13:44 PM
	 * @return
	 */
	private Alert waitForAlert () {
		final WebDriverWait wait = new WebDriverWait (session ().driver (), 5);
		return wait.until ((com.google.common.base.Function <WebDriver, Alert>) d -> d.switchTo ()
			.alert ());
	}
}