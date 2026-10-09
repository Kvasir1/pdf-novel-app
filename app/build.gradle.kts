plugins {
    id("com.android.application")
}

// GitHub에서 조립할 때마다 번호가 올라가야 폰이 「새 판」으로 알고 덮어 설치한다
val runNumber = (System.getenv("GITHUB_RUN_NUMBER") ?: "1").toInt()

android {
    namespace = "kr.kvasir.pdfshelf"
    compileSdk = 35

    defaultConfig {
        applicationId = "kr.kvasir.pdfshelf"
        minSdk = 26
        targetSdk = 35
        versionCode = runNumber
        versionName = "1.$runNumber"
    }

    // 서명 키: 저장소에는 넣지 않는다. GitHub 의 Secrets(KEYSTORE_B64)에서 조립 때 풀어 놓는다.
    val ksFile = file("release.keystore")
    signingConfigs {
        create("release") {
            if (ksFile.exists()) {
                storeFile = ksFile
                storePassword = System.getenv("KEYSTORE_PASS") ?: "pdfshelf"
                keyAlias = "pdfshelf"
                keyPassword = System.getenv("KEYSTORE_PASS") ?: "pdfshelf"
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
        debug {
            signingConfig = signingConfigs.getByName("release")
        }
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("androidx.webkit:webkit:1.12.1")
}
