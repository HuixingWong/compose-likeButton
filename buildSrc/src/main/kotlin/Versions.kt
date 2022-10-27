import org.gradle.api.JavaVersion

object Versions {

    object Android {
        const val min = 21
        const val compile = 33
        const val target = compile
        const val buildTools = "33.0.0"
    }

    object Kotlin {
        const val lang = "1.7.10"
        const val coroutines = "1.6.3"
        const val serialization = "1.3.3"
    }

    object Java {
        const val jvmTarget = "11"
        val java = JavaVersion.VERSION_11
    }

    const val spotless = "6.7.2"
    const val ktlint = "0.43.0"
    const val compose_jb = "1.2.0-beta02"
    const val composeCompiler = "1.3.0"
}