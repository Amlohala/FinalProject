plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.finalproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.finalproject"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    //add retrofit dependency
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    //recyclerview dependency
    implementation(libs.androidx.recyclerview)

    implementation(libs.hilt.android)
    implementation(libs.androidx.core.testing)
    kapt(libs.hilt.android.compiler)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.inline)
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))


    // ViewModel and LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    implementation("com.google.dagger:hilt-android:2.52")
    kapt ("com.google.dagger:hilt-compiler:2.52")
    implementation ("com.android.volley:volley:1.2.1")
    //Material Design
    implementation("com.google.android.material:material:1.12.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    implementation ("org.mockito:mockito-core:4.11.0")
    testImplementation ("org.mockito:mockito-inline:4.11.0")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")

    // JUnit for unit testing
    testImplementation ("junit:junit:4.13.2")
    // Kotlin Test
    testImplementation ("org.jetbrains.kotlin:kotlin-test-junit:2.0.0")
}


// Allow references to generated code
kapt {
    correctErrorTypes = true
}