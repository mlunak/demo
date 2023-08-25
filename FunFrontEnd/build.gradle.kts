import com.github.gradle.node.npm.task.NpmTask

plugins {
  id("base")
  id("com.github.node-gradle.node") version "7.0.0" // gradle-node-plugin
}

node {
  tasks.register("funFrontStartTask", NpmTask::class) {
  dependsOn("npmInstall")
  npmCommand.add("start")
    //god, it never ends!
  }
}


