serenity-documentation
======================

This project contains the main Serenity BDD documentation. The documentation is broken up into chapters, so many people can contribute simultaneously.

== Building and contributing

The Serenity documentation is written in Asciidoc. The build uses Gradle and asciidoctor. You can generate the documentation by running the `asciidoctor` task:

    $ gradle clean asciidoctor

The documentation is generated in `build/asciidoc`.

The master document is `index.asc` - all of the chapters are included into this document.

All of the source code in the documentation is included as snippets from the sample projects in the `src/sample` directory. Look in `src/ascidoc/first-steps.asc' to see an example of how this is done.
