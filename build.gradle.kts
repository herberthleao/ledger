import java.util.Properties

plugins {
    java
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    id("org.liquibase.gradle") version "2.2.0"
}

group = "me.herberthleao"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

// Load properties from "application.properties" file.
val properties = Properties()
properties.load(project.rootProject.file("src/main/resources/application.properties").inputStream())

liquibase {
    activities.register("main") {
        this.arguments = mapOf(
            "changelogFile" to properties.getProperty("spring.liquibase.change-log"),
            "url" to properties.getProperty("spring.datasource.url"),
            "username" to properties.getProperty("spring.datasource.username"),
            "password" to properties.getProperty("spring.datasource.password"),
            "logLevel" to "info"
        )
    }
    runList = "main"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.liquibase:liquibase-core")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    liquibaseRuntime("info.picocli:picocli:4.6.1")
    liquibaseRuntime(group = "javax.xml.bind", name = "jaxb-api", version = "2.3.1")
}

configurations {
    compileOnly {
        extendsFrom(annotationProcessor.get())
    }

    liquibaseRuntime {
        // Add dependencies to Liquibase classpath.
        extendsFrom(implementation.get())
        extendsFrom(runtimeOnly.get())
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}