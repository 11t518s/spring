plugins {
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("org.springframework.boot") version "2.7.18"
	id("com.google.cloud.tools.jib") version "3.1.1"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

jib {
	from {
		image = "arm64v8/openjdk:17-slim"
	}
	to {
		image = "choiderrick/spring"
		tags = setOf("latest", "1.0.1")
	}
	container {
		ports = listOf("8080")
		jvmFlags = listOf("-Xms512m", "-Xmx1024m")
		mainClass = "com.example.demo.DemoApplicationKt"
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.flywaydb:flyway-core:9.16.0")
	implementation("org.flywaydb:flyway-mysql:8.0.33")
	runtimeOnly("mysql:mysql-connector-java:8.0.33")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
