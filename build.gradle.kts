plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
    id("org.jetbrains.kotlin.kapt") version "1.5.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.21"
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("io.micronaut.application") version "2.0.8"
}

version = "0.1"
group = "com.geekmk"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.geekmk.*")
    }
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation:3.1.4")
    kapt(platform("io.micronaut:micronaut-bom"))
    kapt("io.micronaut:micronaut-inject-java:3.1.4")
    kapt("io.micronaut:micronaut-validation:3.1.4")
    kapt("io.micronaut.data:micronaut-data-processor:3.1.2")
    kapt("io.micronaut.openapi:micronaut-openapi:3.2.0")
    implementation("io.micronaut:micronaut-http-client:3.1.4")
    implementation("io.micronaut:micronaut-runtime:3.1.4")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime:3.0.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.7")
    implementation("io.micronaut:micronaut-validation")
    //JPA
    annotationProcessor("io.micronaut.data:micronaut-data-processor:3.2.0")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa:3.2.0")

    implementation("io.micronaut.sql:micronaut-hibernate-jpa:4.0.4")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari:4.0.4")
    annotationProcessor("io.micronaut.data:micronaut-data-hibernate-jpa:3.1.2")
    runtimeOnly("org.postgresql:postgresql:42.3.1")


    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")

}


application {
    mainClass.set("com.geekmk.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("1.8")
}

kapt {
    arguments {
        arg("micronaut.processing.incremental", true)
        arg("micronaut.processing.annotations", "com.sumup.card.mpts.*")
        arg("micronaut.processing.group", "com.sumup.card.mpts")
        arg("micronaut.processing.module", "mpts")
        arg("micronaut.openapi.views.spec", "redoc.enabled=true,rapidoc.enabled=true,swagger-ui.enabled=true,swagger-ui.theme=flattop")
    }
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }


}
