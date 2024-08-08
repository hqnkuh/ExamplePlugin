plugins {
    id("java")
    id("xyz.jpenilla.run-paper") version "2.3.0"
}

group = providers.gradleProperty("plugin_group").get()
version = providers.gradleProperty("plugin_version").get()
description = providers.gradleProperty("plugin_description").get()

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:${providers.gradleProperty("minecraft_version").get()}-R0.1-SNAPSHOT")
}

tasks.runServer {
    minecraftVersion(providers.gradleProperty("minecraft_version").get())
}

tasks.processResources {
    val props =
        mapOf(
            "name" to rootProject.name,
            "version" to project.version,
            "group" to project.group,
            "description" to project.description,
            "repository" to providers.gradleProperty("plugin_repository").get(),
            "author" to providers.gradleProperty("plugin_author").get(),
        )
    filteringCharset = "UTF-8"
    inputs.properties(props)
    filesMatching("**/*.yml") {
        expand(props)
    }
}
