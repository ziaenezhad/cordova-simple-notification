# cordova-plugin-simple-notification

This plugin shows notifications on the status bar of android devices



## Installation
this plugin requires cordova-plugin-android-support-v4 so first you must add that :
    // required for cordova-plugin-simple-notification
    cordova plugin add cordova-plugin-android-support-v4
and this plugin :
    // npm hosted id
    cordova plugin add cordova-plugin-simple-notification

## Supported Platforms

- Android

## Methods

- notification.show

## notification.show

Displays the notification

```js
var unique_id_of_this_notification = 12;
notification.show(unique_id_of_this_notification, 'my title', 'my message');
```