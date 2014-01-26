#! /usr/bin/env groovy

import groovy.json.*

def HOSTNAME = "http://localhost:8080"
def SERVICENAME = "directory/ping"
def SERVICEURL = "$HOSTNAME/$SERVICENAME"
def text = "$SERVICEURL".toURL().text

println JsonOutput.prettyPrint(text)

def json = new JsonSlurper().parseText(text)

json.each{
    println it
}

println json.application

