# Refuge Reconnect (4GR)

A very basic and simple application that collects data for refugees in low connectivity areas and submits form information to a custom server.


## Getting Started

Getting a copy of the project is simple, all you need is git installed locally and also have [Android Studio IDE](https://developer.android.com/studio/index.html) configured for use.

```bash
git clone https://github.com/BrianLusina/refugereconnect.git
```
> Gets a copy of the project ont your development environment

## Prerequisites

For a successful build, you will need to set up a `keystore.properties` file which is used when signing and generating an APK build for the application. This is not checked into version control systems as it contains critical information used in application signing.

In this case, the keystore.properties that you will create has this format:

```properties
keyAlias=<KEY_ALIAS>
keyPassword=<KEY_PASSWORD>
storeFile=<STORE_FILE>
storePassword=<STORE_PASSWORD>
```
> Fill in the placeholders with your values.

Then you can create a signed apk using [Android Studio](https://developer.android.com/studio/publish/app-signing.html).

Now you can install dependencies by running:

```bash
./gradlew tasks
```
> This will download dependencies needed if not already downloaded and the display a list of tasks you can run with gradle

## Running Tests

Tests can be run with:

```bash
./gradlew test
```
>This will run unit tests for the application

## Deployment

Deployment can be done to any Hosting service. Preference being PlayStore. To create an APK for deployment run:

```bash
./gradlew assembleRelease
```
> Generates a signed release apk

This will create 7 apks in the `app/build/release/` folder. 6 apks are split by [ABIs](https://developer.android.com/ndk/guides/abis.html) and 1 apk is a universal APK generated shadowing the rest. You will typically not need to upload the universal APK to PlayStore.

[![forthebadge](http://forthebadge.com/images/badges/built-for-android.svg)](http://forthebadge.com)
[![forthebadge](http://forthebadge.com/images/badges/built-with-love.svg)](http://forthebadge.com)