maven-archetype-templates
=========================

This repository contains commonly used Maven Archetype Templates.

Installation:
-------------
1. Check out the templates
2. From command line goto project root folder. For ex: C:/Apps/git/maven-archetype-templates/quickstart-web-app
3. Execute the following maven commands to install maven archetype:
    quickstart-web-app> mvn clean
    quickstart-web-app> mvn archetype:create-from-project
    quickstart-web-app> cd target/generated-sources/archetype
    quickstart-web-app/target/generated-sources/archetype> mvn clean install

4. Repeat the same steps for all the archetype templates.
5. From Your IDE, while creating maven project filter the archetypes using 'com.sivalabs' and choose the template you want.
6. Enjoy :-)
