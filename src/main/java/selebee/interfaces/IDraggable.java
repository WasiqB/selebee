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

/**
 * @author wasiq.bhamla
 * @since 05-Mar-2017 6:07:00 PM
 */
public interface IDraggable extends IHasBackingElement {
	/**
	 * @author wasiq.bhamla
	 * @since 05-Mar-2017 6:07:31 PM
	 * @return dragDropPerformer
	 */
	IPerformDragAndDrop getDragDropPerformer ();
}