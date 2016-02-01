#!/usr/bin/env bash

mkdir -p tmp/lib
cd tmp/lib
wget http://repo1.maven.org/maven2/no/tornado/fxlauncher/1.0.1/fxlauncher-1.0.1.jar
cd ..
javapackager -deploy -native -outdir packages -outfile FXSamples -srcdir . -srcfiles lib/fxlauncher-1.0.1.jar -argument http://fxsamples.tornado.no/app.xml -appclass fxlauncher.Launcher -name "FXSamples" -title "FXSamples"

