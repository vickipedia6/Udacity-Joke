# Udacity-Joke Telling Application
## Gradle for Android and Java Final Project
In this project, i created an app with multiple flavors that uses multiple libraries and Google Cloud Endpoints. The finished app consists of four modules. A Java library that provides jokes, a Google Cloud Endpoints (GCE) project that serves those jokes, an Android Library containing an activity for displaying jokes, and an Android app that fetches jokes from the GCE module and passes them to the Android Library for display

## Getting Started

As Android projects grow in complexity, it becomes necessary to customize the behavior of the Gradle build tool, allowing automation of repetitive tasks. Particularly, factoring functionality into libraries and creating product flavors allow for much bigger projects with minimal added complexity.

##What Did I Learn?

I learnt about the role of Gradle in building Android Apps and how to use Gradle to manage apps of increasing complexity. I learnt the following:

* Adding free and paid flavors to an app, and set up build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configured a multi project build to compile my libraries and app
* Used the Gradle App Engine plugin to deploy a backend
* Configured an integration test suite that runs against the local App Engine development server

### Prerequisites

* Android Studio 

## Specifications

This project satisfied the following specifications:
* Project contains a Java library for supplying jokes
* Project contains an Android library with an activity that displays jokes passed to it as intent extras.
* Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an   async task.
* Project contains connected tests to verify that the async task is indeed loading jokes.
* Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.
* App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.
* Make the free app variant display interstitial ads between the main activity and the joke-displaying activity.
* Have the app display a loading indicator while the joke is being fetched from the server.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* This project was developed as a part of Udacity's Android Developer Nanodegree 

