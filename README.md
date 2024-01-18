Roku ECP Wrapper
============================

Overview
--------

Roku ECP Wrapper is a Kotlin based wrapper/client for the [Roku External Control API](https://developer.roku.com/docs/developer-program/dev-tools/external-control-api.md).

Key Features:
--------

Roku ECP Wrapper includes helper functions to:

#### Query
* List all channels and active channels
* Obtain device information
* Obtain player state information
* Retrieve application icons

#### Control
* Perform key event and custom event input
* Launch and install channels

#### Search
* Channels and media

Install
--------

Add the following maven dependency to your project's `build.gradle` file:

    dependencies {
        implementation 'com.github.wseemann:roku-ecp-wrapper-kotlin:1.2.0'
    }


Usage
------------

Sample code:

##### Discover all Roku devices on the local network

    List<RokuDevice> rokuDevices = DeviceRequests.discoverDevices();

##### or, create a new device if you already know the devices IP address

    rokuDevice = RokuDevice.create("<IP address>");
    
    // For example:
    
    rokuDevice = RokuDevice.create("http://192.168.1.20:8060");

##### Once you have a valid RokuDevice object you can use the class to perform actions. For example, retrieve a list of available channels on a device

    List<Channel> channels = rokuDevice.queryAppsRequest();
		
    for (Channel channel: channels) {
        // print the channel names
        System.out.println(channel.getTitle());
    }

##### Start/pause playback on a device

    rokuDevice.keyPressRequest(KeyPressKeyValues.PLAY);

License
------------

```
Roku ECP Wrapper: A Kotlin wrapper/client for the Roku External Control API.

Copyright 2023 William Seemann

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
