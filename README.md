algs4partI
==========

A [Gradle](http://gradle.org) build template for Coursera's [Algorithms, Part I](https://www.coursera.org/course/algs4partI) course.

**Don't abuse this project for sharing solutions to assignments!**

To prevent accidental sharing, `.gitignore` excludes all `src` directories.

Prerequisites
-------------

All you need to get started is a JDK installation (1.5 or higher). Make sure that
running `java -version` from the command line succeeds.

Getting started
---------------

Clone this project from GitHub or download and extract its zipball. The first time
you invoke the top-level `gradlew` (*nix) or `gradlew.bat` (Windows) script, the
Gradle build tool will be downloaded automatically. To get rid of Gradle and
everything it downloaded, delete `<user_home>/.gradle`.

Gradle basics
-------------

To build all code, run `gradlew build` from the top-level directory.
To build the code for a particular week of the course, cd into the corresponding
directory and run `../gradlew build` from there. The same holds for all Gradle commands explained below.

Where to place source code
--------------------------

Solutions to assignments should go into `weekN/src` directories.
Manual test and JUnit tests should go into `weekN/test` directories.

External dependencies
---------------------

Jar files under `lib` and classes under `lib/classes` are visible to all code.
JUnit 4.10 is visible to all test code.

How to run `main` classes
-------------------------

`gradlew run<ClassName>`
Example: `gradlew runPercolationStats` will run the `main` method of the
`src/PercolationStats.java` class (assuming it exists).

`gradlew run<ClassName> -Dargs=arg1,arg2`
Example: `gradlew runPercolationStats -Dargs=200,100`

Arguments can also be defined in `weekN/build.gradle`:

    runPercolationStats {
        args 200, 100
    }

Both classes in `src/` and `test/` directories can be run in this way.

How to run JUnit tests
----------------------

`gradlew test`

How to create zip file to be submitted
--------------------------------------

`gradlew zip`

By default, the zip file will contain all files under `weekN/src`. This can be
customized in `weekN/build.gradle`. Example:

    zip {
        include "Percolation.java", "PercolationStats.java"
        // can also use `exclude`
    }

The resulting zip file goes into `weekN/build/distributions`.

How to run Checkstyle
---------------------

`gradlew checkstyle`

How to run FindBugs
-------------------

`gradlew findbugs`

How to create Eclipse projects
------------------------------

`gradlew cleanEclipse eclipse` (from top-level or weekN directory)

Use `Import -> Existing Projects into Workspace` to import the project(s) into Eclipse.

How to create IntelliJ IDEA project
-----------------------------------

`gradlew cleanIdea idea` (from top-level directory)

Use `Open Project` to open the project in IDEA.

Other useful Gradle commands
----------------------------

`gradlew clean` deletes all `build` directories.

`gradlew build` compiles and tests the code and runs Checkstyle and FindBugs.

`gradlew clean build` performs a clean build.

Task names can be abbreviated. For example, `gradlew runPercolationStats` can be
abbreviated to `gradlew runPS`.

Pitfalls
--------

All your classes should live in the default package. Otherwise they won't be able to
use classes from algs4.jar and stdlib.jar, which are also in the default package.

Due to a limitation of Gradle's FindBugs plugin, the exclude filters defined
in `config/findbugs.xml` aren't currently honored. If necessary, you can disable FindBugs
by adding `findbugsMain.enabled = false` to `weekN/build.gradle`.

Disclaimer
----------

Use at your own risk. Files in the `lib` and `data` directories are copyrighted by the
course instructors and are only for personal use by students enrolled in the [Coursera
course](https://www.coursera.org/course/algs4partI).



