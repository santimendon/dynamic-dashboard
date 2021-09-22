# dynamic-dashboard
## About
1. Banners screen: Lets you load image urls. Height of the container is adjusted as per the image height. Width matches device screen width.
2. Dashboard screen: Lets you add multiple sections to your dashboard ex. Banner, List, Grid. UI items placed as per the sequence of your data items. Span count can be assigned to grid item.

------

## Screenshots

<img src="https://github.com/santimendon/dynamic-dashboard/blob/master/screenshots/im1.png" width="250" height="500" hspace=10 vspace=10>

<img src="https://github.com/santimendon/dynamic-dashboard/blob/master/screenshots/im2.png" width="250" height="500" hspace=10 vspace=10>

<img src="https://github.com/santimendon/dynamic-dashboard/blob/master/screenshots/im3.png" width="250" height="500" hspace=10 vspace=10>

<img src="https://github.com/santimendon/dynamic-dashboard/blob/master/screenshots/im4.png" width="250" height="500" hspace=10 vspace=10>

<img src="https://github.com/santimendon/dynamic-dashboard/blob/master/screenshots/im5.png" width="250" height="500" hspace=10 vspace=10>

------

## Features
* The app lets you add sections of different item types to your view on the fly.

------

## Architecture & Components
* [MVVM](https://developer.android.com/jetpack/guide?gclid=CjwKCAjwv_iEBhASEiwARoemvJYflm0CSMY1cN5BjXlWgWirIJ38AlmxyIDzt3KtzzB_ZmB-kegx-RoCvYQQAvD_BwE&gclsrc=aw.ds)
* [Epoxy](https://github.com/airbnb/epoxy)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [Databinding](https://developer.android.com/topic/libraries/data-binding)
* [Kodein](https://kodein.org/Kodein-DI/index.html?latest/android)

------

## Installation
1. cd ~/ProjectLocation/WeatherApp
2. git clone git@github.com:santimendon/dynamic-dashboard.git
3. Build and run the app

## Mock (Banners)
1. Open BannersFragment.kt
2. Change url ex. val url = "https://picsum.photos/2000/1000"
3. You can refer [Lorem Picsum](https://picsum.photos/) for static images
4. In the above static url, first parameter is the width and the second is the height ex. w-2000, h-1000
5. Images for certain values might not be available in lorem picsum. Feel free to use your own url
6. Build and run the app

## Mock (Dynamic Lists)
1. Open  file app/src/main/assets/remotedata.json
2. Add/modify the objects of type banner/list/grid (Observe json)
3. Note: Ensure to assign a unique id to every item. Ex. List (1,2,3) Grid (4,5,6,7), Banner (8,9)
4. UI will be populated as per the sequence of item types
5. To set span count to your grid, set the value against key 'span'.
6. Build and run the app

## Note
Known issue: In case of grid items, span of the last grid object gets assigned to the previous grid items in the recycler view.