
| <img src="https://github.com/gzeinnumer/MyLibViewPager/blob/master/preview/example1.jpg"/>| <img src="https://github.com/gzeinnumer/MyLibViewPager/blob/master/preview/example2.jpg"/> |<img src="https://github.com/gzeinnumer/MyLibViewPager/blob/master/preview/example3.jpg"/> |<img src="https://github.com/gzeinnumer/MyLibViewPager/blob/master/preview/example4.jpg"/> |
|:---|:---|:---|:---|

<h1 align="center">
  MyLibViewPager - Easy ViewPager
</h1>

<div align="center">
    <a><img src="https://img.shields.io/badge/Version-1.0.1-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/Koltin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Simple way to use ViewPager, dots and tab</p>
</div>

---
# Content List
* [Download](#download)
* [Feature List](#feature-list)
* [Usage](#usage)
* [Example Code/App](#example-codeapp)
* [Version](#version)
* [Contribution](#contribution)

---
# Download
Add maven `jitpack.io` and `dependencies` in `build.gradle (Project)` :
```gradle
// build.gradle project
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

// build.gradle app/module
dependencies {
  ...
  implementation 'com.github.gzeinnumer:MyLibViewPager:version'
}
```

---
# Feature List
- [x] [ViewPager Tabs](#viewpager-tabs)
- [x] [ViewPager Dots](#viewpager-dots)

---
# Usage
### ViewPager Tabs

- Widget on `xml`
```xml
<com.google.android.material.tabs.TabLayout
    android:id="@+id/tab_layout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/purple_700"
    app:tabIconTint="@color/white"
    app:tabIndicatorColor="@color/teal_200"
    app:tabSelectedTextColor="@android:color/white"
    app:tabTextColor="@android:color/white" />

<com.gzeinnumer.mylibviewpager.SimpleViewPager
    android:id="@+id/dc"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_weight="1" />
```

#
- **MainActivity.java**.
Type Data

**Type 1** just Fragment. if you use this, `tabs` will be `gone`.
```java
viewPagerAdapter.addFragment(FirstFragment.instance());
viewPagerAdapter.addFragment(FirstFragment.instance());
```
**Type 2** Fragment with Name on Tabs.
```java
viewPagerAdapter.addFragment(FirstFragment.instance(),"First");
viewPagerAdapter.addFragment(FirstFragment.instance(), "Second");
```
**Type 3** Fragment with Icon on Tabs.
```java
viewPagerAdapter.addFragment(FirstFragment.instance(), R.drawable.icon);
viewPagerAdapter.addFragment(FirstFragment.instance(), R.drawable.icon);
```
**Type 4** Fragment with Name and Icon on Tabs.
```java
viewPagerAdapter.addFragment(FirstFragment.instance(),"First", R.drawable.icon);
viewPagerAdapter.addFragment(FirstFragment.instance(),"Second", R.drawable.icon);
```
Use on activity
```java
TabLayout tabLayout = findViewById(R.id.tab_layout);
SimpleViewPager simpleViewPager = findViewById(R.id.dc);

ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

//Type 4
viewPagerAdapter.addFragment(FirstFragment.instance(),"First", R.drawable.default_dot);
viewPagerAdapter.addFragment(FirstFragment.instance(),"Second", R.drawable.default_dot);

simpleViewPager.setAdapter(viewPagerAdapter)
    .setTabLayout(tabLayout)
    //.enableSwipe(false) // true/false -> use this if you want to disable swipe left and right to change page
    .build();
```

Move to Spesific page
```java
simpleViewPager.setSelectedPosition(1);
```

#

**Preview** :

| <img src="https://github.com/gzeinnumer/MyLibViewPager/blob/master/preview/example5.jpg"/>| <img src="https://github.com/gzeinnumer/MyLibViewPager/blob/master/preview/example3.jpg"/>| <img src="https://github.com/gzeinnumer/MyLibViewPager/blob/master/preview/example2.jpg"/> |<img src="https://github.com/gzeinnumer/MyLibViewPager/blob/master/preview/example1.jpg"/> |
|:---|:---|:---|:---|
|Type 1|Type 2|Type 3|Type 4|

#
### ViewPager Dots

- Widget on `xml`
```xml
<com.gzeinnumer.mylibviewpager.SimpleViewPager
    android:id="@+id/dc"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_weight="1" />

<com.google.android.material.tabs.TabLayout
    android:id="@+id/dots_tab"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:tabBackground="@drawable/tab_selector"
    app:tabGravity="center"
    app:tabIndicatorColor="@color/teal_200"
    app:tabIndicatorHeight="0dp"
    app:tabSelectedTextColor="@android:color/white"
    app:tabTextColor="@android:color/white" />
```
you need to make 3 file in your `res->drawable`. You can customize it.

`tab_selector.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:drawable="@drawable/selected_dot"
        android:state_selected="true"/>

    <item android:drawable="@drawable/default_dot"/>
</selector>
```
`selected_dot.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <shape
            android:innerRadius="0dp"
            android:shape="ring"
            android:thickness="8dp"
            android:useLevel="false">
            <solid android:color="@color/teal_200"/>
        </shape>
    </item>
</layer-list>
```
`default_dot.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <shape
            android:innerRadius="0dp"
            android:shape="ring"
            android:thickness="8dp"
            android:useLevel="false">
            <solid android:color="@android:color/darker_gray"/>
        </shape>
    </item>
</layer-list>
```

#
- **MainActivity.java**
```java
SimpleViewPager simpleViewPager = findViewById(R.id.dc);
TabLayout dotsTab = findViewById(R.id.dots_tab);

ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

viewPagerAdapter.addFragment(FirstFragment.instance());
viewPagerAdapter.addFragment(FirstFragment.instance());

simpleViewPager.setAdapter(viewPagerAdapter)
    .setDotsTab(dotsTab, false) // use true if you want to make dots clickable
    //.enableSwipe(false) // true/false -> use this if you want to disable swipe left and right to change page
    .build();
```

Move to Spesific page
```java
simpleViewPager.setSelectedPosition(1);
//or
dotsTab.getTabAt(0).select(); // index page start from 0...FragmentLength - 1
```

#

**Preview** :

| <img src="https://github.com/gzeinnumer/MyLibViewPager/blob/master/preview/example4.jpg" width="400"/>|
|:---|
|Dots Example|

---
# Example Code/App

**FullCode [MainActivity](https://github.com/gzeinnumer/MyLibViewPager/blob/master/app/src/main/java/com/gzeinnumer/mylibviewpager/MainActivity.java) & [FirstFragment](https://github.com/gzeinnumer/MyLibViewPager/blob/master/app/src/main/java/com/gzeinnumer/mylibviewpager/FirstFragment.java) & [XML](https://github.com/gzeinnumer/MyLibViewPager/blob/master/app/src/main/res/layout/activity_main.xml)**

[Sample Code And App](https://github.com/gzeinnumer/Example)

---
# Version
- **1.0.0**
  - First Release
- **1.0.1**
  - Add `simpleViewPager.setSelectedPosition(1);`

---
# Contribution
You can sent your constibution to `branche` `open-pull`.

---

```
Copyright 2020 M. Fadli Zein
```
