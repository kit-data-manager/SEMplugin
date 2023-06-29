# SEM-Plugin
This is a plugin for the [mapping-service](https://github.com/maximilianiKIT/mapping-service).
It enables the [mapping-service](https://github.com/maximilianiKIT/mapping-service) to use the [SEM Mapping tool](https://github.com/kit-data-manager/SEM-Mapping-Tool.git).

## To build the jar file
Clone the repository to the your local device. To bulid the `.jar` file run `./gradlew jar` from command prompt. It will then be built in the directory `build/libs`

## Use the jar file
Move the .jar file to the plugins folder of the local repository of [mapping-service](https://github.com/kit-data-manager/mapping-service).

## Making changes to the plugin
Edit the file `SEMplugin.java`saved under `src/main/java/edu/kit/datamanager/semplugin`

`build.gradle` has particulars about the .jar file name

