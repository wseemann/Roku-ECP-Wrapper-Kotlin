Jaku
============================

Overview
--------

Jaku is a Java wrapper/client for the [Roku External Control API](https://sdkdocs.roku.com/display/sdkdoc/External+Control+API/).

Key Features:
--------

Jaku includes helper functions to:

#### Query
* List all channels and active channels
* Obtain device information
* Retrieve application icons

#### Control
* Perform key event and custom event input
* Launch and install channels

#### Search
* Channels and media

Install
--------

TBA


Usage
------------

Sample code:

##### Retrieve a list of available channels on a device

    List<Channel> channels = QueryRequests.queryAppsRequest(ROKU_DEVICE_IP_ADDRESS);
		
    for (Channel channel: channels) {
        // print the channel names
        System.out.println(channel.getTitle());
    }

##### Start/pause playback on a device

    KeyRequests.keypressRequest(ROKU_DEVICE_IP_ADDRESS, KeypressKeyValues.PLAY);

License
------------

```
Jaku: A Java wrapper/client for the Roku External Control API.

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
