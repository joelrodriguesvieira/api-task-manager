// .teamcity/settings.kts na raiz do seu repositorio

import jetbrains.buildServer.configs.kotlin.*

versionedSettings {
    id("ApiTaskManager") // Substitua pelo ID do seu projeto no TeamCity (opcional, pode ser inferido)
    name = "api-task-manager" // Substitua pelo nome do seu projeto (opcional)
    formatVersion = "2023.1" // Ou a versão mais recente que você está usando
    buildNumberCounter = 1
    description = "Settings for YOUR_PROJECT_NAME managed via Kotlin DSL" // Descrição opcional
}

object BasicBuild : BuildType({
    id("BasicBuild") // ID único para esta Build Configuration
    name = "Basic Build"

    vcs {
        root(RelativeId("ApiTaskManager_HttpsGithubComJoelrodriguesvieiraApiTaskManagerRefsHeadsMaster")) // Referencia ao VCS Root definido acima (ou o ID do VCS Root existente na UI)
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
        vcs {
        }
    }
})