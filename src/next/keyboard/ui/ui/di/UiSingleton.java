/*
 * Copyright 2011 Vancouver Ywebb Consulting Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package next.keyboard.ui.ui.di;

import next.common.ui.ui.kbd.KeyboardPopup;

import com.google.inject.Inject;

/**
 * This class is a workaround as GIN injector creates each time a new instance of the "injectable" classes. Yet for
 * classes such as FormPopup and KeyboardPopup we need to have ONLY one instance.
 * 
 * @author Atanas Roussev ( http://nextinterfaces.com )
 */
public class UiSingleton {

	private static KeyboardPopup keyboardPopup;

	private TabletEventBus tabletEventBus;

	@Inject
	public UiSingleton(TabletEventBus tabletEventBus) {
		this.tabletEventBus = tabletEventBus;
	}

	public KeyboardPopup getKeyboardPopup() {
		if (keyboardPopup == null) {
			keyboardPopup = new KeyboardPopup();
		}
		return keyboardPopup;
	}

}