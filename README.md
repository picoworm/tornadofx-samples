# TornadoFX Samples

Here you will find samples showcasing best practises with [TornadoFX](https://github.com/edvin/tornadofx). For now it contains a fictive CRM application,
inspired by the CRM example app from the [DHTMLX](http://dhtmlx.com/) framework.

![CRM Demo App](/screenshots/crm.png?raw=true "CRM Demo App")

The example also integrates controls from the [TornadoFX Controls](https://github.com/edvin/tornadofx-controls) project.

The deployment descriptor (`pom.xml`) also showcases usage of the [FXLauncher Autoupdating App Launcher](https://github.com/edvin/fxlauncher)
and a prebuilt version of this demo is provided is this repo. You can run it by downloading the launcher (14kKb) and
pointing it to the `app.xml` app manifest:

```bash
wget http://fxsamples.tornado.no/lib/fxlauncher-1.0.1.jar
java -jar fxlauncher-1.0.1.jar http://fxsamples.tornado.no/app.xml
```

### Download prebuilt binaries

- [MacOSX](http://fxsamples.tornado.no/FXSamples-1.0.dmg)
- [Windows](http://fxsamples.tornado.no/FXSamples-1.0.exe)
- [Linux](http://fxsamples.tornado.no/fxsamples-1.0.deb)

The example contains contact data and images from https://randomuser.me. The generated JSON was then stripped for
unneeded fields, but no data was changed. The example data is copyrighted under the
[Creative Commons BY-NC-SA 4.0](http://creativecommons.org/licenses/by-nc-sa/4.0/) license.

If you would like to see other features of Tornado FX showcased, [file an issue](https://gihub.com/edvin/tornadofx-samples/issues) 
and we'll make sure to add an example for you :)
