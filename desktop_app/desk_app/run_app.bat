@echo off
setlocal

rem Configurar o caminho para o JavaFX (ajuste o caminho de acordo com sua instalação)
set JAVA_FX_PATH=C:\Program Files\Java\javafx-sdk-21\lib
rem set JAVA_FX_PATH=C:\caminho\para\javafx-sdk-19\lib

rem Configurar a variável de classe temporária (ajuste o nome do seu arquivo JAR ou classe principal)
set MAIN_CLASS=App

rem Definir o classpath temporário
set CLASSPATH=%JAVA_FX_PATH%\javafx.base.jar;%JAVA_FX_PATH%\javafx.controls.jar;%JAVA_FX_PATH%\javafx.fxml.jar;%JAVA_FX_PATH%\javafx.graphics.jar;%JAVA_FX_PATH%\javafx.media.jar;%JAVA_FX_PATH%\javafx.swing.jar;%JAVA_FX_PATH%\javafx.web.jar;.;%CLASSPATH%

rem Executar o programa Java
java -cp "%CLASSPATH%" %MAIN_CLASS%

rem Restaurar o classpath original
set CLASSPATH=
endlocal
