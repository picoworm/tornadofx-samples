@echo off

#!/usr/bin/env bash

mkdir tmp
cd tmp
wget http://www.apache.org/licenses/LICENSE-2.0.txt
mkdir lib
cd lib
wget http://repo1.maven.org/maven2/no/tornado/fxlauncher/1.0.1/fxlauncher-1.0.1.jar
cd ..
javapackager -deploy -native -outdir packages -outfile FXSamples -srcdir . -srcfiles lib/fxlauncher-1.0.1.jar;LICENSE-2.0.txt -argument http://fxsamples.tornado.no/app.xml -appclass fxlauncher.Launcher -name "FXSamples" -title "FXSamples" -BlicenseFile=LICENSE-2.0.txt
cd ..
echo "Installer is available in tmp\packages\bundles"