plugins {
    id("java")
    id("checkstyle")
    id("maven-publish")
    id("signing")
    id("jacoco")
}

group = "io.github.hamadhassan3"
version = "2.0.0"

// Extra property to determine if the version is a release version or not
extra["isReleaseVersion"] = !version.toString().endsWith("SNAPSHOT")

// Deployment Sonatype repository urls
val releaseRepo = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
val snapshotRepo = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")

checkstyle {
    toolVersion = "10.12.3"
    maxWarnings = 0
    configFile = file("${rootDir}/checkstyle.xml")
}

jacoco {
    toolVersion = "0.8.10"

    reportsDirectory.set(layout.buildDirectory.dir("reports/jacoco"))
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.mockito:mockito-inline:5.2.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.5.0")

    implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("org.apache.httpcomponents:httpclient:4.5.14")
}

publishing {
    repositories {
        maven {
            url = if (project.extra["isReleaseVersion"] as Boolean) releaseRepo else snapshotRepo
            credentials {
                username = System.getenv("OSSRH_USERNAME") ?: "Unknown user"
                password = System.getenv("OSSRH_PASSWORD") ?: "Unknown password"
            }
        }
    }

    publications {
        create<MavenPublication>("mavenJava") {
            pom {
                groupId = "io.github.hamadhassan3"
                artifactId = "outseta-client"
                name = "Outseta Client"
                description = "A Java Client for easily accessing the Outseta API."
                url = "https://github.com/hamadhassan3/outseta-client"
                from(components.findByName("java"))
                        licenses {
                            license {
                                name = "MIT License"
                                url = "http://www.opensource.org/licenses/mit-license.php"
                            }
                        }
                scm {
                    connection = "git@github.com:hamadhassan3/outseta-client.git"
                    developerConnection = "git@github.com:hamadhassan3/outseta-client.git"
                    url = "https://github.com/hamadhassan3/outseta-client.git"
                }
                developers {
                    developer {
                        id = "hamadhassan3"
                        name = "Hammad Hassan"
                        email = "hamadhassan3@gmail.com"
                        organization = "io.github.hamadhassan3"
                        organizationUrl = "https://github.com/hamadhassan3"
                    }
                }
            }
        }
    }
}

signing {
    useGpgCmd()

    val signingKey: String = System.getenv("GPG_SECRET_KEY") ?: "Unknown key"
    val signingPassword: String = System.getenv("GPG_PASSPHRASE") ?: "Unknown password"
    useInMemoryPgpKeys(signingKey, signingPassword)

    sign(publishing.publications.getByName<MavenPublication>("mavenJava"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withJavadocJar()
    withSourcesJar()
}

tasks.test {
    useJUnitPlatform {
        excludeTags("integration")
    }
    finalizedBy(tasks.jacocoTestReport)
}

tasks.withType<Sign>().configureEach {
    enabled = project.extra["isReleaseVersion"] as Boolean
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    dependsOn(tasks.test)
}

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport)
    violationRules {
        rule {
            limit {
                minimum = BigDecimal(0.95)
            }
        }
    }
}
