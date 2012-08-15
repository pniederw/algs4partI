algs4partI
==========

A [Gradle](http://gradle.org) build template for Coursera's [Algorithms, Part I](https://www.coursera.org/course/algs4partI) course.

**Don't use this project to share solutions to assignments!**

To prevent accidental sharing, `.gitignore` excludes all `src` directories.

Getting started
---------------

Clone this project from GitHub or download the zipball.

Gradle basics
-------------

Gradle is invoked via the `gradlew` (*nix) or `gradlew.bat` (Windows) script located
in the top-level directory. To build all code, run `gradlew build` from the top-level directory.
To build the code for a particular week, cd into the corresponding directory and run
`gradlew build` from there. The same holds for all other Gradle commands explained below.

All required dependencies, including Gradle itself, will be downloaded automatically.
They will be cached in `<user_home>/.gradle`.

Where to place source code
--------------------------

Solutions to assignments should go into weekN/src directories.
Manual tests and JUnit tests should go into weekN/test directories.

How to run `main` classes
-------------------------

`gradlew run<ClassName>`
Example: `gradlew runPercolationStats` will run the `main` method of the `src/PercolationStats.java` class (assuming it exists).

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

Use at your own risk.



