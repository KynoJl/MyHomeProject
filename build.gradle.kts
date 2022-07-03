import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import javax.management.remote.JMXConnectionNotification.FAILED


plugins {
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    kotlin("plugin.jpa") version "1.5.31"
}

group = "com.example.projecthome"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(group = "org.springframework.boot", name = "spring-boot-starter-test")
    testImplementation(group = "org.springframework.kafka", name = "spring-kafka-test")
    testImplementation(group = "com.h2database", name = "h2")
    testImplementation(group = "io.mockk", name = "mockk", version = "1.12.2")
    testImplementation(group = "io.kotest", name = "kotest-runner-junit5", version = "4.6.4")
    testImplementation(group = "org.jeasy", name = "easy-random-core", version = "5.0.0")



    implementation("junit:junit:3.8.2")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.10")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("io.kotest:kotest-runner-junit5:4.6.3")
    testImplementation("io.mockk:mockk:1.12.2")



    implementation("org.jeasy:easy-random-core:5.0.0")



    implementation(group = "org.liquibase", name = "liquibase-core")

//    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs = listOf("-Xjsr305=strict")
//        jvmTarget = "11"
//    }
//}
//tasks {
//
//
//    compileKotlin {
//        kotlinOptions {
//            languageVersion = "1.5"
//            apiVersion = "1.5"
//        }
//    }
//    compileTestKotlin {
//        kotlinOptions {
//            languageVersion = "1.5"
//            apiVersion = "1.5"
//        }
//    }
//
//
//    test {
//        testLogging {
//            showExceptions = true
//            showCauses = true
//            showStackTraces = true
//        }
//    }
//}
tasks.test {
    // Use the built-in JUnit support of Gradle.
    useJUnitPlatform()
}