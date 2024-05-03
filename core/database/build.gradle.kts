plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.evanadwyer.core.database"
}

dependencies {
    implementation(projects.core.domain)

    implementation(libs.org.mongodb.bson)
}