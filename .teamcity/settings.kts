import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

version = "2023.1" // Essa linha é obrigatória no settings.kts (não use versionedSettings aqui)

project {
    buildType(BasicBuild)
}

object BasicBuild : BuildType({
    name = "Basic Build"

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
