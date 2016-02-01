#!/usr/bin/env bash

mvn clean package
scp -r target/jfx/app/* w48839@fxsamples.tornado.no:fxsamples
