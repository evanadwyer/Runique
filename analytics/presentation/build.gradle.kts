plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.evanadwyer.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}