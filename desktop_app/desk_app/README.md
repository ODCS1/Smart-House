

## Folder Structure

The workspace contains three key folders by default, where:

- `src`: the folder to maintain sources.
- `lib`: the folder to maintain dependencies.
- `bin`: the folder to store the compiled output files.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

---

## Prerequisites

Before running the project, ensure the following tools and libraries are installed on your machine:

1. **Java Development Kit (JDK)**:
   - Install [JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html).
   - Set the `JAVA_HOME` environment variable to the JDK installation directory (e.g., `C:\Program Files\Java\jdk-21`).

2. **JavaFX SDK**:
   - Download the [JavaFX SDK 21](https://gluonhq.com/products/javafx/) and extract it to a folder, e.g.,:
     ```
     C:\Program Files\Java\javafx-sdk-21
     ```

3. **Visual Studio Code (VS Code)**:
   - Install [VS Code](https://code.visualstudio.com/).
   - Install the following extensions:
     - **Extension Pack for Java**
     - **Debugger for Java**

---

## Configuration Steps

### 1. `settings.json`

The `.vscode/settings.json` file configures the library paths for JavaFX dependencies.

Make sure it is set up like this:

```json
{
    "java.project.sourcePaths": [
        "src"
    ],
    "java.project.outputPath": "bin",
    "java.project.referencedLibraries": [
        "C:\\Program Files\\Java\\javafx-sdk-21\\lib\\javafx.base.jar",
        "C:\\Program Files\\Java\\javafx-sdk-21\\lib\\javafx.controls.jar",
        "C:\\Program Files\\Java\\javafx-sdk-21\\lib\\javafx.fxml.jar",
        "C:\\Program Files\\Java\\javafx-sdk-21\\lib\\javafx.graphics.jar",
        "C:\\Program Files\\Java\\javafx-sdk-21\\lib\\javafx.media.jar",
        "C:\\Program Files\\Java\\javafx-sdk-21\\lib\\javafx.swing.jar",
        "C:\\Program Files\\Java\\javafx-sdk-21\\lib\\javafx.web.jar",
        "C:\\Program Files\\Java\\javafx-sdk-21\\lib\\javafx-swt.jar"
    ]
}
```


If the JavaFX SDK is installed in a different location, update the paths accordingly.


### 3. `launch.json`
The `.vscode/launch.json` file configures how the project is run in VS Code.

Add the following configuration to ensure the JavaFX application runs correctly:


```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Main - Local Machine",
      "request": "launch",

      "mainClass": "Main",


      "projectName": "desk_app",
      "vmArgs": "--module-path \"C:/Program Files/Java/javafx-sdk-21/lib\" --add-modules javafx.controls,javafx.fxml"
    }
  ]
}
```
If the JavaFX SDK is installed in a different location, update the --module-path accordingly.

---
## Running the Project

Follow these steps to compile and run the project:

1. Open the Main.java file in VS Code for example.
2. Open the Run and Debug panel on the left-hand side.
3. Select the `Main - Local Machine` configuration (from launch.json).
4. Click Start Debbugging or press `F5`

if everything is configured correctly, the application will run, and the JavaFX graphical interface will appear.

---
## Troubleshooting

### Commom Erros and Fixes:

1. ***Graphics Device Initialization Failed (QuantumRenderer)***
- Occurs when JavaFX cannot find a suitable graphics pipeline.
- Solution: Update your graphics drivers to the latest version.
2. ***Main Class Not Found***
- Occurs if the `launch.json` configuration does not correctly point to the main class.
- Solution: Ensure that the `mainClass` field in `launch.json` points to the correct class (e.g., `com.example.Main`).
3. ***JavaFX Library Path Issues***
- Occurs if the JavaFX SDK paths are incorrect.
- Solution: Verify the paths in `settings.json` and `launch.json` point to the correct `lib` folder of your JavaFX SDK.

---
## Dependency Management
The `JAVA PROJECTS` view in VS Code allows you to manage your dependencies. This includes adding, updating, and removing libraries. More details can be found [here]().

---
## FAQs
1. ***Can this project use Maven?***
Yes, the project can be migrated to Maven to simplify dependency management. Using Maven, you only need to declare the JavaFX dependencies in a `pom.xml` file.

2. ***Do I need to manually update JavaFX dependencies?***
Yes, if JavaFX is updated, you'll need to update the paths in `settings.json` and `launch.json` to point to the new SDK.

3. ***Can this project be executed in other IDEs, like IntelliJ or Eclipse?***
Yes, but you need to configure the JavaFX SDK and the module paths in the respective IDE.