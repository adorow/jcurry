jcurry 
========

[![Build Status](https://travis-ci.org/adorow/jcurry.svg?branch=master)](https://travis-ci.org/adorow/jcurry) 
[![Maven Central](https://img.shields.io/maven-central/v/com.github.adorow/jcurry.svg?label=version)](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22jcurry%22)

### about

jcurry is a library that extends the main `@FunctionalInterface` interfaces defined in Java8.
The main goal is to add in those interfaces the ability to curry parameters into those interfaces,
(changing this way the functional interface it represents).

The entrypoint is the `jcurry.util.function.Currying` class, where it is required to decorate the given functional interface, to be able to use the extensions.

jcurry requires no additional libraries, it is completely independent (the only requirement is Java8).

Some of the added functionality are:
- currying;
- flipping input parameters;
- composition (where not already applied by Java8).

### using jcurry
#### Maven
```xml
<dependency>
    <groupId>com.github.adorow</groupId>
    <artifactId>jcurry</artifactId>
    <version>1.0.1</version>
</dependency>
```

#### Gradle
```groovy
dependencies {
    compile "com.github.adorow:jcurry:1.0.1"
}
```

### collaborators
- Anderson Dorow (andersondorow@gmail.com)
