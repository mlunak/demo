import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springDocVersion: String by project
val commonsIoVersion: String by project
val funAppDbPwd: String by project

plugins {
    application
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    id("org.flywaydb.flyway") version "9.21.1"
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.spring") version "1.8.22"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springDocVersion")
    implementation("commons-io:commons-io:$commonsIoVersion")
    runtimeOnly("org.postgresql:postgresql")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("cz.capgemini.javateam.JavaTeamApp1Kt")
}

flyway {
    url = "jdbc:postgresql://10.24.15.160:5432/postgres"
    user = "funapp"
    password = funAppDbPwd
    schemas = arrayOf("funapp")
    locations = arrayOf("filesystem:./db/migrations/")
    cleanDisabled = false
}