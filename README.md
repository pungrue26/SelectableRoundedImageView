SelectableRoundedImageView
==========================
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SelectableRoundedImageView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1234)


<b><i>Note that this project is no longer maintained.</i></b>

Android <code>ImageView</code> that supports different radii on each corner. It also 
supports oval(and circle) shape and border. This would be especially useful for 
being used inside <code>CardView</code> which should be rounded <b><i>only</i></b> top left and 
top right corners(Don't forget to call <code>setPreventCornerOverlap(false)</code> on your cardview).

I referred to the [RoundedImageView][6], developed by Vince, in developing this new one, and I really appreciate him. Also, I wrote a short article about how I made this library and my thoughts on CardView, check [my blog post][5].

Get the sample app on Play Store.<br> [![Play Store Image](https://camo.githubusercontent.com/dc1ffe0e4d25c2c28a69423c3c78000ef7ee96bf/68747470733a2f2f646576656c6f7065722e616e64726f69642e636f6d2f696d616765732f6272616e642f656e5f6170705f7267625f776f5f34352e706e67)](https://play.google.com/store/apps/details?id=com.joooonho)

![SelectableRoundedImageView Sample Screenshots][1]

<b>Note</b>: When using with [Glide][9], be sure to add <code>asBitmap()</code> chain, like below.
```java
Glide.with(context)
    .load(src)
    .asBitmap()
    .listener(l)
    .into(imageView) 
```
<b>Note</b>: When using with [Android-Universal-Image-Loader][7], be sure to use <code>SimpleBitmapDisplayer</code> or <code>FadeInBitmapDisplayer</code> rather than <code>RoundedBitmapDisplayer</code>(or <code>RoundedVignetteBitmapDisplayer</code>) when building <code>DisplayImageOptions</code>. See below code.

```java
options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_stub)
                .showImageForEmptyUri(R.drawable.ic_empty)
                .showImageOnFail(R.drawable.ic_error)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
//              .displayer(new RoundedBitmapDisplayer(20))
//              DO NOT USE RoundedBitmapDisplayer. Use SimpleBitmapDisplayer!
                .displayer(new SimpleBitmapDisplayer())
                .build();
```

Usage
----
Define in xml:

```xml
<com.joooonho.SelectableRoundedImageView
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/image"
        android:src="@drawable/photo1"
        android:scaleType="centerCrop"
        app:sriv_left_top_corner_radius="16dip"
        app:sriv_right_top_corner_radius="0dip"
        app:sriv_left_bottom_corner_radius="48dip"
        app:sriv_right_bottom_corner_radius="16dip"
        app:sriv_border_width="2dip"
        app:sriv_border_color="#008fea"
        app:sriv_oval="true" />
```

Or in code:

```java
SelectableRoundedImageView sriv = new SelectableRoundedImageView(context);
sriv.setScaleType(ScaleType.CENTER_CROP);
sriv.setCornerRadiiDP(4, 4, 0, 0);
sriv.setBorderWidthDP(4);
sriv.setBorderColor(Color.BLUE);
sriv.setImageDrawable(drawable);
sriv.setOval(true);
```

Including In Your Project
-------------------------

If you are using Android Studio, SelectableRoundedImageView is available through Gradle.
```
dependencies {
    compile 'com.joooonho:selectableroundedimageview:1.0.1'
}
```

Also SelectableRoundedImageView is presented as a [library project][3]. You can include 
this project by [referencing it as a library project][4] in Eclipse or ant(A standalone JAR 
is not possible due to the custom attributes). 


Developed By
==========================

 * Joonho Kim - <pungrue26@gmail.com>
 
License
-------------------------

    Copyright 2014 Joonho Kim

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    

[1]: http://i.imgur.com/iSizH82.png
[2]: https://play.google.com/store/apps/details?id=com.joooonho
[3]: http://developer.android.com/guide/developing/projects/projects-eclipse.html
[4]: http://developer.android.com/guide/developing/projects/projects-eclipse.html#ReferencingLibraryProject
[5]: http://www.joooooooooonhokim.com/?p=289
[6]: http://github.com/vinc3m1/RoundedImageView
[7]: https://github.com/nostra13/Android-Universal-Image-Loader
[8]: https://github.com/square/picasso
[9]: https://github.com/bumptech/glide
