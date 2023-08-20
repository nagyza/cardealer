plugins {
    id("java")
    id("org.springframework.boot") version "2.7.2"
}

apply(plugin = "io.spring.dependency-management")

group = "org.nagyza"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.2")
    implementation("org.springframework.boot:spring-boot-starter-security:2.7.2")
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.2")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.session:spring-session-core:2.7.2")
    implementation("org.springframework.boot:spring-boot-devtools:2.7.2")

    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

    runtimeOnly("com.h2database:h2:2.2.220")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.2")
    testImplementation("org.springframework.security:spring-security-test:5.8.5")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:2.23.4")
}

tasks.test {
    useJUnitPlatform()
}