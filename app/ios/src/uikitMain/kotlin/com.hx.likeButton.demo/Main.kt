/*
 *  Mask-Android
 *
 *  Copyright (C) 2022  DimensionDev and Contributors
 *
 *  This file is part of Mask X.
 *
 *  Mask-Android is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Mask-Android is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with Mask-Android.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.hx.like.demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import kotlinx.cinterop.autoreleasepool
import kotlinx.cinterop.cstr
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toCValues
import platform.Foundation.NSStringFromClass
import platform.UIKit.UIApplication
import platform.UIKit.UIApplicationDelegateProtocol
import platform.UIKit.UIApplicationDelegateProtocolMeta
import platform.UIKit.UIApplicationMain
import platform.UIKit.UIResponder
import platform.UIKit.UIResponderMeta
import platform.UIKit.UIScreen
import platform.UIKit.UIWindow

fun main() {

  val args = emptyArray<String>()
  memScoped {
    val argc = args.size + 1
    val argv = (arrayOf("skikoApp") + args).map { it.cstr.ptr }.toCValues()
    autoreleasepool {
      UIApplicationMain(argc, argv, null, NSStringFromClass(SkikoAppDelegate))
    }
  }
}

class SkikoAppDelegate : UIResponder, UIApplicationDelegateProtocol {
  companion object : UIResponderMeta(), UIApplicationDelegateProtocolMeta

  @OverrideInit
  constructor() : super()

  private var _window: UIWindow? = null
  override fun window() = _window
  override fun setWindow(window: UIWindow?) {
    _window = window
  }

  override fun application(application: UIApplication, didFinishLaunchingWithOptions: Map<Any?, *>?): Boolean {
    window = UIWindow(frame = UIScreen.mainScreen.bounds).apply {
      rootViewController = Application("Compose likeButton") {
        Column {
          // To skip upper part of screen.
          Spacer(modifier = Modifier.height(30.dp))
          App()
        }
      }
      makeKeyAndVisible()
    }
    return true
  }
}
