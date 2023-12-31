plugins {
    `java-library` 
}

repositories {
    mavenCentral() 
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3") 

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    api("org.apache.commons:commons-math3:3.6.1") 

    implementation("com.google.guava:guava:32.1.1-jre")

    // https://mvnrepository.com/artifact/org.sputnikdev/bluetooth-manager
    implementation("org.sputnikdev:bluetooth-manager:1.5.3")

    implementation("org.usb4java:usb4java:1.3.0")

}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
