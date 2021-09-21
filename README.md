# dynamic-dashboard
## About
This App lets you add multiple sections to your dashboard ex. Banner, List, Grid

------

## Screenshots

<img src="https://github.com/santimendon/dynamic-dashboard/blob/master/screenshots/im1.png" width="250" height="500" hspace=10 vspace=10>

<img src="https://github.com/santimendon/dynamic-dashboard/blob/master/screenshots/im2.png" width="250" height="500" hspace=10 vspace=10>

<img src="https://github.com/santimendon/dynamic-dashboard/blob/master/screenshots/im3.png" width="250" height="500" hspace=10 vspace=10>

<img src="https://github.com/santimendon/dynamic-dashboard/blob/master/screenshots/im4.png" width="250" height="500" hspace=10 vspace=10>

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
3. Open file app/src/main/assets/remotedata.json
4. Add the desired number of objects of type banner/list/grid (Observe json)
5. Build and run the app
