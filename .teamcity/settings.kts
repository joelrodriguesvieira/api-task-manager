import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

version = "2023.1"

project {
    buildType(BasicBuild)
}

object BasicBuild : BuildType({
    name = "Basic Build"

    // 🔧 ESSA É A POSIÇÃO CORRETA
    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            name = "Hello World"
            scriptContent = """
                echo "Hello from TeamCity!"
            """.trimIndent()
        }
    }

    triggers {
        vcs { }
    }
})
