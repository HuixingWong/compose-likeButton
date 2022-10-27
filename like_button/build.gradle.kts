import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.MavenPublishBaseExtension

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("com.vanniktech.maven.publish.base")
}

kotlin {
    android {
        publishLibraryVariants("debug", "release")
    }
    jvm("desktop")
    ios()
    iosSimulatorArm64()
    macosX64()
    macosArm64()
    js(IR) {
        browser()
        nodejs()
    }
    sourceSets {
        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
        val commonMain by getting {
            kotlin.srcDir("src/commonMain/compose")
            dependencies {
                api(compose.ui)
                api(compose.foundation)
                api(compose.material3)
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutines}")
            }
        }
        val androidMain by getting {
            kotlin.srcDir("src/androidMain/gif")
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.coroutines}")
                implementation("androidx.compose.ui:ui-graphics:1.4.0-alpha01")
                implementation("androidx.core:core-ktx:1.9.0")
            }
        }
        val desktopMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:${Versions.Kotlin.coroutines}")
            }
        }
        val darwinMain by creating {
            dependsOn(commonMain)
        }
        val iosMain by getting {
            dependsOn(commonMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(commonMain)
        }
        val macosX64Main by getting {
            dependsOn(commonMain)
        }
        val macosArm64Main by getting {
            dependsOn(commonMain)
        }
        val jsMain by getting {
            dependsOn(commonMain)
        }
    }
}

android {
    namespace = "io.github.hx.likebutton"
    compileSdk = Versions.Android.compile
    buildToolsVersion = Versions.Android.buildTools
    defaultConfig {
        minSdk = Versions.Android.min
        targetSdk = Versions.Android.target
    }
    compileOptions {
        sourceCompatibility = Versions.Java.java
        targetCompatibility = Versions.Java.java
    }
}

@Suppress("UnstableApiUsage")
configure<MavenPublishBaseExtension> {
    configure(KotlinMultiplatform())
}
