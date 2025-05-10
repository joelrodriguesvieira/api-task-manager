// .teamcity/settings.kts na raiz do seu repositorio Node.js

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.*
import jetbrains.buildServer.configs.kotlin.triggers.*
import jetbrains.buildServer.configs.kotlin.vcs.*

versionedSettings {
    mode = VersionedSettings.Mode.ENABLED
}

object IntegracaoContinuaNodeJS : BuildType({
    id("ApiTaskManager")
    name = "api-task-manager"

    vcs {
        root(RelativeId("ApiTaskManager_HttpsGithubComJoelrodriguesvieiraApiTaskManagerRefsHeadsMaster"))
    }

    steps {
        script {
            name = "Instalar Dependencias (npm)"
            workingDir = ""
            scriptContent = """
                npm install
            """.trimIndent()
        }

        script {
            name = "Verificar Compilacao Typescript"
            workingDir = ""
            scriptContent = """
                npx tsc --noEmit
            """.trimIndent()
        }
    }

    triggers {
        vcs {
        }
    }

    artifacts {
    }
})