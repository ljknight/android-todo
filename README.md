# Pre-work - Todo App

Todo App is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Laura Knight

Time spent: 3 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/dZjuLag.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** 
Using Android Studio makes getting up and running with Android really easy. It didn't take too much time to figure out how to make a simple todo app. However, once I started looking at the docs, I realized how much functionality exists and it seems like there is a ton to learn. I like the structure of the apps, how each activity has its own xml and Java.

Separating the xml and Java is really similar to simple web-based front-end code where you have html and pure Javascript. I'm curious if there are frameworks for Android like there are for web and Javascript, and what they would be like. I like how there is no CSS, and the styling is included in the xml. Using out-of-the-box Android UI elements with the drag-and-drop features of Android Studio makes styling easy as well, and the design turns out well without too much effort.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:**
The ArrayAdapter is used to turn each value in an array into a string, then put them all into a list for the UI. In this app it was used for creating the ListView. The ArrayAdapter is important because it allows you to get, set and edit the text inside the list easily. `getView` is called on each item whenever the ListView is shown. Whenever the ListView is re-rendered or the user scrolls, `getView` gets called again. To save on performance, an old view that's no longer being used - `convertView` - is passed in instead of instantiating a new object for every list item.

## Notes

Describe any challenges encountered while building the app.

I wasn't sure about the best way to share methods across activities. I tried creating a Utility class to share the read and write methods, but couldn't get it to work properly, so ultimately my code is not very DRY. Otherwise, it was really fun to build and figure out how everything works as I was making it.

## License

    Copyright 2017 Laura Knight

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
