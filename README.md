SelectableRoundedImageView
==========================
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SelectableRoundedImageView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1234)

Android <code>ImageView</code> that supports different radii on each corner. It also 
supports oval(and circle) shape and border. This would be especially useful for 
being used inside <code>CardView</code> which should be rounded <b><i>only</i></b> top left and 
top right corners(Don't forget to call <code>setPreventCornerOverlap(false)</code> on your cardview).

I referred to the [RoundedImageView][6], developed by Vince, in developing this new one, and I really appreciate him. Also, I wrote a short article about how I made this library and my thoughts on CardView, check [my blog post][5].

Sample application is ready [on the Play Store][2].

![SelectableRoundedImageView Sample Screenshots][1]

<b>Note</b>: I found that it doesn't properly load images when being used with [Android-Universal-Image-Loader][7]. I am working on this, I'll fix it ASAP. This library nicely works with Android framework ImageView's instance methods(setImageDrawable(), setImageBitmap(), etc.) and [Square's Picasso][8] library.

<b>Note</b>: This library currently has a nasty bug when being used with Adapter. This library doesn't work when convert view is saved and retrieved with setTag(), getTag(). So this library <b>DOES</b> work when :

```java
if (convertView == null) {
    view = mInflater.inflate(R.layout.list_item_icon_text, parent, false);
} else {
    view = convertView;
}
```

But this library does <b>NOT</b> work(corners get rounded twice) when :

```java
if (convertView == null) {
    view = inflater.inflate(R.layout.item_list_image, parent, false);
    holder = new ViewHolder();
    holder.text = (TextView) view.findViewById(R.id.text);
    holder.image = (ImageView) view.findViewById(R.id.image);
    view.setTag(holder);
} else {
    holder = (ViewHolder) view.getTag();
}
```
My bad. I will fix it as soon as possible. 

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
sriv.setCornerRadiusesDP(4, 4, 0, 0);
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
    compile 'com.joooonho:selectableroundedimageview:1.0.0'
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
    

[1]: http://i.imgur.com/U5VS7m2.png?1
[2]: https://play.google.com/store/apps/details?id=com.joooonho
[3]: http://developer.android.com/guide/developing/projects/projects-eclipse.html
[4]: http://developer.android.com/guide/developing/projects/projects-eclipse.html#ReferencingLibraryProject
[5]: http://www.joooooooooonhokim.com/?p=289
[6]: http://github.com/vinc3m1/RoundedImageView
[7]: https://github.com/nostra13/Android-Universal-Image-Loader
[8]: https://github.com/square/picasso
