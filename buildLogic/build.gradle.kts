plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    `kotlin-dsl`
    `maven-publish`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories { gradlePluginPortal() }

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.10")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("test"))
}