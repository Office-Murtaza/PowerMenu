/*
 * Copyright (C) 2017 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused")

package com.skydoves.powermenu.kotlin

import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import com.skydoves.powermenu.MaterialPowerMenu
import com.skydoves.powermenu.PowerMenu
import kotlin.reflect.KClass

/** returns a [Lazy] delegate to access the [ComponentActivity]'s [PowerMenu] property. */
@MainThread
@JvmSynthetic
inline fun <reified T : PowerMenu.Factory> ComponentActivity.powerMenu(
  factory: KClass<T>
): Lazy<PowerMenu> {
  return ActivityPowerMenuLazy(this, this, factory)
}

/** returns a [Lazy] delegate to access the [Fragment]'s [PowerMenu] property. */
@MainThread
@JvmSynthetic
inline fun <reified T : PowerMenu.Factory> Fragment.powerMenu(
  factory: KClass<T>
): Lazy<PowerMenu?> {
  return FragmentPowerMenuLazy(this, factory)
}

/** returns a [Lazy] delegate to access the [ComponentActivity]'s [MaterialPowerMenu] property. */
@MainThread
@JvmSynthetic
inline fun <reified T : MaterialPowerMenu.Factory> ComponentActivity.materialPowerMenu(
  factory: KClass<T>
): Lazy<MaterialPowerMenu> {
  return ActivityMaterialPowerMenuLazy(this, this, factory)
}

/** returns a [Lazy] delegate to access the [Fragment]'s [MaterialPowerMenu] property. */
@MainThread
@JvmSynthetic
inline fun <reified T : MaterialPowerMenu.Factory> Fragment.materialPowerMenu(
  factory: KClass<T>
): Lazy<MaterialPowerMenu?> {
  return FragmentMaterialPowerMenuLazy(this, factory)
}
