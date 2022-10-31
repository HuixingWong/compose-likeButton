plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.compose")
}

android {
    compileSdk = Versions.Android.compile
    buildToolsVersion = Versions.Android.buildTools
    defaultConfig {
        applicationId = "com.hx.likeButton.demo"
        minSdk = Versions.Android.min
        targetSdk = Versions.Android.target
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.Java.java
        targetCompatibility = Versions.Java.java
    }
}

dependencies {
    implementation(projects.app.common)
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
