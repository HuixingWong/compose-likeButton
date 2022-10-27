package com.hx.like.demo

import androidx.compose.ui.window.Window
import platform.AppKit.NSApp
import platform.AppKit.NSApplication

fun main() {
  NSApplication.sharedApplication()
  Window("ComposeLikeButton") {
    App()
  }
  NSApp?.run()
}
